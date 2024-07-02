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
import susc.s01.Data.IOHandler;
import susc.s01.Data.Log.JoinLog.PlayerLogHandler;
import susc.s01.IOHandler.FileMap;

public class ExportingPlayerJoinLog extends CommandRegister {
    private boolean isSendCommandFromConsole = false;

    public ExportingPlayerJoinLog() {
        super(CommandMap.EXPORTING_PLAYER_JOIN_LOG);
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


        new IOHandler().exportData(
                FileMap.JOIN_LOG,
                getClass().getName(),
                PlayerLogHandler.getInstance().getAllUserTable()
        );


        String comment = "Success Exporting Data";
        if (!this.isSendCommandFromConsole)
            player.sendMessage(
                    Component.text(comment)
                    .color(TextColor.color(196, 233, 3))
            );
        else Bukkit.getLogger().info(comment);

        return true;
    }
}
