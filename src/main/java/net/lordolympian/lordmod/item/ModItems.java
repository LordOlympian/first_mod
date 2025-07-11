package net.lordolympian.lordmod.item;

import net.lordolympian.lordmod.LordMod;
import net.lordolympian.lordmod.item.custom.FuelItem;
import net.lordolympian.lordmod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LordMod.MODID);

    public static final RegistryObject<Item> BLOOD_GEM = ITEMS.register("bloodgem",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_BLOOD_GEM = ITEMS.register("raw_bloodgem",
            () -> new Item(new Item.Properties()));

    //public static final RegistryObject<Item> HEMOGLOBIN = ITEMS.register("hemoglobin",
    //        () -> new Item(new Item.Properties().food(ModFoods.HEMOGLOBIN)));

    public static final RegistryObject<Item> HEMOGLOBIN = ITEMS.register("hemoglobin",
            () -> new FuelItem(new Item.Properties().food(ModFoods.HEMOGLOBIN), 1600)); // 1600 ticks = 80 seconds

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(300)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
