package net.devintia.quests.quest;

import lombok.Getter;
import lombok.Setter;
import net.devintia.quests.task.TaskInstance;
import net.devintia.quests.task.TaskType;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

/**
 * A quest instance
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
public class QuestInstance {

    private Player player;
    private Quest quest;

    @Setter
    private boolean active;

    private List<TaskInstance> taskInstances;

    QuestInstance( Player player, Quest quest, boolean active ) {
        this.player = player;
        this.quest = quest;
        this.active = active;
        taskInstances = new ArrayList<>();
    }

    public void decrease( TaskType type ) {
        for ( TaskInstance task : taskInstances ) {
            if ( task.getTask().getType().equals( type ) ) {
                task.setCount( task.getCount() - 1 );
                if ( task.getCount() == 0 ) {
                    taskInstances.remove( task );
                    checkCompletion();
                }
                return;
            }
        }
    }

    public void checkCompletion() {
        if ( taskInstances.size() == 0 ) {
            quest.getPlugin().getTriggerHandler().trigger( TriggerType.FINISH_QUEST_SUCCESS, this, player );
            quest.applyRewards( player );

            new BukkitRunnable() {
                @Override
                public void run() {
                    quest.getPlugin().getQuestHandler().removeInstance( QuestInstance.this );
                    taskInstances = null;
                    active = false;
                    player = null;
                }
            }.runTaskLater( quest.getPlugin(), 100 );
        }
    }

    public int getRemaining( TaskType type ) {
        for ( TaskInstance task : taskInstances ) {
            if ( task.getTask().getType().equals( type ) ) {
                return task.getCount();
            }
        }

        return -1;
    }
}
