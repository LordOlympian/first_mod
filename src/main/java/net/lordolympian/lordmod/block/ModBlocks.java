package net.lordolympian.lordmod.block;

import net.lordolympian.lordmod.LordMod;
import net.lordolympian.lordmod.block.custom.SoundBlock;
import net.lordolympian.lordmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LordMod.MODID);

    public static final RegistryObject<Block> BLOOD_GEM_BLOCK = registerBlock("blood_gem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> RAW_BLOOD_GEM_BLOCK = registerBlock("raw_blood_gem_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.AMETHYST)));
    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
            () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> BLOOD_GEM_ORE = registerBlock("blood_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 12)));
    public static final RegistryObject<Block> DEEPSLATE_BLOOD_GEM_ORE = registerBlock("deepslate_blood_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 12)));
    public static final RegistryObject<Block> NETHER_BLOOD_GEM_ORE = registerBlock("nether_blood_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 12)));
    public static final RegistryObject<Block> END_STONE_BLOOD_GEM_ORE = registerBlock("end_stone_blood_gem_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(3, 12)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
