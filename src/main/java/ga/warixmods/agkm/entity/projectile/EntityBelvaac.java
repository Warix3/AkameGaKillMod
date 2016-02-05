package ga.warixmods.agkm.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBelvaac extends EntityThrowableBelvaac{

	public EntityBelvaac(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	 public EntityBelvaac(World worldIn, EntityLivingBase throwerIn)
	    {
	        super(worldIn,throwerIn);
	    
	    }
	 public EntityBelvaac(World worldIn, double x, double y, double z)
	    {
	        super(worldIn,x,y,z);

	    }

	
}
