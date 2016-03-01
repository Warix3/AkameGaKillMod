package ga.warixmods.agkm.potion;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MurasameEffect extends PotionEffect{
	
	public MurasameEffect(int id, int effectDuration) {
		super(id, effectDuration);
	}
	public MurasameEffect(int id, int effectDuration, int effectAmplifier) {
		super(id, effectDuration,effectAmplifier);
	}
	public MurasameEffect(int id, int effectDuration, int effectAmplifier, boolean ambient, boolean showParticles){
		super(id, effectDuration,effectAmplifier,ambient,showParticles);
    }

	@Override
	public boolean onUpdate(EntityLivingBase entityIn)
	    {
	        entityIn.attackEntityFrom(DamageSource.magic, 5.0F);
	        if(entityIn.isEntityAlive())
	        return true;
	        return false;
	    }
}