package org.nationsatwar.glue.guildmaster;

import net.minecraft.world.World;

import org.nationsatwar.clowns.NPCCreator;
import org.nationsatwar.clowns.entities.GenericNPC;

public class GuildMasterNPC extends GenericNPC {

	public GuildMasterNPC(World worldIn, String name) {
		
		super(worldIn, name);
	}
	
	public static void createGuildMaster() {
		
		NPCCreator.addEntity(GuildMasterNPC.class, "Guild Master");
	}
}