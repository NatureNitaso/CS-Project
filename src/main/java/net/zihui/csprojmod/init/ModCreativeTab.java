package net.zihui.csprojmod.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.BarrierBlock;
import org.jetbrains.annotations.NotNull;

public class ModCreativeTab extends CreativeModeTab {


    public ModCreativeTab(int index, String label) {
        super(index, label);
    }

    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(Items.BARRIER);
    }
}
