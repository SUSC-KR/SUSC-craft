package susc.s01;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import susc.s01.Data.IOHandler;
import susc.s01.Data.Log.JoinLog.PlayerLogHandler;
import susc.s01.Event.EventRegister.EventRegister;
import susc.s01.IOHandler.FileMap;

public final class SUSC_craft extends JavaPlugin {
    @Override
    public void onLoad() {
        Bukkit.getLogger().info(SUSC_craft.class.getName() + " Start");
    }

    @Override
    public void onEnable() {
//        EventRegister
        getServer().getPluginManager().registerEvents(new EventRegister(),this);

//        CommandRegister

//        SaveDataFile
        if (!getDataFolder().exists())
            dataFileLoad();

        importData();
    }

    @Override
    public void onDisable() {
        exportData();
    }

    private void dataFileLoad() {
        saveDefaultConfig();
        saveResource(FileMap.JOIN_LOG.getFileName(), false);
        Bukkit.getLogger().info(SUSC_craft.class.getName() + "Save Default DataFile");
    }

    private void importData() {
        PlayerLogHandler.getInstance().updateAllUserData(new IOHandler().importData(
                FileMap.JOIN_LOG,
                SUSC_craft.class.getName()
                )
        );
    }

    private void exportData() {
        new IOHandler().exportData(
                FileMap.JOIN_LOG,
                SUSC_craft.class.getName(),
                PlayerLogHandler.getInstance().getAllUserTable()
        );
    }
}
