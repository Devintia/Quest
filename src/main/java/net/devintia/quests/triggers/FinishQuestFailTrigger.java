package net.devintia.quests.triggers;

import lombok.Getter;
import net.devintia.quests.QuestPlugin;
import net.devintia.quests.trigger.Trigger;
import net.devintia.quests.trigger.TriggerType;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
public class FinishQuestFailTrigger extends Trigger {

    public FinishQuestFailTrigger( QuestPlugin plugin ) {
        super( TriggerType.FINISH_QUEST_FAIL, plugin );
    }

    //TODO trigger FinishQuestFailTrigger

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        return true;
    }
}
