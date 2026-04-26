package me.Keanu.tksMagicWands;

import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;
public class Wand {
    public static NamespacedKey WAND_KEY;
    public static NamespacedKey DURABILITY_KEY;
    public static NamespacedKey TYPE_KEY;
    public static final int MAX_DURABILITY = 128;

    public static void init(JavaPlugin plugin) {
        WAND_KEY = new NamespacedKey(plugin, "is_magic_wand");
        DURABILITY_KEY = new NamespacedKey(plugin, "wand_durability");
        TYPE_KEY = new NamespacedKey(plugin, "wand_type");
    }

}
