package net.devintia.quests.requirements;

import net.devintia.quests.requirement.Requirement;
import net.devintia.quests.requirement.RequirementType;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
public class VisitedRequirement extends Requirement {

    private UUID regionId;

    public VisitedRequirement( String regionId ) {
        super( RequirementType.VISITED );
        this.regionId = UUID.fromString( regionId );
    }

    @Override
    public boolean meetsRequirement( Player player ) {

        //TODO check if player has visited a region
//        if ( player.hasVisited( regionId ) ) {
//            return true;
//        }

        return true;
    }
}
