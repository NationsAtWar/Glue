package org.nationsatwar.glue.items.nationcharter;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.nationsatwar.goldfish.prototypes.PrototypeManager;
import org.nationsatwar.palette.NBTHelper;
import org.nationsatwar.palette.gui.GUIButton;
import org.nationsatwar.palette.gui.GUIHandler;
import org.nationsatwar.palette.gui.GUILabel;
import org.nationsatwar.palette.gui.GUIScreen;

public class GUINationCharterSignatures extends GUIScreen {
	
	private ItemStack nationCharter;

	private GUIButton addSignatureButton;
	private GUIButton returnButton;
	private GUIButton previousButton;
	private GUIButton nextButton;
	
	private static int signaturesPage = 0;
	
	public GUINationCharterSignatures(ItemStack nationCharter) {
		
		this.nationCharter = nationCharter;
	}
	
	public void setElements() {
		
		setWindow((width - 140) / 2, 20, 180, 180);
		
		GUILabel mainLabel = addLabel(windowX + (windowWidth / 2), windowY + 18, "Signatures");
		mainLabel.setFontColor(0xCCAA22);
		mainLabel.setCentered(true);
		mainLabel.setSizeDoubled(true);
		
		addSignatureButton = addButton(windowX + (windowWidth / 2) - 50, windowY + 40, 100, 20, "Add Signature");
		returnButton = addButton(windowX + windowWidth - 30, windowY + 10, 20, 20, "<-");
		
		for (String signature : NBTHelper.getNBTStringList(nationCharter.getTagCompound(), "Signatures"))
			System.out.println(signature);
		
		if (PrototypeManager.getPrototypeByIndex(signaturesPage - 1) != null)
			previousButton = addButton(windowX + 20, windowY + 150, 20, 20, "<");
		
		if (PrototypeManager.getPrototypeByIndex(signaturesPage + 1) != null)
			nextButton = addButton(windowX + 100, windowY + 150, 20, 20, ">");
	}
	
	protected void buttonClicked(GUIButton button) {
		
		// Return
		if (button.equals(returnButton))
			GUIHandler.openGUI(new GUINationCharterMainMenu(nationCharter), false);
		
		// Add Signature
		if (button.equals(addSignatureButton)) {
			
			NBTTagCompound tagCompound = nationCharter.getTagCompound();
			
			NBTHelper.addStringToNBTList(tagCompound, "Signatures", "Aculem");
			NBTHelper.syncNBTWithServer(player, nationCharter.getTagCompound());
			
			GUIHandler.openGUI(new GUINationCharterMainMenu(nationCharter), false);
		}
		
		// Previous Prototype
		if (button.equals(previousButton)) {
			
			signaturesPage--;
			GUIHandler.openGUI(new GUINationCharterSignatures(nationCharter), false);
		}
		
		// Next Prototype
		if (button.equals(nextButton)) {
			
			signaturesPage++;
			GUIHandler.openGUI(new GUINationCharterSignatures(nationCharter), false);
		}
	}
}