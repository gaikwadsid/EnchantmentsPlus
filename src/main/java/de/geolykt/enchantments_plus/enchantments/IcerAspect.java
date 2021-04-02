package de.geolykt.enchantments_plus.enchantments;

import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

import de.geolykt.enchantments_plus.CustomEnchantment;
import de.geolykt.enchantments_plus.arrows.EnchantedArrow;
import de.geolykt.enchantments_plus.arrows.admin.ApocalypseArrow;
import de.geolykt.enchantments_plus.enums.BaseEnchantments;
import de.geolykt.enchantments_plus.enums.Hand;
import de.geolykt.enchantments_plus.util.Tool;


public class IcerAspect extends CustomEnchantment {

	public static final int ID = 112;

	@Override
	public Builder<IcerAspect> defaults() {
		return new Builder<>(IcerAspect::new, ID)
			.propability(0)
			.all("Temporarily freezes the target",
					new Tool[]{Tool.SWORD, Tool.AXE},
					"Icer Aspect",
					2,
					Hand.BOTH);
			.cooldownMillis(30000);
				
	}
	
	public IcerAspect() {
        super(BaseEnchantments.ICERASPECT);
    }
	
	

	@Override
	public boolean onEntityHit(EntityDamageByEntityEvent evt, int level, boolean usedHand) {
		Utilities.addPotion((LivingEntity) evt.getEntity(), PotionEffectType.SLOW,
				(int) Math.round(power * level * 2), 250);
		Utilities.display(Utilities.getCenter(evt.getEntity().getLocation()), Particle.CLOUD, 10, .1f, 1f, 2f, 1f);
		return true;
	}
}
