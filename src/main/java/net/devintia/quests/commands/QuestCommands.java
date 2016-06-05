package net.devintia.quests.commands;

import net.devintia.commons.bukkit.command.CommandArguments;
import net.devintia.commons.bukkit.command.CommandInfo;
import net.devintia.quests.QuestPlugin;
import net.devintia.quests.quest.Quest;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * @author MiniDigger
 * @version 1.0.0
 */
public class QuestCommands {

    private QuestPlugin plugin;

    public QuestCommands( QuestPlugin plugin ) {
        this.plugin = plugin;
    }

    @CommandInfo( name = "quest.start", perm = "quest.start", allowConsole = false )
    public void questStart( CommandArguments args ) {
        UUID id = UUID.fromString( "00000001-0000-0000-0000-000000000001" );
        Quest quest = plugin.getQuestHandler().getQuest( id );

        if ( !quest.checkRequirements( args.getPlayer() ) ) {
            args.getPlayer().spigot().sendMessage( plugin.getPrefix().append( trans( args.getPlayer(), "quest.no_requirement" ) ).color( ChatColor.RED ).create() );
            return;
        }

        quest.newInstance( args.getPlayer(), true );
    }

    @CommandInfo( name = "quest.book", perm = "quest.book", allowConsole = false )
    public void questBook( CommandArguments args ) {
        if ( args.getPlayer().getInventory().firstEmpty() == -1 ) {
            args.getPlayer().spigot().sendMessage( plugin.getPrefix().append( trans( args.getPlayer(), "quest.no_inventory_space" ) ).color( ChatColor.RED ).create() );
            return;
        }
        args.getPlayer().getInventory().addItem( plugin.getQuestHandler().getQuestBook( args.getPlayer() ) );
    }

    @CommandInfo( name = "quest.list", perm = "quest.list", allowConsole = false )
    public void questList( CommandArguments args ) {

    }

    @CommandInfo( name = "quest.list.active", perm = "quest.list-active", allowConsole = false )
    public void questListActive( CommandArguments args ) {

    }

    @CommandInfo( name = "quest.list.open", perm = "quest.list.open", allowConsole = false )
    public void questListOpen( CommandArguments args ) {

    }

    @CommandInfo( name = "quest.list.archive", perm = "quest.list.archive", allowConsole = false )
    public void questListArchive( CommandArguments args ) {
        //TODO PAGINATION
    }

    @CommandInfo( name = "quest.daily", perm = "quest.daily", allowConsole = false )
    public void questDaily( CommandArguments args ) {
        Quest quest = plugin.getQuestHandler().getDailyQuest();
        if ( quest == null ) {
            args.getPlayer().spigot().sendMessage( plugin.getPrefix().append( trans( args.getPlayer(), "quest.no_daily_quest" ) ).color( ChatColor.RED ).create() );
            return;
        }

        for ( BaseComponent[] message : formatQuestInfo( quest, false ) ) {
            args.getPlayer().spigot().sendMessage( message );
        }
    }

    @CommandInfo( name = "quest.daily.start", perm = "quest.daily.start", allowConsole = false )
    public void questDailyStart( CommandArguments args ) {
        Quest quest = plugin.getQuestHandler().getDailyQuest();
        if ( quest == null ) {
            args.getPlayer().spigot().sendMessage( plugin.getPrefix().append( trans( args.getPlayer(), "quest.no_daily_quest" ) ).color( ChatColor.RED ).create() );
            return;
        }

        if ( !quest.checkRequirements( args.getPlayer() ) ) {
            args.getPlayer().spigot().sendMessage( plugin.getPrefix().append( trans( args.getPlayer(), "quest.no_requirement" ) ).color( ChatColor.RED ).create() );
            return;
        }

        quest.newInstance( args.getPlayer(), true );
    }

    //TODO format the quest
    private BaseComponent[][] formatQuestInfo( Quest quest, boolean showShort ) {
        BaseComponent[] title = plugin.getPrefix().append( quest.getName() + "(" + quest.getSeries() + ") " + quest.getType().shortcut() ).create();

        return new BaseComponent[][]{ title };
    }

    private String trans( Player player, String key, Object... args ) {
        return plugin.getLocaleManager().translate( player, key, args );
    }
}
