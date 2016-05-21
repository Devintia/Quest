package net.devintia.quests.quest;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.entity.Player;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
public class QuestInstance {

    private Player player;
    private Quest quest;

    @Setter
    private boolean active;

    QuestInstance( Player player, Quest quest, boolean active ) {
        this.player = player;
        this.quest = quest;
        this.active = active;
    }
}
