package in.nikitapek.dueler.util;

import com.google.gson.reflect.TypeToken;
import in.nikitapek.dueler.Arena;
import org.bukkit.Location;

import java.lang.reflect.Type;

@SuppressWarnings("rawtypes")
public final class SupplementaryTypes {
    public static final Type LOCATION = new TypeToken<Location>() {
    }.getType();
    public static final Type ARENA = new TypeToken<Arena>() {
    }.getType();

    private SupplementaryTypes() {
    }
}
