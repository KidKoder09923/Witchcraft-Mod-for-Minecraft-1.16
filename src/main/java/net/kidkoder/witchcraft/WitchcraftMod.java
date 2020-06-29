package net.kidkoder.witchcraft;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(WitchcraftMod.MODID)
public class WitchcraftMod {
    public static final String MODID = "witchcraft";
    public WitchcraftMod() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistrys);
    }

    private void clientRegistrys(final FMLClientSetupEvent event) {
    }
}
