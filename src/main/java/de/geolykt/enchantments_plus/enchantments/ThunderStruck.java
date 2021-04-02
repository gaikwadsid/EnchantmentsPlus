package de.geolykt.enchantments_plus.enchantments;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

import de.geolykt.enchantments_plus.CustomEnchantment;
import de.geolykt.enchantments_plus.arrows.EnchantedArrow;
import de.geolykt.enchantments_plus.arrows.admin.ApocalypseArrow;
import de.geolykt.enchantments_plus.enums.BaseEnchantments;
import de.geolykt.enchantments_plus.enums.Hand;
import de.geolykt.enchantments_plus.util.Tool;

import static org.bukkit.potion.PotionEffectType.SLOW;


import java.util.List;
import java.util.Random;

public class ThunderStruck extends CustomEnchantment {
	

	public static final int ID = 110;

	@Override
	public Builder<ThunderStruck> defaults() {
		return new Builder<>(ThunderStruck::new, ID)
			.propability(0)
			.all("Strikes lightning at your enemies",
			new Tool[]{Tool.BOW},
			"Thunder Struck",
			1,
			Hand.BOTH);
	}
	
	public ThunderStruck() {
        super(BaseEnchantments.THUNDERSTRUCK);
    }

	
	@Override
	public boolean onEntityHit(EntityDamageByEntityEvent evt, int level, boolean usedHand) {
		if (evt.getEntity() instanceof Player) {
			Player p = (Player) evt.getEntity();
			World world = p.getWorld();
			Location loc = p.getLocation();
			world.strikeLightning(loc);
		
			
		}
		return true;
	}
	
}
