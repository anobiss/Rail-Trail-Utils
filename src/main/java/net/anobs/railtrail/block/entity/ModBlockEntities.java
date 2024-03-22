package net.anobs.railtrail.block.entity;

import net.anobs.railtrail.RailTrail;
import net.anobs.railtrail.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RailTrail.MOD_ID);

    public static final RegistryObject<BlockEntityType<MarketBlockEntity>> MARKET_BE =
            BLOCK_ENTITIES.register("market_be", () ->
                    BlockEntityType.Builder.of(MarketBlockEntity::new,
                            ModBlocks.MARKET.get()).build(null));



    public static void register(IEventBus eventBus){
        BLOCK_ENTITIES.register(eventBus);
    }
}
