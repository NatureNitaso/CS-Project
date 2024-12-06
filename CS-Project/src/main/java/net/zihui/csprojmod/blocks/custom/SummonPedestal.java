package net.zihui.csprojmod.blocks.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ShearsItem;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.LadderBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.zihui.csprojmod.blocks.entity.SummonPedestalBlockEntity;

public class SummonPedestal extends Block {
    public static Items summon;
    public static ItemStack item;

    // Defines the shape of the block
    private static final VoxelShape SHAPE = Shapes.box(0.2, 0, 0.2, 0.8, 1, 0.8);

    public SummonPedestal(Block.Properties properties) {
        super(properties);
    }

    // Block Entity BELOW
    public BlockEntity newBlockEntity (BlockPos pos, BlockState state) {
        return new SummonPedestalBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext collision){
        return SHAPE;
    }

    // Tells about player's interaction with block
    public InteractionResult use(Player player, InteractionHand hand) {
        // Checks to see if not player is running on Client side
        if (!player.level.isClientSide()){
            if (true){
                // Identifies the item in player's hand
                ItemStack held = player.getItemInHand(hand);
                // Checks to see if there's item in hand
                if (held != ItemStack.EMPTY){
                    player.getItemInHand(hand).split(1);
                    System.out.println("It works!");
                    item = held;
                    return InteractionResult.SUCCESS;
                }
            } else {
                // Returns stored item back to player
                player.getInventory().add(item);
                System.out.println("It gone!");
                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.SUCCESS;
    }





}
