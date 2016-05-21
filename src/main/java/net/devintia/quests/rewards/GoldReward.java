package net.devintia.quests.rewards;

import lombok.Getter;
import net.devintia.quests.reward.Reward;
import org.bukkit.entity.Player;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
public class GoldReward extends Reward {

    private double gold;

    public GoldReward( String gold ) {
        this.gold = Double.parseDouble( gold );
    }

    @Override
    public void applyReward( Player player ) {
        //TODO we need an econ handler first
    }
}
