package net.zihui.csprojmod.init;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.BarrierBlock;
import org.jetbrains.annotations.NotNull;

// Initiates a new Minecraft tab that store items from this mod
public class ModCreativeTab extends CreativeModeTab {

    public ModCreativeTab(int index, String label) {
        super(index, label);
    }



    // Sets the icon of the mod tab in the Creative menu as a Barrier block
    @Override
    public @NotNull ItemStack makeIcon() {
        return new ItemStack(Items.BARRIER);
    }



}
