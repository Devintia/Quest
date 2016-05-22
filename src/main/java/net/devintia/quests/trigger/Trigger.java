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
 * A trigger is a listener, that listens to some specific events and can trigger TriggerAble actions or tasks.
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@AllArgsConstructor
@Getter
public abstract class Trigger implements Listener {

    private TriggerType type;
    private QuestPlugin plugin;

    /**
     * Called by a Trigger and triggers all trigger instances that "listen" to this trigger
     *
     * @param input  the input from a event or smth like that
     * @param player the player who triggered the trigger
     * @param quest  the quest instance of the player
     */
    protected void triggered( Object input, Player player, QuestInstance quest ) {
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

    /**
     * see {@link #triggered(Object, Player, QuestInstance)}
     *
     * @param input  -
     * @param player -
     */
    protected void triggered( Object input, Player player ) {
        List<QuestInstance> activeQuests = plugin.getQuestHandler().getActiveQuests( player.getUniqueId() );

        for ( QuestInstance instance : activeQuests ) {
            if ( instance.isActive() ) {
                triggered( input, player, instance );
            }
        }
    }

    public abstract boolean shouldTrigger( Object input, Object expected );
}
