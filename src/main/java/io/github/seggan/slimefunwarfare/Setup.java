package io.github.seggan.slimefunwarfare;

import io.github.mooy1.infinitylib.core.AbstractAddon;
import io.github.seggan.slimefunwarfare.georesources.Arsenic;
import io.github.seggan.slimefunwarfare.georesources.Monazite;
import io.github.seggan.slimefunwarfare.items.Bullet;
import io.github.seggan.slimefunwarfare.items.Dummy;
import io.github.seggan.slimefunwarfare.items.EnergyBlade;
import io.github.seggan.slimefunwarfare.items.Grenade;
import io.github.seggan.slimefunwarfare.items.NuclearBomb;
import io.github.seggan.slimefunwarfare.items.Radio;
import io.github.seggan.slimefunwarfare.items.RadioactiveItem;
import io.github.seggan.slimefunwarfare.items.blocks.Meteor;
import io.github.seggan.slimefunwarfare.items.guns.EnergyRifle;
import io.github.seggan.slimefunwarfare.items.guns.Gun;
import io.github.seggan.slimefunwarfare.items.powersuits.ArmorPiece;
import io.github.seggan.slimefunwarfare.items.powersuits.ElementForge;
import io.github.seggan.slimefunwarfare.items.powersuits.ModuleManipulator;
import io.github.seggan.slimefunwarfare.items.powersuits.PowerSuit;
import io.github.seggan.slimefunwarfare.items.rareearths.Lanthanum;
import io.github.seggan.slimefunwarfare.items.rareearths.RareEarth;
import io.github.seggan.slimefunwarfare.lists.Categories;
import io.github.seggan.slimefunwarfare.lists.Items;
import io.github.seggan.slimefunwarfare.lists.RecipeTypes;
import io.github.seggan.slimefunwarfare.machines.AirLiquefier;
import io.github.seggan.slimefunwarfare.machines.Boominator9000;
import io.github.seggan.slimefunwarfare.machines.BulletPress;
import io.github.seggan.slimefunwarfare.machines.ElementalReactor;
import io.github.seggan.slimefunwarfare.machines.ExplosiveSynthesizer;
import io.github.seggan.slimefunwarfare.machines.IonExchangeSeparator;
import io.github.seggan.slimefunwarfare.machines.MeteorAttractor;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.api.researches.Research;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.items.VanillaItem;
import io.github.thebusybiscuit.slimefun4.implementation.items.blocks.UnplaceableBlock;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

@UtilityClass
public final class Setup {

    private static int researchId = 3478;

    static void setupItems(SlimefunWarfare addon) {
        new SlimefunItem(Categories.RESOURCES, Items.BORAX, RecipeType.NULL, fillNulls(
            CustomItemStack.create(
                Material.STONE,
                "&fStone drop",
                "",
                "&7This item is dropped from stone"
            )
        )).register(addon);
        new SlimefunItem(Categories.RESOURCES, Items.BORON, RecipeType.SMELTERY, fillNulls(Items.BORAX.asOne())).register(addon);
        new SlimefunItem(Categories.GENERAL, Items.SLIMESTEEL, RecipeType.SMELTERY, new ItemStack[]{
            SlimefunItems.STEEL_INGOT.asOne(), new ItemStack(Material.SLIME_BALL), null,
            null, null, null,
            null, null, null
        }).register(addon);

        new SlimefunItem(
            Categories.GENERAL, Items.REINFORCED_SLIMESTEEL, RecipeType.SMELTERY, new ItemStack[]{
            Items.SLIMESTEEL.asOne(), new ItemStack(Material.SLIME_BLOCK), SlimefunItems.DAMASCUS_STEEL_INGOT.asOne(),
            SlimefunItems.HARDENED_METAL_INGOT.asOne(), SlimefunItems.CORINTHIAN_BRONZE_INGOT.asOne(), SlimefunItems.ALUMINUM_BRONZE_INGOT.asOne(),
            null, null, null
        }).register(addon);

        new VanillaItem(Categories.GENERAL, new ItemStack(Material.SLIME_BALL), "SLIME_BALL", RecipeType.ENHANCED_CRAFTING_TABLE, fillNulls(
            Items.BORAX.asOne(), new ItemStack(Material.BONE_MEAL), new ItemStack(Material.WATER_BUCKET)
        )).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.SCOPE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.PLASTIC_SHEET.asOne(), SlimefunItems.MULTIMETER.asOne(), SlimefunItems.PLASTIC_SHEET.asOne(),
            SlimefunItems.HARDENED_GLASS.asOne(), null, SlimefunItems.HARDENED_GLASS.asOne(),
            SlimefunItems.PLASTIC_SHEET.asOne(), SlimefunItems.PLASTIC_SHEET.asOne(), SlimefunItems.PLASTIC_SHEET.asOne()
        }).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.BARREL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Items.SLIMESTEEL.asOne(), Items.SLIMESTEEL.asOne(), Items.SLIMESTEEL.asOne(),
            null, null, null,
            Items.SLIMESTEEL.asOne(), Items.SLIMESTEEL.asOne(), Items.SLIMESTEEL.asOne()
        }).register(addon);

        new SlimefunItem(
            Categories.GENERAL, Items.ADVANCED_BARREL, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Items.REINFORCED_SLIMESTEEL.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(),
            Items.BARREL.asOne(), Items.BARREL.asOne(), Items.BARREL.asOne(),
            Items.REINFORCED_SLIMESTEEL.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(), Items.REINFORCED_SLIMESTEEL.asOne()
        }).register(addon);

        new ElementForge(Categories.POWER_SUITS, Items.ELEMENT_FORGE).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.FIBER_OPTIC_GLASS, RecipeType.SMELTERY, fillNulls(
            Items.ERBIUM_INGOT.asOne(), SlimefunItems.SILICON.asOne(), new ItemStack(Material.GLASS), new ItemStack(Material.GLASS_PANE)
        )).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.FIBER_OPTIC_CABLE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.SILVER_INGOT.asOne(), SlimefunItems.SILVER_INGOT.asOne(), SlimefunItems.SILVER_INGOT.asOne(),
            Items.FIBER_OPTIC_GLASS.asOne(), Items.FIBER_OPTIC_GLASS.asOne(), Items.FIBER_OPTIC_GLASS.asOne(),
            SlimefunItems.SILVER_INGOT.asOne(), SlimefunItems.SILVER_INGOT.asOne(), SlimefunItems.SILVER_INGOT.asOne()
        }, Items.FIBER_OPTIC_CABLE.asQuantity(3)).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.LASER_DIODE, RecipeType.SMELTERY, fillNulls(
            SlimefunItems.SYNTHETIC_SAPPHIRE.asOne(), new ItemStack(Material.GLOWSTONE),
            Items.YTTERBIUM_INGOT.asQuantity(2), Items.FIBER_OPTIC_GLASS.asOne()
        )).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.ULTRA_MAGNET, RecipeType.SMELTERY, fillNulls(
            SlimefunItems.MAGNET.asOne(), Items.NDFEB_ALLOY.asOne(), Items.HOLMIUM_INGOT.asQuantity(2)
        )).register(addon);

        new Radio().register(addon);
    }

    static void setupMelee(SlimefunWarfare addon) {
        new UnplaceableBlock(Categories.MELEE, Items.BATTLE_AXE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            new ItemStack(Material.IRON_AXE), new ItemStack(Material.IRON_INGOT), new ItemStack(Material.IRON_AXE),
            null, new ItemStack(Material.STICK), null,
            null, new ItemStack(Material.STICK), null
        }).register(addon);

        new SlimefunItem(Categories.MELEE, Items.OSMIUM_SWORD, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            null, Items.OSMIUM_INGOT.asOne(), null,
            null, Items.OSMIUM_INGOT.asOne(), null,
            null, new ItemStack(Material.STICK), null
        }).register(addon);

        // Energy
        new SlimefunItem(Categories.GENERAL, Items.OSMIUM_SUPERALLOY, RecipeType.SMELTERY, fillNulls(
            Items.OSMIUM_INGOT.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(), SlimefunItems.REINFORCED_ALLOY_INGOT.asOne(),
            Items.OSMIUM_DUST.asOne(), Items.GADOLINIUM_INGOT.asOne(), Items.TERBIUM_INGOT.asOne()
        )).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.ENERGY_RECTIFIER, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Items.OSMIUM_SUPERALLOY.asOne(), SlimefunItems.CARBONADO_EDGED_CAPACITOR.asOne(), Items.OSMIUM_SUPERALLOY.asOne(),
            SlimefunItems.POWER_CRYSTAL.asOne(), SlimefunItems.ENERGY_REGULATOR.asOne(), SlimefunItems.POWER_CRYSTAL.asOne(),
            Items.OSMIUM_SUPERALLOY.asOne(), SlimefunItems.CARBONADO_EDGED_CAPACITOR.asOne(), Items.OSMIUM_SUPERALLOY.asOne()
        }).register(addon);

        new EnergyBlade().register(addon);

        // Misc
        new Dummy().register(addon);
    }

    static void setupBullets(SlimefunWarfare addon) {
        new BulletPress().register(addon);
        new Bullet(Items.IRON_BULLET, new ItemStack(Material.IRON_INGOT), 0.75, false).register(addon);
        new Bullet(Items.LEAD_BULLET, SlimefunItems.LEAD_INGOT.asOne(), 1, false).register(addon);
        new Bullet(Items.DU_BULLET, SlimefunItems.SMALL_URANIUM.asOne(), 1.5, true).register(addon);
        new Bullet(Items.GOLD_BULLET, SlimefunItems.GOLD_12K.asOne(), 2, false).register(addon);
        new Bullet(Items.TRINITROBULLETENE, Items.PYRO_POWDER.asOne(), 2.75, true).register(addon);
    }

    static void setupGuns(SlimefunWarfare addon) {
        new SlimefunItem(Categories.GENERAL, Items.GUN_CASE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Items.SLIMESTEEL.asOne(), new ItemStack(Material.GUNPOWDER), Items.SLIMESTEEL.asOne(),
            Items.SLIMESTEEL.asOne(), new ItemStack(Material.FLINT_AND_STEEL), Items.SLIMESTEEL.asOne(),
            SlimefunItems.PLASTIC_SHEET.asOne(), new ItemStack(Material.CROSSBOW), SlimefunItems.PLASTIC_SHEET.asOne()
        }).register(addon);

        new Gun(Items.PISTOL, new ItemStack[]{
            null, Items.SLIMESTEEL.asOne(), null,
            null, Items.GUN_CASE.asOne(), Items.SLIMESTEEL.asOne(),
            null, Items.SLIMESTEEL.asOne(), new ItemStack(Material.STICK)
        }, 10, 6, 0.5).register(addon);

        new Gun(Items.REVOLVER, new ItemStack[]{
            null, Items.SLIMESTEEL.asOne(), null,
            null, Items.PISTOL.asOne(), Items.SLIMESTEEL.asOne(),
            null, Items.SLIMESTEEL.asOne(), null
        }, 10, 6, 0.3).register(addon);

        new Gun(Items.MACHINE_GUN, new ItemStack[]{
            Items.SLIMESTEEL.asOne(), Items.SCOPE.asOne(), null,
            Items.BARREL.asOne(), Items.REVOLVER.asOne(), Items.SLIMESTEEL.asOne(),
            Items.SLIMESTEEL.asOne(), Items.SLIMESTEEL.asOne(), SlimefunItems.PLASTIC_SHEET.asOne()
        }, 30, 5, 6, 0.15).register(addon);

        new Gun(Items.MINIGUN, new ItemStack[]{
            Items.REINFORCED_SLIMESTEEL.asOne(), Items.SCOPE.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(),
            Items.ADVANCED_BARREL.asOne(), Items.MACHINE_GUN.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(),
            Items.REINFORCED_SLIMESTEEL.asOne(), SlimefunItems.PLASTIC_SHEET.asOne(), SlimefunItems.PLASTIC_SHEET.asOne()
        }, 40, 5, 8, 0).register(addon);

        new Gun(Items.RIFLE, new ItemStack[]{
            null, Items.SCOPE.asOne(), null,
            Items.BARREL.asOne(), Items.GUN_CASE.asOne(), Items.SLIMESTEEL.asOne(),
            null, Items.SLIMESTEEL.asOne(), SlimefunItems.PLASTIC_SHEET.asOne()
        }, 40, 5, 8, 0.75).register(addon);

        new Gun(Items.SHOTGUN, new ItemStack[]{
            Items.SLIMESTEEL.asOne(), Items.SLIMESTEEL.asOne(), null,
            Items.BARREL.asOne(), Items.BARREL.asOne(), Items.GUN_CASE.asOne(),
            Items.SLIMESTEEL.asOne(), Items.SLIMESTEEL.asOne(), SlimefunItems.PLASTIC_SHEET.asOne()
        }, 25, 5, 13, 1.25).register(addon);

        new Gun(Items.ASSAULT_RIFLE, new ItemStack[]{
            Items.SLIMESTEEL.asOne(), Items.SCOPE.asOne(), new ItemStack(Material.OAK_PLANKS),
            Items.BARREL.asOne(), Items.RIFLE.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(),
            Items.SLIMESTEEL.asOne(), Items.SLIMESTEEL.asOne(), SlimefunItems.PLASTIC_SHEET.asOne()
        }, 50, 3, 13, 0.3).register(addon);

        new Gun(Items.SNIPER, new ItemStack[]{
            null, Items.REINFORCED_SLIMESTEEL.asOne(), Items.REINFORCED_SLIMESTEEL.asOne(),
            Items.ADVANCED_BARREL.asOne(), Items.ADVANCED_BARREL.asOne(), Items.ASSAULT_RIFLE.asOne(),
            new ItemStack(Material.STICK), Items.REINFORCED_SLIMESTEEL.asOne(), SlimefunItems.PLASTIC_SHEET.asOne()
        }, 130, 50, 22, 8).register(addon);

        new EnergyRifle().register(addon);
    }

    static void setupExplosives(SlimefunWarfare addon) {
        new AirLiquefier().register(addon);
        new ExplosiveSynthesizer().register(addon);
        new Boominator9000().register(addon);

        new SlimefunItem(Categories.GENERAL, Items.REINFORCED_CONCRETE, RecipeType.SMELTERY,
            new ItemStack[]{
                SlimefunItems.IRON_DUST.asOne(), new ItemStack(Material.GRAY_CONCRETE_POWDER), null,
                null, null, null,
                null, null, null
            }).register(addon);

        new SlimefunItem(Categories.EXPLOSIVES, Items.LIQUID_AIR, RecipeTypes.AIR_LIQUEFIER,
            new ItemStack[]{
                SlimefunItems.TIN_CAN.asOne(), null, null,
                null, null, null,
                null, null, null
            }).register(addon);

        new SlimefunItem(
            Categories.EXPLOSIVES, Items.LIQUID_NITROGEN, RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                Items.LIQUID_AIR.asOne(), Items.LIQUID_AIR.asOne(), Items.LIQUID_AIR.asOne(),
                Items.LIQUID_AIR.asOne(), Items.LIQUID_AIR.asOne(), Items.LIQUID_AIR.asOne(),
                Items.LIQUID_AIR.asOne(), null, null
            }, Items.LIQUID_NITROGEN.asQuantity(4)).register(addon);

        new SlimefunItem(
            Categories.EXPLOSIVES, Items.PURIFIED_LIQUID_NITROGEN, RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                Items.LIQUID_NITROGEN.asOne(), Items.LIQUID_NITROGEN.asOne(), Items.LIQUID_NITROGEN.asOne(),
                Items.LIQUID_NITROGEN.asOne(), Items.LIQUID_NITROGEN.asOne(), Items.LIQUID_NITROGEN.asOne(),
                Items.LIQUID_NITROGEN.asOne(), Items.LIQUID_NITROGEN.asOne(), Items.LIQUID_NITROGEN.asOne()
            }, Items.PURIFIED_LIQUID_NITROGEN.asQuantity(4)).register(addon);

        new SlimefunItem(
            Categories.EXPLOSIVES, Items.NITROGEN_TRIIODIDE, RecipeTypes.EXPLOSIVE_SYNTHESIZER,
            new ItemStack[]{
                Items.LIQUID_NITROGEN.asOne(), new ItemStack(Material.DRIED_KELP), null,
                null, null, null,
                null, null, null
            }).register(addon);

        new SlimefunItem(
            Categories.EXPLOSIVES, Items.AZIDOAZIDE_AZIDE, RecipeTypes.EXPLOSIVE_SYNTHESIZER,
            new ItemStack[]{
                Items.PURIFIED_LIQUID_NITROGEN.asOne(), new ItemStack(Material.COAL), null,
                null, null, null,
                null, null, null
            }).register(addon);

        new SlimefunItem(
            Categories.EXPLOSIVES, Items.ARSENIC, RecipeType.GEO_MINER, new ItemStack[9]
        ).register(addon);

        new SlimefunItem(Categories.EXPLOSIVES, Items.THIOACETONE, RecipeTypes.EXPLOSIVE_SYNTHESIZER,
            new ItemStack[]{
                SlimefunItems.OIL_BUCKET.asOne(), SlimefunItems.SULFATE.asOne(), null,
                null, null, null,
                null, null, null
            }).register(addon);

        new Arsenic(Items.ARSENIC.asOne()).register();

        new VanillaItem(
            Categories.EXPLOSIVES, new ItemStack(Material.GUNPOWDER),
            "GUNPOWDER", RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            SlimefunItems.SULFATE.asOne(), new ItemStack(Material.BONE_MEAL), new ItemStack(Material.CHARCOAL),
            null, null, null,
            null, null, null
        }).register(addon);

        new SlimefunItem(Categories.EXPLOSIVES, Items.PYRO_POWDER, RecipeType.GRIND_STONE,
            fillNulls(new ItemStack(Material.TNT)), Items.PYRO_POWDER.asQuantity(4)).register(addon);

        new RadioactiveItem(Categories.EXPLOSIVES, Items.ENRICHED_URANIUM, RecipeTypes.BOOMINATOR,
            fillNulls(SlimefunItems.BOOSTED_URANIUM.asOne()), Radioactivity.VERY_DEADLY).register(addon);

        new SlimefunItem(
            Categories.EXPLOSIVES, Items.EMPTY_GRENADE, RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                Items.PYRO_POWDER.asOne(), SlimefunItems.STEEL_INGOT.asOne(), Items.PYRO_POWDER.asOne(),
                SlimefunItems.STEEL_INGOT.asOne(), SlimefunItems.TIN_CAN.asOne(), SlimefunItems.STEEL_INGOT.asOne(),
                Items.PYRO_POWDER.asOne(), SlimefunItems.STEEL_INGOT.asOne(), Items.PYRO_POWDER.asOne(),
            }, Items.EMPTY_GRENADE.asQuantity(4)).register(addon);

        new Grenade(Items.NITROGEN_TRIIODIDE).register(addon);
        new Grenade(Items.AZIDOAZIDE_AZIDE).register(addon);
        new Grenade(Items.ARSENIC).register(addon);
        new Grenade(Items.PYRO_POWDER).register(addon);
        new Grenade(Items.THIOACETONE).register(addon);
        new Grenade(Items.OSMIUM_DUST).register(addon);

        new NuclearBomb(Categories.EXPLOSIVES, Items.NUCLEAR_BOMB, RecipeType.ENHANCED_CRAFTING_TABLE,
            new ItemStack[]{
                SlimefunItems.STEEL_PLATE.asOne(), Items.ENRICHED_URANIUM.asOne(), SlimefunItems.STEEL_PLATE.asOne(),
                new ItemStack(Material.PISTON), Items.ENRICHED_URANIUM.asOne(), new ItemStack(Material.PISTON),
                SlimefunItems.STEEL_PLATE.asOne(), Items.ENRICHED_URANIUM.asOne(), SlimefunItems.STEEL_PLATE.asOne()
            }).register(addon);
    }

    static void setupSpace(SlimefunWarfare addon) {
        new Meteor(Items.OSMIUM_METEOR).register(addon);
        new Meteor(Items.SEGGANESSON_METEOR).register(addon);

        new SlimefunItem(Categories.RESOURCES, Items.OSMIUM_DUST, RecipeType.ORE_CRUSHER, fillNulls(Items.OSMIUM_METEOR.asOne())).register(addon);
        new SlimefunItem(Categories.RESOURCES, Items.OSMIUM_INGOT, RecipeType.SMELTERY, fillNulls(Items.OSMIUM_DUST.asOne())).register(addon);
        new SlimefunItem(Categories.RESOURCES, Items.SEGGANESSON, RecipeType.ORE_CRUSHER, fillNulls(Items.SEGGANESSON_METEOR.asOne())).register(addon);

        new IonExchangeSeparator().energyPerTick(128).register(addon);

        new Monazite(Items.MONAZITE.asOne()).register();
        new SlimefunItem(Categories.RESOURCES, Items.MONAZITE, RecipeType.GEO_MINER, new ItemStack[9]).register(addon);

        new Lanthanum().register(addon);
        new RareEarth(Items.NEODYMIUM_INGOT).register(addon);
        new RareEarth(Items.GADOLINIUM_INGOT).register(addon);
        new RareEarth(Items.TERBIUM_INGOT).register(addon);
        new RareEarth(Items.DYSPROSIUM_INGOT).register(addon);
        new RareEarth(Items.HOLMIUM_INGOT).register(addon);
        new RareEarth(Items.ERBIUM_INGOT).register(addon);
        new RareEarth(Items.YTTERBIUM_INGOT).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.TERFENOL_D, RecipeType.SMELTERY, fillNulls(
            Items.TERBIUM_INGOT.asQuantity(3), Items.GADOLINIUM_INGOT.asQuantity(2), new ItemStack(Material.IRON_INGOT),
            SlimefunItems.COBALT_INGOT.asOne(), Items.DYSPROSIUM_INGOT.asQuantity(2)
        )).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.TERFENOL_D_BLOCK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Items.TERFENOL_D.asOne(), Items.TERFENOL_D.asOne(), Items.TERFENOL_D.asOne(),
            Items.TERFENOL_D.asOne(), Items.TERFENOL_D.asOne(), Items.TERFENOL_D.asOne(),
            Items.TERFENOL_D.asOne(), Items.TERFENOL_D.asOne(), Items.TERFENOL_D.asOne()
        }).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.NDFEB_ALLOY, RecipeType.SMELTERY, fillNulls(
            Items.NEODYMIUM_INGOT.asQuantity(4), Items.BORON.asOne(),
            new ItemStack(Material.IRON_INGOT), Items.DYSPROSIUM_INGOT.asOne()
        )).register(addon);

        new SlimefunItem(Categories.GENERAL, Items.NDFEB_ALLOY_BLOCK, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Items.NDFEB_ALLOY.asOne(), Items.NDFEB_ALLOY.asOne(), Items.NDFEB_ALLOY.asOne(),
            Items.NDFEB_ALLOY.asOne(), Items.NDFEB_ALLOY.asOne(), Items.NDFEB_ALLOY.asOne(),
            Items.NDFEB_ALLOY.asOne(), Items.NDFEB_ALLOY.asOne(), Items.NDFEB_ALLOY.asOne()
        }).register(addon);

        new MeteorAttractor().register(addon);

        new ElementalReactor().register(addon);
    }

    static void setupSuits(SlimefunWarfare addon) {
        new SlimefunItem(Categories.RESOURCES, Items.UNPATENTABLIUM, RecipeTypes.ELEMENT_FORGE, new ItemStack[]{
            Items.SEGGANESSON.asOne(), Items.ARSENIC.asOne(), Items.SEGGANESSON.asOne(),
            Items.OSMIUM_DUST.asOne(), Items.OSMIUM_INGOT.asOne(), Items.OSMIUM_DUST.asOne(),
            Items.SEGGANESSON.asOne(), Items.ARSENIC.asOne(), Items.SEGGANESSON.asOne()
        }).register(addon);

        new SlimefunItem(Categories.POWER_SUITS, Items.POWER_SUIT_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            Items.UNPATENTABLIUM.asOne(), Items.UNPATENTABLIUM.asOne(), Items.UNPATENTABLIUM.asOne(),
            Items.SEGGANESSON.asOne(), SlimefunItems.NETHER_STAR_REACTOR.asOne(), Items.SEGGANESSON.asOne(),
            Items.UNPATENTABLIUM.asOne(), Items.LASER_DIODE.asOne(), Items.UNPATENTABLIUM.asOne()
        }).register(addon);

        new SlimefunItem(Categories.POWER_SUITS, Items.MODULE_CASE, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[]{
            null, Items.OSMIUM_INGOT.asOne(), null,
            Items.FIBER_OPTIC_CABLE.asOne(), Items.POWER_SUIT_GENERATOR.asOne(), Items.FIBER_OPTIC_CABLE.asOne(),
            null, Items.OSMIUM_INGOT.asOne(), null
        }, Items.MODULE_CASE.asQuantity(2)).register(addon);

        new PowerSuit(Items.POWER_SUIT_HELMET, new ItemStack[]{
            SlimefunItems.ADVANCED_CIRCUIT_BOARD.asOne(), Items.POWER_SUIT_GENERATOR.asOne(), SlimefunItems.ADVANCED_CIRCUIT_BOARD.asOne(),
            Items.OSMIUM_SUPERALLOY.asOne(), SlimefunItems.SCUBA_HELMET.asOne(), Items.OSMIUM_SUPERALLOY.asOne(),
            Items.FIBER_OPTIC_CABLE.asOne(), Items.OSMIUM_SUPERALLOY.asOne(), Items.FIBER_OPTIC_CABLE.asOne()
        }, ArmorPiece.HEAD).register(addon);

        new PowerSuit(Items.POWER_SUIT_CHESTPLATE, new ItemStack[]{
            Items.OSMIUM_SUPERALLOY.asOne(), Items.ULTRA_MAGNET.asOne(), Items.OSMIUM_SUPERALLOY.asOne(),
            Items.POWER_SUIT_GENERATOR.asOne(), SlimefunItems.HAZMAT_CHESTPLATE.asOne(), Items.POWER_SUIT_GENERATOR.asOne(),
            Items.LASER_DIODE.asOne(), Items.SEGGANESSON.asOne(), Items.LASER_DIODE.asOne()
        }, ArmorPiece.CHEST).register(addon);

        new PowerSuit(Items.POWER_SUIT_LEGGINGS, new ItemStack[]{
            SlimefunItems.ELECTRIC_MOTOR.asOne(), Items.POWER_SUIT_GENERATOR.asOne(), SlimefunItems.ELECTRIC_MOTOR.asOne(),
            Items.OSMIUM_SUPERALLOY.asOne(), SlimefunItems.HAZMAT_LEGGINGS.asOne(), Items.OSMIUM_SUPERALLOY.asOne(),
            Items.FIBER_OPTIC_CABLE.asOne(), null, Items.FIBER_OPTIC_CABLE.asOne()
        }, ArmorPiece.LEGS).register(addon);

        new PowerSuit(Items.POWER_SUIT_BOOTS, new ItemStack[]{
            null, null, null,
            Items.OSMIUM_SUPERALLOY.asOne(), SlimefunItems.HAZMAT_BOOTS.asOne(), Items.OSMIUM_SUPERALLOY.asOne(),
            Items.OSMIUM_SUPERALLOY.asOne(), Items.POWER_SUIT_GENERATOR.asOne(), Items.OSMIUM_SUPERALLOY.asOne()
        }, ArmorPiece.FEET).register(addon);

        new ModuleManipulator().register(addon);
    }

    static void setupResearches() {
        addResearch("Weapons of Mass Destruction", 70, Items.NUCLEAR_BOMB, Items.BOOMINATOR_9000);
        addResearch("I am Iron Man", 70, Items.POWER_SUIT_HELMET, Items.POWER_SUIT_CHESTPLATE, Items.POWER_SUIT_LEGGINGS, Items.POWER_SUIT_BOOTS);
        addResearch("Energy Weapons", 45, Items.ENERGY_BLADE, Items.ENERGY_RECTIFIER, Items.ENERGY_RIFLE);
        addResearch("Alien Metals", 40, Items.OSMIUM_DUST, Items.OSMIUM_INGOT, Items.OSMIUM_SUPERALLOY);
        addResearch("Rare Earths", 50, Items.MONAZITE, Items.LANTHANUM_INGOT, Items.NEODYMIUM_INGOT, Items.GADOLINIUM_INGOT, Items.TERBIUM_INGOT);
    }

    private static void addResearch(String name, int xp, SlimefunItemStack... stacks) {
        Research research = new Research(
            AbstractAddon.createKey(name.toLowerCase(Locale.ROOT).replace(' ', '_')),
            researchId++,
            name,
            xp
        );

        SlimefunItem[] items = Arrays.stream(stacks)
                                .map(s -> SlimefunItem.getById(s.getItemId()))
                                .filter(Objects::nonNull)
                                .toArray(SlimefunItem[]::new);

        research.addItems(items);
        research.register();
    }

    @SafeVarargs
    private static <T> T[] fillNulls(T... original) {
        return Arrays.copyOf(original, 9);
    }
}
