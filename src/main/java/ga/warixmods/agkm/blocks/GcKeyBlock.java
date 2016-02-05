package ga.warixmods.agkm.blocks;

import java.util.List;

import ga.warixmods.agkm.init.AkameItems;
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
	 public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
	public GcKeyBlock(Material materialIn) {
		super(materialIn);
		// TODO Auto-generated constructor stub
	}
	 
	ItemStack dirt1 = new ItemStack(Blocks.dirt,1);
	ItemStack dirt2 = new ItemStack(Blocks.dirt,1);
	ItemStack dirt3 = new ItemStack(Blocks.dirt,1);
	ItemStack dirt4 = new ItemStack(Blocks.dirt,1);
	ItemStack[] dirt = {dirt2,dirt3,dirt4};
    public boolean isOpaqueCube()
    {
        return false;
    }
	@Override	
	public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn) 
	{
		ItemStack test = new ItemStack(AkameItems.gc_helmet,1);
		ItemStack test2 = new ItemStack(AkameItems.gc_body,1);
		ItemStack test3 = new ItemStack(AkameItems.gc_legs,1);
		ItemStack test4 = new ItemStack(AkameItems.gc_boots,1);
		/* I needed to create separate dirt blocks because weird things happen, also setting air causes minecraft to crash thats why i use dirt */
	
	    ItemStack[] inv = playerIn.getInventory();
	    ItemStack[] inve = playerIn.inventory.mainInventory;
	    
	    String a = inv.toString();
		inv.toString();
		int counter = 0;
		
		
		
		for(ItemStack stack : inv)
		{
			if(stack != null)
			{
			if(stack.toString().contains("gc_helmet")  || stack.toString().contains("gc_body")  || stack.toString().contains("gc_legs")  || stack.toString().contains("gc_boots"))
			{
				
				counter++;
			}
			}
			
			
		}
		int counter2 = 1,counter3 = 0;
		for(ItemStack stack : inve)
		{
			if(stack != null)
			{
			if(stack.toString().contains("gc_helmet")  || stack.toString().contains("gc_body")  || stack.toString().contains("gc_legs")  || stack.toString().contains("gc_boots"))
			{
				
				counter++;
				
				
			inve[counter2 - 1] =  dirt1;
			playerIn.inventory.mainInventory[counter2 - 1] = null;
			
			
			
			}
			counter3++;
			}
			counter2++;
			
		}
		if(counter >= 4)
		{
		
		
		
		playerIn.setCurrentItemOrArmor(4, null);
		playerIn.setCurrentItemOrArmor(3, null);
		playerIn.setCurrentItemOrArmor(2, null);
		playerIn.setCurrentItemOrArmor(1, null);
		
		this.dropBlockAsItem(worldIn, pos, this.getDefaultState(), 1);
		this.breakBlock(worldIn, pos, this.getDefaultState());
		worldIn.removeTileEntity(pos);
		worldIn.destroyBlock(pos, false);
		}
		else
		{
			this.setBlockUnbreakable();
			
		}
	}
	
    public boolean isFullCube()
    {
        return false;
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {

        /* Tag */
    	if(!stack.hasTagCompound())
    	{
    		ItemStack armor = new ItemStack(AkameItems.gc_helmet,1);
    		placer.setCurrentItemOrArmor(4, armor);
    		
    		ItemStack armor2 = new ItemStack(AkameItems.gc_body,1);
    		placer.setCurrentItemOrArmor(3, armor2);
    		
    		ItemStack armor3 = new ItemStack(AkameItems.gc_legs,1);
    		placer.setCurrentItemOrArmor(2, armor3);
    		
    		ItemStack armor4 = new ItemStack(AkameItems.gc_boots,1);
    		placer.setCurrentItemOrArmor(1, armor4);
    	   
    		
    		
    		if(armor.getTagCompound() == null)
        	{
        		armor.setTagCompound(new NBTTagCompound());
        	}
        	NBTTagCompound nbt = new NBTTagCompound();
        	nbt.setInteger("HD", AkameItems.gc_helmet.getMaxDamage());
    		armor.getTagCompound().setTag("HUsage", nbt);
        	armor.setStackDisplayName(EnumChatFormatting.DARK_AQUA + "Grand Chariot Helmet");
    		
    		if(armor2.getTagCompound() == null)
        	{
        		armor2.setTagCompound(new NBTTagCompound());
        	}
        	NBTTagCompound nbt1 = new NBTTagCompound();
        	nbt1.setInteger("CD", AkameItems.gc_body.getMaxDamage());
        	armor2.setStackDisplayName(EnumChatFormatting.DARK_AQUA + "Grand Chariot Chest Plate");
        	
    		if(armor3.getTagCompound() == null)
        	{
        		armor3.setTagCompound(new NBTTagCompound());
        	}
        	NBTTagCompound nbt2 = new NBTTagCompound();
        	nbt2.setInteger("LD", AkameItems.gc_legs.getMaxDamage());
        	armor3.setStackDisplayName(EnumChatFormatting.DARK_AQUA + "Grand Chariot Leggings");
        	
    		if(armor4.getTagCompound() == null)
        	{
        		armor4.setTagCompound(new NBTTagCompound());
        	}
        	NBTTagCompound nbt3 = new NBTTagCompound();
    		nbt3.setInteger("BD", AkameItems.gc_boots.getMaxDamage());
    		armor4.setStackDisplayName(EnumChatFormatting.DARK_AQUA + "Grand Chariot Boots");
    		
    		
    		
    	 
    	}
    	else
    	{
    		
    	}
    	 /* Lightning */
    	 EntityLightningBolt lightning = new EntityLightningBolt(worldIn, pos.getX(), pos.getY(), pos.getZ());
         worldIn.spawnEntityInWorld(lightning);
    
    	
    	
    	/* Placing */
        EnumFacing enumfacing = EnumFacing.getHorizontal(MathHelper.floor_double((double)(placer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3).getOpposite();
        state = state.withProperty(FACING, enumfacing);
        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = this == worldIn.getBlockState(blockpos1).getBlock();
        boolean flag1 = this == worldIn.getBlockState(blockpos2).getBlock();
        boolean flag2 = this == worldIn.getBlockState(blockpos3).getBlock();
        boolean flag3 = this == worldIn.getBlockState(blockpos4).getBlock();

        if (!flag && !flag1 && !flag2 && !flag3)
        {
            worldIn.setBlockState(pos, state, 3);
        }
        else if (enumfacing.getAxis() == EnumFacing.Axis.X && (flag || flag1))
        {
            if (flag)
            {
                worldIn.setBlockState(blockpos1, state, 3);
            }
            else
            {
                worldIn.setBlockState(blockpos2, state, 3);
            }

            worldIn.setBlockState(pos, state, 3);
        }
        else if (enumfacing.getAxis() == EnumFacing.Axis.Z && (flag2 || flag3))
        {
            if (flag2)
            {
                worldIn.setBlockState(blockpos3, state, 3);
            }
            else
            {
                worldIn.setBlockState(blockpos4, state, 3);
            }

            worldIn.setBlockState(pos, state, 3);
        }

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityChest)
            {
                ((TileEntityChest)tileentity).setCustomName(stack.getDisplayName());
            }
        }
        
    }
    
    /* Adding information */
  
    	/* Collision */
    public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask, List list, Entity collidingEntity)
    {

        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;


        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }
    
    /* Placing data */
    /** 
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }
    
}
