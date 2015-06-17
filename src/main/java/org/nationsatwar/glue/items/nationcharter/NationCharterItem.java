package org.nationsatwar.glue.items.nationcharter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import org.nationsatwar.palette.gui.GUIHandler;
import org.nationsatwar.toychest.items.Toy;

public class NationCharterItem extends Toy {

	public NationCharterItem(String name) {
		
		super(name);
		this.setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		
		if (!itemStackIn.hasTagCompound()) {
			
			itemStackIn.setTagCompound(new NBTTagCompound());
			itemStackIn.getTagCompound().setString("Nation Name", "(None Assigned)");
		}
		
		if (!worldIn.isRemote)
			return itemStackIn;
		
		GUIHandler.openGUI(new GUINationCharterMainMenu(itemStackIn), false);
		return itemStackIn;
	}
}