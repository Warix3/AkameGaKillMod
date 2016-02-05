package ga.warixmods.agkm.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityIceShards extends EntityThrowableIce{




	public EntityIceShards(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	public EntityIceShards(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
    }
    public EntityIceShards(World worldIn, double x, double y, double p_i1778_6_)
    {
        super(worldIn,x,y,p_i1778_6_);
    }

	public int randomTilt;


	@Override
    public void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null)
        {
            byte b0 = 5;

            if (p_70184_1_.entityHit instanceof EntityBlaze)
            {
                b0 = 20;
            }

            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), b0);
        }

        for (int i = 0; i < 8; ++i) 
        {
            this.worldObj.spawnParticle(EnumParticleTypes.CLOUD, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
	public int getRandomTilt()
	{
		return randomTilt;
	}
	
	public void setRandomTilt(int angle)
	{
		randomTilt = angle;
	}
}
