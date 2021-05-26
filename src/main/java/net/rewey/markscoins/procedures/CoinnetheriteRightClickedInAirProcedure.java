package net.rewey.markscoins.procedures;

import net.rewey.markscoins.MarkscoinsModElements;
import net.rewey.markscoins.MarkscoinsMod;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;

import java.util.Map;

@MarkscoinsModElements.ModElement.Tag
public class CoinnetheriteRightClickedInAirProcedure extends MarkscoinsModElements.ModElement {
	public CoinnetheriteRightClickedInAirProcedure(MarkscoinsModElements instance) {
		super(instance, 86);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency entity for procedure CoinnetheriteRightClickedInAir!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency world for procedure CoinnetheriteRightClickedInAir!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof ServerWorld) {
			LightningBoltEntity _ent = EntityType.LIGHTNING_BOLT.create((World) world);
			_ent.moveForced(
					Vector3d.copyCenteredHorizontally(
							new BlockPos(
									(int) (entity.world.rayTraceBlocks(
											new RayTraceContext(entity.getEyePosition(1f),
													entity.getEyePosition(1f).add(entity.getLook(1f).x * 64, entity.getLook(1f).y * 64,
															entity.getLook(1f).z * 64),
													RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.ANY, entity))
											.getPos().getX()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 64, entity.getLook(1f).y * 64,
													entity.getLook(1f).z * 64),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.ANY, entity)).getPos().getY()),
									(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
											entity.getEyePosition(1f).add(entity.getLook(1f).x * 64, entity.getLook(1f).y * 64,
													entity.getLook(1f).z * 64),
											RayTraceContext.BlockMode.VISUAL, RayTraceContext.FluidMode.ANY, entity)).getPos().getZ()))));
			_ent.setEffectOnly(false);
			((World) world).addEntity(_ent);
		}
	}
}
