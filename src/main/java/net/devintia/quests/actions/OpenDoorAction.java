package net.devintia.quests.actions;

import lombok.Getter;
import net.devintia.quests.action.Action;
import net.devintia.quests.action.ActionType;
import net.devintia.quests.quest.QuestInstance;
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
public class OpenDoorAction extends Action {

    private UUID doorId;

    public OpenDoorAction( List<TriggerInstance> triggers, String doorId ) {
        super( triggers, ActionType.OPEN_DOOR );
        this.doorId = UUID.fromString( doorId );
    }

    @Override
    public void trigger( TriggerType trigger, Player player, QuestInstance quest ) {
        //TODO open door
        player.sendMessage( "*door " + doorId + " opens* (was triggered by " + trigger + ")" );
    }
}
