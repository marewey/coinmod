
package net.rewey.markscoins.item;

import net.rewey.markscoins.MarkscoinsModElements;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import java.util.List;

@MarkscoinsModElements.ModElement.Tag
public class CoinframeItem extends MarkscoinsModElements.ModElement {
	@ObjectHolder("markscoins:coinframe")
	public static final Item block = null;
	public CoinframeItem(MarkscoinsModElements instance) {
		super(instance, 82);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(null).maxStackSize(64).isImmuneToFire().rarity(Rarity.UNCOMMON));
			setRegistryName("coinframe");
		}

		@Override
		public int getItemEnchantability() {
			return 13;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 2;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("Used to mint coins"));
		}
	}
}
