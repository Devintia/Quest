package net.devintia.quests.triggers;

import net.devintia.quests.QuestPlugin;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;

/**
 * Created by Martin on 27.05.2016.
 */
public class BreakBlockTrigger extends Trigger {

    public BreakBlockTrigger( QuestPlugin plugin ) {
        super( TriggerType.BREAK_BLOCK, plugin );
    }

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        if ( !( input instanceof Block ) ) {
            return false;
        }

        Block block = (Block) input;

        if ( expected instanceof Material ) {
            Material material = (Material) expected;
            return block.getType().equals( material );
        }

        return false;
    }

    @EventHandler( priority = EventPriority.MONITOR )
    public void onBreak( BlockBreakEvent event ) {
        if ( event.getPlayer() != null ) {
            triggered( event.getBlock(), event.getPlayer() );
        }
    }
}
