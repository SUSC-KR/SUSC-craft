package susc.s01.Data.Log;

import susc.s01.Data.Log.JoinLog.PlayerLog;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class LogData {
    private static class PlayerLogData {
        private final static ConcurrentHashMap<UUID, PlayerLog> INSTANCE = new ConcurrentHashMap<>();
    }

    public static ConcurrentHashMap<UUID, PlayerLog> getJoinLogDataInstance() {
        return PlayerLogData.INSTANCE;
    }
}
