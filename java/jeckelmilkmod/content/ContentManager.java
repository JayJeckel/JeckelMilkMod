package jeckelmilkmod.content;

import jeckelmilkmod.core.Refs;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidContainerRegistry;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ContentManager
{
	public static class ModBlocks
	{
		public static Block milk_block;
	}

	public static class ModItems
	{
		public static Item milk_bottle;
	}

	public static class ModFluids
	{
		public static Fluid milk_fluid;
	}

	public void pre()
	{
		ModFluids.milk_fluid = new Fluid("milk").setDensity(1030);
		final boolean result = FluidRegistry.registerFluid(ModFluids.milk_fluid);

		if (!result) { Refs.getLogger().warn("Mod Disabled: Milk Fluid already registered."); }
		else
		{
			final FluidStack stackMilk = FluidRegistry.getFluidStack("milk", FluidContainerRegistry.BUCKET_VOLUME);

			ModBlocks.milk_block = new BlockMilk(ModFluids.milk_fluid);
			GameRegistry.registerBlock(ModBlocks.milk_block, ModBlocks.milk_block.getUnlocalizedName().substring(5));

			ModItems.milk_bottle = new ItemMilkBottle();
			GameRegistry.registerItem(ModItems.milk_bottle, ModItems.milk_bottle.getUnlocalizedName().substring(5));

			FluidContainerRegistry.registerFluidContainer(stackMilk, new ItemStack(Items.milk_bucket), new ItemStack(Items.bucket));
			FluidContainerRegistry.registerFluidContainer(stackMilk, new ItemStack(ModItems.milk_bottle), new ItemStack(Items.glass_bottle));

			BucketHandler.INSTANCE.buckets.put(ModBlocks.milk_block, Items.milk_bucket);
			MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		}
	}

	public void initialize()
	{
	}

	public void post()
	{
	}
}
