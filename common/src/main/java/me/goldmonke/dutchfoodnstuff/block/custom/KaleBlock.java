package me.goldmonke.dutchfoodnstuff.block.custom;

import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class KaleBlock extends CropBlock {


    public static final int MAX_AGE = 7;


    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D), // Age 0
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D), // Age 1
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D), // Age 2
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D), // Age 3
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D), // Age 4
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D), // Age 5
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D), // Age 6
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 10.0D, 16.0D) // Age 7
    };


    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.KALE_SEEDS.get();
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return AGE_TO_SHAPE[getAge(state)];
    }


    public KaleBlock(Properties properties) {
        super(properties);
    }
}
