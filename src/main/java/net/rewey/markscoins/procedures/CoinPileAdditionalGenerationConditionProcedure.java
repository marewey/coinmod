package net.rewey.markscoins.procedures;

import net.rewey.markscoins.MarkscoinsModElements;
import net.rewey.markscoins.MarkscoinsMod;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.Blocks;

import java.util.Map;

@MarkscoinsModElements.ModElement.Tag
public class CoinPileAdditionalGenerationConditionProcedure extends MarkscoinsModElements.ModElement {
	public CoinPileAdditionalGenerationConditionProcedure(MarkscoinsModElements instance) {
		super(instance, 76);
	}

	public static boolean executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency x for procedure CoinPileAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency y for procedure CoinPileAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency z for procedure CoinPileAdditionalGenerationCondition!");
			return false;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency world for procedure CoinPileAdditionalGenerationCondition!");
			return false;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() instanceof FlowingFluidBlock)) {
			return (false);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z + 1)))).getBlock() instanceof FlowingFluidBlock)) {
			return (false);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) (z - 1)))).getBlock() instanceof FlowingFluidBlock)) {
			return (false);
		} else if (((world.getBlockState(new BlockPos((int) (x - 1), (int) y, (int) z))).getBlock() instanceof FlowingFluidBlock)) {
			return (false);
		} else if (((world.getBlockState(new BlockPos((int) (x + 1), (int) y, (int) z))).getBlock() instanceof FlowingFluidBlock)) {
			return (false);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() instanceof FlowingFluidBlock)) {
			return (false);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y + 1), (int) z))).getBlock() instanceof FlowingFluidBlock)) {
			return (false);
		}
		if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.STONE.getDefaultState().getBlock())) {
			return (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.MYCELIUM.getDefaultState()
				.getBlock())) {
			return (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.DIRT.getDefaultState().getBlock())) {
			return (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRASS_BLOCK.getDefaultState()
				.getBlock())) {
			return (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.GRAVEL.getDefaultState().getBlock())) {
			return (true);
		} else if (((world.getBlockState(new BlockPos((int) x, (int) (y - 1), (int) z))).getBlock() == Blocks.SAND.getDefaultState().getBlock())) {
			return (true);
		}
		return (false);
	}
}
