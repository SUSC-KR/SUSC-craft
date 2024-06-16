package susc.s01.IOHandler;

import susc.s01.SUSC_craft;

import java.io.File;

public enum FilePathMap {
    JOIN_LOG(new File(SUSC_craft.getPlugin(SUSC_craft.class).getDataFolder(), "JoinLog.json"));

    private final File filePathInstance;

    FilePathMap(File filePathInstance) {
        this.filePathInstance = filePathInstance;
    }

    public File getFilePathInstance() {
        return filePathInstance;
    }

    public String getFileName() {
        return filePathInstance.getName();
    }
}
