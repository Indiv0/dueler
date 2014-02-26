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

public class CommandRemove extends PlayerOnlyCommand {
    private DuelerInfoManager infoManager;

    public CommandRemove(DuelerConfigurationContext configurationContext) {
        super(configurationContext, CommandArena.ArenaCommands.REMOVE, 1, 1);

        infoManager = configurationContext.infoManager;
    }

    @Override
    protected boolean executeForPlayer(Player player, TypeSafeList<String> args) {
        String arenaName = args.get(0);

        for (Arena arena : infoManager.arenas) {
            if (arena.getName().equals(arenaName)) {
                infoManager.arenas.remove(arena);
                player.sendMessage(ChatColor.GREEN + String.format("[Dueler] Successfully removed the '%s' arena.", arenaName));
                return true;
            }
        }

        player.sendMessage(ChatColor.RED + String.format("[Dueler] Failed to remove non-existent arena '%s'.", arenaName));

        return true;
    }

    @Override
    public TypeSafeList<String> onTabComplete(CommandSender sender, TypeSafeList<String> args) {
        return TypeSafeCollections.emptyList();
    }
}
