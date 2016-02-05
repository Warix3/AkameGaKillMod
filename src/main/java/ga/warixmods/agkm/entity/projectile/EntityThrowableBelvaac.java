package ga.warixmods.agkm.entity.projectile;

import java.util.List;

import ga.warixmods.agkm.init.AkameItems;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityThrowableBelvaac extends EntityThrowable{
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private Block inTile;
    protected boolean inGround;
    public int throwableShake;
    /** The entity that threw this throwable item. */
    private EntityLivingBase thrower;
    private String throwerName;
    private int ticksInGround;
    private int ticksInAir;
    private static final String __OBFID = "CL_00001723";
	public EntityThrowableBelvaac(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	  public EntityThrowableBelvaac(World worldIn, EntityLivingBase throwerIn)
	    {
	        super(worldIn);
	        this.thrower = throwerIn;
	        this.setSize(0.25F, 0.25F);
	        this.setLocationAndAngles(throwerIn.posX, throwerIn.posY + (double)throwerIn.getEyeHeight(), throwerIn.posZ, throwerIn.rotationYaw, throwerIn.rotationPitch);
	        this.posX -= (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
	        this.posY -= 0.10000000149011612D;
	        this.posZ -= (double)(MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
	        this.setPosition(this.posX, this.posY, this.posZ);
	        float f = 0.4F;
	        this.motionX = (double)(-MathHelper.sin(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
	        this.motionZ = (double)(MathHelper.cos(this.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(this.rotationPitch / 180.0F * (float)Math.PI) * f);
	        this.motionY = (double)(-MathHelper.sin((this.rotationPitch + this.getInaccuracy()) / 180.0F * (float)Math.PI) * f);
	        this.setThrowableHeading(this.motionX, this.motionY, this.motionZ, this.getVelocity(), 1.0F);
	    }
	  
	  public EntityThrowableBelvaac(World worldIn, double x, double y, double z)
	    {
	        super(worldIn);
	        this.ticksInGround = 0;
	        this.setSize(0.25F, 0.25F);
	        this.setPosition(x, y, z);
	    }
	@Override
	protected void onImpact(MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
		
		boolean tr = true;
		Entity entity = p_70184_1_.entityHit;
	
		
		if(!this.worldObj.isRemote)
		{
		if(entity != null)	
		{
			if(entity instanceof EntityCreature || entity instanceof EntitySlime)
			{
				if(entity.isEntityAlive())
				{
			
			tr = false;
			ItemStack drop = new ItemStack(AkameItems.belvaac_part_1,1);
			this.entityDropItem(drop, 0);
			entity.attackEntityFrom(DamageSource.generic, 10);
			this.setDead();
			this.setCustomNameTag("Dead");
			
			}
			}
		}
		
		if(p_70184_1_.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && tr && !this.hasCustomName())
		{
			ItemStack drop = new ItemStack(AkameItems.belvaac_part_1,1);
			this.setCustomNameTag("Dead");
			this.entityDropItem(drop, 0);
			this.setDead();
		}
		
		
		}
	}
	 protected float getVelocity()
	    {
	        return 1.5F;
	    }

	    protected float getInaccuracy()
	    {
	        return 0.0F;
	    }
	    protected float getGravityVelocity()
	    {
	    	
	    
	    	if(this.getNBTTagCompound() != null)
	    	{
	    		if(this.getNBTTagCompound().hasKey("Special"))
		    	{
	    	if(this.getNBTTagCompound().getBoolean("Special"))
	    	{
	        return 0;
	    	}
	    	else
	    	{
	    		return 0.03F;
	    	}
	    	
	    	}
	    	else{
	    		return 0.03F;
	    	}
	    	
	    	}else
	    	{
	    		return 0.03F;
	    	}
	    	
	    }
	    
	   
	    @Override
	    public void onUpdate()
	    {
	        this.lastTickPosX = this.posX;
	        this.lastTickPosY = this.posY;
	        this.lastTickPosZ = this.posZ;
	        super.onUpdate();

	        if (this.throwableShake > 0)
	        {
	            --this.throwableShake;
	        }

	        if (this.inGround)
	        {
	            if (this.worldObj.getBlockState(new BlockPos(this.xTile, this.yTile, this.zTile)).getBlock() == this.inTile)
	            {
	                

	                return;
	            }

	            this.inGround = false;
	            this.motionX *= (double)(this.rand.nextFloat() * 0.2F);
	            this.motionY *= (double)(this.rand.nextFloat() * 0.2F);
	            this.motionZ *= (double)(this.rand.nextFloat() * 0.2F);
	            this.ticksInGround = 0;
	            this.ticksInAir = 0;
	        }
	        else
	        {
	            ++this.ticksInAir;
	        }

	        Vec3 vec3 = new Vec3(this.posX, this.posY, this.posZ);
	        Vec3 vec31 = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
	        MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31);
	        vec3 = new Vec3(this.posX, this.posY, this.posZ);
	        vec31 = new Vec3(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

	        if (movingobjectposition != null)
	        {
	            vec31 = new Vec3(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
	        }

	        if (!this.worldObj.isRemote)
	        {
	            Entity entity = null;
	            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
	            double d0 = 0.0D;
	            EntityLivingBase entitylivingbase = this.getThrower();

	            for (int j = 0; j < list.size(); ++j)
	            {
	                Entity entity1 = (Entity)list.get(j);

	                if (entity1.canBeCollidedWith() && (entity1 != entitylivingbase || this.ticksInAir >= 5))
	                {
	                    float f = 0.3F;
	                    AxisAlignedBB axisalignedbb = entity1.getEntityBoundingBox().expand((double)f, (double)f, (double)f);
	                    MovingObjectPosition movingobjectposition1 = axisalignedbb.calculateIntercept(vec3, vec31);

	                    if (movingobjectposition1 != null)
	                    {
	                        double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

	                        if (d1 < d0 || d0 == 0.0D)
	                        {
	                        	
	                            entity = entity1;
	                            d0 = d1;
	                        }
	                    }
	                }
	            }

	            if (entity != null)
	            {
	                movingobjectposition = new MovingObjectPosition(entity);
	            }
	        }

	        if (movingobjectposition != null)
	        {
	            if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK && this.worldObj.getBlockState(movingobjectposition.getBlockPos()).getBlock() == Blocks.portal)
	            {
	                this.inPortal = true;
	            }
	            else
	            {
	            	
	                this.onImpact(movingobjectposition);
	            }
	        }

	        this.posX += this.motionX;
	        this.posY += this.motionY;
	        this.posZ += this.motionZ;
	        float f1 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
	        this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

	        for (this.rotationPitch = (float)(Math.atan2(this.motionY, (double)f1) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
	        {
	            ;
	        }

	        while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
	        {
	            this.prevRotationPitch += 360.0F;
	        }

	        while (this.rotationYaw - this.prevRotationYaw < -180.0F)
	        {
	            this.prevRotationYaw -= 360.0F;
	        }

	        while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
	        {
	            this.prevRotationYaw += 360.0F;
	        }

	        this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
	        this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
	        float f2 = 0.99F;
	        float f3 = this.getGravityVelocity();

	        if (this.isInWater())
	        {
	            for (int i = 0; i < 4; ++i)
	            {
	                float f4 = 0.25F;
	                this.worldObj.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * (double)f4, this.posY - this.motionY * (double)f4, this.posZ - this.motionZ * (double)f4, this.motionX, this.motionY, this.motionZ, new int[0]);
	            }

	            f2 = 0.8F;
	        }

	        this.motionX *= (double)f2;
	        this.motionY *= (double)f2;
	        this.motionZ *= (double)f2;
	        this.motionY -= (double)f3;
	        this.setPosition(this.posX, this.posY, this.posZ);
	    }
	    
	    
	    
	    
}
