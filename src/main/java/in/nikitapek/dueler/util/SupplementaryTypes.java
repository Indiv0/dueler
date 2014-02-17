package in.nikitapek.dueler.util;

import com.google.gson.reflect.TypeToken;
import org.bukkit.Location;

import java.lang.reflect.Type;

@SuppressWarnings("rawtypes")
public final class SupplementaryTypes {
    public static final Type LOCATION = new TypeToken<Location>() {
    }.getType();

    private SupplementaryTypes() {
    }
}
