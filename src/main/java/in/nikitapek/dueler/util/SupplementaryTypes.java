package in.nikitapek.dueler.util;

import com.google.gson.reflect.TypeToken;
import in.nikitapek.dueler.Arena;
import org.bukkit.Location;

import java.lang.reflect.Type;
import java.util.TreeSet;

@SuppressWarnings("rawtypes")
public final class SupplementaryTypes {
    public static final Type LOCATION = new TypeToken<Location>() {
    }.getType();
    public static final Type ARENA = new TypeToken<Arena>() {
    }.getType();
    public static final Type TREESET = new TypeToken<TreeSet>() {
    }.getType();

    private SupplementaryTypes() {
    }
}
