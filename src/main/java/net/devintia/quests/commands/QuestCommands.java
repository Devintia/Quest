package net.devintia.quests.commands;

import net.devintia.commons.bukkit.command.CommandArguments;
import net.devintia.commons.bukkit.command.CommandInfo;
import net.devintia.quests.QuestPlugin;
import net.devintia.quests.quest.Quest;
import net.devintia.quests.quest.QuestInstance;

import java.util.UUID;

/**
 * Created by Martin on 21.05.2016.
 */
public class QuestCommands {

    private QuestPlugin plugin;

    public QuestCommands( QuestPlugin plugin ) {
        this.plugin = plugin;
    }

    @CommandInfo( name = "quest.start", perm = "quest.start" )
    public void questStart( CommandArguments args ) {
        UUID id = UUID.fromString( "00000001-0000-0000-0000-000000000001" );
        Quest quest = plugin.getQuestHandler().getQuest( id );

        if ( !quest.checkRequirements( args.getPlayer() ) ) {
            args.getPlayer().sendMessage( "You don't meet the requirements for this quest!" );
            return;
        }

        QuestInstance instance = quest.newInstance( args.getPlayer() );
    }
}
