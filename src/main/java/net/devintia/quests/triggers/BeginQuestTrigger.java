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
public class BeginQuestTrigger extends Trigger {

    public BeginQuestTrigger( QuestPlugin plugin ) {
        super( TriggerType.BEGIN_QUEST, plugin );
    }

    @Override
    public boolean shouldTrigger( Object input, Object expected ) {
        return true;
    }
}
