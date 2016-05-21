package net.devintia.quests.trigger;

import org.bukkit.entity.Player;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
public interface TriggerAble {

    void trigger( TriggerType trigger, Player player );
}
