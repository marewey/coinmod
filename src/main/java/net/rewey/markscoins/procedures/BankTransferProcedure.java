package net.rewey.markscoins.procedures;

import net.rewey.markscoins.MarkscoinsModVariables;
import net.rewey.markscoins.MarkscoinsModElements;
import net.rewey.markscoins.MarkscoinsMod;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

@MarkscoinsModElements.ModElement.Tag
public class BankTransferProcedure extends MarkscoinsModElements.ModElement {
	public BankTransferProcedure(MarkscoinsModElements instance) {
		super(instance, 61);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency entity for procedure BankTransfer!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MarkscoinsModVariables.PlayerVariables())).money) >= 0)) {
			if (((new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								ItemStack stack = ((Slot) ((Map) invobj).get(sltid)).getStack();;
								if (stack != null)
									return stack.getCount();
							}
						}
					}
					return 0;
				}
			}.getAmount((int) (1))) > 0)) {
				{
					double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money)
							- ((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new MarkscoinsModVariables.PlayerVariables())).transfer));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.money = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) 0;
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					ItemStack _setstack = (new Object() {
						public ItemStack getItemStack(int sltid) {
							Entity _ent = entity;
							if (_ent instanceof ServerPlayerEntity) {
								Container _current = ((ServerPlayerEntity) _ent).openContainer;
								if (_current instanceof Supplier) {
									Object invobj = ((Supplier) _current).get();
									if (invobj instanceof Map) {
										return ((Slot) ((Map) invobj).get(sltid)).getStack();
									}
								}
							}
							return ItemStack.EMPTY;
						}
					}.getItemStack((int) (1)));
					_setstack.setCount((int) ((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display));
					ItemHandlerHelper.giveItemToPlayer(((PlayerEntity) entity), _setstack);
				}
				if (entity instanceof ServerPlayerEntity) {
					Container _current = ((ServerPlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							((Slot) ((Map) invobj).get((int) (1))).putStack(ItemStack.EMPTY);
							_current.detectAndSendChanges();
						}
					}
				}
			}
		}
	}
}
