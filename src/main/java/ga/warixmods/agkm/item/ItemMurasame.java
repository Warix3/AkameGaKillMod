package ga.warixmods.agkm.item;

import ga.warixmods.agkm.potion.PotionEffect2;
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

public class ItemMurasame extends ItemSword {

	public ItemMurasame(ToolMaterial material) {
		super(material);
		// TODO Auto-generated constructor stub
		
		
	}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		if (!stack.hasTagCompound()) {
			NBTTagCompound nbt = new NBTTagCompound();
			stack.setTagCompound(nbt);
			nbt.setString("Type", "Teigu");
		}
		}
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		
			if(entity instanceof EntityLivingBase)
			{
		((EntityLivingBase) entity).addPotionEffect(new PotionEffect2(19, 2000,2000));
		
		 if(((EntityLivingBase) entity).getHealth() <= 2.0F)
         {
         	entity.attackEntityFrom(DamageSource.generic, 1.0F);
         
		}}
		 
        return false;
    }
	@Override
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
		
        stack.damageItem(1, attacker);
        return true;
    }
	 @SideOnly(Side.CLIENT)
	    public boolean isFull3D()
	    {
	        return true;
	    }
}
