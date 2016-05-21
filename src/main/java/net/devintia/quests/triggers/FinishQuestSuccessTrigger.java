package net.devintia.quests.triggers;

import lombok.Getter;
import net.devintia.quests.QuestPlugin;
import net.devintia.quests.events.PlayerFinishQuestEvent;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
public class FinishQuestSuccessTrigger extends Trigger {

    public FinishQuestSuccessTrigger( QuestPlugin plugin ) {
        super( TriggerType.FINISH_QUEST_SUCCESS, plugin );
    }

    @EventHandler( priority = EventPriority.MONITOR )
    public void onTrigger( PlayerFinishQuestEvent event ) {
        if ( event.isSuccess() ) {
            triggered( null, event.getPlayer(), event.getQuest() );
        }
    }

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        return true;
    }
}
