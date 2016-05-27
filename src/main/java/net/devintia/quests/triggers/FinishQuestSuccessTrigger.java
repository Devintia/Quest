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
public class FinishQuestSuccessTrigger extends Trigger {

    public FinishQuestSuccessTrigger( QuestPlugin plugin ) {
        super( TriggerType.FINISH_QUEST_SUCCESS, plugin );
    }

    //TODO trigger FinishQuestSuccessTrigger

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        return true;
    }
}
