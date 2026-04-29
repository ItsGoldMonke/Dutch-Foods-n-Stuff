package me.goldmonke.dutchfoodnstuff.item.custom;

import me.goldmonke.dutchfoodnstuff.block.ModBlocks;
import me.goldmonke.dutchfoodnstuff.item.ModItems;
import me.goldmonke.dutchfoodnstuff.util.ModStats;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;



public class CheeseSlicer extends HoeItem {


    public CheeseSlicer(Tier tier, Properties properties) {
        super(tier, properties);
    }


    @Override
    public InteractionResult useOn(UseOnContext context) {

        Level world = context.getLevel();
        Block clickedBlock = world.getBlockState(context.getClickedPos()).getBlock();
        BlockPos blockPos = context.getClickedPos();


        if (clickedBlock.defaultBlockState().is(ModBlocks.CHEESE_BLOCK)) {
            if(!world.isClientSide()) {
                context.getPlayer().awardStat(ModStats.CHEESE_SLICED.get());
                world.addFreshEntity(new ItemEntity(world, blockPos.getX() + 0.5, blockPos.getY(), blockPos.getZ() + 0.5, new ItemStack(ModItems.CHEESE_SLICE, 16)));
                world.setBlockAndUpdate(context.getClickedPos(), Blocks.AIR.defaultBlockState());
                world.playSound(null, context.getClickedPos(), SoundEvents.MOSS_BREAK, SoundSource.BLOCKS, 1.0F, 0.8F);
                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) world), ((ServerPlayer) context.getPlayer()),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

            }


            return InteractionResult.SUCCESS;
        }



        return InteractionResult.PASS;
    }


}
