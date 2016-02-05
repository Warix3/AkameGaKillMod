package ga.warixmods.agkm.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMastemaFeather extends EntityThrowable{
	public EntityMastemaFeather(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		// TODO Auto-generated constructor stub
	}
	public EntityMastemaFeather(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	   public EntityMastemaFeather(World worldIn, double x, double y, double p_i1778_6_)
	    {
	        super(worldIn,x,y,p_i1778_6_);
	    }
	@Override
	protected void onImpact(MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
        if (p_70184_1_.entityHit != null)
        {
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 20);
        }

        for (int i = 0; i < 8; ++i) 
        {
            this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
	}

}
