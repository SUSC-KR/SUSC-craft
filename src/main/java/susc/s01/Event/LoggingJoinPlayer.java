package susc.s01.Event;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import susc.s01.Data.Log.JoinLog.PlayerLog;
import susc.s01.Data.Log.JoinLog.PlayerLogHandler;

import java.util.Calendar;
import java.util.TimeZone;

public class LoggingJoinPlayer {
    private final PlayerJoinEvent event;
    private final PlayerLogHandler playerLogHandler = PlayerLogHandler.getInstance();

    public LoggingJoinPlayer(PlayerJoinEvent event) {
        this.event = event;
        pushingPlayerJoinLog();
    }

    private void pushingPlayerJoinLog() {
        /*
        처음 접속하면 0으로 뜸
        */
        Player player = this.event.getPlayer();

        PlayerLog currentPlayerLogData = this.playerLogHandler.getData(player.getUniqueId());
        int playerJoinCount = 0;
        if (currentPlayerLogData != null)
            currentPlayerLogData.joinCount();

        PlayerLog playerLog = new PlayerLog(
                player.getUniqueId(),
                player.getName(),
                playerJoinCount,
                Calendar.getInstance(TimeZone.getTimeZone("JST")),
                Calendar.getInstance(TimeZone.getTimeZone("JST"))
        );

        playerLogHandler.putData(playerLog);
    }
}
