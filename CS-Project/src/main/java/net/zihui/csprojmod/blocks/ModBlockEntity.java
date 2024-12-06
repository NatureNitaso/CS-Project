package net.zihui.csprojmod.blocks;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zihui.csprojmod.CSProjMain;
import net.zihui.csprojmod.blocks.entity.SummonPedestalBlockEntity;

public class ModBlockEntity {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPEs =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CSProjMain.MOD_ID);

    public static final RegistryObject<BlockEntityType<SummonPedestalBlockEntity>>
            SUMMON_PEDESTAL_BLOCK_ENTITY = BLOCK_ENTITY_TYPEs.register("summon_pedestal_block_entity",
            () -> BlockEntityType.Builder.of(SummonPedestalBlockEntity:: new, ModBlocks.SUMMON_PEDESTAL.get())
                    .build(null));
}
