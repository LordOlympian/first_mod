package net.lordolympian.lordmod.item;

import net.lordolympian.lordmod.LordMod;
import net.lordolympian.lordmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, LordMod.MODID);

    public static final RegistryObject<CreativeModeTab> LORD_TAB = CREATIVE_MODE_TABS.register("lord_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BLOOD_GEM.get()))
                    .title(Component.translatable("creativetab.lord_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BLOOD_GEM.get());
                        output.accept(ModItems.RAW_BLOOD_GEM.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.HEMOGLOBIN.get());

                        output.accept(ModBlocks.BLOOD_GEM_BLOCK.get());
                        output.accept(ModBlocks.RAW_BLOOD_GEM_BLOCK.get());
                        output.accept(ModBlocks.SOUND_BLOCK.get());

                        output.accept(ModBlocks.BLOOD_GEM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_BLOOD_GEM_ORE.get());
                        output.accept(ModBlocks.NETHER_BLOOD_GEM_ORE.get());
                        output.accept(ModBlocks.END_STONE_BLOOD_GEM_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
