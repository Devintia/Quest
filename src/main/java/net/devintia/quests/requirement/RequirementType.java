package net.devintia.quests.requirement;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.devintia.quests.requirements.LevelRequirement;
import net.devintia.quests.requirements.VisitedRequirement;

/**
 * Created by Martin on 21.05.2016.
 */
@Getter
@AllArgsConstructor
public enum RequirementType {
    LEVEL( "level", LevelRequirement.class ), VISITED( "visited", VisitedRequirement.class );

    private String name;
    private Class<? extends Requirement> clazz;

    public static RequirementType fromConfig( String key ) {
        for ( RequirementType type : values() ) {
            if ( type.getName().endsWith( key ) ) {
                return type;
            }
        }
        return null;
    }
}
