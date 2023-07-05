package ru.zunowskie.Manager.Utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.List;

public class TabCmpl implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            return Arrays.asList("download", "help");
        }
        if (args.length == 2 && args[0].equalsIgnoreCase("download")) {
            return Arrays.asList("zChatPers", "zTPSControls");
        }

        return null;
    }
}
