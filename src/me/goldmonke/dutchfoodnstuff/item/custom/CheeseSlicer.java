package me.goldmonke.dutchfoodnstuff.item.custom;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import me.goldmonke.dutchfoodnstuff.util.ModStats;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;



public class CheeseSlicer extends Item {
    public CheeseSlicer(net.minecraft.item.Item.Settings settings) {
        super(settings);
    }

    


    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        World world = context.getWorld();
        Block clickedBlock = world.getBlockState(context.getBlockPos()).getBlock();
        BlockPos blockPos = context.getBlockPos();


        if (clickedBlock.getDefaultState().isOf(ModBlocks.CHEESE_BLOCK)) {
            if(!world.isClient) {
                context.getPlayer().incrementStat(ModStats.CHEESE_SLICED);
                world.spawnEntity(new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, new ItemStack(ModItems.CHEESE_SLICE, 16)));
                world.setBlockState(context.getBlockPos(), Blocks.AIR.getDefaultState());
                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_CACTUS_FLOWER_BREAK, SoundCategory.BLOCKS, 1.0F, 0.8F);
                context.getStack().damage(1, ((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

            }


            return ActionResult.SUCCESS;
        }



        return ActionResult.PASS;
    }



}
