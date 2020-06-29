package net.kidkoder.witchcraft.event;

import net.kidkoder.witchcraft.renderer.entity.NetheriteElytraLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.FORGE)
public class Events {
    @SubscribeEvent
    public static void renderPlayer(RenderPlayerEvent.Pre event) {
        PlayerEntity player = event.getPlayer();
        PlayerRenderer renderer = event.getRenderer();
        renderer.addLayer(new NetheriteElytraLayer<>(renderer));

    }
}
