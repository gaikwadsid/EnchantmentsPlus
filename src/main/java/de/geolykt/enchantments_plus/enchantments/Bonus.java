package de.geolykt.enchantments_plus.enchantments;

import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

import de.geolykt.enchantments_plus.CustomEnchantment;
import de.geolykt.enchantments_plus.arrows.EnchantedArrow;
import de.geolykt.enchantments_plus.arrows.admin.ApocalypseArrow;
import de.geolykt.enchantments_plus.enums.BaseEnchantments;
import de.geolykt.enchantments_plus.enums.Hand;
import de.geolykt.enchantments_plus.util.Tool;

import static org.bukkit.potion.PotionEffectType.SLOW;


import java.util.Random;

public class Bonus extends CustomEnchantment {

	public static final int ID = 101;

	@Override
	public Builder<Bonus> defaults() {
		return new Builder<>(Bonus::new, ID)
			.propability(0)
			.all("Gain +2 Health",
				new Tool[]{Tool.HELMET, Tool.CHESTPLATE, Tool.LEGGINGS, Tool.BOOTS},
				"Bonus",
				1,
				Hand.BOTH);
	}
	
	public Bonus() {
        super(BaseEnchantments.BONUS);
    }

	@Override
	public boolean onScan(Player player, int level, boolean usedHand) {
		player.setMaxHealth(player.getMaxHealth() + 2);
	    return true;
	  }
}
