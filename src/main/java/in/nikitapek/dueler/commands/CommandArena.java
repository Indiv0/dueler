package in.nikitapek.dueler.commands;

import com.amshulman.mbapi.commands.DelegatingCommand;
import com.amshulman.mbapi.util.PermissionsEnum;
import in.nikitapek.dueler.commands.arena.CommandAdd;
import in.nikitapek.dueler.util.Commands;
import in.nikitapek.dueler.util.DuelerConfigurationContext;

public class CommandArena extends DelegatingCommand {
    public CommandArena(DuelerConfigurationContext configurationContext) {
        super(configurationContext, Commands.ARENA, 2, 2);
        registerSubcommand(new CommandAdd(configurationContext));
    }

    public enum ArenaCommands implements PermissionsEnum {
        ADD;

        private static final String PREFIX;

        static {
            PREFIX = Commands.ARENA.getPrefix() + Commands.ARENA.name() + ".";
        }

        @Override
        public String getPrefix() {
            return PREFIX;
        }
    }
}
