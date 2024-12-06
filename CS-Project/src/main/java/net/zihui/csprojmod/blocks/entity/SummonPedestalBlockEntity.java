package net.zihui.csprojmod.blocks.entity;

import ca.weblite.objc.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.items.ItemStackHandler;
import net.zihui.csprojmod.blocks.ModBlockEntity;
import org.jetbrains.annotations.NotNull;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.Objects;

public class SummonPedestalBlockEntity extends BlockEntity {
    private ItemStack storedItem = ItemStack.EMPTY; // This determines the item that is store by this block

    public SummonPedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntity.SUMMON_PEDESTAL_BLOCK_ENTITY.get(), pos, state);
    }

    // This sets the stored item within the block to whatever parameter is passed
    public void setStoredItem(ItemStack item) {
        this.storedItem = item;
        this.setChanged();
    }

    // Gets stored item
    public ItemStack getStoredItem() {
        return storedItem;
    }

    // Tells about player's interaction with block
    public InteractionResult use(Player player, InteractionHand hand) {

        // Checks to see if conditions are met
        if (!player.level.isClientSide) {
            if (storedItem.isEmpty()) {
                // Store the item if it's empty
                ItemStack itemInHand = player.getItemInHand(hand);
                if (!itemInHand.isEmpty()) {
                    setStoredItem(itemInHand.split(1));  // Store one item and remove it from the player's hand.
                    level.setBlock(player.getOnPos(), player.getBlockStateOn(), 1);
                    return InteractionResult.SUCCESS;
                }
            } else {
                // Return the stored item to the player
                player.getInventory().add(storedItem);
                setStoredItem(ItemStack.EMPTY);
                player.hurt(DamageSource.DRY_OUT, 3);
                return InteractionResult.SUCCESS;
            }
    }

        return InteractionResult.SUCCESS;
    }

    // Saving the item to the block entity (Important to consistency)
    @Override
    public void saveAdditional(CompoundTag tag){
        super.saveAdditional(tag);
        if (!storedItem.isEmpty()) {
            tag.put("StoredItem", storedItem.save(new CompoundTag()));
        }
    }

    // Loads Item when block is loaded
    public void load(CompoundTag tag) {
        super.load(tag);
        if (tag.contains("StoredItem")) {
            storedItem = ItemStack.of(tag.getCompound("StoredItem"));
        }
    }
}
