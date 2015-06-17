package org.nationsatwar.glue.items.nationcharter;

import net.minecraft.item.ItemStack;

import org.nationsatwar.glue.Glue;
import org.nationsatwar.palette.gui.GUIButton;
import org.nationsatwar.palette.gui.GUIHandler;
import org.nationsatwar.palette.gui.GUILabel;
import org.nationsatwar.palette.gui.GUIScreen;

public class GUINationCharterMainMenu extends GUIScreen {
	
	private ItemStack nationCharter;
	
	private GUIButton renameNationButton;
	private GUIButton signaturesButton;
	
	private GUILabel errorLabel;
	
	public GUINationCharterMainMenu(ItemStack nationCharter) {
		
		this.nationCharter = nationCharter;
	}
	
	@Override
	protected void setElements() {
		
		setWindow((width - 140) / 2, 20, 180, 180);
		
		GUILabel mainLabel = addLabel(windowX + (windowWidth / 2), windowY + 18, "Nation Charter");
		mainLabel.setFontColor(0xCCAA22);
		mainLabel.setCentered(true);
		mainLabel.setSizeDoubled(true);
		
		if (nationCharter == null) {
			
			Glue.log("Item is null");
			return;
		}
		
		if (nationCharter.getTagCompound() == null) {
			
			Glue.log("Compound is null");
			return;
		}
		
		if (nationCharter.getTagCompound().getString("Nation Name") == null) {
			
			Glue.log("String is null");
			return;
		}
		
		String nationName = nationCharter.getTagCompound().getString("Nation Name");
		
		renameNationButton = addButton(windowX + 40, windowY + 40, 100, 20, nationName);
		signaturesButton = addButton(windowX + 40, windowY + 70, 100, 20, "Signatures");
		
		GUILabel leaderLabel = addLabel(windowX + 20, windowY + 100, "Nation Leader");
		leaderLabel.setFontColor(0xCCAA22);
		GUILabel nationLeader = addLabel(windowX + 30, windowY + 115, "(None assigned)");
		nationLeader.setFontColor(0xCCAA22);
		
		GUILabel secondLabel = addLabel(windowX + 20, windowY + 130, "Nation Co-Leader");
		secondLabel.setFontColor(0xCCAA22);
		GUILabel nationSecond = addLabel(windowX + 30, windowY + 145, "(None assigned)");
		nationSecond.setFontColor(0xCCAA22);
		
		errorLabel = addLabel(windowX + 10, windowY + 160, "");
		errorLabel.setFontColor(FontColor.RED);
		errorLabel.setCentered(true);
	}
	
	@Override
	protected void buttonClicked(GUIButton button) {
		
		if (button.equals(renameNationButton))
			GUIHandler.openGUI(new GUINationCharterRenameNation(nationCharter), false);
		
		if (button.equals(signaturesButton))
			GUIHandler.openGUI(new GUINationCharterSignatures(nationCharter), false);
	}
}