package net.devintia.quests.requirements;

import net.devintia.quests.requirement.Requirement;
import net.devintia.quests.requirement.RequirementType;
import org.bukkit.entity.Player;

/**
 * Created by Martin on 21.05.2016.
 */
public class LevelRequirement extends Requirement {

    private int level;

    public LevelRequirement( String level ) {
        super( RequirementType.LEVEL );
        this.level = Integer.parseInt( level );
    }

    @Override
    public boolean meetsRequirement( Player player ) {
        // TODO check the level of the player's char
        int playerlevel = 0;

        return playerlevel >= level;
    }
}
