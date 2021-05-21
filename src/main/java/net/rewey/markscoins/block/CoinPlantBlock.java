
package net.rewey.markscoins.block;

import net.rewey.markscoins.procedures.CoinPlantAdditionalGenerationConditionProcedure;
import net.rewey.markscoins.procedures.CoinPileEntityCollidesInTheBlockProcedure;
import net.rewey.markscoins.MarkscoinsModElements;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.common.PlantType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.NoiseDependant;
import net.minecraft.world.gen.feature.RandomPatchFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.blockplacer.SimpleBlockPlacer;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.World;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.Direction;
import net.minecraft.potion.Effects;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import java.util.Random;
import java.util.Map;
import java.util.HashMap;

import com.google.common.collect.ImmutableMap;

@MarkscoinsModElements.ModElement.Tag
public class CoinPlantBlock extends MarkscoinsModElements.ModElement {
	@ObjectHolder("markscoins:coin_plant")
	public static final Block block = null;
	public CoinPlantBlock(MarkscoinsModElements instance) {
		super(instance, 78);
		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.MISC)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}
	private static Feature<BlockClusterFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;
	private static class FeatureRegisterHandler {
		@SubscribeEvent
		public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			feature = new RandomPatchFeature(BlockClusterFeatureConfig.field_236587_a_) {
				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, BlockClusterFeatureConfig config) {
					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;
					if (dimensionType == World.OVERWORLD)
						dimensionCriteria = true;
					if (dimensionType == World.THE_NETHER)
						dimensionCriteria = true;
					if (!dimensionCriteria)
						return false;
					int x = pos.getX();
					int y = pos.getY();
					int z = pos.getZ();
					if (!CoinPlantAdditionalGenerationConditionProcedure.executeProcedure(ImmutableMap.of()))
						return false;
					return super.generate(world, generator, random, pos, config);
				}
			};
			configuredFeature = feature.withConfiguration(
					(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(block.getDefaultState()), new SimpleBlockPlacer())).tries(64)
							.build())
					.withPlacement(Placement.COUNT_NOISE.configure(new NoiseDependant(-0.8, 0, 1)));
			event.getRegistry().register(feature.setRegistryName("coin_plant"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("markscoins:coin_plant"), configuredFeature);
		}
	}
	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> configuredFeature);
	}
	public static class BlockCustomFlower extends FlowerBlock {
		public BlockCustomFlower() {
			super(Effects.SATURATION, 0,
					Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.CHAIN).hardnessAndResistance(0f, 0f)
							.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true).speedFactor(0.9f)
							.setLightLevel(s -> 6));
			setRegistryName("coin_plant");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 100;
		}

		@Override
		public PathNodeType getAiPathNodeType(BlockState state, IBlockReader world, BlockPos pos, MobEntity entity) {
			return PathNodeType.DANGER_OTHER;
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 60;
		}

		@Override
		public boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
			Block block = state.getBlock();
			return (block == Blocks.STONE.getDefaultState().getBlock() || block == Blocks.GRASS_BLOCK.getDefaultState().getBlock()
					|| block == Blocks.MYCELIUM.getDefaultState().getBlock() || block == Blocks.DIRT.getDefaultState().getBlock()
					|| block == Blocks.COARSE_DIRT.getDefaultState().getBlock() || block == Blocks.PODZOL.getDefaultState().getBlock()
					|| block == Blocks.SAND.getDefaultState().getBlock() || block == Blocks.NETHERRACK.getDefaultState().getBlock());
		}

		@Override
		public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
			BlockPos blockpos = pos.down();
			BlockState blockstate = worldIn.getBlockState(blockpos);
			return this.isValidGround(blockstate, worldIn, blockpos);
		}

		@Override
		public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.BEACH;
		}

		@Override
		public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
			super.onEntityCollision(state, world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("x", x);
				$_dependencies.put("y", y);
				$_dependencies.put("z", z);
				$_dependencies.put("world", world);
				CoinPileEntityCollidesInTheBlockProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
