package net.mcreator.dimensionaldungeon;

import net.minecraft.world.World;
import net.minecraft.world.GameType;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;

@Elementsdimensionaldungeon.ModElement.Tag
public class MCreatorGm1CommandExecuted extends Elementsdimensionaldungeon.ModElement {
	public MCreatorGm1CommandExecuted(Elementsdimensionaldungeon instance) {
		super(instance, 3);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure MCreatorGm1CommandExecuted!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure MCreatorGm1CommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		World world = (World) dependencies.get("world");
		if (((entity instanceof EntityPlayer) ? ((EntityPlayer) entity).capabilities.isCreativeMode : false)) {
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("You are already in creative mode!"), (false));
			}
		} else {
			if (entity instanceof EntityPlayer)
				((EntityPlayer) entity).setGameType(GameType.CREATIVE);
			if (entity instanceof EntityPlayer && !world.isRemote) {
				((EntityPlayer) entity).sendStatusMessage(new TextComponentString("Succsefully mode changed to Creative!"), (false));
			}
		}
	}
}
