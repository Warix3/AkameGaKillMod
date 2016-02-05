package ga.warixmods.agkm.events;

import java.util.Iterator;
import java.util.Random;

import com.google.common.eventbus.Subscribe;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.SendPacketToClient;
import ga.warixmods.agkm.entity.AI.copy.AttackOnCollidex;
import ga.warixmods.agkm.entity.AI.copy.FindNearestNonHuman;
import ga.warixmods.agkm.entity.projectile.EntityRocket;
import ga.warixmods.agkm.entity.special.EntityRocketLauncher;
import ga.warixmods.agkm.events.extendedproperties.EntityExtendedProperties;
import ga.warixmods.agkm.init.AkameItems;
import ga.warixmods.agkm.item.ItemYatsufusa;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.event.entity.player.PlayerEvent.StartTracking;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ForgeEvents 
{
	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityLivingBase) {
			EntityExtendedProperties.register((EntityLivingBase) event.entity);
		}
	}
	@SubscribeEvent
	public void chunkEventLoad(ChunkEvent.Load event) {

		ClassInheritanceMultiMap[] b = event.getChunk().getEntityLists();

		int i = 0;
		for (Object a: b) {
			Iterator iterator = b[i].getByClass(EntityCreature.class).iterator();

			while (iterator.hasNext()) {
				EntityCreature entity = (EntityCreature) iterator.next();

				if (EntityExtendedProperties.get(entity).isServant()) {
					entity.tasks.taskEntries.clear();
					entity.targetTasks.taskEntries.clear();
					entity.tasks.addTask(4, new AttackOnCollidex((EntityCreature) entity, EntityLiving.class, 1.0D, true));
					entity.targetTasks.addTask(2, new FindNearestNonHuman((EntityCreature) entity, EntityLiving.class, true));
				}

			}
			i++;

		}

	}
	@SubscribeEvent
	public void EntityInteractEvent(EntityInteractEvent event) {

		if(event.entityPlayer.getHeldItem() != null)
		{
			
		//Honest
		if(event.entityPlayer.getHeldItem().getItem() == AkameItems.honest)
		{
			if (event.target instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) event.target;
				NBTTagCompound nbt = player.getHeldItem().getTagCompound();
				if(nbt.getString("Type").equals("Teigu"))
				{
				player.destroyCurrentEquippedItem();
				event.entityPlayer.destroyCurrentEquippedItem();
				}
			}
		}
			
			
		//Demons extract wand
		if (event.entityPlayer.getHeldItem().getItem() == AkameItems.demons_extract_wand) {
			if (event.target instanceof EntityLivingBase) {
				EntityExtendedProperties.get((EntityLivingBase) event.target).setFrozen(true);
				if(event.target instanceof EntityLiving)
				{
					event.target.getDataWatcher().updateObject(15, Byte.valueOf((byte)(1)));
				}
			}
		}
		//Perfector
		if (event.entityPlayer.getHeldItem().getItem() == AkameItems.perfector) {
			if (event.target instanceof EntityLiving) {
				EntityLiving living = (EntityLiving) event.target;

				int id = event.entityPlayer.getHeldItem().getTagCompound().getInteger("id");
				switch (id) {
					case 0:
						living.addPotionEffect(new PotionEffect(1, 2000));
						break;
					case 1:
						living.addPotionEffect(new PotionEffect(21, 2000));
						break;
					case 2:
						living.addPotionEffect(new PotionEffect(8, 2000));
						break;
					case 3:
						living.addPotionEffect(new PotionEffect(6, 2000));
						break;
				}

				if (event.target.worldObj != null) {
					EntityRocketLauncher rL = new EntityRocketLauncher(event.target.worldObj);
					rL.posX = event.target.posX;
					rL.posY = event.target.posY + event.target.height;
					rL.posZ = event.target.posZ;

					if (!event.target.worldObj.isRemote) {


						event.target.worldObj.spawnEntityInWorld(rL);
						rL.mountEntity(living);
					}

				}
			}
		}
		}
	}
	@SubscribeEvent
	public void LivingDeathEvent(LivingDeathEvent event) {

		if (event.source.getEntity() instanceof EntityPlayer) {

			EntityPlayer playerIn = (EntityPlayer) event.source.getEntity();

			if (playerIn.getHeldItem() != null) {
                //Yatsufusa
				if (playerIn.getHeldItem().getItem() instanceof ItemYatsufusa) {


					NBTTagCompound nbt = playerIn.getHeldItem().getTagCompound();
					EntityLivingBase target = event.entityLiving;
					if (EntityExtendedProperties.get((EntityLivingBase) target).isServant()) {
						target.setDead();
						event.setCanceled(true);
					}
					int a = EntityList.getEntityID(target);

					if (nbt != null && nbt.hasKey("id")) {

						int[] ids = nbt.getIntArray("id");
						int c = 0;
						for(int i : ids)
						{
							if(i==0)
							{
								ids[c] = a;
								break;
							}
								c++;
						}
						nbt.setIntArray("id", ids);
						
					}
				}
				
				
			}
		}
	}
	@SubscribeEvent
	public void LivingSetAttackTargetEvent(LivingSetAttackTargetEvent event)
	{
		World worldIn = event.entity.worldObj;
	    EntityLiving target = null;
	    EntityLiving attacker = null;
	    if(event.entity instanceof EntityLiving)
	    	attacker = (EntityLiving) event.entity;
	    if(event.target instanceof EntityLiving)
		    target = (EntityLiving) event.target;

	    if(attacker != null && attacker.riddenByEntity instanceof EntityRocketLauncher && target != null)
	    {
	    	EntityRocketLauncher rocketLauncher = (EntityRocketLauncher) attacker.riddenByEntity;
	    	EntityRocket rocket = new EntityRocket(worldIn,rocketLauncher,target,1.0F,0F,attacker);
	    	rocket.setPosition(rocketLauncher.posX, rocketLauncher.posY, rocketLauncher.posZ);
	        rocket.rotationYaw = attacker.rotationYawHead;
	        rocket.rotationPitch = attacker.rotationPitch;
	    	worldIn.spawnEntityInWorld(rocket);
	    }
	   
	}
	@SubscribeEvent
	public void StartTracking(StartTracking event)
	{
		if(event.target instanceof EntityLiving)
		{
			String state;
			if(EntityExtendedProperties.get((EntityLivingBase) event.target).isFrozen())
				state = "true";
			else
				state = "false";
		AkameGaKill.networkClient.sendTo(new SendPacketToClient(event.target.getEntityId(),state), (EntityPlayerMP) event.entityPlayer);
		}
	}
	@SubscribeEvent
	public void LivingHurtEvent(LivingHurtEvent event)
	{
		//Demon's extract
		if(EntityExtendedProperties.get(event.entityLiving).isFrozen())
		{
			Random rand = new Random();
			
			WorldServer server = (WorldServer) event.entityLiving.worldObj;
			event.entityLiving.worldObj.playSoundAtEntity(event.entityLiving, "dig.glass", 1, 1);
			for(int i = 0; i<=20; i++)
			server.spawnParticle(EnumParticleTypes.BLOCK_CRACK, event.entityLiving.posX, event.entityLiving.posY, event.entityLiving.posZ, 1, rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),79);
			event.entityLiving.setDead();
			
		}
		//Extase
		if(event.source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if(player.getHeldItem() != null && player.getHeldItem().getItem() == AkameItems.extase)
			{
				event.entity.attackEntityFrom(DamageSource.magic, 5.0F + event.entityLiving.getTotalArmorValue());
					if(event.source != DamageSource.magic)
				event.setCanceled(false);
			}
		}
	}
	@SubscribeEvent
	public void LivingUpdateEvent(LivingUpdateEvent event)
	{
		//Mastema
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity; 
			if(player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem() == AkameItems.mastema)
			{
				player.capabilities.allowFlying = true;
			}
			else if (!player.capabilities.isCreativeMode)
			{
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
			}
			
		}
	}
	
}