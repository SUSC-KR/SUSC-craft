package susc.s01.IOHandler

import susc.s01.Data.Log.JoinLog.PlayerLog
import susc.s01.SUSC_craft
import java.io.File

enum class FileMap(val filePathInstance: File, val fileInstanceType: Class<*>) {
    JOIN_LOG(
        File(SUSC_craft.getPlugin<SUSC_craft>(SUSC_craft::class.java).getDataFolder(), "JoinLog.json"),
        PlayerLog::class.java
    );

    val fileName: String
        get() = filePathInstance.name
}
