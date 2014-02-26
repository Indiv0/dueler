package in.nikitapek.dueler.util;

import com.amshulman.mbapi.util.PermissionsEnum;

public enum Commands implements PermissionsEnum {
    DUEL, ARENA;

    @Override
    public String getPrefix() {
        return "dueler.";
    }
}
