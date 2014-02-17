package in.nikitapek.dueler.util;

import com.amshulman.mbapi.MbapiPlugin;
import com.amshulman.mbapi.util.ConfigurationContext;

public class DuelerConfigurationContext extends ConfigurationContext {
    public final boolean useCombatTag;

    public DuelerConfigurationContext(MbapiPlugin plugin) {
        super(plugin);

        plugin.saveDefaultConfig();

        useCombatTag = plugin.getConfig().getBoolean("useCombatTag", true);
    }
}
