package in.nikitapek.dueler;

import com.amshulman.mbapi.MbapiPlugin;
import in.nikitapek.dueler.listeners.DuelerListener;
import in.nikitapek.dueler.util.DuelerConfigurationContext;

public class DuelerPlugin extends MbapiPlugin {
    @Override
    public void onEnable() {
        registerEventHandler(new DuelerListener(new DuelerConfigurationContext(this)));
        super.onEnable();
    }
}
