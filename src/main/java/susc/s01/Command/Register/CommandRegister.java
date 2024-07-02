package susc.s01.Command.Register;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class CommandRegister implements CommandExecutor {
    private final CommandMap kindOfCommand;

    public CommandRegister(CommandMap kindOfCommand) {
        this.kindOfCommand = kindOfCommand;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return false;
    }
}
