package net.devintia.quests.trigger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.quest.QuestInstance;

/**
 * Created by Martin on 21.05.2016.
 */
@Getter
@AllArgsConstructor
public class TriggerInstance {
    private TriggerType type;
    private String data;
}
