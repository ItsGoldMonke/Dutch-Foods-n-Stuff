package me.goldmonke.dutchfoodnstuff.block.custom;

import com.mojang.serialization.MapCodec;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import me.goldmonke.dutchfoodnstuff.util.ModStats;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class BoerenkoolPot extends HorizontalFacingBlock {

    public static final MapCodec<BoerenkoolPot> CODEC = createCodec(BoerenkoolPot::new);

    private static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 9.0, 14.0);

    public BoerenkoolPot(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }


    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }
            if (player.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
                return ActionResult.CONSUME;
            }
        }
        return tryEat(world, pos, state, player);
    }



        protected static ActionResult tryEat (WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player){
            if (!player.canConsume(false)) {
                return ActionResult.PASS;
            } else {
                player.incrementStat(ModStats.EAT_STAMPPOT_BOERENKOOL);
                player.getHungerManager().add(6, 0.3F);
                world.emitGameEvent(player, GameEvent.EAT, pos);
                world.playSound(player, pos, SoundEvents.ENTITY_GENERIC_EAT.value(), SoundCategory.PLAYERS); // here done
                world.playSound(player, pos, SoundEvents.ENTITY_PLAYER_BURP, SoundCategory.PLAYERS); // here done
                world.breakBlock(pos, true);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return ActionResult.SUCCESS;
        }

}
