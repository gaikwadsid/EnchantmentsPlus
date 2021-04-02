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

public class Energy extends CustomEnchantment {

	public static final int ID = 113;

	@Override
	public Builder<Energy> defaults() {
		return new Builder<>(Energy::new, ID)
			.propability(0)
			.all("Power for crossbows",
					new Tool[]{Tool.CROSSBOW},
				"Energy",
				5,
				Hand.BOTH);
	}
	
	public Energy() {
        super(BaseEnchantments.ENERGY);
    }
	

	@Override
	public boolean onEntityHit(EntityDamageByEntityEvent evt, int level, boolean usedHand) {

		
		if (evt.getEntity() instanceof LivingEntity && ADAPTER
			      .attackEntity((LivingEntity)evt.getEntity(), (Player)evt.getDamager(), 0.0D)) {
			      Player player = (Player)evt.getDamager();
			     
			      player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue((int) Math.round(1.25*(level+1)));	      
			}
	
		return true;
	}
}
