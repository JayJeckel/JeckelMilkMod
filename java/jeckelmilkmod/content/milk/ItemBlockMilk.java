package jeckelmilkmod.content.milk;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMilk extends ItemBlock
{
	public ItemBlockMilk(Block block)
	{
		super(block);
	}

	public Block getBlock() { return this.field_150939_a; }

	@Override public int getMetadata(int meta) { return 0; }

	@Override public String getUnlocalizedName(ItemStack stack) { return this.getBlock().getUnlocalizedName(); }

	/*@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List infoList, boolean par4)
	{
		infoList.add("Liquid Milk");
	}*/
}
