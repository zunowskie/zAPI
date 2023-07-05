package ru.zunowskie;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import ru.zunowskie.Commands.MainCMD;
import ru.zunowskie.Manager.Utils.TabCmpl;

public final class zAPI extends JavaPlugin {



    public static zAPI instance;
    public static zAPI getInstance(){
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        loadModules();
        logo();

    }

    @Override
    public void onDisable() {
        saveConfig();
    }



    public void loadModules(){
        saveDefaultConfig();
        getCommand("zapi").setExecutor(new MainCMD());
        getServer().getPluginCommand("zapi").setTabCompleter(new TabCmpl());

    }


    public void logo(){


        Bukkit.getLogger().info("§e| §c███████╗░█████╗░██████╗░██╗");
        Bukkit.getLogger().info("§e| §c╚════██║██╔══██╗██╔══██╗██║");
        Bukkit.getLogger().info("§e| §c░░███╔═╝███████║██████╔╝██║");
        Bukkit.getLogger().info("§e| §c██╔══╝░░██╔══██║██╔═══╝░██║");
        Bukkit.getLogger().info("§e| §c███████╗██║░░██║██║░░░░░██║");
        Bukkit.getLogger().info("§e| §c╚══════╝╚═╝░░╚═╝╚═╝░░░░░╚═╝");
        Bukkit.getLogger().info("§e| §fПлагин §6zAPI §7 §fВерсия плагина - §a1.0");
        Bukkit.getLogger().info("§e| §fРазработчик - §e§nvk.com/zunowi §f");
        Bukkit.getLogger().info("");


        // logo
    }
}
