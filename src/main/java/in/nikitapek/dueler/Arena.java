package in.nikitapek.dueler;

import com.amshulman.mbapi.util.CoreTypes;
import com.amshulman.typesafety.TypeSafeMap;
import com.amshulman.typesafety.impl.TypeSafeMapImpl;
import in.nikitapek.dueler.util.SupplementaryTypes;
import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map.Entry;

public class Arena implements Comparable<Arena> {
    private String name;
    private TypeSafeMap<Location, String> spawnAreas;

    public Arena() {
        for (String playerName : spawnAreas.values()) {
            playerName = null;
        }
    }

    public Arena(String name, Location location) {
        spawnAreas = new TypeSafeMapImpl<>(new HashMap<Location, String>(), SupplementaryTypes.LOCATION, CoreTypes.STRING);
        spawnAreas.put(location, null);
    }

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return !spawnAreas.values().contains(null);
    }

    public void addPlayer(String playerName) {
        for (Entry<Location, String> entry : spawnAreas.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue(playerName);
                return;
            }
        }
    }

    public void removePlayer(String playerName) {
        for (Entry<Location, String> entry : spawnAreas.entrySet()) {
            if (playerName.equals(entry.getValue())) {
                entry.setValue(null);
                return;
            }
        }
    }

    public boolean containsPlayer(String playerName) {
        for (Entry<Location, String> entry : spawnAreas.entrySet()) {
            if (playerName.equals(entry.getValue())) {
                return true;
            }
        }

        return false;
    }

    public int getEmptySlots() {
        int emptySlotCount = 0;

        for (String playerName : spawnAreas.values()) {
            if (playerName == null) {
                emptySlotCount++;
            }
        }

        return emptySlotCount;
    }

    @Override
    public int compareTo(Arena arena) {
        if (arena == null) {
            return 1;
        }

        if (!name.equals(arena.getName())) {
            return 1;
        }

        if (spawnAreas.entrySet() != arena.spawnAreas.entrySet()) {
            return 1;
        }

        return 0;
    }
}
