package mods.bloxgate.bloxgatemod.common;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGeneratorBlox implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world,
                         IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch (world.provider.dimensionId)
        {
            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);

            case 0:
                generateSuface(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    private void generateSuface(World world, Random random, int BlockX, int BlockZ)
    {
        for (int i = 0; i <= 2; i++)
        {
            int Xcoord = BlockX + random.nextInt(1);
            int Zcoord = BlockZ + random.nextInt(1);
            int Ycoord = random.nextInt(25);
            (new WorldGenMinable(mod_bloxgatemod.uraniumOre, 2)).generate(world, random, Xcoord, Ycoord, Zcoord);
        }
    }

    private void generateNether(World world, Random random, int BlockX, int BlockZ)
    {
        for (int i = 0; i <= 4; i++)
        {
            int Xcoord = BlockX + random.nextInt(2);
            int Zcoord = BlockZ + random.nextInt(2);
            int Ycoord = random.nextInt(50);
            (new WorldGenMinable(mod_bloxgatemod.NetherUraniumOre, 10, Blocks.netherrack)).generate(world, random, Xcoord, Ycoord, Zcoord);
        }
    }
}
