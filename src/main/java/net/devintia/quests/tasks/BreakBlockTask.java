package net.devintia.quests.tasks;

import net.devintia.quests.quest.QuestInstance;
import net.devintia.quests.task.Task;
import net.devintia.quests.task.TaskType;
import net.devintia.quests.trigger.TriggerInstance;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.Material;
import org.bukkit.entity.Player;

/**
 * Created by Martin on 27.05.2016.
 */
public class BreakBlockTask extends Task {

    public BreakBlockTask( String data ) {
        super( TaskType.BREAK_BLOCK, new TriggerInstance( TriggerType.BREAK_BLOCK, Material.valueOf( data.split( "\\|" )[0] ) ), Integer.parseInt( data.split( "\\|" )[1] ) );
    }

    @Override
    public void trigger( TriggerType trigger, Player player, QuestInstance quest ) {
        decrease( quest );
    }
}
