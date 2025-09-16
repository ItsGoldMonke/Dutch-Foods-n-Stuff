package me.goldmonke.dutchfoodnstuff.item.custom;

import me.goldmonke.dutchfoodnstuff.DutchFoodsnStuff;
import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;



public class CheeseSlicer extends Item {
    public CheeseSlicer(Settings settings) {
        super(settings);
    }


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        BlockPos blockPos = context.getBlockPos();


        if (clickedBlock.getDefaultState().isOf(ModBlocks.CHEESE_BLOCK)) {
            if(!world.isClient) {

                world.spawnEntity(new ItemEntity(world, blockPos.getX(), blockPos.getY(), blockPos.getZ(), new ItemStack(ModItems.CHEESE_SLICE, 16)));
                world.playSound(null, context.getBlockPos(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS);
                world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_CACTUS_FLOWER_BREAK, SoundCategory.BLOCKS);

            }


            return ActionResult.SUCCESS;
        }



        return ActionResult.PASS;
    }
}
