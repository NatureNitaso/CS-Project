package net.zihui.csprojmod.blocks.custom;

import com.sun.net.httpserver.Authenticator;
import net.minecraft.client.gui.components.ChatComponent;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.commands.SummonCommand;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.zihui.csprojmod.blocks.entity.SummonPedestalBlockEntity;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;

public class SummonPedestal extends BaseEntityBlock {
    public Items summon;

    public SummonPedestal(Block.Properties properties) {
        super(properties);
    }


    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack held = player.getItemInHand(hand); // grabs item that's in the players hand upon interaction
        int index = held.getCount(); // Gets the # of items held in player's hand

        // Checks to see if this behavior is on the client or server side
        if (!level.isClientSide()) {
            if (held.getItem() == Items.HEART_OF_THE_SEA) {
                index -= 1;
                player.getItemInHand(hand).setCount(index);
                return InteractionResult.SUCCESS;
            } else {
                index -= 1;
                player.getItemInHand(hand).setCount(index);
                return InteractionResult.SUCCESS;

            }
            return InteractionResult.FAIL;
        }
        return InteractionResult.FAIL;
    }

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
