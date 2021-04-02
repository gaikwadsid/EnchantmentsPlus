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

public class Might extends CustomEnchantment {

	public static final int ID = 108;

	@Override
	public Builder<Might> defaults() {
		return new Builder<>(Might::new, ID)
			.propability(0)
			.all("Gains Luck",
				new Tool[]{Tool.HELMET},
				"Might",
				1,
				Hand.BOTH);		
	}
	
	public Might() {
        super(BaseEnchantments.MIGHT);
    }

	@Override
	public boolean onScan(Player player, int level, boolean usedHand) {
	    Utilities.addPotion((LivingEntity)player, PotionEffectType.LUCK, 610, 3);
	    return true;
	  }
}
