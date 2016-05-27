package net.devintia.quests.task;

import lombok.Getter;
import net.devintia.quests.quest.QuestInstance;
import net.devintia.quests.trigger.TriggerAble;
import net.devintia.quests.trigger.TriggerInstance;

/**
 * A task is a objective a player needs to complete to finish the quest.
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
public abstract class Task implements TriggerAble {

    private TaskType type;
    private TriggerInstance triggerInstance;
    private int triggersRequired;

    public Task( TaskType type, TriggerInstance triggerInstance, int triggersRequired ) {
        this.type = type;
        this.triggerInstance = triggerInstance;
        this.triggersRequired = triggersRequired;
    }

    public TaskInstance newInstance( QuestInstance quest ) {
        return new TaskInstance( this, quest, triggersRequired );
    }

    public void decrease(QuestInstance quest){
        quest.decrease(type);
    }
}
