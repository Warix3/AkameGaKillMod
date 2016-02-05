package ga.warixmods.agkm.init;
import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.entity.projectile.EntityBelvaac;
import ga.warixmods.agkm.entity.projectile.EntityIceShards;
import ga.warixmods.agkm.entity.projectile.EntityMastemaFeather;
import ga.warixmods.agkm.entity.projectile.EntityRocket;
import ga.warixmods.agkm.entity.special.EntityRocketLauncher;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class AkameEntities {

	
	public static void init()
	{

	}
		
	public static void register()
	{
		EntityRegistry.registerModEntity(EntityIceShards.class, "ice_shards", 4, AkameGaKill.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityBelvaac.class, "belvaac_part", 36, AkameGaKill.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityRocketLauncher.class, "rocket_launcher", 37, AkameGaKill.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityRocket.class, "rocket", 38, AkameGaKill.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityMastemaFeather.class, "mastema_feather", 39, AkameGaKill.instance, 80, 3, true);
	}
	
	
		
	public static void registerRender(Block block)
	{
		
	}
}
