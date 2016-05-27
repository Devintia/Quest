package net.devintia.quests.triggers;

import net.devintia.quests.QuestPlugin;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
public class EnterRegionTrigger extends Trigger {
    public EnterRegionTrigger( QuestPlugin plugin ) {
        super( TriggerType.ENTER_REGION, plugin );
    }

    //TODO trigger EnterRegionTrigger

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        if ( input == null && expected != null ) {
            return false;
        }
        return input.equals( expected );
    }
}
