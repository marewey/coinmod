package net.rewey.markscoins.procedures;

import net.rewey.markscoins.item.CoinwoodItem;
import net.rewey.markscoins.item.CoinstoneItem;
import net.rewey.markscoins.item.CoinsapphireItem;
import net.rewey.markscoins.item.CoinrubyItem;
import net.rewey.markscoins.item.CoinplatinumItem;
import net.rewey.markscoins.item.CoinnetheriteItem;
import net.rewey.markscoins.item.CoinironItem;
import net.rewey.markscoins.item.CoingoldItem;
import net.rewey.markscoins.item.CoinemeraldItem;
import net.rewey.markscoins.item.CoindiamondItem;
import net.rewey.markscoins.item.CoincopperItem;
import net.rewey.markscoins.item.CoinamethystItem;
import net.rewey.markscoins.MarkscoinsModVariables;
import net.rewey.markscoins.MarkscoinsModElements;
import net.rewey.markscoins.MarkscoinsMod;

import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

@MarkscoinsModElements.ModElement.Tag
public class BankOutputCalcProcedure extends MarkscoinsModElements.ModElement {
	public BankOutputCalcProcedure(MarkscoinsModElements instance) {
		super(instance, 60);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency entity for procedure BankOutputCalc!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((0 < ((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new MarkscoinsModVariables.PlayerVariables())).money))) {
			if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 4)) {
				{
					double _setval = (double) Math.floor(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoinwoodItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 16)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 4));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 4));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoinstoneItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 64)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 16));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 16));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoincopperItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 256)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 64));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 64));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoinironItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 1024)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 256));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 256));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoingoldItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 4096)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 1024));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 1024));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoinplatinumItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 16384)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 4096));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 4096));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoinamethystItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 65536)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 16384));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 16384));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoinsapphireItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 262144)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 65536));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 65536));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoinemeraldItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 1048576)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 262144));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 262144));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoinrubyItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) < 4194304)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 1048576));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 1048576));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoindiamondItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			} else if ((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new MarkscoinsModVariables.PlayerVariables())).money) >= 4194304)) {
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money) / 4194304));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.display = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				{
					double _setval = (double) Math.floor((((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).display) * 4194304));
					entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
						capability.transfer = _setval;
						capability.syncPlayerVariables(entity);
					});
				}
				if (entity instanceof PlayerEntity) {
					Container _current = ((PlayerEntity) entity).openContainer;
					if (_current instanceof Supplier) {
						Object invobj = ((Supplier) _current).get();
						if (invobj instanceof Map) {
							ItemStack _setstack = new ItemStack(CoinnetheriteItem.block, (int) (1));
							_setstack.setCount((int) new Object() {
								int convert(String s) {
									try {
										return Integer.parseInt(s.trim());
									} catch (Exception e) {
									}
									return 0;
								}
							}.convert((new java.text.DecimalFormat("#")
									.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
											.orElse(new MarkscoinsModVariables.PlayerVariables())).display)))));
							((Slot) ((Map) invobj).get((int) (1))).putStack(_setstack);
							_current.detectAndSendChanges();
						}
					}
				}
			}
		}
		{
			String _setval = (String) (new java.text.DecimalFormat("#,###,###,### PC")
					.format(((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new MarkscoinsModVariables.PlayerVariables())).money)));
			entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.money_disp = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
