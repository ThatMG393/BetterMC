package thatmg393.bt.mc.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.SettingsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.options.GameOptions;
import net.minecraft.text.TranslatableText;
import net.minecraft.text.Text;
import thatmg393.bt.mc.screens.BTMCConfigScreen;

import org.spongepowered.asm.mixin.injection.At;

@Mixin(SettingsScreen.class)
public class TitleScreenMixin extends Screen
{
    private final GameOptions settings;
    
    protected TitleScreenMixin(Text title, GameOptions gameOptions)
    {
        super(title);
        this.settings = gameOptions;
    }

    @Inject(at = @At("HEAD"), method = "init")
    private void initWidgetsNormal(CallbackInfo ci)
    {
        //168 def, 373 new
        this.addButton(new ButtonWidget(this.width / 2 - 100 + 205, this.height / 6 + 168, 70, 20, new TranslatableText("options.btmcconfig.button_text").asFormattedString(), (buttonWidget) -> {
            //BTMC.LOGGER.info("I've been clicked!");
            this.minecraft.openScreen(new BTMCConfigScreen(this, this.settings));
        }));
    }
}
