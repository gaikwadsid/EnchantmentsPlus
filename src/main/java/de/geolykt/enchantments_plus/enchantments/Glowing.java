package de.geolykt.enchantments_plus.enchantments;

import static org.bukkit.potion.PotionEffectType.SLOW;

import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

import de.geolykt.enchantments_plus.CustomEnchantment;
import de.geolykt.enchantments_plus.arrows.EnchantedArrow;
import de.geolykt.enchantments_plus.arrows.admin.ApocalypseArrow;
import de.geolykt.enchantments_plus.enums.BaseEnchantments;
import de.geolykt.enchantments_plus.enums.Hand;
import de.geolykt.enchantments_plus.util.Tool;

public class Glowing extends CustomEnchantment{
	
    public static final int ID = 105;
    
    @Override
    public Builder<Glowing> defaults(){
    	return new Builder<>(Glowing::new, ID)
    		.propability(0)
			.all("Temporarily shows the target",
				new Tool[]{Tool.SWORD, Tool.AXE},
				"Glowing",
				1,
				Hand.BOTH);
    }
    
    public Glowing() {
        super(BaseEnchantments.GLOWING);
    }

		@Override
		public boolean onEntityHit(EntityDamageByEntityEvent evt, int level, boolean usedHand) {
			Utilities.addPotion((LivingEntity) evt.getEntity(), PotionEffectType.GLOWING,
				(int) Math.round(40 + level * power * 40), (int) Math.round(power * level * 2));
			Utilities.display(Utilities.getCenter(evt.getEntity().getLocation()), Particle.CLOUD, 10, .1f, 1f, 2f, 1f);
			return true;
		}
    }



