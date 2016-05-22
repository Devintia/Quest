package net.devintia.quests.trigger;

import org.bukkit.entity.Player;

/**
 * A action or a task that can be triggered by a trigger
 *
 * @author MiniDigger
 * @version 1.0.0
 */
public interface TriggerAble {

    void trigger( TriggerType trigger, Player player );
}
