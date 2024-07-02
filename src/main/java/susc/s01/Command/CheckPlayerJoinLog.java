package susc.s01.Command;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import susc.s01.Command.Register.CommandMap;
import susc.s01.Command.Register.CommandRegister;
import susc.s01.Data.Log.JoinLog.PlayerLog;
import susc.s01.Data.Log.JoinLog.PlayerLogHandler;

public class CheckPlayerJoinLog extends CommandRegister {
    private boolean isSendCommandFromConsole = false;

    public CheckPlayerJoinLog() {
        super(CommandMap.CHECK_PLAYER_JOIN_LOG);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = null;
        if (sender instanceof Player p)
            player = p;
        else this.isSendCommandFromConsole = true;


        if (!this.isSendCommandFromConsole && !player.isOp()) {
            player.sendMessage(
                    Component.text("관리자 권한이 없습니다.")
                            .color(TextColor.color(233, 30, 100))
            );
            return false;
        }


        PlayerLog playerLog = PlayerLogHandler.getInstance().getData(Bukkit.getPlayer(args[0]).getUniqueId());
        if (!this.isSendCommandFromConsole)
            player.sendMessage(
                    Component.text(playerLog.toString())
                            .color(TextColor.color(196, 233, 3))
            );
        else Bukkit.getLogger().info(playerLog.toString());
        return true;
    }
}
