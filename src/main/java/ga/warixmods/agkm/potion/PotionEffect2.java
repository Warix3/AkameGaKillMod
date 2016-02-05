package ga.warixmods.agkm.potion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class PotionEffect2 extends PotionEffect{





	public PotionEffect2(int id, int effectDuration) {
		super(id, effectDuration);
		// TODO Auto-generated constructor stub
	}
	public PotionEffect2(int id, int effectDuration, int effectAmplifier) {
		super(id, effectDuration,effectAmplifier);
		// TODO Auto-generated constructor stub
	}
	public PotionEffect2(int id, int effectDuration, int effectAmplifier, boolean ambient, boolean showParticles)
    {
		super(id, effectDuration,effectAmplifier,ambient,showParticles);
    }
	

	    /** ID value of the potion this effect matches. */
	    private int potionID = 19;
	    /** The duration of the potion effect */
	    private int duration = 20000;
	    /** The amplifier of the potion effect */
	    private int amplifier = 20000;

	    /** List of ItemStack that can cure the potion effect **/
	    @Override
	public boolean onUpdate(EntityLivingBase entityIn)
	    {
	    	
	    	if (this.duration > 0)
	        {
	            if (Potion.potionTypes[this.potionID].isReady(this.duration, this.amplifier))
	            {
	            
	                this.performEffect(entityIn);
	                entityIn.attackEntityFrom(DamageSource.magic, 2.0F);
	            }
	            --this.duration;
	        }
            if(entityIn.getHealth() <= 1.0F)
            {
            	entityIn.attackEntityFrom(DamageSource.generic, 1.0F);
            }
	        return this.duration > 0;
	    }
	    @Override
	public void performEffect(EntityLivingBase entityIn)
    {
	    	if (this.duration > 0)
	        {
            Potion.potionTypes[19].performEffect(entityIn, this.amplifier);
	        }
    }




}
