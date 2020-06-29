package net.kidkoder.witchcraft.objects.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;

import javax.annotation.Nullable;

public class NetheriteElytraArmor extends ElytraItem {


    public NetheriteElytraArmor(Properties builder) {
        super(builder);
    }

    @Nullable
    @Override
    public EquipmentSlotType getEquipmentSlot(ItemStack stack) {
        return EquipmentSlotType.CHEST;
    }
}
