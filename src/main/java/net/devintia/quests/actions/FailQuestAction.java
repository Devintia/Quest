package net.devintia.quests.actions;

import net.devintia.quests.action.Action;
import net.devintia.quests.action.ActionType;
import net.devintia.quests.quest.QuestInstance;
import net.devintia.quests.trigger.TriggerInstance;
import net.devintia.quests.trigger.TriggerType;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * Created by Martin on 28.05.2016.
 */
public class FailQuestAction extends Action {

    public FailQuestAction( List<TriggerInstance> triggers, String data ) {
        super( triggers, ActionType.FAIL_QUEST );
    }

    @Override
    public void trigger( TriggerType trigger, Player player, QuestInstance quest ) {
        quest.cancel( false );
    }
}
