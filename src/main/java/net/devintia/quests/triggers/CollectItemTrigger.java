package net.devintia.quests.triggers;

import net.devintia.quests.QuestPlugin;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerPickupItemEvent;

import java.util.UUID;

/**
 * Created by Martin on 21.05.2016.
 */
public class CollectItemTrigger extends Trigger {

    public CollectItemTrigger( QuestPlugin plugin ) {
        super( TriggerType.COLLECT_ITEM, plugin );
    }

    @EventHandler( priority = EventPriority.MONITOR )
    public void onTrigger( PlayerPickupItemEvent event ) {
        if ( event.isCancelled() ) {
            return;
        }

        UUID itemid = null;//TODO get the item id via the itemstack

        triggered( itemid, event.getPlayer() );
    }

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        if ( input == null || expected != null ) {
            return false;
        }
        return input.equals( expected );
    }
}
