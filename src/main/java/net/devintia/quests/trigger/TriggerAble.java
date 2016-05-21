package net.devintia.quests.trigger;

import org.bukkit.entity.Player;

/**
 * Created by Martin on 21.05.2016.
 */
public interface TriggerAble {

    void trigger( TriggerType trigger, Player player );
}
