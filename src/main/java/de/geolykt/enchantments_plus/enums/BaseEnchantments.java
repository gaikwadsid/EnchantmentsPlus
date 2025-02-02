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
package de.geolykt.enchantments_plus.enums;

/**
 * Enumeration of the Enchantments in the stock Release
 * @since 1.1.0
 */
public enum BaseEnchantments {

    ANTHROPOMORPHISM(1),
    APOCALYPSE(69),
    ARBORIST(2),
    BIND(4),
    BLAZES_CURSE(5),
    BLIZZARD(6),
    BOUNCE(7),
    BURST(8),
    COMBUSTION(9),
    CONVERSION(10),
    CUSTOM(0),
    DECAPITATION(11),
    ETHERAL(70),
    EXTRACTION(12),
    FIRE(13),
    FIRESTORM(14),
    FIREWORKS(15),
    FORCE(16),
    FROZEN_STEP(17),
    FUSE(18),
    GERMINATION(19),
    GLIDE(20),
    GLUTTONY(21),
    GOLD_RUSH(22),
    GRAB(23),
    GREEN_THUMB(24),
    GUST(25),
    HARVEST(26),
    HASTE(27),
    ICE_ASPECT(29),
    JUMP(30),
    LASER(31),
    LEVEL(32),
    LONG_CAST(33),
    LUMBER(34),
    MAGNETISM(35),
    MEADOR(36),
    MISSILE(71),
    MOW(37),
    MYSTERY_FISH(38),
    NETHER_STEP(39),
    NIGHT_VISION(40),
    PERSEPHONE(41),
    PIERCE(42),
    PLOUGH(43),
    POTION(44),
    POTION_RESISTANCE(45),
    QUICK_SHOT(46),
    RAINBOW(47),
    RAINBOW_SLAM(48),
    REAPER(49),
    REVEAL(68),
    SATURATION(50),
    SHORT_CAST(51),
    SHRED(52),
    SINGULARITY(72),
    SIPHON(53),
    SONIC_SHOCK(75),
    SPECTRAL(54),
    SPEED(55),
    SPIKES(56),
    SPREAD(57),
    STATIONARY(58),
    STOCK(59),
    STREAM(74),
    SWITCH(60),
    TERRAFORMER(61),
    TOXIC(62),
    TRACER(63),
    TRANSFORMATION(64),
    UNREPAIRABLE(73),
    VARIETY(65),
    VORTEX(66),
    WEIGHT(67),
    BONUS(101),
    CRITICAL(102),
    DEFORESTER(103),
    FREEZER(104),
    GLOWING(105),
    INSTANTSMELT(106),
    LIFESTEAL(107),
    MIGHT(108),
    TELEKINESIS(109),
    THUNDERSTRUCK(110),
    WHET(111),
    ICERASPECT(112),
    ENERGY(113);

    private final short legacyID;

    /**
     * Constructor for the enum
     * @param id The numeric ID of the enchantment
     * @since 3.0.0
     */
    private BaseEnchantments(int id) {
        legacyID = (short) id;
    }

    /**
     * Obtains the legacy ID of the enchantment.
     * This is the same ID that was used in Zenchantments
     * as well as in the legacy NBT getters up until 3.x.x (inclusive)
     * Will return 0 if the enchantment was not existing at the time the legacyID system was in use.
     * @return The legacy ID of an enchantment
     * @since 3.0.0
     */
    public short getLegacyID() {
        return legacyID;
    }
}
