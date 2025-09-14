package com.k1llm3sixy.shadowcoords.mixins;

import com.k1llm3sixy.shadowcoords.config.Config;
import net.minecraft.client.gui.hud.DebugHud;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
@Mixin(DebugHud.class)
public abstract class DebugHudMixin {
    @Redirect(method = "getLeftText", at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z"))
    private boolean changeLeftText(List list, Object element) {
        if (element instanceof String str && Config.toggle) {
            if (str.startsWith("XYZ: ")) return false;
            if (str.startsWith("Block: ")) return false;
        }
        return list.add(element);
    }

    @Redirect(method = "getRightText", at = @At(value = "INVOKE", target = "Ljava/util/List;add(Ljava/lang/Object;)Z"))
    private boolean changeRightText(List list, Object element) {
        if (element instanceof String str && Config.toggle) {
            if (str.contains("Targeted Block: ")) return false;
            if (str.contains("Targeted Fluid: ")) return false;
        }
        return list.add(element);
    }
}