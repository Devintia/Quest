package net.devintia.quests;

import lombok.Getter;
import net.devintia.commons.bukkit.command.CommandHandler;
import net.devintia.quests.commands.QuestCommands;
import net.devintia.quests.quest.QuestHandler;
import net.devintia.quests.trigger.TriggerHandler;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Martin on 21.05.2016.
 */
public class QuestPlugin extends JavaPlugin {
    @Getter
    private QuestHandler questHandler;
    @Getter
    private TriggerHandler triggerHandler;
    @Getter
    private CommandHandler commandHandler;

    @Override
    public void onEnable() {
        questHandler = new QuestHandler( this );
        questHandler.loadQuests();

        triggerHandler = new TriggerHandler( this );
        triggerHandler.registerTriggers();

        commandHandler = new CommandHandler( this );
        commandHandler.register( new QuestCommands( this ) );
    }
}
