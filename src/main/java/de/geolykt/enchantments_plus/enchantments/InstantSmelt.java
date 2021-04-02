package de.geolykt.enchantments_plus.enchantments;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import de.geolykt.enchantments_plus.CustomEnchantment;
import de.geolykt.enchantments_plus.arrows.EnchantedArrow;
import de.geolykt.enchantments_plus.arrows.admin.ApocalypseArrow;
import de.geolykt.enchantments_plus.enums.BaseEnchantments;
import de.geolykt.enchantments_plus.enums.Hand;
import de.geolykt.enchantments_plus.util.Tool;

import static org.bukkit.potion.PotionEffectType.SLOW;


import java.util.Collection;
import java.util.Random;

public class InstantSmelt extends CustomEnchantment {

	public static final int ID = 106;

	@Override
	public Builder<InstantSmelt> defaults() {
		return new Builder<>(InstantSmelt::new, ID)
			.propability(0)
			.all("Ores are instantly smelted",
					new Tool[]{Tool.PICKAXE},
					"Telekinesis",
					1,
					Hand.BOTH);
	}
	
	public InstantSmelt() {
        super(BaseEnchantments.INSTANTSMELT);
    }

	@Override
	public boolean onBlockBreak(BlockBreakEvent evt, int level, boolean usedHand) {
		if (evt.getPlayer().getGameMode().equals(GameMode.CREATIVE))
		      return false; 
		    if (evt.getBlock().getType() == Material.GOLD_ORE || evt.getBlock().getType() == Material.IRON_ORE) {
		      Utilities.damageTool(evt.getPlayer(), 1, usedHand);
		      for (int x = 0; x < Storage.rnd.nextInt((int)Math.round(this.power * level + 1.0D)) + 1; x++)
		        evt.getBlock().getWorld().dropItemNaturally(evt.getBlock().getLocation(), new ItemStack(
		              (evt.getBlock().getType() == Material.GOLD_ORE) ? Material.GOLD_INGOT : Material.IRON_INGOT)); 
		      		      evt.getBlock().setType(Material.AIR);
		      
		      return true;
		    } 
		    return false;
	  }
}
