/*
 * Copyright (C) 2016-2021 David Rubio Escares / Kodehawa
 *
 *  Mantaro is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  Mantaro is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Mantaro. If not, see http://www.gnu.org/licenses/
 */

package net.kodehawa.mantarobot.commands.currency.item.special.tools;

import net.kodehawa.mantarobot.commands.currency.item.Item;
import net.kodehawa.mantarobot.commands.currency.item.ItemType;
import net.kodehawa.mantarobot.commands.currency.item.special.helpers.Breakable;
import net.kodehawa.mantarobot.commands.currency.item.special.helpers.Castable;
import net.kodehawa.mantarobot.commands.currency.item.special.helpers.Salvageable;
import net.kodehawa.mantarobot.commands.currency.item.special.helpers.attributes.Attribute;
import net.kodehawa.mantarobot.commands.currency.item.special.helpers.attributes.ItemUsage;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Wrench extends Item implements Castable, Salvageable, Attribute {
    private final float chance;
    private final int level;
    private final int durability;
    private final int tier;
    private final double multiplierReduction;
    private final List<Integer> salvageReturns;

    public Wrench(ItemType type, float chance, int level, double multiplierReduction, String emoji, String name,
                  String translatedName, String desc, long value, int durability, int tier, boolean sellable, boolean buyable, String recipe,
                  int... recipeTypes) {
        super(type, emoji, name, translatedName, desc, value, sellable, buyable, recipe, recipeTypes);
        this.chance = chance;
        this.level = level;
        this.multiplierReduction = multiplierReduction;
        this.salvageReturns = Arrays.stream(recipeTypes).filter(id -> id > 1).boxed().collect(Collectors.toList());
        this.durability = durability;
        this.tier = tier;
    }

    public Wrench(ItemType type, float chance, int level, double multiplierReduction, String emoji, String name,
                  String translatedName, String desc, long value, int durability, int tier, boolean buyable) {
        super(type, emoji, name, translatedName, desc, value, true, buyable);
        this.chance = chance;
        this.level = level;
        this.multiplierReduction = multiplierReduction;
        this.salvageReturns = Collections.emptyList();
        this.durability = durability;
        this.tier = tier;
    }

    public float getChance() {
        return this.chance;
    }

    public int getLevel() {
        return this.level;
    }

    public double getMultiplierReduction() {
        return this.multiplierReduction;
    }

    @Override
    public List<Integer> getReturns() {
        return salvageReturns;
    }

    @Override
    public int getCastLevelRequired() {
        return 0;
    }

    @Override
    public int getMaximumCastAmount() {
        return 5000;
    }

    @Override
    public int getMaxDurability() {
        return durability;
    }

    // TODO: this two below before pushing to testing!
    @Override
    public String buildAttributes() {
        return "placeholder";
    }

    @Override
    public String getExplanation() {
        return "placeholder";
    }

    @Override
    public ItemUsage getType() {
        return ItemUsage.CASTING;
    }

    @Override
    public int getTier() {
        return tier;
    }
}
