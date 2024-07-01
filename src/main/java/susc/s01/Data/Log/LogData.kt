package susc.s01.Data.Log

import susc.s01.Data.Log.JoinLog.PlayerLog
import java.util.*
import java.util.concurrent.ConcurrentHashMap

object LogData {
    private object PlayerLogData {
        val joinLogDataInstance: ConcurrentHashMap<UUID, PlayerLog> = ConcurrentHashMap()
            get() = PlayerLogData.INSTANCE
    }
}
