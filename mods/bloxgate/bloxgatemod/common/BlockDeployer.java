/*package mods.bloxgate.bloxgatemod.common;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.bloxgate.bloxgatemod.common.tileentity.TileEntityBlockDeployer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockDeployer extends BlockContainer
{
    public BlockDeployer()
    {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabRedstone);
        this.setHardness(5F);
        this.setResistance(10F);
        this.setStepSound(this.soundTypeSnow);
    }
    @SideOnly(Side.CLIENT)
    public static IIcon topIcon;
    @SideOnly(Side.CLIENT)
    public static IIcon sideIcon;
    @SideOnly(Side.CLIENT)
    public static IIcon frontIcon;

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconregister)
    {
        topIcon = iconregister.registerIcon("bloxgate:deployer_top");
        sideIcon = iconregister.registerIcon("bloxgate:deployer_side");
        frontIcon = iconregister.registerIcon("bloxgate:deployer_front");
    }
    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        setDefaultDirection(world, x, y, z);
    }
    private void setDefaultDirection(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            int zNeg = world.getBlockMetadata(x, y, z - 1);
            int zPos = world.getBlockMetadata(x, y, z + 1);
            int xNeg = world.getBlockMetadata(x - 1, y, z);
            int xPos = world.getBlockMetadata(x + 1, y, z);
            byte meta = 3;

            if (Block.opaqueCubeLookup[xNeg] && !Block.opaqueCubeLookup[xPos])
            {
                meta = 5;
            }

            if (Block.opaqueCubeLookup[xPos] && !Block.opaqueCubeLookup[xNeg])
            {
                meta = 4;
            }

            if (Block.opaqueCubeLookup[zNeg] && !Block.opaqueCubeLookup[zPos])
            {
                meta = 3;
            }

            if (Block.opaqueCubeLookup[zPos] && !Block.opaqueCubeLookup[zNeg])
            {
                meta = 2;
            }

            world.setBlockMetadataWithNotify(x, y, z, meta, 2);
        }
    }
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack itemstack)
    {
        int rotation = MathHelper.floor_double((double)(entity.rotationYaw * 4F / 360F) + 0.5D) & 3;

        if (rotation == 0)
        {
            world.setBlockMetadataWithNotify(x, y, z, 2, 2);
        }

        if (rotation == 1)
        {
            world.setBlockMetadataWithNotify(x, y, z, 5, 2);
        }

        if (rotation == 2)
        {
            world.setBlockMetadataWithNotify(x, y, z, 3, 2);
        }

        if (rotation == 3)
        {
            world.setBlockMetadataWithNotify(x, y, z, 4, 2);
        }
    }
    @Override
    public IIcon getIcon(int side, int meta)
    {
        if (side == 0 || side == 1)
        {
            return topIcon;
        }
        else if (side != meta)
        {
            return sideIcon;
        }
        else
        {
            return frontIcon;
        }
    }
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            cpw.mods.fml.common.network.internal.FMLNetworkHandler.openGui(player, mod_bloxgatemod.instance, 0, world, x, y, z);
        }

        return true;
    }
	@Override
	public TileEntity createNewTileEntity(World arg0, int arg1) {
		return new TileEntityBlockDeployer();
	}
}
*/