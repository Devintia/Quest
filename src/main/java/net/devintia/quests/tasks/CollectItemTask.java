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
public class CollectItemTask extends Task {

    private int amount;

    public CollectItemTask( String data ) {
        super( TaskType.COLLECT_ITEM, new TriggerInstance( TriggerType.COLLECT_ITEM, data.split( "\\|" )[0] ) );
        try {
            amount = Integer.parseInt( data.split( "\\|" )[1] );
        } catch ( Exception ex ) {
            amount = 1;
        }
    }

    @Override
    public void trigger( TriggerType trigger, Player player ) {
        if ( --amount <= 0 ) {
            setCompleted( true );
        }
    }
}
