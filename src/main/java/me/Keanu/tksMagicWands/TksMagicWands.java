package me.Keanu.tksMagicWands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public final class TksMagicWands extends JavaPlugin {

    @Override
    public void onEnable() {
        Wand.init(this);
        RecipeManager.registerRecipes(this);
        getServer().getPluginManager().registerEvents(new WandListener(), this);
        getLogger().info("Takuma's Wand Plugin has been enabled!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("Takuma's Wand Plugin has been disabled.");
    }



}


