package net.devintia.quests.quest;

/**
 * Holds the types a quest can have
 *
 * @author MiniDigger
 * @version 1.0.0
 */
public enum QuestType {
    /**
     * Main quest series, only for quests that have something to do with the main story
     */
    STORY,
    /**
     * Side quests, that have nothing to do with the main story but have thier own small story
     */
    SIDE,
    /**
     * Small quests, littly story, much grind
     */
    DAILY,
    /**
     * Like daily, but weekly
     */
    WEEKLY,
    /**
     * A mission is a quests that gets activated by some action the user does. eg you could get a mission quest 'kill 20 zombies' after killing some zombies
     */
    MISSION;
}
