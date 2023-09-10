package ru.zunowskie.manager.utils;

import org.bukkit.ChatColor;

public class TranslateColors {


    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
}