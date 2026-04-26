package me.Keanu.tksMagicWands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public class RecipeManager {
    public static void registerRecipes(JavaPlugin plugin) {
        ShapedRecipe flightWandRecipe = new ShapedRecipe(new NamespacedKey(plugin, "flight_wand_recipe"), WandManager.createWand("Flight"));
        flightWandRecipe.shape("WAW", "WSW", "WFW");
        flightWandRecipe.setIngredient('A', Material.AMETHYST_SHARD);
        flightWandRecipe.setIngredient('S', Material.BREEZE_ROD);
        flightWandRecipe.setIngredient('F', Material.FEATHER);
        flightWandRecipe.setIngredient('W', Material.WIND_CHARGE);
        Bukkit.addRecipe(flightWandRecipe);

        ShapedRecipe fireWandRecipe= new ShapedRecipe(new NamespacedKey(plugin, "fire_wand_recipe"), WandManager.createWand("Fire"));
        fireWandRecipe.shape(" C ", " B ", " M ");
        fireWandRecipe.setIngredient('C', Material.FIRE_CHARGE);
        fireWandRecipe.setIngredient('B', Material.BLAZE_ROD);
        fireWandRecipe.setIngredient('M', Material.MAGMA_CREAM);
        Bukkit.addRecipe(fireWandRecipe);

        ShapedRecipe lightningWandRecipe= new ShapedRecipe(new NamespacedKey(plugin, "lightning_wand_recipe"), WandManager.createWand("Lightning"));
        lightningWandRecipe.shape(" A ", "CBC", " R ");
        lightningWandRecipe.setIngredient('A', Material.AMETHYST_SHARD);
        lightningWandRecipe.setIngredient('B', Material.BREEZE_ROD);
        lightningWandRecipe.setIngredient('C', Material.COPPER_INGOT);
        lightningWandRecipe.setIngredient('R', Material.REDSTONE);
        Bukkit.addRecipe(lightningWandRecipe);

        ShapedRecipe TeleportWandRecipe = new ShapedRecipe(new NamespacedKey(plugin, "teleport_wand_recipe"), WandManager.createWand("Teleportation"));
        TeleportWandRecipe.shape(" P ", " S ", " E ");
        TeleportWandRecipe.setIngredient('P', Material.ENDER_PEARL);
        TeleportWandRecipe.setIngredient('S', Material.STICK);
        TeleportWandRecipe.setIngredient('E', Material.ENDER_EYE);
        Bukkit.addRecipe(TeleportWandRecipe);

        ShapedRecipe GoldenWandRecipe = new ShapedRecipe(new NamespacedKey(plugin, "golden_wand_recipe"), WandManager.createWand("Gold"));
        GoldenWandRecipe.shape(" A ", "GSG", " G ");
        GoldenWandRecipe.setIngredient('A', Material.SPECTRAL_ARROW);
        GoldenWandRecipe.setIngredient('G', Material.GOLD_INGOT);
        GoldenWandRecipe.setIngredient('S', Material.STICK);
        Bukkit.addRecipe(GoldenWandRecipe);

        ShapedRecipe HealWandRecipe = new ShapedRecipe(new NamespacedKey(plugin, "healing_wand_recipe"), WandManager.createWand("Heal"));
        HealWandRecipe.shape(" C ", " B ", " A ");
        HealWandRecipe.setIngredient('C', Material.GOLDEN_CARROT);
        HealWandRecipe.setIngredient('B', Material.BREEZE_ROD);
        HealWandRecipe.setIngredient('A', Material.GOLDEN_APPLE);
        Bukkit.addRecipe(HealWandRecipe);
    }
}
