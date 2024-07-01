package susc.s01.IOHandler;

import susc.s01.Data.Log.JoinLog.PlayerLog;
import susc.s01.SUSC_craft;

import java.io.File;

public enum FileMap {
    JOIN_LOG(new File(SUSC_craft.getPlugin(SUSC_craft.class).getDataFolder(), "JoinLog.json"));

    private final File filePathInstance;

    FileMap(File filePathInstance) {
        this.filePathInstance = filePathInstance;
    }

    public File getFilePathInstance() {
        return filePathInstance;
    }

    public String getFileName() {
        return filePathInstance.getName();
    }
}
