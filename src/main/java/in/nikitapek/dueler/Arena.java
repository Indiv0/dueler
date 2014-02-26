package in.nikitapek.dueler;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Arena {
    private Map<Location, String> spawnAreas;

    public Arena() {
        spawnAreas = new HashMap<>();
    }

    public Arena(Location location) {
        this();
        spawnAreas.put(location, null);
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
}
