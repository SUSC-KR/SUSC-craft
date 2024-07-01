package susc.s01.Event

import org.bukkit.event.player.PlayerJoinEvent
import susc.s01.Data.Log.JoinLog.PlayerLog
import susc.s01.Data.Log.JoinLog.PlayerLogHandler
import java.util.*

class LoggingJoinPlayer(private val event: PlayerJoinEvent) {
    private val playerLogHandler: PlayerLogHandler = PlayerLogHandler.Companion.getInstance()

    init {
        pushingPlayerJoinLog()
    }

    private fun pushingPlayerJoinLog() {
        /*
        처음 접속하면 0으로 뜸
        */
        val player = event.player

        val currentPlayerLogData = playerLogHandler.getData(player.uniqueId)
        val playerJoinCount = 0
        currentPlayerLogData?.joinCount

        val playerLog = PlayerLog(
            player.uniqueId,
            player.name,
            playerJoinCount,
            Calendar.getInstance(TimeZone.getTimeZone("JST")),
            Calendar.getInstance(TimeZone.getTimeZone("JST"))
        )

        playerLogHandler.putData(playerLog)
    }
}
