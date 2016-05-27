package net.devintia.quests.tasks;

import net.devintia.quests.quest.QuestInstance;
import net.devintia.quests.task.Task;
import net.devintia.quests.task.TaskType;
import net.devintia.quests.trigger.TriggerInstance;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.entity.Player;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
public class KillMobTask extends Task {

    private int required;

    public KillMobTask( String data ) {
        super( TaskType.KILL_MOB, new TriggerInstance( TriggerType.KILL, data.split( "\\|" )[0] ), Integer.parseInt( data.split( "\\|" )[1] ) );
    }

    @Override
    public void trigger( TriggerType trigger, Player player, QuestInstance quest ) {
        decrease( quest );
    }
}
