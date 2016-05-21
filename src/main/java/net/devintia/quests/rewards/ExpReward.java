package net.devintia.quests.rewards;

import lombok.Getter;
import net.devintia.quests.reward.Reward;
import org.bukkit.entity.Player;

/**
 * Created by Martin on 18.05.2016.
 */
@Getter
public class ExpReward extends Reward {

    private int exp;

    public ExpReward( String exp ) {
        this.exp = Integer.parseInt( exp );
    }

    @Override
    public void applyReward( Player player ) {
        //TODO we need an exp handler first
    }
}
