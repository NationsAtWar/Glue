package org.nationsatwar.glue.guildmaster;

import net.minecraft.entity.player.EntityPlayer;

import org.nationsatwar.clowns.actions.CustomAction;
import org.nationsatwar.clowns.entities.GenericNPC;
import org.nationsatwar.glue.items.nationcharter.NationCharterItem;
import org.nationsatwar.palette.ItemHelper;

public class GiveCharter extends CustomAction {

	public GiveCharter(GenericNPC npc) {
		
		super(npc);
	}

	@Override
	public void fireAction(EntityPlayer player) {
		
		ItemHelper.giveItemToPlayer(player, NationCharterItem.instance, 1);
	}
}