/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mods.bloxgate.bloxgatemod.common;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;

/**
 *
 * @author Gregory
 */
public class BloxgatemodFuelHandler implements IFuelHandler{
    @Override
    public int getBurnTime(ItemStack fuel){
        int var1 = fuel.itemID;
        if (var1 == mod_bloxgatemod.uranium.itemID){
            return 24000;
        } 
        else{
            return 0;
        }
    }
    
}
