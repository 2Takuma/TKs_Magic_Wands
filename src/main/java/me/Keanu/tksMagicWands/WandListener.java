package me.Keanu.tksMagicWands;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.SpectralArrow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;
import org.bukkit.Sound;

public class WandListener implements Listener {

    @EventHandler
    public void onWandUse(PlayerInteractEvent event) {
        ItemStack item = event.getItem();

        if (item == null || item.getType() == Material.AIR || !item.hasItemMeta()) {
            return;
        }

        ItemMeta meta = item.getItemMeta();
        String type = meta.getPersistentDataContainer().get(Wand.TYPE_KEY, PersistentDataType.STRING);

        if (type == null) return;

        // Spell activation
        if (type.equals("Flight")) {
            handleFlight(event.getPlayer());
        }
        else if (type.equals("Fire")) {
            handleFire(event.getPlayer());
        }
        else if (type.equals("Lightning")) {
            handleLightning(event.getPlayer());
        }
        else if (type.equals("Teleportation")) {
            handleTeleport(event.getPlayer());
        }
        else if (type.equals("Gold")) {
            handleGold(event.getPlayer());
        }
        else if (type.equals("Heal")) {
            handleHeal(event.getPlayer());
        }


        int current = meta.getPersistentDataContainer().get(Wand.DURABILITY_KEY, PersistentDataType.INTEGER);
        current--;

        if (current <= 0) {
            event.getPlayer().sendMessage("§4The wand has broken.");
            event.getPlayer().getInventory().setItemInMainHand(null);
        }
        else {
            meta.getPersistentDataContainer().set(Wand.DURABILITY_KEY, PersistentDataType.INTEGER, current);
            WandManager.updateLore(meta, current, type);
            item.setItemMeta(meta);
        }

    }

    @EventHandler // Stops server from disabling glide if player is not wearing elytra
    public void onGlideToggle(EntityToggleGlideEvent event) {
        if (event.getEntity() instanceof Player player) {
            if (isHoldingWand(player)) {
                if (!player.isOnGround()) {
                    event.setCancelled(true);
                }
            }
        }
    }

    private boolean isHoldingWand(Player player) {
        ItemStack item = player.getInventory().getItemInMainHand();
        if (item.getType() == Material.AIR || !item.hasItemMeta()) return false;
        return item.getItemMeta().getPersistentDataContainer().has(Wand.WAND_KEY, PersistentDataType.BYTE);
    }

    private void handleFlight(Player player) {
        player.setVelocity(player.getLocation().getDirection().multiply(1.5));
        player.setGliding(true);
        player.playSound(player, Sound.ENTITY_BREEZE_WIND_BURST, 100.0f, 1.0f);
    }

    private void handleFire(Player player) {
        player.launchProjectile(org.bukkit.entity.Fireball.class);
        player.playSound(player, Sound.ITEM_FIRECHARGE_USE, 100.0f, 1.0f);
    }

    private void handleLightning(Player player) {
        Block target = player.getTargetBlock(null, 100);
        if (target != null && target.getType() != Material.AIR) {
            Location strikeLocation = target.getLocation();
            player.getWorld().strikeLightning(strikeLocation);
        }
    }

    private void handleTeleport(Player player) {
        Location newLoc = player.getLocation().add(player.getLocation().getDirection().multiply(5));
        player.teleport(newLoc);
        player.playSound(newLoc, Sound.ENTITY_ENDERMAN_TELEPORT, 100.0f, 1.0f);
    }

    private void handleGold(Player player) {
        Vector direction = player.getLocation().getDirection();
        SpectralArrow arrow = player.launchProjectile(SpectralArrow.class, direction);
        arrow.setShooter(player);
    }

    private void handleHeal(Player player) {
        player.setHealth(20.0);
    }

}