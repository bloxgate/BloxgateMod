/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods.bloxgate.bloxgatemod.common;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 *
 * @author Gregory
 */
public class BloxgatemodFuelHandler implements IFuelHandler
{
    @Override
    public int getBurnTime(ItemStack fuel)
    {
        if (fuel.getItem() == mod_bloxgatemod.uranium)
        {
            return 24000;
        }
        else
        {
            return 0;
        }
    }
}
