package net.devintia.quests.quest;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.trigger.TriggerAble;
import net.devintia.quests.trigger.TriggerInstance;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@AllArgsConstructor
@Getter
public class Message implements TriggerAble {

    private List<String> messages;
    private List<TriggerInstance> triggers;

    @Override
    public void trigger( TriggerType trigger, Player player ) {
        for ( String msg : messages ) {
            player.sendMessage( msg );
        }
    }
}
