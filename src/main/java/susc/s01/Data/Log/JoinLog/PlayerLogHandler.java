package susc.s01.Data.Log.JoinLog;

import org.bukkit.Bukkit;
import susc.s01.Data.Log.Handler;
import susc.s01.Data.Log.LogData;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerLogHandler implements Handler<UUID, PlayerLog> {
    private static class JoinLoggerHandlerHolder {
        private final static PlayerLogHandler INSTANCE = new PlayerLogHandler();
    }

    public static PlayerLogHandler getInstance() {
        return JoinLoggerHandlerHolder.INSTANCE;
    }

    private final ConcurrentHashMap<UUID, PlayerLog> joinLogData = LogData.getJoinLogDataInstance();

    @Override
    public synchronized void putData(PlayerLog playerLog) {
        joinLogData.put(playerLog.uuid(), playerLog);
    }

    @Override
    public synchronized PlayerLog getData(UUID uuid) {
        return joinLogData.get(uuid);
    }

    @Override
    public synchronized Boolean replaceData(PlayerLog playerLog) throws Exception {
        PlayerLog legacy = joinLogData.get(playerLog.uuid());
        if (legacy.equals(playerLog))
            throw new Exception("Failed Replace Object > " + playerLog.uuid());

        joinLogData.replace(playerLog.uuid(), playerLog);
        return true;
    }

    @Override
    public synchronized Boolean removeData(UUID uuid) throws Exception  {
        if (joinLogData.get(uuid) == null)
            throw new Exception("Non Exists JoinData > " + uuid);

        joinLogData.remove(uuid);
        return true;
    }

    @Override
    public ArrayList<PlayerLog> getAllUserTable() {
        Bukkit.getOnlinePlayers().forEach(player -> getData(player.getUniqueId()));
        return new ArrayList<>(new ConcurrentHashMap<>(this.joinLogData).values());
    }

    @Override
    public void updateAllUserData(ArrayList<PlayerLog> newUserData) {
        this.joinLogData.clear();

        if (newUserData == null)
            return;

        newUserData.forEach(this::putData);
    }
}
