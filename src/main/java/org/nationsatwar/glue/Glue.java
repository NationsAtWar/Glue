package org.nationsatwar.glue;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

import org.nationsatwar.glue.guildmaster.GuildMasterNPC;
import org.nationsatwar.glue.proxy.CommonProxy;

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
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		GuildMasterNPC.createGuildMaster();
	}
	
	@EventHandler
	public void commandEvent(FMLServerStartingEvent event) {
		
		
	}
}