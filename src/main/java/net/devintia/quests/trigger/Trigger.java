package net.devintia.quests.trigger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.QuestPlugin;
import net.devintia.quests.action.Action;
import net.devintia.quests.quest.Message;
import net.devintia.quests.quest.QuestInstance;
import net.devintia.quests.task.Task;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.List;

/**
 * Created by Martin on 18.05.2016.
 */
@AllArgsConstructor
@Getter
public abstract class Trigger implements Listener {

    private TriggerType type;
    private QuestPlugin plugin;

    public void triggered( Object input, Player player, QuestInstance quest ) {
        for ( Action action : quest.getQuest().getActions( getType() ) ) {
            for ( TriggerInstance triggerInstance : action.getTriggers() ) {
                if ( triggerInstance.getType().equals( type ) ) {
                    if ( shouldTrigger( input, triggerInstance.getData() ) ) {
                        action.trigger( type, player );
                    }
                }
            }
        }
        for ( Message message : quest.getQuest().getMessages( getType() ) ) {
            for ( TriggerInstance triggerInstance : message.getTriggers() ) {
                if ( triggerInstance.getType().equals( type ) ) {
                    if ( shouldTrigger( input, triggerInstance.getData() ) ) {
                        message.trigger( type, player );
                    }
                }
            }
        }
        for ( Task task : quest.getQuest().getTasks( getType() ) ) {
            if ( task.getTriggerInstance().getType().equals( type ) ) {
                if ( shouldTrigger( input, task.getTriggerInstance().getData() ) ) {
                    task.trigger( type, player );
                }
            }
        }
    }

    public void triggered( Object input, Player player ) {
        List<QuestInstance> activeQuests = plugin.getQuestHandler().getActiveQuests( player.getUniqueId() );

        for ( QuestInstance instance : activeQuests ) {
            if ( instance.isActive() ) {
                triggered( input, player, instance );
            }
        }
    }

    public abstract boolean shouldTrigger( Object input, Object expected );
}
