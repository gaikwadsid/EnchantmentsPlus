package de.geolykt.enchantments_plus.enchantments;

import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffectType;

import de.geolykt.enchantments_plus.CustomEnchantment;
import de.geolykt.enchantments_plus.arrows.EnchantedArrow;
import de.geolykt.enchantments_plus.arrows.admin.ApocalypseArrow;
import de.geolykt.enchantments_plus.enums.BaseEnchantments;
import de.geolykt.enchantments_plus.enums.Hand;
import de.geolykt.enchantments_plus.util.Tool;

import static org.bukkit.potion.PotionEffectType.SLOW;


import java.util.List;
import java.util.Random;

public class Deforester extends CustomEnchantment {
	
	private static final int MAX_BLOCKS = 200;
	  
	  public static int[][] SEARCH_FACES = new int[][] { {} };

	public static final int ID = 103;

	@Override
	public Builder<Deforester> defaults() {
		return new Builder<>(Deforester::new, ID)
			.propability(0)
			.all("Breaks more of a tree",
				new Tool[]{Tool.AXE},
				"Deforester",
				3,
				Hand.BOTH);
	}
	
	public Deforester() {
        super(BaseEnchantments.DEFORESTER);
    }

	
	@Override
	public boolean onBlockBreak(BlockBreakEvent evt, int level, boolean usedHand) {
	    if (!evt.getPlayer().isSneaking())
	      return false; 
	    Block startBlock = evt.getBlock();
	    if (!Storage.COMPATIBILITY_ADAPTER.TrunkBlocks().contains(startBlock.getType()))
	      return false; 
	    List<Block> blocks = Utilities.BFS(startBlock, level*3, true, Float.MAX_VALUE, SEARCH_FACES, Storage.COMPATIBILITY_ADAPTER
	        .TrunkBlocks(), Storage.COMPATIBILITY_ADAPTER.LumberWhitelist(), true, false);
	    for (Block b : blocks)
	      ADAPTER.breakBlockNMS(b, evt.getPlayer()); 
	    return !blocks.isEmpty();
	  }
}
