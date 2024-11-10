package net.zihui.csprojmod.init;


// This is where we register all of our items into the game

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;

public class ItemsInit {
    // Sets up register for deferred register method
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CSProjMain.MOD_ID);

    // Register first item
    public static final RegistryObject<Item> TESTOBJ = ITEMS.register("testobj",
            () -> new Item(new Item.Properties()));

    // Registers all items in the Deferred Register to the Forge directory
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
