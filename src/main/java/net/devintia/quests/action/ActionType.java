package net.devintia.quests.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.actions.CloseDoorAction;
import net.devintia.quests.actions.OpenDoorAction;

/**
 * Created by Martin on 20.05.2016.
 */
@Getter
@AllArgsConstructor
public enum ActionType {
    OPEN_DOOR( "open_door", OpenDoorAction.class ),
    CLOSE_DOOR( "close_door", CloseDoorAction.class ),
    /*SPAWN_MOB, SPAWN_NPC, KILL_NPC, KILL_MOB, DROP_ITEM, GIVE_ITEM*/;

    private String name;
    private Class<? extends Action> clazz;

    public static ActionType fromConfig( String name ) {
        for ( ActionType type : values() ) {
            if ( type.getName().equals( name ) || type.name().equals( name ) ) {
                return type;
            }
        }
        return null;
    }
}
