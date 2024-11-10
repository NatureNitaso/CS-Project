package net.zihui.csprojmod;

// imports up here //
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.zihui.csprojmod.init.ItemsInit;
import net.zihui.csprojmod.init.ModCreativeTab;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(CSProjMain.MOD_ID)
public class CSProjMain {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "csprojmod";
    public static final ModCreativeTab instance = new ModCreativeTab(CreativeModeTab.TABS.length, "csprojmod");

    public CSProjMain() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::setup);



        // Calls to ItemsInit to register the items within there
        ItemsInit.ITEMS.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
}