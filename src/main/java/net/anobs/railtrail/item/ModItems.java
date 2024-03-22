package net.anobs.railtrail.item;

import net.anobs.railtrail.RailTrail;
import net.anobs.railtrail.item.custom.DollarItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RailTrail.MOD_ID);

    public static final RegistryObject<Item> DOLLAR = ITEMS.register("dollar", () -> new DollarItem(new Item.Properties()));



    public static  void  register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
