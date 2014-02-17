package in.nikitapek.dueler.commands;

import com.amshulman.mbapi.commands.PlayerOnlyCommand;
import com.amshulman.typesafety.TypeSafeCollections;
import com.amshulman.typesafety.TypeSafeList;
import in.nikitapek.dueler.util.Commands;
import in.nikitapek.dueler.util.DuelerConfigurationContext;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandDuel extends PlayerOnlyCommand {
    public CommandDuel(final DuelerConfigurationContext configurationContext) {
        super(configurationContext, Commands.DUEL, 1, 2);
    }

    @Override
    protected boolean executeForPlayer(final Player player, final TypeSafeList<String> args) {
        return true;
    }

    @Override
    public TypeSafeList<String> onTabComplete(final CommandSender sender, final TypeSafeList<String> args) {
        return TypeSafeCollections.emptyList();
    }
}
