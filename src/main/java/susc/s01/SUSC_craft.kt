package susc.s01

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import susc.s01.Data.IOHandler
import susc.s01.Data.Log.JoinLog.PlayerLogHandler
import susc.s01.Event.EventRegister.EventRegister
import susc.s01.IOHandler.FileMap

class SUSC_craft : JavaPlugin() {
    override fun onLoad() {
        Bukkit.getLogger().info(SUSC_craft::class.java.name + " Start")
    }

    override fun onEnable() {
        // EventRegister
        server.pluginManager.registerEvents(EventRegister(), this)

        // CommandRegister

        // SaveDataFile
        if (!dataFolder.exists()) dataFileLoad()

        importData()
    }

    override fun onDisable() {
        exportData()
    }

    private fun dataFileLoad() {
        saveDefaultConfig()
        saveResource(FileMap.JOIN_LOG.fileName, false)
        Bukkit.getLogger().info(SUSC_craft::class.java.name + "Save Default DataFile")
    }

    private fun importData() {
        PlayerLogHandler.getInstance().updateAllUserData(
            IOHandler().importData(
                FileMap.JOIN_LOG,
                SUSC_craft::class.java.name
            )
        )
    }

    private fun exportData() {
        IOHandler().exportData(
            FileMap.JOIN_LOG,
            SUSC_craft::class.java.name,
            PlayerLogHandler.getInstance().allUserTable
        )
    }
}
