package in.nikitapek.dueler.commands;

import com.amshulman.mbapi.commands.PlayerOnlyCommand;
import com.amshulman.typesafety.TypeSafeCollections;
import com.amshulman.typesafety.TypeSafeList;
import in.nikitapek.dueler.Arena;
import in.nikitapek.dueler.management.DuelerInfoManager;
import in.nikitapek.dueler.util.Commands;
import in.nikitapek.dueler.util.DuelerConfigurationContext;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Map;

public class CommandDuel extends PlayerOnlyCommand {
    private DuelerInfoManager infoManager;

    public CommandDuel(final DuelerConfigurationContext configurationContext) {
        super(configurationContext, Commands.DUEL, 1, 2);

        this.infoManager = configurationContext.infoManager;
    }

    @Override
    protected boolean executeForPlayer(final Player player, final TypeSafeList<String> args) {
        String challengeeName = args.get(0);
        Player challengeePlayer = Bukkit.getPlayer(args.get(0));

        if (player.getName().equals(challengeeName)) {
            player.sendMessage(ChatColor.RED + "[Dueler] So you like playing with yourself?");
            return true;
        }

        if (challengeePlayer == null) {
            player.sendMessage(ChatColor.RED + String.format("[Dueler] Failed to find the player %s!", challengeeName));
            return true;
        }

        for (Arena arena : infoManager.arenas) {
            if (arena.containsPlayer(challengeeName)) {
                player.sendMessage(ChatColor.RED + String.format("[Dueler] %s is already in a duel!", challengeeName));
                return true;
            }
        }

        Arena emptyArena = null;

        if (args.size() == 2) {
            String arenaName = args.get(1);

            for (Arena arena : infoManager.arenas) {
                if (arena.getName().equals(arenaName)) {
                    emptyArena = arena;
                    break;
                }
            }

            if (emptyArena == null) {
                player.sendMessage(ChatColor.RED + String.format("[Dueler] Arena '%s' does not exist.", arenaName));
                return true;
            }


            if (emptyArena.isFull()) {
                player.sendMessage(ChatColor.RED + String.format("[Dueler] Arena %s is full.", arenaName));
                return true;
            }
        } else {
            for (Arena arena : infoManager.arenas) {
                if (!arena.isFull()) {
                    emptyArena = arena;
                }
            }
        }

        if (emptyArena == null) {
            player.sendMessage(ChatColor.RED + String.format("[Dueler] Failed to find an empty arena."));
            return true;
        }

        player.sendMessage(ChatColor.YELLOW + String.format("[Dueler] Challenging %s to a duel in %s!", challengeeName, emptyArena));
        // TODO: IMPLEMENT CHALLENGE LOGIC.

        return true;

    }

    @Override
    public TypeSafeList<String> onTabComplete(final CommandSender sender, final TypeSafeList<String> args) {
        return TypeSafeCollections.emptyList();
    }
}
