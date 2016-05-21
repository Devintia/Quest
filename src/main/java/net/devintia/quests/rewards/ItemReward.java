package net.devintia.quests.rewards;

import lombok.Getter;
import net.devintia.quests.reward.Reward;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
public class ItemReward extends Reward {

    private UUID itemId;
    private int count;

    public ItemReward( String itemId ) {
        String[] s = itemId.split( "\\|" );
        this.itemId = UUID.fromString( s[0] );
        this.count = Integer.parseInt( s[1] );
    }

    @Override
    public void applyReward( Player player ) {
        //TODO we need an item handler first
    }
}
