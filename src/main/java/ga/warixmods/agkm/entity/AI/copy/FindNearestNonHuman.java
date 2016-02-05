package ga.warixmods.agkm.entity.AI.copy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import ga.warixmods.agkm.events.extendedproperties.EntityExtendedProperties;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.player.EntityPlayer;

public class FindNearestNonHuman extends EntityAITarget{
	 protected final Class targetClass;
	    private final int targetChance;
	    /** Instance of FindNearestNonHumanSorter. */
	    protected final FindNearestNonHuman.Sorter theNearestAttackableTargetSorter;
	    /**
	     * This filter is applied to the Entity search.  Only matching entities will be targetted.  (null -> no
	     * restrictions)
	     */
	    protected Predicate targetEntitySelector;
	    protected EntityLivingBase targetEntity;
	    private static final String __OBFID = "CL_00001620";

	    public FindNearestNonHuman(EntityCreature creature, Class classTarget, boolean checkSight)
	    {
	        this(creature, classTarget, checkSight, false);
	    }

	    public FindNearestNonHuman(EntityCreature creature, Class classTarget, boolean checkSight, boolean onlyNearby)
	    {
	        this(creature, classTarget, 10, checkSight, onlyNearby, (Predicate)null);
	    }

	    public FindNearestNonHuman(EntityCreature creature, Class classTarget, int chance, boolean checkSight, boolean onlyNearby, final Predicate targetSelector)
	    {
	        super(creature, checkSight, onlyNearby);
	        this.targetClass = classTarget;
	        this.targetChance = chance;
	        this.theNearestAttackableTargetSorter = new FindNearestNonHuman.Sorter(creature);
	        this.setMutexBits(1);
	        this.targetEntitySelector = new Predicate()
	        {
	            private static final String __OBFID = "CL_00001621";
	            public boolean isApplicable(EntityLivingBase entitylivingbaseIn)
	            {
	                if (targetSelector != null && !targetSelector.apply(entitylivingbaseIn) || EntityExtendedProperties.get(entitylivingbaseIn).isServant())
	                {
	                    return false;
	                }
	                else
	                {
	                    if (entitylivingbaseIn instanceof EntityPlayer)
	                    {
	                        double d0 = FindNearestNonHuman.this.getTargetDistance();

	                        if (entitylivingbaseIn.isSneaking())
	                        {
	                            d0 *= 0.800000011920929D;
	                        }

	                        if (entitylivingbaseIn.isInvisible())
	                        {
	                            float f = ((EntityPlayer)entitylivingbaseIn).getArmorVisibility();

	                            if (f < 0.1F)
	                            {
	                                f = 0.1F;
	                            }

	                            d0 *= (double)(0.7F * f);
	                        }

	                        if ((double)entitylivingbaseIn.getDistanceToEntity(FindNearestNonHuman.this.taskOwner) > d0)
	                        {
	                            return false;
	                        }
	                    }

	                    return FindNearestNonHuman.this.isSuitableTarget(entitylivingbaseIn, false);
	                }
	            }
	            public boolean apply(Object p_apply_1_)
	            {
	                return this.isApplicable((EntityLivingBase)p_apply_1_);
	            }
	        };
	    }

	   

		/**
	     * Returns whether the EntityAIBase should begin execution.
	     */
	    public boolean shouldExecute()
	    {
	        if (this.targetChance > 0 && this.taskOwner.getRNG().nextInt(this.targetChance) != 0)
	        {
	            return false;
	        }
	        else
	        {
	            double d0 = this.getTargetDistance();
	            List list = this.taskOwner.worldObj.getEntitiesWithinAABB(this.targetClass, this.taskOwner.getEntityBoundingBox().expand(d0, 4.0D, d0), Predicates.and(this.targetEntitySelector, targetEntitySelector));
	            Collections.sort(list, this.theNearestAttackableTargetSorter);

	            if (list.isEmpty() )
	            {
	                return false;
	            }
	            else
	            {
	                this.targetEntity = (EntityLivingBase)list.get(0);
	                return true;
	            }
	        }
	    }

	    /**
	     * Execute a one shot task or start executing a continuous task
	     */
	    public void startExecuting()
	    {
	    	
	        this.taskOwner.setAttackTarget(this.targetEntity);
	        super.startExecuting();
	    }

	    public static class Sorter implements Comparator
	        {
	            private final Entity theEntity;
	            private static final String __OBFID = "CL_00001622";

	            public Sorter(Entity theEntityIn)
	            {
	                this.theEntity = theEntityIn;
	            }

	            public int compare(Entity p_compare_1_, Entity p_compare_2_)
	            {
	                double d0 = this.theEntity.getDistanceSqToEntity(p_compare_1_);
	                double d1 = this.theEntity.getDistanceSqToEntity(p_compare_2_);
	                return d0 < d1 ? -1 : (d0 > d1 ? 1 : 0);
	            }

	            public int compare(Object p_compare_1_, Object p_compare_2_)
	            {
	                return this.compare((Entity)p_compare_1_, (Entity)p_compare_2_);
	            }
	        }
}
