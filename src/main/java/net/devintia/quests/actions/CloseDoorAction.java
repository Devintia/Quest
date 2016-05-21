package net.devintia.quests.actions;

import lombok.Getter;
import net.devintia.quests.action.Action;
import net.devintia.quests.action.ActionType;
import net.devintia.quests.trigger.TriggerInstance;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
public class CloseDoorAction extends Action {

    private UUID doorId;

    public CloseDoorAction( List<TriggerInstance> triggers, String doorId ) {
        super( triggers, ActionType.CLOSE_DOOR );
        this.doorId = UUID.fromString( doorId );
    }

    @Override
    public void trigger( TriggerType trigger, Player player ) {
        //TODO close door
        player.sendMessage( "*door " + doorId + " closed* (was triggered by " + trigger + ")" );
    }
}
