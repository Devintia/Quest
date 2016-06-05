package net.devintia.quests.quest;

import lombok.AllArgsConstructor;

/**
 * Holds the types a quest can have
 *
 * @author MiniDigger
 * @version 1.0.0
 */
@AllArgsConstructor
public enum QuestType {
    /**
     * Main quest series, only for quests that have something to do with the main story
     */
    STORY( "S" ),
    /**
     * Side quests, that have nothing to do with the main story but have thier own small story
     */
    SIDE( "N" ),
    /**
     * Small quests, littly story, much grind
     */
    DAILY( "D" ),
    /**
     * Like daily, but weekly
     */
    WEEKLY( "W" ),
    /**
     * A mission is a quests that gets activated by some action the user does. eg you could get a mission quest 'kill 20 zombies' after killing some zombies
     */
    MISSION( "M" );

    private String shortCut;

    public String shortcut() {
        return shortCut;
    }
}
