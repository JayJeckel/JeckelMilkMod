package jeckelmilkmod.content;

import jeckelmilkmod.core.Refs;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMilk extends BlockFluidClassic
{
	@SideOnly(Side.CLIENT)
	protected IIcon stillIcon;
	@SideOnly(Side.CLIENT)
	protected IIcon flowIcon;

	public BlockMilk(Fluid fluid)
	{
			super(fluid, Material.water);
			this.setBlockName("milk_block");
	}

	@Override public IIcon getIcon(int side, int meta)
	{
			return (side == 0 || side == 1 ? this.stillIcon : this.flowIcon);
	}

	@SideOnly(Side.CLIENT)
	@Override public void registerBlockIcons(IIconRegister register)
	{
		this.stillIcon = register.registerIcon(Refs.ModId + ":" + "milk_still");
		this.flowIcon = register.registerIcon(Refs.ModId + ":" + "milk_flow");
		ContentManager.ModFluids.milk_fluid.setIcons(this.stillIcon, this.flowIcon);
	}

	/*@Override public boolean canDisplace(IBlockAccess world, int x, int y, int z)
	{
		if (world.getBlock(x,  y,  z).getMaterial().isLiquid()) { return false; }
		return super.canDisplace(world, x, y, z);
	}*/

	/*@Override public boolean displaceIfPossible(World world, int x, int y, int z)
	{
		if (world.getBlock(x, y, z).getMaterial().isLiquid()) { return false; }
		return super.displaceIfPossible(world, x, y, z);
	}*/

}
