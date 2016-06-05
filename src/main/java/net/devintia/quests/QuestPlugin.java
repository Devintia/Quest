package net.devintia.quests;

import lombok.Getter;
import net.devintia.commons.bukkit.command.CommandHandler;
import net.devintia.commons.i18n.LocaleManager;
import net.devintia.quests.commands.QuestCommands;
import net.devintia.quests.quest.QuestHandler;
import net.devintia.quests.trigger.TriggerHandler;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
public class QuestPlugin extends JavaPlugin {
    @Getter
    private QuestHandler questHandler;
    @Getter
    private TriggerHandler triggerHandler;
    @Getter
    private CommandHandler commandHandler;
    @Getter
    private LocaleManager localeManager;

    @Override
    public void onEnable() {
        questHandler = new QuestHandler( this );
        questHandler.loadQuests();

        triggerHandler = new TriggerHandler( this );
        triggerHandler.registerTriggers();

        commandHandler = new CommandHandler( this );
        commandHandler.register( new QuestCommands( this ) );

        localeManager = new LocaleManager( this );
        localeManager.initFromLocaleSpecWithoutAutorefresh( getDataFolder() + File.separator + "lang" + File.separator + "locspec" );
    }

    @Override
    public void onDisable() {
        questHandler = null;
        triggerHandler = null;
        commandHandler = null;
        localeManager.cleanup();
        localeManager = null;
    }

    public ComponentBuilder getPrefix() {
        return new ComponentBuilder( "Quest" ).color( ChatColor.BLUE ).append( "> " ).color( ChatColor.BLACK );
    }
}
