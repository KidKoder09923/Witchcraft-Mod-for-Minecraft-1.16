package net.kidkoder.witchcraft.init;

import net.kidkoder.witchcraft.objects.armor.NetheriteElytraArmor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus= Mod.EventBusSubscriber.Bus.MOD)
public class ItemInit {
    public static Item NETHERITE_ELYTRA = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(
                NETHERITE_ELYTRA = new NetheriteElytraArmor(new Item.Properties().defaultMaxDamage(1000).group(ItemGroup.TRANSPORTATION).rarity(Rarity.UNCOMMON)).setRegistryName("netherite_elytra")
        );
    }
}
