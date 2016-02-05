package ga.warixmods.agkm.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityThrowableIce extends EntityThrowable{

	public int ticksInGround;
	public EntityThrowableIce(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		// TODO Auto-generated constructor stub
	}
    public EntityThrowableIce(World worldIn)
    {
        super(worldIn);
        this.setSize(0.25F, 0.25F);
    }
    public EntityThrowableIce(World worldIn, double x, double y, double p_i1778_6_)
    {
        super(worldIn);
        this.ticksInGround = 0;
        this.setSize(0.25F, 0.25F);
        this.setPosition(x, y, p_i1778_6_);
    }
	@Override
	public void onImpact(MovingObjectPosition p_70184_1_) {
		// TODO Auto-generated method stub
		
	}
	@Override
    public void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy)
    {
        float f2 = MathHelper.sqrt_double(x * x + y * y + z * z);
        x /= (double)f2;

        z /= (double)f2;
        x += this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        
        z += this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        x *= (double)velocity;

        z *= (double)velocity;
        this.motionX = x;
        this.motionY = y;
        this.motionZ = z;
        float f3 = MathHelper.sqrt_double(x * x + z * z);
        this.prevRotationYaw = this.rotationYaw = (float)(Math.atan2(x, z) * 180.0D / Math.PI);

        this.ticksInGround = 0;
    }
	@Override
    public float getGravityVelocity()
    {
        return 0.001F;
    }

}
