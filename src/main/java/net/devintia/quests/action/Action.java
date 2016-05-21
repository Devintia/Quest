package net.devintia.quests.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.trigger.TriggerAble;
import net.devintia.quests.trigger.TriggerInstance;

import java.util.List;

/**
 * Created by Martin on 20.05.2016.
 */
@AllArgsConstructor
@Getter
public abstract class Action implements TriggerAble {

    private List<TriggerInstance> triggers;
    private ActionType type;

}
