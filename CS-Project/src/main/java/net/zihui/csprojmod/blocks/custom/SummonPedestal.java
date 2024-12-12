package net.zihui.csprojmod.blocks.custom;

import com.sun.net.httpserver.Authenticator;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.SummonCommand;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.client.event.CustomizeGuiOverlayEvent;
import net.minecraftforge.event.level.NoteBlockEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.items.ItemStackHandler;
import net.zihui.csprojmod.blocks.entity.SummonPedestalBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;

public class SummonPedestal extends BaseEntityBlock {
    public Items summons;
    public ItemStack stored;

    public SummonPedestal(Block.Properties properties) {
        super(properties);
        stored = ItemStack.EMPTY;
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand); // grabs item that's in the players hand upon interaction
        int index = held.getCount(); // Gets the # of items held in player's hand

        // Checks to see if this behavior is on the client or server side
        if (!level.isClientSide() && stored == ItemStack.EMPTY) {
            if (held.getItem() == Items.HEART_OF_THE_SEA) {
                index -= 1;
                player.getItemInHand(hand).setCount(index);
                setStoredItem(held, player, hand);
                return InteractionResult.SUCCESS;
            } else {
                index -= 1;
                player.getItemInHand(hand).setCount(index);
                setStoredItem(held, player, hand);
                return InteractionResult.SUCCESS;
            }
        } else {
            returnStoredItem(level, pos, state);
            return InteractionResult.SUCCESS;
        }
    }

    // Method to storeItem
    public void setStoredItem(ItemStack item, Player player, InteractionHand hand) {
        int index = player.getItemInHand(hand).getCount();
        player.getItemInHand(hand).setCount(index);
        stored = item;
    }

    // Method that drops the item at the block pos in the world
    public void returnStoredItem(Level level, BlockPos pos, BlockState state) {
        if (!level.isClientSide) {
            ItemEntity storedItemEntity = new ItemEntity(level, pos.getX(), pos.getY(),
                    pos.getZ(), stored); // Makes new item entity based on what is stored within the obj
            level.addFreshEntity(storedItemEntity); // Drops the entity of the item stored within the obj
            stored = ItemStack.EMPTY; // Set stored obj variable back to empty
        }
    }

    // Method for itemStored

//    public ItemStack manageStoredItem(BlockPos pos, Level level, BlockState state, Player player, InteractionHand hand) {
//        boolean isStoredEmpty = (stored == ItemStack.EMPTY); // Checks to see if stored == empty
//        boolean isHandEmpty = (player.getItemInHand(hand) != ItemStack.EMPTY); // Checks to see if hand is empty
//    }



    /* BLOCK ENTITY */

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return null;
    }
}


    // Block Entity BELOW
//    @Override
//    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return null;
//    }
