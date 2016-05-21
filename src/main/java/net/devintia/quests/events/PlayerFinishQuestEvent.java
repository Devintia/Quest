package net.devintia.quests.events;

import lombok.Getter;
import net.devintia.quests.quest.QuestInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * Created by Martin on 20.05.2016.
 */
@Getter
public class PlayerFinishQuestEvent extends PlayerEvent {

    private static final HandlerList handlers = new HandlerList();
    private QuestInstance quest;
    private boolean success;

    public PlayerFinishQuestEvent( Player who, QuestInstance quest, boolean success ) {
        super( who );
        this.quest = quest;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
