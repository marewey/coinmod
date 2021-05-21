package net.rewey.markscoins.procedures;

import net.rewey.markscoins.MarkscoinsModElements;
import net.rewey.markscoins.MarkscoinsMod;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Block;

import java.util.Map;

@MarkscoinsModElements.ModElement.Tag
public class CoinPileEntityCollidesInTheBlockProcedure extends MarkscoinsModElements.ModElement {
	public CoinPileEntityCollidesInTheBlockProcedure(MarkscoinsModElements instance) {
		super(instance, 75);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency entity for procedure CoinPileEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency x for procedure CoinPileEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency y for procedure CoinPileEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency z for procedure CoinPileEntityCollidesInTheBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency world for procedure CoinPileEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof PlayerEntity)) {
			if (world instanceof World) {
				Block.spawnDrops(world.getBlockState(new BlockPos((int) x, (int) y, (int) z)), (World) world,
						new BlockPos((int) x, (int) y, (int) z));
				world.destroyBlock(new BlockPos((int) x, (int) y, (int) z), false);
			}
		}
	}
}
