package net.devintia.quests.requirement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.entity.Player;

/**
 * Created by Martin on 21.05.2016.
 */
@Getter
@AllArgsConstructor
public abstract class Requirement {

    private RequirementType type;

    public abstract boolean meetsRequirement( Player player );
}
