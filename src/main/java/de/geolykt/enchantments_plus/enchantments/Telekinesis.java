package de.geolykt.enchantments_plus.enchantments;

import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

import de.geolykt.enchantments_plus.CustomEnchantment;
import de.geolykt.enchantments_plus.arrows.EnchantedArrow;
import de.geolykt.enchantments_plus.arrows.admin.ApocalypseArrow;
import de.geolykt.enchantments_plus.enums.BaseEnchantments;
import de.geolykt.enchantments_plus.enums.Hand;
import de.geolykt.enchantments_plus.util.Tool;

import static org.bukkit.potion.PotionEffectType.SLOW;

import java.util.Collection;
import java.util.Random;

public class Telekinesis extends CustomEnchantment {

	public static final int ID = 109;

	@Override
	public Builder<Telekinesis> defaults() {
		return new Builder<>(Telekinesis::new, ID)
			.propability(0)
			.all("Blocks go directly into your inventory",
			new Tool[]{Tool.PICKAXE, Tool.SHOVEL},
			"Telekinesis",
			1,
			Hand.BOTH);
	}
	
	public Telekinesis() {
        super(BaseEnchantments.TELEKINESIS);
    }

	@Override
	public boolean onBlockBreak(BlockBreakEvent evt, int level, boolean usedHand) {
		evt.setDropItems(false);
		Player player = evt.getPlayer();
		Block block = (Block) evt.getBlock();
		Collection<ItemStack> drops = block.getDrops(player.getInventory().getItemInMainHand());
		if(drops.isEmpty()) {
			return false; 
		}
		
		player.getInventory().addItem(drops.iterator().next());
		
	    return true;
	  }
}
