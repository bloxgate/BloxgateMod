package mods.bloxgate.bloxgatemod.client.container;

import mods.bloxgate.bloxgatemod.common.tileentity.TileEntityBlockDeployer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerBlockDeployer extends Container
{
    private TileEntityBlockDeployer deployer;

    public ContainerBlockDeployer(InventoryPlayer invPlayer, TileEntityBlockDeployer entity)
    {
        this.deployer = entity;
    }

    @Override
    public boolean canInteractWith(EntityPlayer entityplayer)
    {
        return deployer.isUseableByPlayer(entityplayer);
    }
}
