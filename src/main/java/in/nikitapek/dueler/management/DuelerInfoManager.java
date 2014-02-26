package in.nikitapek.dueler.management;

import com.amshulman.mbapi.management.InfoManager;
import com.amshulman.mbapi.util.CoreTypes;
import com.amshulman.typesafety.TypeSafeMap;
import com.amshulman.typesafety.impl.TypeSafeMapImpl;
import in.nikitapek.dueler.Arena;
import in.nikitapek.dueler.util.DuelerConfigurationContext;
import in.nikitapek.dueler.util.SupplementaryTypes;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.LinkedList;

public class DuelerInfoManager extends InfoManager {
    public TypeSafeMap<String, Arena> arenas;
    public HashMap<String, LinkedList<Player>> duels = new HashMap<>();

    public DuelerInfoManager(DuelerConfigurationContext configurationContext) {
        super(configurationContext);
        arenas = new TypeSafeMapImpl<>(new HashMap<String, Arena>(), CoreTypes.STRING, SupplementaryTypes.ARENA);
    }

    @Override
    protected void saveAll() {
    }

    @Override
    protected void unloadAll() { }
}
