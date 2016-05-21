package net.devintia.quests.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.trigger.TriggerAble;
import net.devintia.quests.trigger.TriggerInstance;

import java.util.List;

/**
 * A action can happen at any point in time during a quest. It gets triggered by a trigger
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@AllArgsConstructor
@Getter
public abstract class Action implements TriggerAble {

    private List<TriggerInstance> triggers;
    private ActionType type;

}
