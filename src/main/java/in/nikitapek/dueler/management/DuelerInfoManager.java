package in.nikitapek.dueler.management;

import com.amshulman.mbapi.management.InfoManager;
import com.amshulman.mbapi.util.CoreTypes;
import com.amshulman.typesafety.TypeSafeMap;
import com.amshulman.typesafety.impl.TypeSafeMapImpl;
import in.nikitapek.dueler.util.DuelerConfigurationContext;
import in.nikitapek.dueler.util.SupplementaryTypes;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

public final class DuelerInfoManager extends InfoManager {
    private final TypeSafeMap<String, Location> arenas;
    private final TypeSafeMap<Player, Player> duels;

    public DuelerInfoManager(final DuelerConfigurationContext configurationContext) {
        super(configurationContext);
        arenas = new TypeSafeMapImpl<>(new HashMap<String, Location>(), CoreTypes.STRING, SupplementaryTypes.LOCATION);
    }

    @Override
    protected void saveAll() {
    }

    @Override
    protected void unloadAll() { }
}
