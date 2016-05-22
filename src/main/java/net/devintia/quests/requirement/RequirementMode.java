package net.devintia.quests.requirement;

/**
 * Specifies if a player needs to meet all (AND) or at least one (OR) to be able to start a quest
 *
 * @author MiniDigger
 * @version 1.0.0
 */
public enum RequirementMode {

    /**
     * A player needs to meet all requirements to be able to start the quest
     */
    AND,
    /**
     * A player needs to meet at least one requirement to be able to start the quest
     */
    OR
}
