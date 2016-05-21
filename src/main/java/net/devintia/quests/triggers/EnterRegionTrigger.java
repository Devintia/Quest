package net.devintia.quests.triggers;

import net.devintia.quests.QuestPlugin;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;

/**
 * Created by Martin on 21.05.2016.
 */
public class EnterRegionTrigger extends Trigger {
    public EnterRegionTrigger( QuestPlugin plugin ) {
        super( TriggerType.ENTER_REGION, plugin );
    }

    public void onEnterRegion() {
        //TODO trigger enterregiontrigger
    }

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        if ( input == null && expected != null ) {
            return false;
        }
        return input.equals( expected );
    }
}
