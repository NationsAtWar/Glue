package org.nationsatwar.glue.items.nationcharter;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import org.nationsatwar.goldfish.prototypes.PrototypeManager;
import org.nationsatwar.goldfish.util.Constants;
import org.nationsatwar.palette.NBTHelper;
import org.nationsatwar.palette.gui.GUIButton;
import org.nationsatwar.palette.gui.GUIHandler;
import org.nationsatwar.palette.gui.GUILabel;
import org.nationsatwar.palette.gui.GUIScreen;
import org.nationsatwar.palette.gui.GUITextField;

public class GUINationCharterRenameNation extends GUIScreen {
	
	private ItemStack nationCharter;
	
	private GUITextField renameTextField;
	private GUIButton confirmButton;
	private GUILabel errorLabel;
	
	public GUINationCharterRenameNation(ItemStack nationCharter) {
		
		this.nationCharter = nationCharter;
	}
	
	@Override
	public void setElements() {

		setWindow((width - 140) / 2, 64, 140, 100);
		
		confirmButton = addButton(windowX + 15, windowY + windowHeight - 20, 50, 20, "Confirm");
		addButton(windowX + windowWidth - 65, windowY + windowHeight - 20, 50, 20, "Cancel");
		
		String nationName = nationCharter.getTagCompound().getString("Nation Name");

		addLabel(windowX + (windowWidth / 2), windowY + 15, "Rename Nation:").setCentered(true);
		addLabel(windowX + (windowWidth / 2), windowY + 28, nationName + "?").setCentered(true);
		
		renameTextField = addTextField(windowX + 20, windowY + 45, 100, 20, nationName);
		renameTextField.setRegEx(Constants.PROTOTYPE_NAME_REGEX);
		renameTextField.setMaxStringLength(PrototypeManager.MAX_PROTOTYPE_NAME_LENGTH);
		
		errorLabel = addLabel(windowX + (windowWidth / 2), windowY + 48, "");
		errorLabel.setFontColor(FontColor.RED);
		errorLabel.setCentered(true);
	}
	
	@Override
	protected void buttonClicked(GUIButton button) {
		
		// Renames Nation
		if (button.equals(confirmButton)) {
			
			if (renameTextField.getText().matches(Constants.PROTOTYPE_NAME_REGEX)) {
				
				NBTTagCompound tagCompound = nationCharter.getTagCompound();
				tagCompound.setString("Nation Name", renameTextField.getText());
				
				NBTHelper.syncNBTWithServer(player, tagCompound);
				
				GUIHandler.openGUI(new GUINationCharterMainMenu(nationCharter), false);
				return;
			}
			else if (errorLabel.getText() == "")
				errorLabel.setText("Enter a nation name");
			else
				errorLabel.setText("Enter valid characters");

			renameTextField.setText("");
			return;
		}
		
		// Cancel - Returns to Main Menu
		else
			GUIHandler.openGUI(new GUINationCharterMainMenu(nationCharter), false);
	}
}