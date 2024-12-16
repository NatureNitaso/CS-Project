package net.zihui.csprojmod.blocks;

import net.minecraft.core.Registry;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.blocks.entity.SummonPedestalBlockEntity;
import org.checkerframework.checker.signature.qual.Identifier;

public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CSProjMain.MOD_ID);

    public static final RegistryObject<BlockEntityType<SummonPedestalBlockEntity>> SUMMON_PEDESTAL_BLOCK_ENTITY =
            BLOCK_ENTITY_TYPES.register("summon_pedestal_entity", () ->
                    BlockEntityType.Builder.of(SummonPedestalBlockEntity::new,
                            ModBlocks.SUMMON_PEDESTAL.get()).build(null));

    public static void register(IEventBus eventbus) {
        BLOCK_ENTITY_TYPES.register(eventbus);
    }


}
