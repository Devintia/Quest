package net.devintia.quests.triggers;

import net.devintia.quests.QuestPlugin;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.EntityDeathEvent;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
public class KillTrigger extends Trigger {

    public KillTrigger( QuestPlugin plugin ) {
        super( TriggerType.KILL, plugin );
    }

    //TODO trigger killtrigger

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        return true;
    }

    @EventHandler( priority = EventPriority.MONITOR )
    public void onKill( EntityDeathEvent event ) {
        Player killer = event.getEntity().getKiller();
        if ( killer != null ) {
            triggered( event.getEntity().getUniqueId(), killer );
        }
    }
}
