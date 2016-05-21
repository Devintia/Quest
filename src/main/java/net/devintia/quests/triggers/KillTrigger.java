package net.devintia.quests.triggers;

import net.devintia.quests.QuestPlugin;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;

/**
 * Created by Martin on 21.05.2016.
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
