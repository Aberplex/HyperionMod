package net.aredd.hyperionmod.block.custom;

import net.aredd.hyperionmod.block.ModBlocks;
import net.aredd.hyperionmod.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.ItemConvertible;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class HyperCropBlock extends CropBlock {
    public static final int MAX_AGE = 1;
    public static final IntProperty AGE = Properties.AGE_1;

    private static final VoxelShape[] AGE_TO_SHAPE = new VoxelShape[]{createCuboidShape(0.0, 0.0, 0.0, 16.0, 15.0, 16.0),
            createCuboidShape(0.0, 0.0, 0.0, 16.0, 15.0, 16.0)};


    public HyperCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return ModItems.HYPER_BERRY;
    }

    @Override
    protected IntProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.HYPER_STONE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(AGE)];
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = state.get(AGE);
        if (i < MAX_AGE && random.nextInt(10) == 0) {
            state = (BlockState)state.with(AGE, i + 1);
            world.setBlockState(pos, state, Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    public void grow(ServerWorld world, Random random, BlockPos pos, BlockState state) {
        if (random.nextFloat() < 0.15f) {
            super.grow(world, random, pos, state);
        }
    }
}
