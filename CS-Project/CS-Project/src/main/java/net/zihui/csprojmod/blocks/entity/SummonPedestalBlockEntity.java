package net.zihui.csprojmod.blocks.entity;

import ca.weblite.objc.Message;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.server.ServerMain;
import net.minecraftforge.items.ItemStackHandler;
import net.zihui.csprojmod.blocks.ModBlockEntity;
import net.zihui.csprojmod.blocks.custom.SummonPedestal;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.util.Objects;
import java.util.Properties;

public class SummonPedestalBlockEntity extends BlockEntity {

    private ItemStack storedItem = ItemStack.EMPTY;
    private Player p;

    public SummonPedestalBlockEntity(BlockPos pos, BlockState state){
        super(ModBlockEntity.SUMMON_PEDESTAL_BLOCK_ENTITY.get(), pos, state);
        System.out.println("Makes a Block Entity");
    }


    public static void tick(Level world, BlockPos pos, BlockState state, SummonPedestalBlockEntity be) {
        // This method runs every tick; you can use it to handle periodic logic
    }

    public InteractionResult using(BlockPos pos, Level level, BlockState state, Player player, InteractionHand hand) {
        ItemStack held = player.getItemInHand(hand);
        System.out.println("This method 'use' is being utilized");
        int index;

        if (held.getItem() == Items.HEART_OF_THE_SEA) {
            sendMessage(player, held);
        }
        return InteractionResult.CONSUME;
    }

    public ItemStack getItem() {
        return storedItem;
    }

    public void setItem(ItemStack item) {
        this.storedItem = item;
        setChanged(); // Updates block to sshow changes
    }

    public void sendMessage(Player player, ItemStack item) {
        if (item.getItem() == Items.HEART_OF_THE_SEA) {
            player.sendSystemMessage(net.minecraft.network.chat.Component.literal("Success "));
        }
        player.sendSystemMessage(Component.literal("Failed "));
    }






//    // This sets the stored item within the block to whatever parameter is passed
//    public void setItem(ItemStack item) {
//        this.item = item;
//        this.setChanged();
//    }
//
//    // Gets stored item
//    public ItemStack getStoredItem() {
//        return item;
//
//    // Tells about player's interaction with block
//    public InteractionResult use(Player player, InteractionHand hand) {
//        // Checks to see if not player is running on Client side
//        if (!player.level.isClientSide()){
//            if (storedItem.isEmpty()){
//                // Identifies the item in player's hand
//                ItemStack itemInHand = player.getItemInHand(hand);
//                // Checks to see if there's item in hand
//                if (!itemInHand.isEmpty()){
//                    setStoredItem(itemInHand.split(1));
//                    System.out.println("It works!");
//                    return InteractionResult.SUCCESS;
//                }
//            } else {
//                // Returns stored item back to player
//                player.getInventory().add(storedItem);
//                setStoredItem(ItemStack.EMPTY);
//                System.out.println("It gone!");
//                return InteractionResult.SUCCESS;
//            }
//        }
//        return InteractionResult.SUCCESS;
//    }

//    // Saving the item to the block entity (Important to consistency)
//    @Override
//    public void saveAdditional(CompoundTag tag){
//        super.saveAdditional(tag);
//        if (!storedItem.isEmpty()) {
//            tag.put("StoredItem", storedItem.save(new CompoundTag()));
//        }
//    }
//
//    // Loads Item when block is loaded
//    public void load(CompoundTag tag) {
//        super.load(tag);
//        if (tag.contains("StoredItem")) {
//            storedItem = ItemStack.of(tag.getCompound("StoredItem"));
//        }
//    }
}
