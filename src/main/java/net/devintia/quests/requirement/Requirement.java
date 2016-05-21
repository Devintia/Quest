package net.devintia.quests.requirement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
@Getter
@AllArgsConstructor
public abstract class Requirement {

    private RequirementType type;

    public abstract boolean meetsRequirement( Player player );
}
