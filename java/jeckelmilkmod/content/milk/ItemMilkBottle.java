package jeckelmilkmod.content.milk;

import java.util.List;

import jeckelmilkmod.core.Refs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMilkBottle extends Item
{
	public ItemMilkBottle()
	{
		this.setUnlocalizedName("milk_bottle");
		this.setTextureName(Refs.ModId + ":" + this.getUnlocalizedName().substring(5));
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setMaxDamage(16);
	}

	public EnumAction getItemUseAction(ItemStack stack) { return EnumAction.drink; }

	public int getMaxItemUseDuration(ItemStack stack) { return 32; }

	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
	{
		if (!player.capabilities.isCreativeMode) { --stack.stackSize; }
		if (!world.isRemote) { player.curePotionEffects(new ItemStack(Items.milk_bucket)); }
		return (stack.stackSize <= 0 ? new ItemStack(Items.glass_bottle) : stack);
	}

	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		return stack;
	}

	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@Override public void addInformation(ItemStack stack, EntityPlayer player, @SuppressWarnings("rawtypes") List infoList, boolean par4)
	{
		infoList.add("Drink me to cure debuffs.");
	}
}
