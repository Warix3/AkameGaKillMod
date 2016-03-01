package ga.warixmods.agkm;
import ga.warixmods.agkm.events.ForgeEvents;
import ga.warixmods.agkm.events.ForgeEventsClient;
import ga.warixmods.agkm.init.AkameBlocks;
import ga.warixmods.agkm.init.AkameEntities;
import ga.warixmods.agkm.init.AkameItems;
import ga.warixmods.agkm.proxy.ClientProxy;
import ga.warixmods.agkm.proxy.ServerProxy;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version=Reference.VERSION)
public class AkameGaKill {
	public static final AkameTab tabAkame= new AkameTab("tabAkame");
	public static SimpleNetworkWrapper network;
	public static SimpleNetworkWrapper networkClient;
    @Instance (value = Reference.MOD_ID)
    public static AkameGaKill instance;
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static ServerProxy proxy;
	public static ClientProxy clientProxy;
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		
		network = NetworkRegistry.INSTANCE.newSimpleChannel("AGKMServer");
		network.registerMessage(SendPacketToServer.Handler.class, SendPacketToServer.class, 0, Side.SERVER);
		
		networkClient = NetworkRegistry.INSTANCE.newSimpleChannel("AGKMClient");
		networkClient.registerMessage(SendPacketToClient.Handler.class, SendPacketToClient.class, 0, Side.CLIENT);
		
		AkameItems.init();
		AkameItems.register();
		
		AkameBlocks.init();
		AkameBlocks.register();
		

		AkameEntities.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, proxy);
		proxy.registerRenders();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
}






