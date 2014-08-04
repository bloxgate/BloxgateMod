package mods.bloxgate.bloxgatemod.client;

import mods.bloxgate.bloxgatemod.client.container.ContainerBlockDeployer;
import mods.bloxgate.bloxgatemod.client.gui.GuiBlockDeployer;
import mods.bloxgate.bloxgatemod.common.mod_bloxgatemod;
import mods.bloxgate.bloxgatemod.common.tileentity.TileEntityBlockDeployer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler
{
    public GuiHandler()
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(mod_bloxgatemod.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch (ID)
        {
            case 0:
                if (entity != null && entity instanceof TileEntityBlockDeployer)
                {
                    return new ContainerBlockDeployer(player.inventory, (TileEntityBlockDeployer) entity);
                }
                else
                {
                    return null;
                }

            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z)
    {
        TileEntity entity = world.getTileEntity(x, y, z);

        switch (ID)
        {
            case 0:
                if (entity != null && entity instanceof TileEntityBlockDeployer)
                {
                    return new GuiBlockDeployer(player.inventory, (TileEntityBlockDeployer) entity);
                }
                else
                {
                    return null;
                }

            default:
                return null;
        }
    }
}
