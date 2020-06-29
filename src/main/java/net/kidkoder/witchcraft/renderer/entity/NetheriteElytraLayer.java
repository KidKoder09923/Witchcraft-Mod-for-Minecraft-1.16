package net.kidkoder.witchcraft.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.kidkoder.witchcraft.WitchcraftMod;
import net.kidkoder.witchcraft.init.ItemInit;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class NetheriteElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
    private static final ResourceLocation TEXTURE_ELYTRA = new ResourceLocation(WitchcraftMod.MODID, "textures/entity/netherite_elytra.png");
    private final NetheriteElytraModel<T> modelElytra = new NetheriteElytraModel<>();

    public NetheriteElytraLayer(IEntityRenderer<T, M> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.CHEST);
        if (itemstack.getItem() == ItemInit.NETHERITE_ELYTRA) {
            ResourceLocation resourcelocation;
            if (entitylivingbaseIn instanceof AbstractClientPlayerEntity) {
                AbstractClientPlayerEntity abstractclientplayerentity = (AbstractClientPlayerEntity)entitylivingbaseIn;
                if (abstractclientplayerentity.isPlayerInfoSet() && abstractclientplayerentity.getLocationElytra() != null) {
                    resourcelocation = abstractclientplayerentity.getLocationElytra();
                } else if (abstractclientplayerentity.hasPlayerInfo() && abstractclientplayerentity.getLocationCape() != null && abstractclientplayerentity.isWearing(PlayerModelPart.CAPE)) {
                    resourcelocation = abstractclientplayerentity.getLocationCape();
                } else {
                    resourcelocation = TEXTURE_ELYTRA;
                }
            } else {
                resourcelocation = TEXTURE_ELYTRA;
            }

            matrixStackIn.push();
            matrixStackIn.translate(0.0D, 0.0D, 0.125D);
            this.getEntityModel().copyModelAttributesTo(this.modelElytra);
            this.modelElytra.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            IVertexBuilder ivertexbuilder = ItemRenderer.func_239391_c_(bufferIn, this.modelElytra.getRenderType(resourcelocation), false, itemstack.hasEffect());
            this.modelElytra.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStackIn.pop();
        }
    }
}
