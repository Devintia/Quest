package net.devintia.quests.requirement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * A player needs to meet all (or one, depending on the RequirementMode) requirements to be able to start the quest
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public abstract class Requirement {

    private RequirementType type;

    public abstract boolean meetsRequirement( Player player );
}
