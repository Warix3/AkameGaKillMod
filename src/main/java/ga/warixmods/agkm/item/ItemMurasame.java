package ga.warixmods.agkm.item;

import java.util.List;

import ga.warixmods.agkm.potion.MurasameEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMurasame extends ItemTeiguSword {

	public ItemMurasame(ToolMaterial material) {
		super(material);
		this.bFull3D = true;
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
			if(entity instanceof EntityLivingBase)
				((EntityLivingBase) entity).addPotionEffect(new MurasameEffect(19, 2000,2000));
            return false;
    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn,List toolTip,boolean advanced)
    {
    	toolTip.add("\u00A7c\u00A7oOne-Cut Killer: Murasame");
    	toolTip.add("\u00A74Murasame is a poisonous blade that can kill");   
    	toolTip.add("\u00A74a person with only one cut. Once the");
    	toolTip.add("\u00A74sword pierces skin, it injects a lethal poison");
    	toolTip.add("\u00A74into the victim, killing them within seconds");  
    	toolTip.add("\u00A74However, this ability only works on living,");
    	toolTip.add("\u00A74organic beings that have a heart, rendering it ");
    	toolTip.add("\u00A74ineffective against Mechanical Monsters.");
    }
}
