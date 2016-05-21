package net.devintia.quests.reward;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.quest.Quest;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Martin on 18.05.2016.
 */
@AllArgsConstructor
@Getter
public abstract class Reward {

    public abstract void applyReward( Player player );
}
