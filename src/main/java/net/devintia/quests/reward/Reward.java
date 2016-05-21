package net.devintia.quests.reward;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@AllArgsConstructor
@Getter
public abstract class Reward {

    public abstract void applyReward( Player player );
}
