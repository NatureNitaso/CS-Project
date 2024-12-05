package net.zihui.csprojmod.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class SummonPedestal extends Block {
    public static Items summon;

    public SummonPedestal(Block.Properties properties) {
        super(properties);
    }
    // Overrides the interaction result method (what happens upon interacting

    @Override
    public @NotNull InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        // Makes a variable that identifies the held item of the player interacting with the block
        ItemStack held = player.getItemInHand(hand);
        int index = player.getItemInHand(hand).getCount();

        // Checks to see if item matchs with it's requirements. 1. is running on server ride
        // 2. held item is equal to summon item
        // 3.
        if (!level.isClientSide() && held.getItem() == Items.HEART_OF_THE_SEA){
            player.getItemInHand(hand).setCount(index - 1); //Takes away 1 item upon consumption
            level.explode(player, pos.getX(), pos.getY(), pos.getZ(), 4.0F, true, Explosion.BlockInteraction.NONE);
            return InteractionResult.CONSUME;
        }


        return super.use(state, level, pos, player, hand, hit);
    }


    // Block Entity BELOW
//    @Override
//    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
//        return null;
//    }

}
