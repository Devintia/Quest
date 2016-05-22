package net.devintia.quests.trigger;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * A trigger instance holds the data for a trigger. This could be that mobid for a KillMobTrigger or the message for a ChatMessageTrigger
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public class TriggerInstance {
    private TriggerType type;
    private String data;
}
