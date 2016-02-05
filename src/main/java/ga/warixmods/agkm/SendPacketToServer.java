package ga.warixmods.agkm;

import ga.warixmods.agkm.events.extendedproperties.EntityExtendedProperties;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SendPacketToServer implements IMessage {

	private String text;
	private int num,recieved,id = 0;
	private NBTTagCompound nbt;
	String state;
	public SendPacketToServer() {}
	
	public SendPacketToServer(String text)
	{
		this.text = text;
		this.recieved = 0;
	}
	
	public SendPacketToServer(int num)
	{
		this.num = num;
		this.recieved = 1;
	}
	


	@Override
	public void fromBytes(ByteBuf buf) {
		switch(this.recieved)
		{
	    case 0: 
	    	
		this.text =	ByteBufUtils.readUTF8String(buf);
		break;
	    case 1: 
	    	
		this.num = ByteBufUtils.readVarInt(buf, 5);
	    break;
	    case 2:
	    
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		switch(this.recieved)
		{
	    case 0: 
	    	
			ByteBufUtils.writeUTF8String(buf, this.text);
		break;
	    case 1: 
	    	
			ByteBufUtils.writeVarInt(buf,this.num, 5);
	    break;
	    case 2:
	    	
		}
	}
	public static class Handler implements IMessageHandler<SendPacketToServer, IMessage>{

		@Override
		public IMessage onMessage(final SendPacketToServer message, final MessageContext ctx) 
		{ 
			IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj;
			
			
	        mainThread.addScheduledTask(new Runnable() 
	        { 
	      @Override 
	      public void run() 
	        { 
	        	
	        	switch(message.recieved)
	        	{
	        	
	        	case 0:
	        	String text = message.text;
	        	int num2 = Integer.parseInt(text.substring(4));
	        	int num = message.num;
	        	
	        	String idS = text.substring(3, 4);
	        	int idI = Integer.parseInt(idS);
	        	
	        	text = text.substring(4);
	        		switch(idI)
	        		{
	        		case 0: 
	        			
	        			ctx.getServerHandler().playerEntity.getHeldItem().getTagCompound().setInteger("id",num2);
	        			break;
	        		case 1: 
	        			
	        			ctx.getServerHandler().playerEntity.getHeldItem().getTagCompound().setInteger("id", num2);
	        			break;
	        		case 2: 
	        			
	        			ctx.getServerHandler().playerEntity.getHeldItem().getTagCompound().setInteger("idU",num2);
	        			break;
	        		case 3: 
	        			int[] ids = ctx.getServerHandler().playerEntity.getHeldItem().getTagCompound().getIntArray("id");
	        			ids[num2] = 0;
	        			ctx.getServerHandler().playerEntity.getHeldItem().getTagCompound().setIntArray("id", ids);
	        			break;
	        		
	        		}	
	        		break;
	        	case 1:
	        		
	        		
	        		
	        		break;
	        	case 2:
	        		
	        		
	        		break;
	        	}
	        }});
			
				
			return null;
		}

	

		
	}
	}
	

