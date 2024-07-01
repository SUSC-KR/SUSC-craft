package susc.s01.Data.Log.JoinLog;

import susc.s01.Data.Log.Log;

import java.util.Calendar;
import java.util.UUID;

public record PlayerLog(
        UUID uuid,
        String playerName,
        int joinCount,
        Calendar joinDate,
        Calendar leaveDate
) implements Log {
}
