package in.nikitapek.dueler;

import com.amshulman.mbapi.MbapiPlugin;
import in.nikitapek.dueler.commands.CommandArena;
import in.nikitapek.dueler.commands.CommandDuel;
import in.nikitapek.dueler.listeners.DuelerListener;
import in.nikitapek.dueler.util.DuelerConfigurationContext;

public class DuelerPlugin extends MbapiPlugin {
    @Override
    public void onEnable() {
        DuelerConfigurationContext configurationContext = new DuelerConfigurationContext(this);

        registerCommandExecutor(new CommandArena(configurationContext));
        registerCommandExecutor(new CommandDuel(configurationContext));
        registerEventHandler(new DuelerListener(configurationContext));

        super.onEnable();
    }
}
