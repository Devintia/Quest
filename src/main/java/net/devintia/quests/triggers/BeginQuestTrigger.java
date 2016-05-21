package net.devintia.quests.triggers;

import lombok.Getter;
import net.devintia.quests.QuestPlugin;
import net.devintia.quests.events.PlayerBeginQuestEvent;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;

/**
 * Created by Martin on 20.05.2016.
 */
@Getter
public class BeginQuestTrigger extends Trigger {

    public BeginQuestTrigger( QuestPlugin plugin ) {
        super( TriggerType.BEGIN_QUEST, plugin );
    }

    @EventHandler( priority = EventPriority.MONITOR )
    public void onTrigger( PlayerBeginQuestEvent event ) {
        if ( event.isCancelled() ) {
            return;
        }

        triggered( null, event.getPlayer(), event.getQuest() );
    }

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        return true;
    }
}
