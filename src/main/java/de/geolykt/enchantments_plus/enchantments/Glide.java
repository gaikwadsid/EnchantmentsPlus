package de.geolykt.enchantments_plus.enchantments;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

import de.geolykt.enchantments_plus.Config;
import de.geolykt.enchantments_plus.CustomEnchantment;
import de.geolykt.enchantments_plus.compatibility.CompatibilityAdapter;
import de.geolykt.enchantments_plus.enums.BaseEnchantments;
import de.geolykt.enchantments_plus.enums.Hand;
import de.geolykt.enchantments_plus.util.Tool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static org.bukkit.Material.AIR;

public class Glide extends CustomEnchantment {

    // The players using glide and their most recent Y coordinate
    public static final Map<Player, Double> sneakGlide = new HashMap<>();
    public static final int ID = 20;

    @Override
    public Builder<Glide> defaults() {
        return new Builder<>(Glide::new, ID)
                .all(BaseEnchantments.GLIDE,
                        "Gently brings the player back to the ground when sneaking",
                        new Tool[]{Tool.LEGGINGS},
                        "Glide",
                        3, // MAX LVL
                        Hand.NONE);
    }

    private static final EquipmentSlot[] SLOTS = 
            new EquipmentSlot[] {EquipmentSlot.FEET, EquipmentSlot.LEGS, EquipmentSlot.CHEST, EquipmentSlot.HEAD};
    
    @Override
    public boolean onFastScan(Player player, int level, boolean usedHand) {
        if (!sneakGlide.containsKey(player)) {
            sneakGlide.put(player, player.getLocation().getY());
        }
        if (!player.isSneaking() || sneakGlide.get(player) == player.getLocation().getY()) {
            return false;
        }
        boolean b = false;
        for (int i = -5; i < 0; i++) {
            if (player.getLocation().getBlock().getRelative(0, i, 0).getType() != AIR) {
                b = true;
            }
        }
        if (player.getVelocity().getY() > -0.5) {
            b = true;
        }
        if (!b) {
            double cosPitch = Math.cos(Math.toRadians(player.getLocation().getPitch()));
            double sinYaw = Math.sin(Math.toRadians(player.getLocation().getYaw()));
            double cosYaw = Math.cos(Math.toRadians(player.getLocation().getYaw()));
            Vector v = new Vector(-cosPitch * sinYaw, 0, -1 * (-cosPitch * cosYaw));
            v.multiply(level * power / 2);
            v.setY(-1);
            player.setVelocity(v);
            player.setFallDistance((float) (6 - level * power) - 4);
            Location l = player.getLocation().clone();
            l.setY(l.getY() - 3);
            CompatibilityAdapter.display(l, Particle.CLOUD, 1, .1f, 0, 0, 0);
        }
        if (ThreadLocalRandom.current().nextInt(5 * level) == 5) { // Slowly damage all armor
            for (EquipmentSlot slot : SLOTS) {
                final ItemStack s = player.getInventory().getItem(slot);
                if (s != null
                        && CustomEnchantment.hasEnchantment(Config.get(player.getWorld()), s, BaseEnchantments.GLIDE)
                        && CompatibilityAdapter.damageItem2(s, level)) {
                    player.getInventory().setItem(slot, new ItemStack(Material.AIR));
                }
            }
        }
        sneakGlide.put(player, player.getLocation().getY());
        return true;
    }

}
