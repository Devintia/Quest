package net.devintia.quests.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.devintia.quests.quest.QuestInstance;

/**
 * Created by Martin on 27.05.2016.
 */
@Getter
@AllArgsConstructor
public class TaskInstance {

    private Task task;
    private QuestInstance quest;
    @Setter
    private int count;
}
