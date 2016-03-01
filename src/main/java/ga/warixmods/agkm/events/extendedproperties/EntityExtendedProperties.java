package ga.warixmods.agkm.events.extendedproperties;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.SendPacketToServer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class EntityExtendedProperties implements IExtendedEntityProperties
{
	protected EntityLivingBase theEntity;
	protected boolean isFrozen;
	protected boolean isServant;
	boolean shouldFly;
	public final static String IEEP_NAME = "AGKMEPEntity";

	public EntityExtendedProperties(){}
	
	public EntityExtendedProperties(EntityLivingBase entity)
	{
		this.theEntity = entity;
	}
	
	public static void register(EntityLivingBase entity)
	{
		entity.registerExtendedProperties(IEEP_NAME, new EntityExtendedProperties(entity));
	}

	public static EntityExtendedProperties get(EntityLivingBase entity)
	{
		return (EntityExtendedProperties) entity.getExtendedProperties(IEEP_NAME);
	}

	@Override
	public void saveNBTData(NBTTagCompound nbt)
	{
		NBTTagCompound data = new NBTTagCompound();
		data.setBoolean("isFrozen", this.isFrozen());
		data.setBoolean("isServant", this.isServant());
		data.setBoolean("shouldFly", this.shouldFly());
		nbt.setTag(IEEP_NAME, data);

	}

	

	@Override
	public void loadNBTData(NBTTagCompound nbt)
	{
		NBTTagCompound data = nbt.getCompoundTag(IEEP_NAME);
		this.isFrozen = data.getBoolean("isFrozen");
		this.isServant = data.getBoolean("isServant");
		this.shouldFly = data.getBoolean("shouldFly");
	}

	@Override
	public void init(Entity entity, World world)
	{}
	public boolean shouldFly()
	{
		return this.shouldFly;
	}
	public void setFly(boolean state)
	{
		this.shouldFly = state;
	}
	
	public boolean isFrozen()
	{
		return this.isFrozen;
	}
	
	public void setFrozen(boolean state)
	{
		this.isFrozen = state;
		
	}
	public boolean isServant()
	{
		return this.isServant;
	}

	public void setServant(boolean state)
	{
		this.isServant = state;
		
	}
}