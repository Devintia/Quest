package net.devintia.quests.trigger;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.triggers.BeginQuestTrigger;
import net.devintia.quests.triggers.CollectItemTrigger;
import net.devintia.quests.triggers.EnterRegionTrigger;
import net.devintia.quests.triggers.FinishQuestFailTrigger;
import net.devintia.quests.triggers.FinishQuestSuccessTrigger;
import net.devintia.quests.triggers.KillTrigger;

/**
 * Created by Martin on 18.05.2016.
 */
@Getter
@AllArgsConstructor
public enum TriggerType {

    BEGIN_QUEST( "begin_quest", BeginQuestTrigger.class ),
    FINISH_QUEST_SUCCESS( "finish_quest_success", FinishQuestSuccessTrigger.class ),
    FINISH_QUEST_FAIL( "finish_quest_fail", FinishQuestFailTrigger.class ),
    COLLECT_ITEM( "collect_item", CollectItemTrigger.class ),
    ENTER_REGION( "enter_region", EnterRegionTrigger.class ),
    KILL( "kill", KillTrigger.class );

    private String name;
    private Class<? extends Trigger> clazz;

    public static TriggerType fromConfig( String key ) {
        for ( TriggerType type : values() ) {
            if ( type.getName().equals( key ) ) {
                return type;
            }
        }
        return null;
    }
}
