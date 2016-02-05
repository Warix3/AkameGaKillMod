package ga.warixmods.agkm;

import ga.warixmods.agkm.events.extendedproperties.EntityExtendedProperties;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SendPacketToClient implements IMessage{

	private String state;
	private int id;
	private int recieved;
	public SendPacketToClient() {}
	public SendPacketToClient(int id,String state) {
		this.state = state;
		this.id = id;
		this.recieved = 2;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		
		this.state = ByteBufUtils.readUTF8String(buf);
	    this.id = ByteBufUtils.readVarInt(buf, 5);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		ByteBufUtils.writeUTF8String(buf, this.state);
    	ByteBufUtils.writeVarInt(buf, this.id, 5);
	}
	
	public static class Handler implements IMessageHandler<SendPacketToClient, IMessage>{

		@Override
		public IMessage onMessage(final SendPacketToClient message, MessageContext ctx) {
			
			IThreadListener mainThreadClient = Minecraft.getMinecraft();
			
			
			
			mainThreadClient.addScheduledTask(new Runnable() 
	        { 
				
				
			      @Override 
			      public void run() 
			        { 
			    	  boolean state;
			    	  if(message.state.equals("true"))
			    			  state = true;
			    	  else
			    		  	  state = false;
			    	  
			    	  EntityExtendedProperties.get((EntityLivingBase) Minecraft.getMinecraft().theWorld.getEntityByID(message.id)).setFrozen(state);  ;
	                }
	        });
			return null;
		}

	}
}
