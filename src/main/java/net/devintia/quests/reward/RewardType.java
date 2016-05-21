package net.devintia.quests.reward;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.rewards.ExpReward;
import net.devintia.quests.rewards.GoldReward;
import net.devintia.quests.rewards.ItemReward;

/**
 * Created by Martin on 21.05.2016.
 */
@Getter
@AllArgsConstructor
public enum RewardType {
    EXP( "exp", ExpReward.class ), GOLD( "gold", GoldReward.class ), ITEM( "item", ItemReward.class );

    private String name;
    private Class<? extends Reward> clazz;

    public static RewardType fromConfig( String key ) {
        for ( RewardType type : values() ) {
            if ( type.getName().endsWith( key ) ) {
                return type;
            }
        }
        return null;
    }
}
