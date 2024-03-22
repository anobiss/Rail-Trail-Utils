package net.anobs.railtrail.datagen;

import net.anobs.railtrail.RailTrail;
import net.anobs.railtrail.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, RailTrail.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(ModBlocks.ODOMETER.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(ModBlocks.ODOMETER.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.LOOTCRATE.get());
    }
}
