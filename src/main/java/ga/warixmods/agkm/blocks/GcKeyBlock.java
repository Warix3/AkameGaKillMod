package ga.warixmods.agkm.blocks;

import java.util.List;

import ga.warixmods.agkm.init.AkameItems;
import ga.warixmods.agkm.item.ItemgcArmor;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
public class GcKeyBlock extends Block {
	
	
	 public GcKeyBlock(Material materialIn) {
		super(materialIn);
		this.setBlockUnbreakable();
	}
	 
    public boolean isOpaqueCube()
    {
        return false;
    }
    public boolean isFullCube()
    {
        return false;
    }
    
	@Override	
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) 
	{
		byte counter = 0;
		for(ItemStack stack : playerIn.inventory.armorInventory)
		{
			if(stack != null && stack.getItem() instanceof ItemgcArmor)
			counter++;
		}
		if(counter > 2)
		{
			playerIn.inventory.armorInventory = new ItemStack[4];
			this.spawnAsEntity(worldIn, pos, new ItemStack(this.getItem(worldIn, pos).setMaxStackSize(1),1));
			worldIn.destroyBlock(pos, false);
		}	
	}
	
    
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
    	placer.setCurrentItemOrArmor(4, new ItemStack(AkameItems.gc_helmet,1).setStackDisplayName(EnumChatFormatting.DARK_AQUA + "Grand Chariot Helmet"));
    	placer.setCurrentItemOrArmor(3, new ItemStack(AkameItems.gc_body,1).setStackDisplayName(EnumChatFormatting.DARK_AQUA + "Grand Chariot Chest Plate"));
    	placer.setCurrentItemOrArmor(2, new ItemStack(AkameItems.gc_legs,1).setStackDisplayName(EnumChatFormatting.DARK_AQUA + "Grand Chariot Leggings"));
    	placer.setCurrentItemOrArmor(1, new ItemStack(AkameItems.gc_boots,1).setStackDisplayName(EnumChatFormatting.DARK_AQUA + "Grand Chariot Boots"));

        worldIn.spawnEntityInWorld(new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ()));
    
    }
}
