package org.nationsatwar.glue.proxy;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;
import org.nationsatwar.glue.proxy.CommonProxy;
import org.nationsatwar.palette.KeyBindings;

public class ClientProxy extends CommonProxy {

	public static KeyBinding debugKey;
	
	@Override
	public void registerKeybindings() {
		
		debugKey = KeyBindings.registerKey(Keyboard.KEY_R, "debugKey");
	}
}