package uk.co.khobbits.liquidsafe;

import java.util.logging.Logger;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LiquidSafe extends JavaPlugin implements Listener {

    private static final Logger LOGGER = Logger.getLogger("Minecraft");

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new LiquidSafe(), this);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onEntityDamage(final EntityDamageEvent event) {
        if (event.isCancelled()) {
            return;
        }

        if (event.getEntityType() != EntityType.PLAYER) {
            return;
        }

        final EntityDamageEvent.DamageCause cause = event.getCause();

        final Player user = (Player) event.getEntity();

        if (cause == EntityDamageEvent.DamageCause.LAVA && user.hasPermission("liquidsafe.nodamage.lava")) {
            event.setCancelled(true);
            return;
        }
        if (cause == EntityDamageEvent.DamageCause.SUFFOCATION && user.hasPermission("liquidsafe.nodamage.suffocation")) {
            event.setCancelled(true);
            return;
        }
        if ((cause == EntityDamageEvent.DamageCause.FIRE || cause == EntityDamageEvent.DamageCause.FIRE_TICK)
                && user.hasPermission("liquidsafe.nodamage.fire")) {
            event.setCancelled(true);
            return;
        }
        if (cause == EntityDamageEvent.DamageCause.DROWNING && user.hasPermission("liquidsafe.nodamage.drowning")) {
            event.setCancelled(true);
            return;
        }
        if (cause == EntityDamageEvent.DamageCause.VOID && user.hasPermission("liquidsafe.nodamage.void")) {
            event.setCancelled(true);
            return;
        }
    }
}
