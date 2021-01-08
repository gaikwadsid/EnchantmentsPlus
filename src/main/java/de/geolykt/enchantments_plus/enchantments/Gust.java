/*
 * This file is part of EnchantmentsPlus, a bukkit plugin.
 * Copyright (c) 2015 - 2020 Zedly and Zenchantments contributors.
 * Copyright (c) 2020 - 2021 Geolykt and EnchantmentsPlus contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, version 3.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.geolykt.enchantments_plus.enchantments;

import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import de.geolykt.enchantments_plus.CustomEnchantment;
import de.geolykt.enchantments_plus.Storage;
import de.geolykt.enchantments_plus.compatibility.CompatibilityAdapter;
import de.geolykt.enchantments_plus.enums.BaseEnchantments;
import de.geolykt.enchantments_plus.enums.Hand;
import de.geolykt.enchantments_plus.util.Tool;

import static org.bukkit.event.block.Action.RIGHT_CLICK_AIR;
import static org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK;

public class Gust extends CustomEnchantment {

    public static final int ID = 25;

    @Override
    public Builder<Gust> defaults() {
        return new Builder<>(Gust::new, ID)
            .all("Pushes the user through the air at the cost of their health",
                    new Tool[]{Tool.SWORD},
                    "Gust",
                    1, // MAX LVL
                    Hand.RIGHT,
                    BaseEnchantments.RAINBOW_SLAM, BaseEnchantments.FORCE);
    }

    public Gust() {
        super(BaseEnchantments.GUST);
    }

    @Override
    public boolean onBlockInteract(final PlayerInteractEvent evt, int level, final boolean usedHand) {
        final Player player = evt.getPlayer();
        if (evt.getAction().equals(RIGHT_CLICK_AIR) || evt.getAction().equals(RIGHT_CLICK_BLOCK)) {
            if (player.getHealth() > 2 && (evt.getClickedBlock() == null ||
                evt.getClickedBlock().getLocation().distance(player.getLocation()) > 2)) {
                final Block blk = player.getTargetBlock(null, 10);
                player.setVelocity(blk.getLocation().toVector().subtract(player.getLocation().toVector())
                                      .multiply(.25 * power));
                player.setFallDistance(-40);
                ADAPTER.damagePlayer(player, 3, EntityDamageEvent.DamageCause.MAGIC);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Storage.plugin, () -> {
                    CompatibilityAdapter.damageTool(evt.getPlayer(), 1, usedHand);
                }, 1);
                return true;
            }
        }
        return false;
    }
}
