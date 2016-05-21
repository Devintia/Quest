package net.devintia.quests.tasks;

import net.devintia.quests.quest.QuestInstance;
import net.devintia.quests.task.Task;
import net.devintia.quests.task.TaskType;
import net.devintia.quests.trigger.TriggerInstance;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.entity.Player;

/**
 * Created by Martin on 21.05.2016.
 */
public class GoToRegionTask extends Task {

    public GoToRegionTask(  String regionId ) {
        super( TaskType.GOTO_REGION, new TriggerInstance( TriggerType.ENTER_REGION, regionId ) );
    }

    @Override
    public void trigger( TriggerType trigger, Player player ) {
        setCompleted( true );
    }
}
