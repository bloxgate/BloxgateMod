package mods.bloxgate.bloxgatemod.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlockDeployer extends TileEntity implements IInventory
{
    private ItemStack[] inventory;

    public TileEntityBlockDeployer()
    {
        inventory = new ItemStack[1];
    }

    @Override
    public int getSizeInventory()
    {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int i)
    {
        return inventory[i];
    }

    @Override
    public ItemStack decrStackSize(int i, int j)
    {
        ItemStack itemstack = getStackInSlot(i);

        if (itemstack != null)
        {
            if (itemstack.stackSize <= j)
            {
                setInventorySlotContents(i, null);
            }
            else
            {
                itemstack = itemstack.splitStack(i);
            }
        }

        return itemstack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int i)
    {
        ItemStack itemstack = getStackInSlot(i);
        setInventorySlotContents(i, null);
        return itemstack;
    }

    @Override
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        inventory[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
        {
            itemstack.stackSize = getInventoryStackLimit();
        }

    }

    public String getInvName()
    {
        return "Block Deployer";
    }

    public boolean isInvNameLocalized()
    {
        return true;
    }

    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer entityplayer)
    {
        if (entityplayer.getDistanceSq(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D) <= 64)
        {
            return true;
        }
        else
        {
            return false;
        }
    }



    @Override
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        // TODO Auto-generated method stub
        return true;
    }

	@Override
	public void closeInventory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInventoryName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void openInventory() {
		// TODO Auto-generated method stub
		
	}
}
