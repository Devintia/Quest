package net.devintia.quests.triggers;

import net.devintia.quests.QuestPlugin;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by Martin on 28.05.2016.
 */
public class PlayerDeathTrigger extends Trigger {

    public PlayerDeathTrigger( QuestPlugin plugin ) {
        super( TriggerType.PLAYER_DEATH, plugin );
    }

    @EventHandler
    public void onDeath( PlayerDeathEvent event ) {
        triggered( null, event.getEntity() );
    }

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        return true;
    }
}
