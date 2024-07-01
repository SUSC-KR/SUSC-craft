package susc.s01.Event

import org.bukkit.event.player.PlayerQuitEvent
import susc.s01.Data.Log.JoinLog.PlayerLog
import susc.s01.Data.Log.JoinLog.PlayerLogHandler
import java.util.*

class LoggingQuitPlayer(private val event: PlayerQuitEvent) {
    private val playerLogHandler: PlayerLogHandler = PlayerLogHandler.Companion.getInstance()

    init {
        pushingPlayerQuitLog()
    }

    private fun pushingPlayerQuitLog() {
        val player = event.player
        val currentPlayerLogData = playerLogHandler.getData(player.uniqueId)

        val playerLog = PlayerLog(
            player.uniqueId,
            player.name,
            currentPlayerLogData!!.joinCount,
            currentPlayerLogData.joinDate,
            Calendar.getInstance(TimeZone.getTimeZone("JST"))
        )

        try {
            playerLogHandler.replaceData(playerLog)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
