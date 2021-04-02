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

import static org.bukkit.potion.PotionEffectType.SLOW;


public class Freezer extends CustomEnchantment {

	public static final int ID = 104;

	@Override
	public Builder<Freezer> defaults() {
		return new Builder<>(Freezer::new, ID)
			.propability(0)
			.all("Temporarily freezes the target",
			new Tool[]{Tool.BOW, Tool.CROSSBOW, Tool.TRIDENT},
			"Freezer",
			2,
			Hand.BOTH);
			.cooldownMillis(30000);
	}
	
	public Freezer() {
        super(BaseEnchantments.FREEZER);
    }

	@Override
	public boolean onEntityHit(EntityDamageByEntityEvent evt, int level, boolean usedHand) {
		Utilities.addPotion((LivingEntity) evt.getEntity(), PotionEffectType.SLOW,
				(int) Math.round(power * level * 2), 250);
		return true;
	}
}
