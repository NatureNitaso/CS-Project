package net.zihui.csprojmod;

// imports up here //
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.zihui.csprojmod.init.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(CSProjMain.MOD_ID)
public class CSProjMain {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "csprojmod";

    public CSProjMain() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);



        // Calls to ModItems to register the items within there
        ModItems.ITEMS.register(modEventBus);
        // Calls to ModBlocks to register the blocks made there



        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
}