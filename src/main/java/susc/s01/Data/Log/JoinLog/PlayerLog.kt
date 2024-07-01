package susc.s01.Data.Log.JoinLog

import susc.s01.Data.Log.Log
import java.util.*

@JvmRecord
data class PlayerLog(
    val uuid: UUID,
    val playerName: String,
    val joinCount: Int,
    val joinDate: Calendar,
    val leaveDate: Calendar
) : Log
