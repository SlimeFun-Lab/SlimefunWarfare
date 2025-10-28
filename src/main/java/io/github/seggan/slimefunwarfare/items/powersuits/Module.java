package io.github.seggan.slimefunwarfare.items.powersuits;

import io.github.seggan.slimefunwarfare.SlimefunWarfare;
import io.github.seggan.slimefunwarfare.Util;
import io.github.seggan.slimefunwarfare.lists.Categories;
import io.github.seggan.slimefunwarfare.lists.Heads;
import io.github.seggan.slimefunwarfare.lists.Items;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.apache.commons.lang.WordUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public enum Module {
    NANOFIBER_CUSHION(0, "Nanofober Cushion", ArmorPiece.FEET, new ItemStack[]{
        new ItemStack(Material.FEATHER), Items.REINFORCED_SLIMESTEEL.asOne(), new ItemStack(Material.FEATHER),
        Items.REINFORCED_SLIMESTEEL.asOne(), Items.MODULE_CASE.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(),
        new ItemStack(Material.FEATHER), Items.REINFORCED_SLIMESTEEL.asOne(), new ItemStack(Material.FEATHER),
    }, 5, "&7This module keeps you from", "&7taking fall damage"),
    MINI_JETS(1, "Mini Jets", ArmorPiece.FEET, new ItemStack[]{
        Items.OSMIUM_SUPERALLOY.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(), Items.OSMIUM_SUPERALLOY.asOne(),
        SlimefunItems.STEEL_THRUSTER.asOne(), Items.MODULE_CASE.asOne(), SlimefunItems.STEEL_THRUSTER.asOne(),
        Items.OSMIUM_SUPERALLOY.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(), Items.OSMIUM_SUPERALLOY.asOne()
    }, 8, "&7Gives you creative flight"),
    LIFE_SUPPORT(2, "Life Support Systems", PotionEffectType.REGENERATION, 2, ArmorPiece.CHEST, new ItemStack[]{
        SlimefunItems.ESSENCE_OF_AFTERLIFE.asOne(), Items.SLIMESTEEL.asOne(), SlimefunItems.ESSENCE_OF_AFTERLIFE.asOne(),
        Items.SLIMESTEEL.asOne(), Items.MODULE_CASE.asOne(), Items.SLIMESTEEL.asOne(),
        SlimefunItems.ESSENCE_OF_AFTERLIFE.asOne(), Items.SLIMESTEEL.asOne(), SlimefunItems.ESSENCE_OF_AFTERLIFE.asOne()
    }, 5),
    HEAT_SINKS(3, "Heat Sinks", PotionEffectType.FIRE_RESISTANCE, 0, ArmorPiece.CHEST, new ItemStack[]{
        new ItemStack(Material.MAGMA_CREAM), Items.OSMIUM_INGOT.asOne(), new ItemStack(Material.MAGMA_CREAM),
        Items.OSMIUM_INGOT.asOne(), Items.MODULE_CASE.asOne(), Items.OSMIUM_INGOT.asOne(),
        new ItemStack(Material.MAGMA_CREAM), Items.OSMIUM_INGOT.asOne(), new ItemStack(Material.MAGMA_CREAM)
    }, 1),
    HYDRAULICS(4, "Integrated Hydraulics", PotionEffectType.STRENGTH, 1, ArmorPiece.CHEST, new ItemStack[]{
        SlimefunItems.REINFORCED_PLATE.asOne(), Items.OSMIUM_SUPERALLOY.asOne(), SlimefunItems.REINFORCED_PLATE.asOne(),
        SlimefunItems.FUEL_BUCKET.asOne(), Items.MODULE_CASE.asOne(), SlimefunItems.FUEL_BUCKET.asOne(),
        SlimefunItems.REINFORCED_PLATE.asOne(), Items.OSMIUM_SUPERALLOY.asOne(), SlimefunItems.REINFORCED_PLATE.asOne()
    }, 3),
    REACTION_WHEELS(5, "Reaction Wheels", ArmorPiece.LEGS, new ItemStack[]{
        SlimefunItems.STEEL_PLATE.asOne(), Items.OSMIUM_SUPERALLOY.asOne(), SlimefunItems.STEEL_PLATE.asOne(),
        SlimefunItems.STEEL_INGOT.asOne(), Items.MODULE_CASE.asOne(), SlimefunItems.STEEL_INGOT.asOne(),
        SlimefunItems.STEEL_PLATE.asOne(), Items.OSMIUM_SUPERALLOY.asOne(), SlimefunItems.STEEL_PLATE.asOne()
    }, 5, "&7This module makes you", "&7sprint faster"),
    ENERGY_SHIELD(6, "Personal Energy Shield", PotionEffectType.RESISTANCE, 2, ArmorPiece.CHEST, new ItemStack[]{
        Items.UNPATENTABLIUM.asOne(), Items.OSMIUM_SUPERALLOY.asOne(), Items.UNPATENTABLIUM.asOne(),
        Items.POWER_SUIT_GENERATOR.asOne(), Items.MODULE_CASE.asOne(), Items.POWER_SUIT_GENERATOR.asOne(),
        Items.ENERGY_RECTIFIER.asOne(), Items.SEGGANESSON.asOne(), Items.ENERGY_RECTIFIER.asOne()
    }, 3),
    AQUAMASK(7, "AquaMask™", PotionEffectType.CONDUIT_POWER, 0, ArmorPiece.HEAD, new ItemStack[]{
        new ItemStack(Material.PUFFERFISH), SlimefunItems.CLOTH.asOne(), new ItemStack(Material.PUFFERFISH),
        Items.SLIMESTEEL.asOne(), Items.MODULE_CASE.asOne(), Items.SLIMESTEEL.asOne(),
        new ItemStack(Material.PUFFERFISH), SlimefunItems.CLOTH.asOne(), new ItemStack(Material.PUFFERFISH)
    }, 2),
    AUXILIARY_GENERATOR(8, "Auxiliary Generator", null, new ItemStack[]{
        Items.OSMIUM_SUPERALLOY.asOne(), Items.POWER_SUIT_GENERATOR.asOne(), Items.OSMIUM_SUPERALLOY.asOne(),
        Items.SEGGANESSON.asOne(), Items.MODULE_CASE.asOne(), Items.SEGGANESSON.asOne(),
        Items.OSMIUM_SUPERALLOY.asOne(), Items.SEGGANESSON.asOne(), Items.OSMIUM_SUPERALLOY.asOne()
    }, 5, "&7Boosts the suit's energy production"),
    ELECTRONIC_SPRINGS(9, "Electronic Springs", PotionEffectType.JUMP_BOOST, 1, ArmorPiece.LEGS, new ItemStack[]{
        Items.REINFORCED_SLIMESTEEL.asOne(), SlimefunItems.ADVANCED_CIRCUIT_BOARD.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(),
        Items.REINFORCED_SLIMESTEEL.asOne(), Items.MODULE_CASE.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(),
        Items.REINFORCED_SLIMESTEEL.asOne(), SlimefunItems.BASIC_CIRCUIT_BOARD.asOne(), Items.REINFORCED_SLIMESTEEL.asOne()
    }, 3),
    MINI_PISTONS(10, "Mini Pistons", PotionEffectType.HASTE, 3, ArmorPiece.CHEST, new ItemStack[]{
        Items.REINFORCED_SLIMESTEEL.asOne(), new ItemStack(Material.PISTON), Items.REINFORCED_SLIMESTEEL.asOne(),
        Items.REINFORCED_SLIMESTEEL.asOne(), Items.MODULE_CASE.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(),
        Items.REINFORCED_SLIMESTEEL.asOne(), new ItemStack(Material.PISTON), Items.REINFORCED_SLIMESTEEL.asOne()
    }, 3),
    ;
    @Getter
    @Nullable
    private final PotionEffect effect;
    @Getter
    @Nullable
    private final ArmorPiece allowed;
    @Getter
    @Nonnull
    private final SlimefunItemStack item;
    @Nonnull
    private final ItemStack[] recipe;
    @Getter
    private final int power;

    @Getter
    private final int id;

    private static final Map<Integer, Module> cache = new HashMap<>();

    static {
        for (Module module : Module.values()) {
            cache.put(module.id, module);
        }
    }

    Module(int id, @Nonnull String name, @Nullable PotionEffectType effect, int level, @Nullable ArmorPiece allowed, @Nonnull ItemStack[] recipe, int power, @Nonnull String... lore) {
        this.id = id;
        this.allowed = allowed;
        this.power = power;
        if (effect != null) {
            this.effect = new PotionEffect(effect, 21, level, false, false, false);
        } else {
            this.effect = null;
        }
        this.recipe = recipe;

        List<String> loreList = new ArrayList<>(Arrays.asList(lore));
        if (lore.length > 0) {
            loreList.add(0, "");
        }
        loreList.add("");
        if (effect != null) {
            loreList.add(String.format("&7Effect: &a%s %d", WordUtils.capitalizeFully(effect.getName().replace('_', ' ')), level + 1));
        }
        loreList.add(allowed == null ? "&7Install anywhere" : "&7Install on " + allowed);
        loreList.add(String.format("&eUses %dJ", power));

        this.item = new SlimefunItemStack(
            this.name(),
                Util.fromBase64Hash(Heads.MODULE),
            "&6" + name,
            loreList.toArray(new String[0])
        );
    }

    Module(int id, @Nonnull String name, ArmorPiece allowed, @Nonnull ItemStack[] recipe, int power, @Nonnull String... lore) {
        this(id, name, null, 0, allowed, recipe, power, lore);
    }

    public static void setup(SlimefunWarfare addon) {
        for (Module module : Module.values()) {
            new ModuleItem(Categories.POWER_SUITS, module.item, RecipeType.ENHANCED_CRAFTING_TABLE, module.recipe, module)
                .register(addon);
        }
    }

    @Nullable
    public static Module getById(int id) {
        return cache.get(id);
    }

    public static class ModuleItem extends SlimefunItem implements NotPlaceable {

        @Getter
        private final Module module;

        public ModuleItem(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, Module module) {
            super(category, item, recipeType, recipe);

            this.module = module;
        }
    }
}
