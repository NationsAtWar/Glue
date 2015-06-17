package org.nationsatwar.glue;

import java.util.logging.Level;
import java.util.logging.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.nationsatwar.glue.events.ChatCommands;
import org.nationsatwar.glue.guildmaster.GuildMasterNPC;
import org.nationsatwar.glue.items.nationcharter.NationCharterItem;
import org.nationsatwar.glue.proxy.CommonProxy;
import org.nationsatwar.toychest.items.Toy;

@Mod(modid = Glue.MODID, 
	name = Glue.MODNAME, 
	version = Glue.MODVER)
public class Glue {

    @Instance(Glue.MODID)
    public static Glue instance;

	@SidedProxy(clientSide = Glue.CLIENT_PROXY_CLASS, serverSide = Glue.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final String MODID = "glue";
	public static final String MODNAME = "Glue";
	public static final String MODVER = "0.0.1";
	
	public static final String CLIENT_PROXY_CLASS = "org.nationsatwar.glue.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "org.nationsatwar.glue.proxy.CommonProxy";
	
	private static final Logger log = Logger.getLogger("Minecraft");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		// Register NPCs
		GuildMasterNPC.createGuildMaster();
		
		// Register Items
		Toy.register(new NationCharterItem("nationcharter"), MODID);
	}
	
	@EventHandler
	public void commandEvent(FMLServerStartingEvent event) {
		
		event.registerServerCommand(new ChatCommands("glue"));
	}
	
	/**
	 * Mod logger handler. Useful for debugging.
	 * 
	 * @param logMessage  Message to send to the console.
	 */
	public static void log(String logMessage) {
		
		log.log(Level.INFO, logMessage);
	}
}