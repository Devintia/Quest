package net.devintia.quests;

import lombok.Getter;
import net.devintia.commons.bukkit.command.CommandHandler;
import net.devintia.commons.i18n.LocaleManager;
import net.devintia.db.DbHandler;
import net.devintia.db.DbHandlerFactory;
import net.devintia.db.DbType;
import net.devintia.quests.commands.QuestCommands;
import net.devintia.quests.quest.QuestHandler;
import net.devintia.quests.trigger.TriggerHandler;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

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
    @Getter
    private DbHandler dbHandler;

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

        dbHandler = DbHandlerFactory.getNewDbHandler( DbType.YAML );//TODO use a real db!
        dbHandler.init();

        //DB Test
        dbHandler.save( "key", new DBTest( "test", 1 ) );
        DBTest test = (DBTest) dbHandler.get( "key" );
        if ( test.testString.equals( "test" ) && test.testInt == 1 ) {
            System.out.println( "sucess!" );
        } else {
            System.out.println( "fail!" );
        }
        dbHandler.update( "key", new DBTest( "test2", 2 ) );
        test = (DBTest) dbHandler.get( "key" );
        if ( test.testString.equals( "test2" ) && test.testInt == 2 ) {
            System.out.println( "sucess!" );
        } else {
            System.out.println( "fail!" );
        }
    }

    class DBTest implements ConfigurationSerializable {

        String testString;
        int testInt;

        public DBTest( String s, int i ) {
            testString = s;
            testInt = i;
        }

        public DBTest( Map<String, Object> data ) {
            testInt = (int) data.get( "testInt" );
            testString = (String) data.get( "testString" );
        }

        @Override
        public Map<String, Object> serialize() {
            Map<String, Object> map = new HashMap<>();
            map.put( "testInt", testInt );
            map.put( "testString", testString );
            return map;
        }
    }


    @Override
    public void onDisable() {
        questHandler = null;
        triggerHandler = null;
        commandHandler = null;
        localeManager.cleanup();
        localeManager = null;
        dbHandler.cleanUp();
        dbHandler = null;
    }

    public ComponentBuilder getPrefix() {
        return new ComponentBuilder( "Quest" ).color( ChatColor.BLUE ).append( "> " ).color( ChatColor.BLACK );
    }
}
