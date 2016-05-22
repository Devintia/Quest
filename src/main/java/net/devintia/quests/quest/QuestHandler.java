package net.devintia.quests.quest;

import lombok.extern.java.Log;
import net.devintia.quests.QuestPlugin;
import net.devintia.quests.action.Action;
import net.devintia.quests.action.ActionType;
import net.devintia.quests.requirement.Requirement;
import net.devintia.quests.requirement.RequirementMode;
import net.devintia.quests.requirement.RequirementType;
import net.devintia.quests.reward.Reward;
import net.devintia.quests.reward.RewardType;
import net.devintia.quests.task.Task;
import net.devintia.quests.task.TaskType;
import net.devintia.quests.trigger.TriggerInstance;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Handles the loading and management of all quests
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@Log
public class QuestHandler {

    private List<Quest> quests;
    private QuestPlugin plugin;
    private Map<UUID, List<QuestInstance>> questInstances;
    private File questFile;

    public QuestHandler( QuestPlugin plugin ) {
        this.plugin = plugin;
        quests = new ArrayList<>();
        questInstances = new HashMap<>();
        questFile = new File( plugin.getDataFolder(), "quests" );
    }

    /**
     * Loads all quest files from the quest folder
     */
    public void loadQuests() {
        if ( !questFile.exists() ) {
            questFile.mkdirs();
        }
        for ( File file : questFile.listFiles( ( dir, name ) -> {
            return name.endsWith( ".quest" );
        } ) ) {
            loadQuest( file );
        }
    }

    /**
     * @param playerId the uuid of the player
     * @return all active quests for a player
     */
    public List<QuestInstance> getActiveQuests( UUID playerId ) {
        return questInstances.get( playerId );
    }

    /**
     * @param id the id of the quest
     * @return the quest with the id, may be null if it does not exists
     */
    public Quest getQuest( UUID id ) {
        for ( Quest quest : quests ) {
            if ( quest.getId().equals( id ) ) {
                return quest;
            }
        }
        return null;
    }

    void newInstance( QuestInstance instance ) {
        List<QuestInstance> instances = questInstances.get( instance.getPlayer().getUniqueId() );
        if ( instances == null ) {
            instances = new ArrayList<>();
        }
        instances.add( instance );
        questInstances.put( instance.getPlayer().getUniqueId(), instances );
    }

    private void loadQuest( File file ) {
        FileConfiguration questConfig = YamlConfiguration.loadConfiguration( file );

        // quest
        UUID questUUID = UUID.fromString( questConfig.getString( "quest.uuid" ) );
        String questName = questConfig.getString( "quest.name" );
        String questAuthor = questConfig.getString( "quest.author" );
        String questSeries = questConfig.getString( "quest.series" );
        QuestType questType = QuestType.valueOf( questConfig.getString( "quest.type" ) );

        // requirements
        RequirementMode requirementMode = RequirementMode.valueOf( questConfig.getString( "requirement.mode" ) );
        List<Requirement> requirements = new ArrayList<>();
        ConfigurationSection requirementSection = questConfig.getConfigurationSection( "requirement" );
        for ( String key : requirementSection.getKeys( false ) ) {
            if ( key.equals( "mode" ) ) {
                continue;
            }

            RequirementType type = RequirementType.fromConfig( key );
            if ( type != null ) {
                try {
                    Requirement requirement = type.getClazz().getConstructor( String.class ).newInstance( requirementSection.getString( key ) );
                    requirements.add( requirement );
                } catch ( Exception ex ) {
                    log.warning( "Could not load requirement " + key + " for quest " + questName + ": error while initiation: " + ex.getClass().getName() + ": " + ex.getMessage() );
                }
            } else {
                log.warning( "Could not load requirement " + key + " for quest " + questName + ": unknown type " + key );
            }
        }

        //tasks
        List<Task> tasks = new ArrayList<>();
        ConfigurationSection taskSection = questConfig.getConfigurationSection( "task" );
        for ( String key : taskSection.getKeys( false ) ) {
            TaskType type = TaskType.fromConfig( key );
            if ( type != null ) {
                try {
                    Task task = type.getClazz().getConstructor( String.class ).newInstance( taskSection.getString( key ) );
                    tasks.add( task );
                } catch ( Exception ex ) {
                    log.warning( "Could not load task " + key + " for quest " + questName + ": error while initiation: " + ex.getClass().getName() + ": " + ex.getMessage() );
                }
            } else {
                log.warning( "Could not load task " + key + " for quest " + questName + ": unknown type " + key );
            }
        }

        //rewards
        List<Reward> rewards = new ArrayList<>();
        ConfigurationSection rewardSection = questConfig.getConfigurationSection( "reward" );
        for ( String key : rewardSection.getKeys( false ) ) {
            RewardType type = RewardType.fromConfig( key );
            if ( type != null ) {
                try {
                    Reward reward = type.getClazz().getConstructor( String.class ).newInstance( rewardSection.getString( key ) );
                    rewards.add( reward );
                } catch ( Exception ex ) {
                    ex.printStackTrace();
                    log.warning( "Could not load reward " + key + " for quest " + questName + ": error while initiation: " + ex.getClass().getName() + ": " + ex.getMessage() );
                }
            } else {
                log.warning( "Could not load reward " + key + " for quest " + questName + ": unknown type " + key );
            }
        }

        //actions
        List<Action> actions = new ArrayList<>();
        ConfigurationSection actionSection = questConfig.getConfigurationSection( "action" );
        for ( String key : actionSection.getKeys( false ) ) {
            ActionType type = ActionType.fromConfig( actionSection.getString( key + ".type" ) );
            if ( type != null ) {
                List<TriggerInstance> triggerInstances = new ArrayList<>();
                ConfigurationSection triggerSection = questConfig.getConfigurationSection( "action." + key + ".trigger" );
                for ( String triggerKey : triggerSection.getKeys( false ) ) {
                    TriggerType triggerType = TriggerType.fromConfig( triggerKey );
                    if ( triggerType != null ) {
                        try {
                            TriggerInstance triggerInstance = new TriggerInstance( triggerType, triggerSection.getString( key ) );
                            triggerInstances.add( triggerInstance );
                        } catch ( Exception ex ) {
                            log.warning( "Could not load trigger " + triggerKey + " for action " + key + " for quest " + questName + ": error while initiation: " + ex.getClass().getName() + ": " + ex.getMessage() );
                        }
                    } else {
                        log.warning( "Could not load reward " + key + " for action " + key + " for quest " + questName + ": unknown type " + key );
                    }
                }

                try {
                    Action action = type.getClazz().getConstructor( List.class, String.class ).newInstance( triggerInstances, actionSection.getString( key + ".data" ) );
                    actions.add( action );
                } catch ( Exception ex ) {
                    log.warning( "Could not load action " + key + " for quest " + questName + ": error while initiation: " + ex.getClass().getName() + ": " + ex.getMessage() );
                }
            } else {
                log.warning( "Could not load action " + key + " for quest " + questName + ": unknown type " + actionSection.getString( key + ".type" ) );
            }
        }

        //messages
        List<Message> messages = new ArrayList<>();
        ConfigurationSection messageSection = questConfig.getConfigurationSection( "message" );
        for ( String key : messageSection.getKeys( false ) ) {
            List<TriggerInstance> triggerInstances = new ArrayList<>();
            ConfigurationSection triggerSection = questConfig.getConfigurationSection( "message." + key + ".trigger" );
            for ( String triggerKey : triggerSection.getKeys( false ) ) {
                TriggerType triggerType = TriggerType.fromConfig( triggerKey );
                if ( triggerType != null ) {
                    try {
                        TriggerInstance triggerInstance = new TriggerInstance( triggerType, triggerSection.getString( key ) );
                        triggerInstances.add( triggerInstance );
                    } catch ( Exception ex ) {
                        log.warning( "Could not load trigger " + triggerKey + " for message " + key + " for quest " + questName + ": error while initiation: " + ex.getClass().getName() + ": " + ex.getMessage() );
                    }
                } else {
                    log.warning( "Could not load reward " + key + " for message " + key + " for quest " + questName + ": unknown type " + key );
                }
            }

            try {
                Message message = new Message( Arrays.asList( messageSection.getString( key + ".string" ).split( "\n" ) ), triggerInstances );
                messages.add( message );
            } catch ( Exception ex ) {
                log.warning( "Could not load message " + key + " for quest " + questName + ": error while initiation: " + ex.getClass().getName() + ": " + ex.getMessage() );
            }
        }

        Quest quest = new Quest( questUUID, questName, questAuthor, questSeries, questType, requirementMode, requirements, actions, messages, tasks, rewards, plugin );
        quests.add( quest );

        log.info( "Loaded quest " + quest.getName() + "(" + quest + ")" );
    }
}
