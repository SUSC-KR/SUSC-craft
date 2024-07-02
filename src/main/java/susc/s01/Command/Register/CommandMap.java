package susc.s01.Command.Register;

import org.bukkit.command.CommandExecutor;
import susc.s01.Command.CheckPlayerJoinLog;
import susc.s01.Command.ExportingPlayerJoinLog;

public enum CommandMap {
    EXPORTING_PLAYER_JOIN_LOG("ExportingPlayerJoinLog", new ExportingPlayerJoinLog()),
    CHECK_PLAYER_JOIN_LOG("CheckPlayerJoinLog", new CheckPlayerJoinLog());

    private final String commandLabel;
    private final CommandExecutor executeCommandInstance;

    CommandMap(String commandLabel, CommandExecutor executeCommandInstance) {
        this.commandLabel = commandLabel;
        this.executeCommandInstance = executeCommandInstance;
    }

    public String getCommandLabel() {
        return commandLabel;
    }

    public CommandExecutor getExecuteCommandInstance() {
        return executeCommandInstance;
    }
}
