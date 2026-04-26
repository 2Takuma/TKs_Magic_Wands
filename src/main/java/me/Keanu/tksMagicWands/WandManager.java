package me.Keanu.tksMagicWands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import java.util.ArrayList;
import java.util.List;

public class WandManager {
    public static ItemStack createWand(String type) {
        ItemStack item = new ItemStack(Material.STICK);
        ItemMeta meta = item.getItemMeta();

        if (meta != null) {
            meta.getPersistentDataContainer().set(Wand.TYPE_KEY, PersistentDataType.STRING, type);
            meta.getPersistentDataContainer().set(Wand.WAND_KEY, PersistentDataType.BYTE, (byte) 1);
            meta.getPersistentDataContainer().set(Wand.DURABILITY_KEY, PersistentDataType.INTEGER, Wand.MAX_DURABILITY);

            if (type.equals("Flight")) {
                meta.setDisplayName("§d§lWand of Flight");
            }
            else if (type.equals("Fire")) {
                meta.setDisplayName("§c§lWand of Fire");
            }
            else if (type.equals("Lightning")) {
                meta.setDisplayName("§b§lWand of Lightning");
            }
            else if (type.equals("Teleportation")) {
                meta.setDisplayName("§1§lWand of Teleportation");
            }
            else if (type.equals("Gold")) {
                meta.setDisplayName("§6§lWand of Gold");
            }
            else if (type.equals("Heal")) {
                meta.setDisplayName("§a§lWand of Healing");
            }

            updateLore(meta, Wand.MAX_DURABILITY, type); // Pass type to Lore
            item.setItemMeta(meta);
        }
        return item;
    }

    public static void updateLore(ItemMeta meta, int currentDurability, String type) {
        List<String> lore = new ArrayList<>();

        if (type.equals("Flight")) {
            lore.add("§7Right click to fly!");
        }
        else if (type.equals("Fire")) {
            lore.add("§7Right click to shoot fire!");
        }
        else if (type.equals("Lightning")) {
            lore.add("§7Right click to summon Lightning!");
        }
        else if (type.equals("Teleportation")) {
            lore.add("§7Right click to teleport forward!");
        }
        else if (type.equals("Gold")) {
            lore.add("§7Right click to shoot golden arrows!");
        }
        else if (type.equals("Heal")) {
            lore.add("§7Right click to heal health!");
        }

        lore.add("");
        lore.add("§fDurability: §e" + currentDurability + " / " + Wand.MAX_DURABILITY);
        meta.setLore(lore);
    }
}
