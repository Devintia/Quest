package net.devintia.quests.quest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.QuestPlugin;
import net.devintia.quests.action.Action;
import net.devintia.quests.events.PlayerBeginQuestEvent;
import net.devintia.quests.requirement.Requirement;
import net.devintia.quests.requirement.RequirementMode;
import net.devintia.quests.reward.Reward;
import net.devintia.quests.task.Task;
import net.devintia.quests.trigger.TriggerInstance;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public class Quest {

    private UUID id;
    private String name;
    private String author;
    private String series;
    private QuestType type;
    private RequirementMode requirementMode;
    private List<Requirement> requirements;
    private List<Action> actions;
    private List<Message> messages;
    private List<Task> tasks;
    private List<Reward> rewards;
    private QuestPlugin plugin;

    public void applyRewards( Player player ) {
        for ( Reward reward : rewards ) {
            reward.applyReward( player );
        }
    }

    public List<Action> getActions( TriggerType type ) {
        List<Action> result = new ArrayList<>();

        for ( Action action : actions ) {
            for ( TriggerInstance instance : action.getTriggers() ) {
                if ( instance.getType().equals( type ) ) {
                    result.add( action );
                }
            }
        }

        return result;
    }

    public List<Message> getMessages( TriggerType type ) {
        List<Message> result = new ArrayList<>();

        for ( Message message : messages ) {
            for ( TriggerInstance instance : message.getTriggers() ) {
                if ( instance.getType().equals( type ) ) {
                    result.add( message );
                }
            }
        }

        return result;
    }

    public List<Task> getTasks( TriggerType type ) {
        List<Task> result = new ArrayList<>();

        for ( Task task : tasks ) {
            if ( task.getTriggerInstance().getType().equals( type ) ) {
                result.add( task );
            }
        }

        return result;
    }

    public boolean checkRequirements( Player player ) {
        boolean meetOne = false;
        boolean failedOne = false;
        for ( Requirement requirement : requirements ) {
            if ( requirement.meetsRequirement( player ) ) {
                meetOne = true;
            } else {
                failedOne = true;
            }
        }

        if ( failedOne && requirementMode == RequirementMode.AND ) {
            return false;
        }

        if ( meetOne && requirementMode == RequirementMode.OR ) {
            return true;
        }

        return false;
    }

    /**
     * Checks if a player completed all necessary tasks for this quest
     *
     * @param playerid the uuid of the player to check
     * @return weather or not the player has completed this quest
     */
    public boolean checkCompleted( UUID playerid ) {
        //TODO check for completion
        return true;
    }

    /**
     * Creates a new quest instance for the player. Gets called if a player starts a quest (active = true) or if the quests status of a player gets loaded (active = false)
     *
     * @param player the player who should be assigned to the new instance
     * @param active true if the player just started the quest, false if the questinstance was loaded from the db
     * @return the new quest instance
     */
    public QuestInstance newInstance( Player player, boolean active ) {
        QuestInstance instance = new QuestInstance( player, this, active );

        for ( Task task : tasks ) {
            instance.getTaskInstances().add( task.newInstance( instance ) );
        }

        if ( active ) {
            PlayerBeginQuestEvent event = new PlayerBeginQuestEvent( player, instance );
            Bukkit.getPluginManager().callEvent( event );
            if ( event.isCancelled() ) {
                return null;
            }
        }

        plugin.getQuestHandler().newInstance( instance );

        return instance;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", series='" + series + '\'' +
                ", type=" + type +
                ", requirementMode=" + requirementMode +
                ", requirements=" + requirements +
                ", actions=" + actions +
                ", messages=" + messages +
                ", tasks=" + tasks +
                ", rewards=" + rewards +
                ", plugin=" + plugin +
                '}';
    }
}
