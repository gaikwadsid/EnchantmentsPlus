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


public class LifeSteal extends CustomEnchantment {

	public static final int ID = 107;

	@Override
	public Builder<LifeSteal> defaults() {
		return new Builder<>(LifeSteal::new, ID)
			.propability(0)
			.all("Gain Health for each kill",
					new Tool[]{Tool.SWORD, Tool.AXE, Tool.BOW, Tool.TRIDENT, Tool.CROSSBOW},
					"Life Steal",
					3,
					Hand.BOTH);
	}
	
	public LifeSteal() {
        super(BaseEnchantments.LIFESTEAL);
    }
	
	
	@Override
	public boolean onEntityHit(EntityDamageByEntityEvent evt, int level, boolean usedHand) {
		if (evt.getEntity() instanceof LivingEntity && ADAPTER
			      .attackEntity((LivingEntity)evt.getEntity(), (Player)evt.getDamager(), 0.0D)) {
			      Player player = (Player)evt.getDamager();
			      if (player.getHealth() + level/2 <= player.getMaxHealth()) {
			          player.setHealth(player.getHealth() + level/2); 
			}
		}
		return true;
	}
}
