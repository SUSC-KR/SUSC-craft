package susc.s01.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;
import susc.s01.Data.Log.JoinLog.PlayerLog;
import susc.s01.Data.Log.JoinLog.PlayerLogHandler;

import java.util.Calendar;
import java.util.TimeZone;

public class LoggingQuitPlayer {
    private final PlayerQuitEvent event;
    private final PlayerLogHandler playerLogHandler = PlayerLogHandler.getInstance();

    public LoggingQuitPlayer(PlayerQuitEvent event) {
        this.event = event;
        pushingPlayerQuitLog();
    }

    private void pushingPlayerQuitLog() {
        Player player = this.event.getPlayer();
        PlayerLog currentPlayerLogData = this.playerLogHandler.getData(player.getUniqueId());

        PlayerLog playerLog = new PlayerLog(
                player.getUniqueId(),
                player.getName(),
                currentPlayerLogData.joinCount(),
                currentPlayerLogData.joinDate(),
                Calendar.getInstance(TimeZone.getTimeZone("JST"))
        );

        try {
            playerLogHandler.replaceData(playerLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
