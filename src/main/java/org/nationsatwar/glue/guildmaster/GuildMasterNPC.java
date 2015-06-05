package org.nationsatwar.glue.guildmaster;

import net.minecraft.world.World;

import org.nationsatwar.clowns.NPCHook;
import org.nationsatwar.clowns.entities.GenericNPC;

public class GuildMasterNPC extends GenericNPC {
	
	public GuildMasterNPC(World worldIn) {
		
		super(worldIn);
	}

	public GuildMasterNPC(World worldIn, String name) {
		
		super(worldIn, name);
		
		addCustomAction("Charter", new GiveCharter());
	}
	
	public static void createGuildMaster() {
		
		NPCHook.registerNPC(GuildMasterNPC.class, "Guild Master");
	}
}