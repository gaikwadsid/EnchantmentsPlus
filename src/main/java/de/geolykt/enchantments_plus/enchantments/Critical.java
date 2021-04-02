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

public class Critical extends CustomEnchantment {

	public static final int ID = 102;

	@Override
	public Builder<Critical> defaults() {
		return new Builder<>(Critical::new, ID)
			.propability(0)
			.all("Land a crit without jumping",
				new Tool[]{Tool.SWORD},
				"Critical",
				3,
				Hand.BOTH);
	}
	
	public Critical() {
        super(BaseEnchantments.CRITICAL);
    }

	
	@Override
	public boolean onEntityHit(EntityDamageByEntityEvent evt, int level, boolean usedHand) {
		if (evt.getEntity() instanceof LivingEntity && ADAPTER
			      .attackEntity((LivingEntity)evt.getEntity(), (Player)evt.getDamager(), 0.0D)) {
			      Player player = (Player)evt.getDamager();
			      Random randy = new Random();
			      if(randy.nextFloat()<level*.02) {
			      player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(evt.getDamage()+4);
			      }
			}
		
		return true;
	}
}
