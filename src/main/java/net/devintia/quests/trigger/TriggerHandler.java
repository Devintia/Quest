package net.devintia.quests.trigger;

import lombok.extern.java.Log;
import net.devintia.quests.QuestPlugin;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Handles the registration of all triggers
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@Log
public class TriggerHandler {

    private QuestPlugin plugin;
    private Map<TriggerType, Trigger> triggers;

    public TriggerHandler( QuestPlugin plugin ) {
        this.plugin = plugin;
        this.triggers = new HashMap<>();
    }

    private Trigger registerTrigger( Trigger trigger ) {
        plugin.getServer().getPluginManager().registerEvents( trigger, plugin );
        return trigger;
    }

    /**
     * Registers the listeners for all triggers, needs to be called onEnable
     */
    public void registerTriggers() {
        for ( TriggerType triggerType : TriggerType.values() ) {
            try {
                triggers.put( triggerType, registerTrigger( triggerType.getClazz().getConstructor( QuestPlugin.class ).newInstance( plugin ) ) );
            } catch ( InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e ) {
                log.warning( "Could not register trigger " + triggerType + ": " + e.getClass().getName() + ": " + e.getMessage() );
            }
        }
    }

    /**
     * Triggers a trigger
     *
     * @param type   the type of trigger to trigger
     * @param input  addtional data about the triggering
     * @param player the player who triggered the trigger
     */
    public void trigger( TriggerType type, Object input, Player player ) {
        Trigger trigger = triggers.get( type );
        if ( trigger == null ) {
            log.warning( "No trigger registered for type " + type + ": Can't process trigger!" );
            return;
        }

        trigger.triggered( input, player );
    }
}
