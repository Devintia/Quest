package net.devintia.quests.task;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.tasks.BreakBlockTask;
import net.devintia.quests.tasks.CollectItemTask;
import net.devintia.quests.tasks.GoToRegionTask;
import net.devintia.quests.tasks.KillMobTask;

/**
 * Holds class references for all tasks
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public enum TaskType {

    GOTO_REGION( "goto_region", GoToRegionTask.class ),
    KILL_MOB( "kill_mob", KillMobTask.class ),
    COLLECT_ITEM( "collect_item", CollectItemTask.class ),
    BREAK_BLOCK( "break_block", BreakBlockTask.class );

    private String name;
    private Class<? extends Task> clazz;

    public static TaskType fromConfig( String key ) {
        for ( TaskType type : values() ) {
            if ( type.getName().equals( key ) ) {
                return type;
            }
        }
        return null;
    }
}
