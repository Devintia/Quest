package net.devintia.quests.triggers;

import net.devintia.quests.QuestPlugin;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;

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
        return false;
    }
}
