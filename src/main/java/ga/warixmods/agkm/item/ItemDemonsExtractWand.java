package ga.warixmods.agkm.item;

import java.util.Random;

import ga.warixmods.agkm.AkameGaKill;
import ga.warixmods.agkm.entity.projectile.EntityIceShards;
import ga.warixmods.agkm.inventory.GuiWand;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDemonsExtractWand extends ItemTeigu {

	IBlockState ice = Blocks.ice.getDefaultState();
	IBlockState packed_ice = Blocks.packed_ice.getDefaultState();
	
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {return true;}
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
	{
		if(!stack.hasTagCompound())
		{
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("id", 0);
		stack.setTagCompound(nbt);
		}
	}
	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) 
	{
		if (!playerIn.isSneaking()) {
			
        if(itemStackIn.getTagCompound().getInteger("id") == 0)
        	iceShards(itemStackIn, worldIn, playerIn);
        
		}
		else 
			playerIn.openGui(AkameGaKill.instance, GuiWand.GUI_ID, worldIn, 0, 0, 0);
		return itemStackIn;
	}
	
	public boolean onItemUse(ItemStack itemStackIn, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if (!playerIn.isSneaking()) 
		{
			switch (itemStackIn.getTagCompound().getInteger("id")) 
			{
				case 1:
					buildIce(itemStackIn, playerIn, worldIn, pos, side, hitZ, hitZ, hitZ);
					break;
				case 2:
					freezeWater(itemStackIn, playerIn, worldIn);
			}
		} 
		else 
			playerIn.openGui(AkameGaKill.instance, GuiWand.GUI_ID, worldIn, 0, 0, 0);
		return false;
	}
	
	//on item right click
	public void iceShards(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) 
	{
		worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		if (!worldIn.isRemote) 
			worldIn.spawnEntityInWorld(new EntityIceShards(worldIn, playerIn));
	}
	
	//on item right click on block
	public void freezeWater(ItemStack stack, EntityPlayer playerIn, World worldIn) 
	{
		boolean isEmpty = true;
		MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, isEmpty);
		if (movingobjectposition != null) {
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
				BlockPos pos = movingobjectposition.getBlockPos();

				int y = pos.getY();

				BlockPos northeast = new BlockPos(pos.getX() + 1, y, pos.getZ() - 1);
				BlockPos northwest = new BlockPos(pos.getX() - 1, y, pos.getZ() - 1);
				BlockPos southwest = new BlockPos(pos.getX() - 1, y, pos.getZ() + 1);
				BlockPos southeast = new BlockPos(pos.getX() + 1, y, pos.getZ() + 1);
				if (isWater(pos, worldIn)) {
					worldIn.setBlockState(pos, getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(pos);
					worldIn.notifyNeighborsOfStateChange(pos, Blocks.ice);
				}
				if (isWater(pos.north(), worldIn)) {
					worldIn.setBlockState(pos.north(), getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(pos.north());
					worldIn.notifyNeighborsOfStateChange(pos.north(), Blocks.ice);
				}
				if (isWater(pos.north(2), worldIn)) {
					worldIn.setBlockState(pos.north(2), getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(pos.north(2));
					worldIn.notifyNeighborsOfStateChange(pos.north(2), Blocks.ice);
				}
				if (isWater(pos.west(), worldIn)) {
					worldIn.setBlockState(pos.west(), getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(pos.west());
					worldIn.notifyNeighborsOfStateChange(pos.west(), Blocks.ice);
				}
				if (isWater(pos.west(2), worldIn)) {
					worldIn.setBlockState(pos.west(2), getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(pos.west(2));
					worldIn.notifyNeighborsOfStateChange(pos.west(2), Blocks.ice);
				}
				if (isWater(pos.south(), worldIn)) {
					worldIn.setBlockState(pos.south(), getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(pos.south());
					worldIn.notifyNeighborsOfStateChange(pos.south(), Blocks.ice);
				}
				if (isWater(pos.south(2), worldIn)) {
					worldIn.setBlockState(pos.south(2), getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(pos.south(2));
					worldIn.notifyNeighborsOfStateChange(pos.south(2), Blocks.ice);
				}
				if (isWater(pos.east(), worldIn)) {
					worldIn.setBlockState(pos.east(), getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(pos.east());
					worldIn.notifyNeighborsOfStateChange(pos.east(), Blocks.ice);
				}
				if (isWater(pos.east(2), worldIn)) {
					worldIn.setBlockState(pos.east(2), getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(pos.east(2));
					worldIn.notifyNeighborsOfStateChange(pos.east(2), Blocks.ice);
				}
				if (isWater(northeast, worldIn)) {
					worldIn.setBlockState(northeast, getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(northeast);
					worldIn.notifyNeighborsOfStateChange(northeast, Blocks.ice);
				}
				if (isWater(northwest, worldIn)) {
					worldIn.setBlockState(northwest, getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(northwest);
					worldIn.notifyNeighborsOfStateChange(northwest, Blocks.ice);
				}
				if (isWater(southwest, worldIn)) {
					worldIn.setBlockState(southwest, getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(southwest);
					worldIn.notifyNeighborsOfStateChange(southwest, Blocks.ice);
				}
				if (isWater(southeast, worldIn)) {
					worldIn.setBlockState(southeast, getRandomState(ice, packed_ice));
					worldIn.markBlockForUpdate(southeast);
					worldIn.notifyNeighborsOfStateChange(southeast, Blocks.ice);
				}

			}
		}
	}

	public void buildIce(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) 
	{
		if (!worldIn.isRemote) {
			worldIn.setBlockState(pos.up(), getRandomState(ice, packed_ice));
			worldIn.setBlockState(pos.down(), getRandomState(ice, packed_ice));
			worldIn.setBlockState(pos.east(), getRandomState(ice, packed_ice));
			worldIn.setBlockState(pos.west(), getRandomState(ice, packed_ice));
			worldIn.setBlockState(pos.north(), getRandomState(ice, packed_ice));
			worldIn.setBlockState(pos.south(), getRandomState(ice, packed_ice));
		}
		worldIn.markBlockForUpdate(pos.up());
		worldIn.markBlockForUpdate(pos.down());
		worldIn.markBlockForUpdate(pos.east());
		worldIn.markBlockForUpdate(pos.west());
		worldIn.markBlockForUpdate(pos.north());
		worldIn.markBlockForUpdate(pos.south());
	}
	
	private IBlockState getRandomState(IBlockState state1, IBlockState state2) 
	{
		if (new Random().nextInt(100) > 50) 
			return state1;
			return state2;
	}

	private boolean isWater(BlockPos pos, World worldIn) 
	{
		if (worldIn.getBlockState(pos).getBlock().getMaterial() == Material.water && ((Integer) worldIn.getBlockState(pos).getValue(BlockLiquid.LEVEL)).intValue() == 0) 
			return true;
			return false;
	}



}