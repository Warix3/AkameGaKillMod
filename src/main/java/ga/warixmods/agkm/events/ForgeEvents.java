package ga.warixmods.agkm.events;

import java.util.Iterator;
import java.util.Random;
import java.util.UUID;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.SendPacketToClient;
import ga.warixmods.agkm.entity.AI.copy.AttackOnCollidex;
import ga.warixmods.agkm.entity.AI.copy.FindNearestNonHuman;
import ga.warixmods.agkm.entity.projectile.EntityRocket;
import ga.warixmods.agkm.entity.special.EntityRocketLauncher;
import ga.warixmods.agkm.events.extendedproperties.EntityExtendedProperties;
import ga.warixmods.agkm.init.AkameItems;
import ga.warixmods.agkm.item.ItemDemonsExtractWand;
import ga.warixmods.agkm.item.ItemErastone;
import ga.warixmods.agkm.item.ItemMastema;
import ga.warixmods.agkm.item.ItemPerfector;
import ga.warixmods.agkm.item.ItemTeigu;
import ga.warixmods.agkm.item.ItemTeiguArmor;
import ga.warixmods.agkm.item.ItemTeiguFood;
import ga.warixmods.agkm.item.ItemTeiguSword;
import ga.warixmods.agkm.item.ItemYatsufusa;
import ga.warixmods.agkm.item.ItemgcArmor;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
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
			
		//Erastone
		if(event.entityPlayer.getHeldItem().getItem() instanceof ItemErastone)
		{
			if (event.target instanceof EntityPlayer)
			{
				EntityPlayer player = (EntityPlayer) event.target;
				Item heldItem = player.getHeldItem().getItem();
				
				if (heldItem instanceof ItemTeigu || heldItem instanceof ItemTeiguArmor || heldItem instanceof ItemTeiguFood || heldItem instanceof ItemTeiguSword)
				event.entityPlayer.destroyCurrentEquippedItem();
			}
		}
			
			
		//Demons extract wand
		if (event.entityPlayer.getHeldItem().getItem() instanceof ItemDemonsExtractWand) {
			
			if (event.target instanceof EntityLivingBase && event.entityPlayer.getHeldItem().getTagCompound() != null && event.entityPlayer.getHeldItem().getTagCompound().getInteger("id") == 3) {
				EntityExtendedProperties.get((EntityLivingBase) event.target).setFrozen(true);
				if(event.target instanceof EntityLiving)
				{
					event.target.getDataWatcher().updateObject(15, Byte.valueOf((byte)(1)));
				}
			}
		}
		//Perfector
		if (event.entityPlayer.getHeldItem().getItem() instanceof ItemPerfector) {
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
		if(event.entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.entity; 
			boolean hasGC = false;
			boolean hasMastema = false;
			
			AttributeModifier modify = new AttributeModifier(UUID.fromString("92AEAA56-375B-4498-935B-2F7F58070635"), "Test", 2, 2);
			AttributeModifier modify2 = new AttributeModifier(UUID.fromString("45AEAA45-455B-6798-585B-4F5F58043519"), "Test2", 2, 2);
				if(((player.inventory.armorInventory[0] != null && player.inventory.armorInventory[0].getItem() instanceof ItemgcArmor) && (player.inventory.armorInventory[1] != null && player.inventory.armorInventory[1].getItem() instanceof ItemgcArmor)&&(player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof ItemgcArmor)&&(player.inventory.armorInventory[3] != null && player.inventory.armorInventory[3].getItem() instanceof ItemgcArmor)))
				{
					EntityExtendedProperties.get(player).setFly(true);
					if(!player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).hasModifier(modify))
					{
						player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).applyModifier(modify);
					}
					
					if(!player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).hasModifier(modify2))
					{
						player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).applyModifier(modify2);
					}
					
					
					hasGC = true;
				}
				else
				{
					
					player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.movementSpeed).removeModifier(modify);
					player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.attackDamage).removeModifier(modify2);
					
				}
				if(player.inventory.armorInventory[2] != null && player.inventory.armorInventory[2].getItem() instanceof ItemMastema)
				{
					EntityExtendedProperties.get(player).setFly(true);
					hasMastema = true;
				}
				if(!(hasGC || hasMastema))
				{
					EntityExtendedProperties.get(player).setFly(false);
				}
				
				if (!EntityExtendedProperties.get(player).shouldFly() && !player.capabilities.isCreativeMode)
				{
					player.capabilities.allowFlying = false;
					player.capabilities.isFlying = false;
			    }
				else
				{
					player.capabilities.allowFlying = true;
				}
		}
	}
}