package net.devintia.quests.trigger;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public class TriggerInstance {
    private TriggerType type;
    private String data;
}
