package in.nikitapek.dueler.commands.arena;

import com.amshulman.mbapi.commands.PlayerOnlyCommand;
import com.amshulman.typesafety.TypeSafeCollections;
import com.amshulman.typesafety.TypeSafeList;
import in.nikitapek.dueler.Arena;
import in.nikitapek.dueler.commands.CommandArena;
import in.nikitapek.dueler.management.DuelerInfoManager;
import in.nikitapek.dueler.util.DuelerConfigurationContext;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandList extends PlayerOnlyCommand {
    private DuelerInfoManager infoManager;

    public CommandList(DuelerConfigurationContext configurationContext) {
        super(configurationContext, CommandArena.ArenaCommands.LIST, 0, 1);

        infoManager = configurationContext.infoManager;
    }

    @Override
    protected boolean executeForPlayer(Player player, TypeSafeList<String> args) {
        boolean showAll = false;

        if (args.size() > 0) {
            if ("all".equals(args.get(0))) {
                showAll = true;
            } else {
                player.sendMessage(ChatColor.RED + String.format("[Dueler] Invalid argument '%s'. Use the `/dueler list` command with no arguments or the argument 'all'.", args.get(0)));
                return true;
            }
        }

        if (showAll) {
            player.sendMessage(ChatColor.GREEN +"[Dueler] Listing all arenas:");
        } else {
            player.sendMessage(ChatColor.GREEN +"[Dueler] Listing empty arenas:");
        }
        for (Arena arena : infoManager.arenas) {
            if (arena.isFull() && !showAll) {
                continue;
            }

            player.sendMessage(ChatColor.GREEN + String.format("    %s --- %s slots available", arena.getName(), arena.getEmptySlots()));
        }

        return true;
    }

    @Override
    public TypeSafeList<String> onTabComplete(CommandSender sender, TypeSafeList<String> args) {
        return TypeSafeCollections.emptyList();
    }
}
