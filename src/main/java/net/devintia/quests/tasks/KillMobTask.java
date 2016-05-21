package net.devintia.quests.tasks;

import net.devintia.quests.task.Task;
import net.devintia.quests.task.TaskType;
import net.devintia.quests.trigger.TriggerInstance;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.entity.Player;

/**
 * Created by Martin on 21.05.2016.
 */
public class KillMobTask extends Task {

    private int required;

    public KillMobTask( String data ) {
        super( TaskType.KILL_MOB, new TriggerInstance( TriggerType.KILL, data.split( "\\|" )[0] ) );
        this.required = Integer.parseInt( data.split( "\\|" )[1] );
    }

    @Override
    public void trigger( TriggerType trigger, Player player ) {
        if ( --required <= 0 ) {
            setCompleted( true );
        }
    }
}
