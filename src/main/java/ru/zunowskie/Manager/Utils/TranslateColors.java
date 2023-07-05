package ru.zunowskie.Manager.Utils;

import org.bukkit.ChatColor;

public class TranslateColors {


    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}