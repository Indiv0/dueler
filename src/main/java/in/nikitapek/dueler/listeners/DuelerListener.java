package in.nikitapek.dueler.listeners;

import com.amshulman.mbapi.util.CoreTypes;
import com.amshulman.typesafety.TypeSafeMap;
import com.amshulman.typesafety.impl.TypeSafeMapImpl;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileLaunchEvent;

import java.util.HashMap;

public class DuelerListener implements Listener {
    private final TypeSafeMap<String, Long> cooldownTimes;

    private final boolean useCombatTag;

    public DuelerListener(in.nikitapek.dueler.util.DuelerConfigurationContext configurationContext) {
        cooldownTimes = new TypeSafeMapImpl<>(new HashMap<String, Long>(), CoreTypes.STRING, CoreTypes.LONG);

        // Retrieve configuration options.
        useCombatTag = configurationContext.useCombatTag;
    }

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEnderPearlThrow(ProjectileLaunchEvent event) {
    }
}
