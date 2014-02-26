package in.nikitapek.dueler.util;

import com.amshulman.mbapi.MbapiPlugin;
import com.amshulman.mbapi.util.ConfigurationContext;
import com.amshulman.typesafety.gson.TypeSafeSetTypeAdapter;
import in.nikitapek.dueler.Arena;
import in.nikitapek.dueler.management.DuelerInfoManager;

public class DuelerConfigurationContext extends ConfigurationContext {
    public DuelerInfoManager infoManager;

    public final boolean useCombatTag;

    public DuelerConfigurationContext(MbapiPlugin plugin) {
        super(plugin, new TypeSafeSetTypeAdapter<Arena>(SupplementaryTypes.TREESET, SupplementaryTypes.ARENA));

        plugin.saveDefaultConfig();

        useCombatTag = plugin.getConfig().getBoolean("useCombatTag", true);

        infoManager = new DuelerInfoManager(this);
    }
}
