package me.dovide.colorutil;

import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ColorUtil {

    private static final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    public static String colorize(String text) {
        // For HEX Colors
        text = getHEXString(text);
        //Normal colorize
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    private static String getHEXString(String text) {
        Matcher match = pattern.matcher(text);
        while (match.find()) {
            String newText = text.substring(match.start(), match.end());
            text = text.replace(newText, ChatColor.of(newText) + "");
            match = pattern.matcher(text);
        }

        return text;
    }

}
