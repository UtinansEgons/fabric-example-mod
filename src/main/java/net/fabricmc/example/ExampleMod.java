package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.armor.ModArmorMaterials;
import net.fabricmc.example.tools.AstolfoToolMaterial;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.HeightRangePlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.GenerationStep;



public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final Block ASTOLFO_ORE = new Block(FabricBlockSettings.of(Material.STONE).strength(1.0f, 1.0f).sounds(BlockSoundGroup.STONE));
	public static final ArmorMaterial ASTOLFO_MATERIAL = new ModArmorMaterials();

	public static final Item ASTOLFO = new Item(new Item.Settings().group(ItemGroup.MATERIALS));

	public static final Item ASTOLFO_FACE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(ItemFood.ASTOLFO_FACE));
	public static final Item GOLDEN_ASTOLFO_FACE = new Item(new Item.Settings().group(ItemGroup.FOOD).food(ItemFood.GOLDEN_ASTOLFO_FACE));

	public static final Item ASTOLFO_HELMET = new ArmorItem(ExampleMod.ASTOLFO_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item ASTOLFO_CHESTPLATE = new ArmorItem(ExampleMod.ASTOLFO_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item ASTOLFO_LEGGINGS = new ArmorItem(ExampleMod.ASTOLFO_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(ItemGroup.COMBAT));
	public static final Item ASTOLFO_BOOTS = new ArmorItem(ExampleMod.ASTOLFO_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(ItemGroup.COMBAT));

	public static final ToolItem ASTOLFO_SWORD = new SwordItem(AstolfoToolMaterial.INSTANCE, 10000000, 100000000, new Item.Settings().group(ItemGroup.TOOLS));



	private static ConfiguredFeature<?, ?> OVERWORLD_ASTOLFO_ORE_CONFIGURED_FEATURE = Feature.ORE
			.configure(new OreFeatureConfig(
					OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,
					ExampleMod.ASTOLFO_ORE.getDefaultState(),
					9)); // vein size

	public static PlacedFeature OVERWORLD_ASTOLFO_ORE_PLACED_FEATURE = OVERWORLD_ASTOLFO_ORE_CONFIGURED_FEATURE.withPlacement(
			CountPlacementModifier.of(20), // number of veins per chunk
			SquarePlacementModifier.of(), // spreading horizontally
			HeightRangePlacementModifier.uniform(YOffset.getBottom(), YOffset.fixed(64))); // height




	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.


		Registry.register(Registry.BLOCK, new Identifier("modid", "astolfo_ore"), ASTOLFO_ORE);
		Registry.register(Registry.ITEM, new Identifier("modid", "astolfo_ore"), new BlockItem(ASTOLFO_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

		Registry.register(Registry.ITEM, new Identifier("modid", "astolfo_helmet"), ASTOLFO_HELMET);
		Registry.register(Registry.ITEM, new Identifier("modid", "astolfo_chestplate"), ASTOLFO_CHESTPLATE);
		Registry.register(Registry.ITEM, new Identifier("modid", "astolfo_leggings"), ASTOLFO_LEGGINGS);
		Registry.register(Registry.ITEM, new Identifier("modid", "astolfo_boots"), ASTOLFO_BOOTS);

		Registry.register(Registry.ITEM, new Identifier("modid", "astolfo"), ASTOLFO);
		Registry.register(Registry.ITEM, new Identifier("modid", "astolfo_face"), ASTOLFO_FACE);
		Registry.register(Registry.ITEM, new Identifier("modid", "golden_astolfo_face"), GOLDEN_ASTOLFO_FACE);

		Registry.register(Registry.ITEM, new Identifier("modid", "astolfo_sword"), ASTOLFO_SWORD);

		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE,
				new Identifier("modid", "overworld_astolfo_ore"), OVERWORLD_ASTOLFO_ORE_CONFIGURED_FEATURE);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("modid", "overworld_astolfo_ore"),
				OVERWORLD_ASTOLFO_ORE_PLACED_FEATURE);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY,
						new Identifier("modid", "overworld_astolfo_ore")));


	}
}
