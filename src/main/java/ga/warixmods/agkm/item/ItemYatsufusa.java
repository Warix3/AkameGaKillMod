package ga.warixmods.agkm.item;

import ga.warixmods.agkm.AkameGaKill;


import ga.warixmods.agkm.events.extendedproperties.EntityExtendedProperties;
import ga.warixmods.agkm.init.AkameItems;
import ga.warixmods.agkm.inventory.GuiYatsufusa;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class ItemYatsufusa extends ItemTeiguSword

{
	public ItemYatsufusa(ToolMaterial material) {
		super(material);
		
		// TODO Auto-generated constructor stub
		
	}
	
	 @SideOnly(Side.CLIENT)
	    public boolean isFull3D()
	    {
	        return true;
	    }

	@Override
    public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
	   if(!stack.hasTagCompound())
	   {
		   NBTTagCompound nbt = new NBTTagCompound();
		   stack.setTagCompound(nbt);
		   int[] id = new int[7];
		   nbt.setIntArray("id", id);
		   nbt.setInteger("idU",0);
	   }	
    }
	@Override
	 public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		int spawnID = 0;
		if(!worldIn.isRemote)
        {
    	  if(stack.getTagCompound().hasKey("idU") && stack.getTagCompound().getInteger("idU") != 0);
    	  {
    		  spawnID = stack.getTagCompound().getInteger("idU");
    		  if(EntityList.createEntityByID(spawnID, worldIn) instanceof EntityLiving && spawnID > 0)
    		  {	  
    			EntityCreature entity = (EntityCreature) EntityList.createEntityByID(spawnID, worldIn);
    			entity.setCustomNameTag(playerIn.getName() + "'s Servant!");
    			EntityExtendedProperties.get(entity).setServant(true);
    			entity.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
    			entity.tasks.taskEntries.clear();
    			entity.targetTasks.taskEntries.clear();
    			
    		  	worldIn.spawnEntityInWorld(entity);
    		  	stack.getTagCompound().setInteger("idU",0);
    			  
    		  }
    		  else if(EntityList.createEntityByID(spawnID, worldIn) instanceof EntitySlime)
    		  {
    			  EntityLiving entity = (EntityLiving) EntityList.createEntityByID(spawnID, worldIn);
    			  entity.setCustomNameTag("Slimes currently not in function");
    			  entity.setPosition(pos.getX(), pos.getY() + 1, pos.getZ());
    			  entity.tasks.taskEntries.clear();
    			  entity.targetTasks.taskEntries.clear();
        		  worldIn.spawnEntityInWorld(entity);
        		  stack.getTagCompound().setInteger("idU",0);
    		  }
    		  
    	  }
	
        }
		 return false;
    }
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
		if(playerIn.isSneaking())
		{
			playerIn.openGui(AkameGaKill.instance, GuiYatsufusa.GUI_ID, worldIn, 0, 0, 0);
		}
        return itemStackIn;
    }
}
