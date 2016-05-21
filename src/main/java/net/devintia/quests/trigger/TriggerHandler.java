package net.devintia.quests.trigger;

import lombok.extern.java.Log;
import net.devintia.quests.QuestPlugin;

import java.lang.reflect.InvocationTargetException;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Log
public class TriggerHandler {

    private QuestPlugin plugin;

    public TriggerHandler( QuestPlugin plugin ) {
        this.plugin = plugin;
    }

    public void registerTrigger( Trigger trigger ) {
        plugin.getServer().getPluginManager().registerEvents( trigger, plugin );
    }

    public void registerTriggers() {
        for ( TriggerType triggerType : TriggerType.values() ) {
            try {
                registerTrigger( triggerType.getClazz().getConstructor( QuestPlugin.class ).newInstance( plugin ) );
            } catch ( InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e ) {
                log.warning( "Could not register trigger " + triggerType + ": " + e.getClass().getName() + ": " + e.getMessage() );
            }
        }
    }
}
