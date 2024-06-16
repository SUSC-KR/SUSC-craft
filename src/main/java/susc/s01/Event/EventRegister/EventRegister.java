package susc.s01.Event.EventRegister;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import susc.s01.Event.LoggingJoinPlayer;
import susc.s01.Event.LoggingQuitPlayer;

public class EventRegister implements Listener {

    @EventHandler(priority = EventPriority.LOWEST)
    public void PlayerJoinEvent(PlayerJoinEvent event) {
        new LoggingJoinPlayer(event);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void PlayerLeaveEvent(PlayerQuitEvent event) {
        new LoggingQuitPlayer(event);
    }
}
