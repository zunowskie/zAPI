package ru.zunowskie.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import ru.zunowskie.manager.DowloadToPlugins;

public class MainCMD implements CommandExecutor {
    public static String c(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(c("&6&lzAPI: &fДанную команду можно выполнять только игрокам!"));
            return true;

        } else {
            if (cmd.getName().equalsIgnoreCase("zapi")) {
                if (args.length == 0) {
                    String message = "&6╔\n" +
                            "§6║ &fПривет &a" + sender.getName() + "\n" +
                            "§6║\n" +
                            "§6║ &fБлагодарю за &aиспользование &fплагинов &6zunowskie\n" +
                            "§6║\n" +
                            "§6║ &6&lzAPI - &a&lАПИ &fдля запуска и &eкорректной &fработы плагинов &6Z\n" +
                            "§6║\n" +
                            "§6║ &fВерсия - &a1.0\n" +
                            "§6║\n" +
                            "§6║ &fКоманды &6&lzAPI\n" +
                            "§6║\n" +
                            "§6║ &e&l/zapi &adownload - &fданная команда скачивает плагины\n" +
                            "§6║ &fс репозитория &6zunowskie\n" +
                            "§6║\n" +
                            "§6║ &e&l/zapi &ahelp - &fконтакты &6zunowskie\n" +
                            "§6╚";

                    sender.sendMessage(c(message));
                    return true;

                }

                switch (args[0].toLowerCase()) {
                    case "help":
                        String message = "&6╔\n" +
                                "§6║ &fКонтакты &6zunowskie\n" +
                                "§6║\n" +
                                "§6║ &b&lVK: &6https://bio.hushworld.fun\n" +
                                "§6╚";
                        sender.sendMessage(c(message));
                        break;
                    case "download":
                        if (args.length == 1) {
                            String message2 = "&6╔\n" +
                                    "§6║ &f&lПривет, &a" + sender.getName() + "\n" +
                                    "§6║\n" +
                                    "§6║ &fТебя приветствует &eмастер &fустановщик плагинов &6zunowskie!\n" +
                                    "§6║\n" +
                                    "§6║ &fДанная &aутилита &fбыла создана для быстрого\n" +
                                    "§6║ &fскачивания из репозитория &6zunowskie\n" +
                                    "§6║\n" +
                                    "§6║ &fДоступные &aкоманды &eдля &fскачивания плагина\n" +
                                    "§6║\n" +
                                    "§6║ &f/zapi &edownload &aплагин\n" +
                                    "§6╚";

                            sender.sendMessage(c(message2));
                            break;
                        }


                }


                if (args[0].equalsIgnoreCase("download")) {
                    if (args.length == 1) {
                        String message = "&6╔\n" +
                                "§6║ &f&lПривет, &a" + sender.getName() + "\n" +
                                "§6║\n" +
                                "§6║ &fТебя приветствует &eмастер &fустановщик плагинов &6zunowskie!\n" +
                                "§6║\n" +
                                "§6║ &fДанная &aутилита &fбыла создана для быстрого\n" +
                                "§6║ &fскачивания из репозитория &6zunowskie\n" +
                                "§6║\n" +
                                "§6║ &fДоступные &aкоманды &eдля &fскачивания плагина\n" +
                                "§6║\n" +
                                "§6║ &f/zapi &edownload &aплагин\n" +
                                "§6╚";

                        sender.sendMessage(c(message));
                        return true;
                    }

                    if (args[1].equalsIgnoreCase("zChatPers")) {


                        if (!Bukkit.getServer().getVersion().contains("1.16.5")) {
                            sender.sendMessage(c("&6&lzAPI: &fВерсия вашего сервера не поддерживает данный плагин."));
                            return true;
                        }

                        if (Bukkit.getPluginManager().getPlugin("zChatPers") != null) {
                            sender.sendMessage(c("&6&lzAPI: &fПлагин уже загружен. Загрузка &eотменена"));
                            return true;
                        }

                        if (Bukkit.getPluginManager().getPlugin("VK-API") == null) {
                            sender.sendMessage(c("&6&lzAPI: &fУстановите библиотеку VK-API Bukkit и настройте ее. Потом повторите скачивание"));
                            return true;
                        }

                        sender.sendMessage(c("&6&lzAPI: &fНачинаю скачивать плагин с репозитория zunowskie..."));

                        DowloadToPlugins.toDowload("https://github.com/zunowskie/zChatPers/releases/latest/download/zChatPers.1.16.5.jar", "plugins", "zChatPers.jar", () -> {

                            sender.sendMessage(c("&6&lzAPI: &fПлагин был успешно загружен и запущен"));
                        });
                    }
                    if (args[1].equalsIgnoreCase("zRespawn")) {
                        if (Bukkit.getPluginManager().getPlugin("zRespawn") != null) {

                            sender.sendMessage(c("&6&lzAPI: &fПлагин уже загружен. Загрузка &eотменена"));
                            return true;
                        }

                        sender.sendMessage(c("&6&lzAPI: &fНачинаю скачивать плагин с репозитория zunowskie..."));

                        DowloadToPlugins.toDowload("https://github.com/zunowskie/zRespawn/releases/latest/download/zRespawn.jar", "plugins", "zRespawn.jar", () -> {

                            sender.sendMessage(c("&6&lzAPI: &fПлагин был успешно загружен и запущен"));
                        });

                    }
                    if (args[1].equalsIgnoreCase("zBoss")) {
                        if (Bukkit.getPluginManager().getPlugin("zBoss") != null) {
                            sender.sendMessage(c("&6&lzAPI: &fПлагин уже загружен. Загрузка &eотменена"));
                            return true;
                        }

                        if (Bukkit.getServer().getVersion().contains("1.12.2")) {
                            sender.sendMessage(c("&6&lzAPI: &fНачинаю скачивать плагин с репозитория zunowskie..."));

                            DowloadToPlugins.toDowload("https://github.com/zunowskie/zBoss/releases/latest/download/zBoss.jar", "plugins", "zBoss.jar", () -> {
                                sender.sendMessage(c("&6&lzAPI: &fПлагин был успешно загружен и запущен"));
                            });
                            return true;
                        } else {
                            if (args.length >= 3 && args[2].equalsIgnoreCase("confirm")) {
                                sender.sendMessage(c("&6&lzAPI: &fНачинаю скачивать плагин с репозитория zunowskie..."));

                                DowloadToPlugins.toDowload("https://github.com/zunowskie/zBoss/releases/latest/download/zBoss.jar", "plugins", "zBoss.jar", () -> {
                                    sender.sendMessage(c("&6&lzAPI: &fПлагин был успешно загружен и запущен"));
                                });
                                return true;
                            } else {
                                sender.sendMessage(c("&6&lzAPI: &fСвыше версии 1.12.2 плагин не проверялся! Могут быть ошибки и т.д. Если вы уверены что хотите установить то напиши /zapi download zBoss confirm"));
                            }
                        }
                    }


                    if (args[1].equalsIgnoreCase("zTPSControls ")) {

                        if (!Bukkit.getServer().getVersion().contains("1.16.5")) {
                            sender.sendMessage(c("&6&lzAPI: &fВерсия вашего сервера не поддерживает данный плагин."));
                            return true;
                        }

                        if (Bukkit.getPluginManager().getPlugin("zTPSControls ") != null) {

                            sender.sendMessage(c("&6&lzAPI: &fПлагин уже загружен. Загрузка &eотменена"));
                            return true;
                        }

                        sender.sendMessage(c("&6&lzAPI: &fНачинаю скачивать плагин с репозитория zunowskie..."));

                        DowloadToPlugins.toDowload("https://github.com/zunowskie/zTPSControls/releases/latest/download/zTPSControl.jar", "plugins", "zRespawn.jar", () -> {

                            sender.sendMessage(c("&6&lzAPI: &fПлагин был успешно загружен и запущен"));
                        });

                    }

                }
            }
        }

        return true;
    }
}
