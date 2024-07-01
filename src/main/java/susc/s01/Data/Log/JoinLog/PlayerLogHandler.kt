package susc.s01.Data.Log.JoinLog

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import susc.s01.Data.Handler
import susc.s01.Data.Log.LogData
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.function.Consumer

class PlayerLogHandler : Handler<UUID, PlayerLog?> {
    private object JoinLoggerHandlerHolder {
        val instance: PlayerLogHandler = PlayerLogHandler()
            get() = JoinLoggerHandlerHolder.INSTANCE
    }

    private val joinLogData: ConcurrentHashMap<UUID?, PlayerLog?>? = LogData.getJoinLogDataInstance()

    @Synchronized
    override fun putData(playerLog: PlayerLog?) {
        joinLogData!![playerLog!!.uuid] = playerLog
    }

    @Synchronized
    override fun getData(uuid: UUID): PlayerLog? {
        return joinLogData!![uuid]
    }

    @Synchronized
    @Throws(Exception::class)
    override fun replaceData(playerLog: PlayerLog?): Boolean {
        val legacy = joinLogData!![playerLog!!.uuid]
        if (legacy == playerLog) throw Exception("Failed Replace Object > " + playerLog.uuid)

        joinLogData.replace(playerLog.uuid, playerLog)
        return true
    }

    @Synchronized
    @Throws(Exception::class)
    override fun removeData(uuid: UUID): Boolean {
        if (joinLogData!![uuid] == null) throw Exception("Non Exists JoinData > $uuid")

        joinLogData.remove(uuid)
        return true
    }

    override val allUserTable: ArrayList<E>
        get() {
            Bukkit.getOnlinePlayers().forEach { player: Player -> getData(player.uniqueId) }
            return ArrayList(ConcurrentHashMap(this.joinLogData).values)
        }

    override fun updateAllUserData(newUserData: ArrayList<PlayerLog?>?) {
        joinLogData!!.clear()

        if (newUserData == null) return

        newUserData.forEach(Consumer { playerLog: PlayerLog? -> this.putData(playerLog) })
    }

    companion object {
    }
}
