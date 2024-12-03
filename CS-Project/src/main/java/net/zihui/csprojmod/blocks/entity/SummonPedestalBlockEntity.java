package net.zihui.csprojmod.blocks.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.npc.InventoryCarrier;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jline.utils.Display;

import java.awt.*;

public class SummonPedestalBlockEntity extends BlockEntity implements InventoryCarrier {// Implement Item Holder (Item frame)
    public SummonPedestalBlockEntity(BlockEntityType<?> entityType, BlockPos pos, BlockState state) {
        super(entityType, pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Test Summon Pedestal");
    }

    @Override
    public SimpleContainer getInventory() {
        return null;
    }
}
