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

public class Whet extends CustomEnchantment {

	public static final int ID = 111;

	@Override
	public Builder<Whet> defaults() {
		return new Builder<>(Whet::new, ID)
			.propability(0)
			.all("Sharpness for Trident",
			new Tool[]{Tool.TRIDENT},
			"Whet",
			5,
			Hand.BOTH);
	}
	
	public Whet() {
        super(BaseEnchantments.WHET);
    }

	@Override
	public boolean onEntityHit(EntityDamageByEntityEvent evt, int level, boolean usedHand) {
		
		if (evt.getEntity() instanceof LivingEntity && ADAPTER
			      .attackEntity((LivingEntity)evt.getEntity(), (Player)evt.getDamager(), 0.0D)) {
			      Player player = (Player)evt.getDamager();
			     
			      player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue((int) Math.round(.5 * level + .5));	      
			}
	
		return true;
	}
}
