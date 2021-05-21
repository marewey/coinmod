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

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.container.Slot;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import java.util.function.Supplier;
import java.util.Map;

@MarkscoinsModElements.ModElement.Tag
public class BankInputCalcProcedure extends MarkscoinsModElements.ModElement {
	public BankInputCalcProcedure(MarkscoinsModElements instance) {
		super(instance, 59);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency entity for procedure BankInputCalc!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				MarkscoinsMod.LOGGER.warn("Failed to load dependency world for procedure BankInputCalc!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;
			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if ((new ItemStack(CoinwoodItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + (new Object() {
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
								}.getAmount((int) (0))));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoinstoneItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 4));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoincopperItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 16));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoinironItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 64));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoingoldItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 256));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoinplatinumItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 1024));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoinamethystItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 4096));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoinsapphireItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 16384));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoinemeraldItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 65536));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoinrubyItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 262144));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoindiamondItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 1048576));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				} else if ((new ItemStack(CoinnetheriteItem.block, (int) (1)).getItem() == (new Object() {
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
				}.getItemStack((int) (0))).getItem())) {
					{
						double _setval = (double) (((entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null)
								.orElse(new MarkscoinsModVariables.PlayerVariables())).money) + ((new Object() {
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
								}.getAmount((int) (0))) * 4194304));
						entity.getCapability(MarkscoinsModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.money = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
					if (entity instanceof ServerPlayerEntity) {
						Container _current = ((ServerPlayerEntity) entity).openContainer;
						if (_current instanceof Supplier) {
							Object invobj = ((Supplier) _current).get();
							if (invobj instanceof Map) {
								((Slot) ((Map) invobj).get((int) (0))).putStack(ItemStack.EMPTY);
								_current.detectAndSendChanges();
							}
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) 1);
	}
}
