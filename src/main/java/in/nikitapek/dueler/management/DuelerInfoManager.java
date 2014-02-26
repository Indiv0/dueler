package in.nikitapek.dueler.management;

import com.amshulman.mbapi.management.InfoManager;
import com.amshulman.mbapi.storage.TypeSafeStorageSet;
import in.nikitapek.dueler.Arena;
import in.nikitapek.dueler.util.DuelerConfigurationContext;
import in.nikitapek.dueler.util.SupplementaryTypes;

import java.util.HashMap;

public class DuelerInfoManager extends InfoManager {
    public TypeSafeStorageSet<Arena> arenas;
    public HashMap<String, HashMap<String, Boolean>> challenges = new HashMap<>();

    public DuelerInfoManager(DuelerConfigurationContext configurationContext) {
        super(configurationContext);

        arenas = storageManager.getStorageSet("arenas", SupplementaryTypes.ARENA);
        arenas.loadAll();
    }

    @Override
    protected void saveAll() {
        arenas.saveAll();
    }

    @Override
    protected void unloadAll() {
        arenas.unloadAll();
    }
}
