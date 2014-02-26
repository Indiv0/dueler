package in.nikitapek.dueler.commands.arena;

import com.amshulman.mbapi.commands.PlayerOnlyCommand;
import com.amshulman.typesafety.TypeSafeCollections;
import com.amshulman.typesafety.TypeSafeList;
import in.nikitapek.dueler.Arena;
import in.nikitapek.dueler.commands.CommandArena;
import in.nikitapek.dueler.management.DuelerInfoManager;
import in.nikitapek.dueler.util.DuelerConfigurationContext;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandAdd extends PlayerOnlyCommand {
    private DuelerInfoManager infoManager;

    public CommandAdd(DuelerConfigurationContext configurationContext) {
        super(configurationContext, CommandArena.ArenaCommands.ADD, 1, 1);

        infoManager = configurationContext.infoManager;
    }

    @Override
    protected boolean executeForPlayer(Player player, TypeSafeList<String> args) {
        String arenaName = args.get(0);
        Location arenaLocation = player.getLocation().getBlock().getLocation();

        infoManager.arenas.put(arenaName, new Arena(arenaLocation));
        player.sendMessage(ChatColor.RED + "[Dueler] Successfully created an arena.");

        return true;
    }

    @Override
    public TypeSafeList<String> onTabComplete(CommandSender sender, TypeSafeList<String> args) {
        return TypeSafeCollections.emptyList();
    }
}
