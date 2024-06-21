package susc.s01.IOHandler;

import susc.s01.Data.Log.JoinLog.PlayerLog;
import susc.s01.SUSC_craft;

import java.io.File;

public enum FileMap {
    JOIN_LOG(new File(SUSC_craft.getPlugin(SUSC_craft.class).getDataFolder(), "JoinLog.json"), PlayerLog.class);

    private final File filePathInstance;
    private final Class<?> fileInstanceType;

    FileMap(File filePathInstance, Class<?> fileInstanceType) {
        this.filePathInstance = filePathInstance;
        this.fileInstanceType = fileInstanceType;
    }

    public File getFilePathInstance() {
        return filePathInstance;
    }

    public Class<?> getFileInstanceType() {
        return fileInstanceType;
    }

    public String getFileName() {
        return filePathInstance.getName();
    }
}
