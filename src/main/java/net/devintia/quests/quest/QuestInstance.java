package net.devintia.quests.quest;

import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * Created by Martin on 20.05.2016.
 */
@Getter
public class QuestInstance {

    private Player player;
    private Quest quest;

    private boolean active;

    public QuestInstance( Player player, Quest quest ) {
        this.player = player;
        this.quest = quest;
    }
}
