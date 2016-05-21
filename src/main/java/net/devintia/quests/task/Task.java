package net.devintia.quests.task;

import lombok.Getter;
import lombok.Setter;
import net.devintia.quests.trigger.TriggerAble;
import net.devintia.quests.trigger.TriggerInstance;

/**
 * Created by Martin on 21.05.2016.
 */
@Getter
public abstract class Task implements TriggerAble {

    private TaskType type;
    private TriggerInstance triggerInstance;
    @Setter
    private boolean completed;

    public Task( TaskType type, TriggerInstance triggerInstance ) {
        this.type = type;
        this.triggerInstance = triggerInstance;
        completed = false;
    }
}
