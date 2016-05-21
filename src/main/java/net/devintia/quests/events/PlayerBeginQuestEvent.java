package net.devintia.quests.events;

import lombok.Getter;
import net.devintia.quests.quest.QuestInstance;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
public class PlayerBeginQuestEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancel = false;
    private QuestInstance quest;

    public PlayerBeginQuestEvent( Player who, QuestInstance quest ) {
        super( who );
        this.quest = quest;
    }

    @Override
    public boolean isCancelled() {
        return false;
    }

    public void setCancelled( boolean cancel ) {
        this.cancel = cancel;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
