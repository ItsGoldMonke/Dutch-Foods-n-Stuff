package me.goldmonke.dutchfoodnstuff.block.custom;

import com.mojang.serialization.MapCodec;
import me.goldmonke.dutchfoodnstuff.util.ModStats;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class BoerenkoolPot extends HorizontalDirectionalBlock {

    public static final MapCodec<BoerenkoolPot> CODEC = simpleCodec(BoerenkoolPot::new);

    private static final VoxelShape SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 9.0, 14.0);

    public BoerenkoolPot(Properties settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }


    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return this.defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }


    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        if (world.isClientSide()) {
            if (tryEat(world, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }
            if (player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }
        return tryEat(world, pos, state, player);
    }



        protected static InteractionResult tryEat (LevelAccessor world, BlockPos pos, BlockState state, Player player){
            if (!player.canEat(false)) {
                return InteractionResult.PASS;
            } else {
                player.awardStat(ModStats.EAT_STAMPPOT_BOERENKOOL.get());
                player.getFoodData().eat(6, 0.3F);
                world.gameEvent(player, GameEvent.EAT, pos);
                world.playSound(player, pos, SoundEvents.GENERIC_EAT, SoundSource.PLAYERS); // here done
                world.playSound(player, pos, SoundEvents.PLAYER_BURP, SoundSource.PLAYERS); // here done
                world.destroyBlock(pos, true);
                world.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return InteractionResult.SUCCESS;
        }

}
