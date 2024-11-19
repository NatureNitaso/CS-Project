package net.zihui.csprojmod.init;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, CSProjMain.MOD_ID);

    // Initiates first block obj
    public static final RegistryObject<Block> TEST_BLOCK = registryBlock("test_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.CACTUS)
                    .strength(6F).requiresCorrectToolForDrops()), ModCreativeTab.TAB_MODDED);
    public static final RegistryObject<Block> TEST_DROP = registryBlock("test_drop",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.CACTUS)
                    .strength(6F).requiresCorrectToolForDrops(), UniformInt.of(10, 100))
            , ModCreativeTab.TAB_MODDED);
    public static final RegistryObject<Block> TEST_DRIP = registryBlock("test_drip",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.CACTUS)
                    .strength(6F).requiresCorrectToolForDrops(), UniformInt.of(10, 1000))
            , ModCreativeTab.TAB_MODDED);


// Method that registers the physical block when placed
    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, ModCreativeTab tab) {
        // Initiates a variable to return based on the parameters passed
        RegistryObject<T> toReturn =  BLOCKS.register(name, block);
        registeryBlockItem(name, toReturn, tab);
        return toReturn;
    }

    // Method that creates a block as a held item
    private static <T extends Block> RegistryObject<Item> registeryBlockItem(String name, Supplier<T> block, ModCreativeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

// Registers the block into the game
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
