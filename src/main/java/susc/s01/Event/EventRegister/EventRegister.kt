package susc.s01.Event.EventRegister

import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import susc.s01.Event.LoggingJoinPlayer
import susc.s01.Event.LoggingQuitPlayer

class EventRegister : Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    fun PlayerJoinEvent(event: PlayerJoinEvent) {
        LoggingJoinPlayer(event)
    }

    @EventHandler(priority = EventPriority.LOWEST)
    fun PlayerLeaveEvent(event: PlayerQuitEvent) {
        LoggingQuitPlayer(event)
    }
}
