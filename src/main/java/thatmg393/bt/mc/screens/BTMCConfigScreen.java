package thatmg393.bt.mc.screens;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.options.GameOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.options.GameOptions;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.TranslatableText;
import thatmg393.bt.mc.BTMC;
import thatmg393.bt.mc.config.SimpleConfig.CType;

public class BTMCConfigScreen extends GameOptionsScreen 
{
    private Screen parent;

    public BTMCConfigScreen(Screen parent, GameOptions gameOptions) 
    {
        super(parent, gameOptions, new TranslatableText("options.btmcconfig.title", new Object[0]));
        this.parent = parent;
    }

    //private ButtonListWidget list = new ButtonListWidget(this.minecraft, this.width, this.height, 32, this.height - 32, 25);

    List<String> cb_list = new ArrayList<String>();

    
    int index = 0;
    String cb = (String)BTMC.CONFIG.getKey("cb_value", CType.s);

    private ButtonWidget cb_changer;

    public String getCB() 
    {
        return cb;
    }
    
    protected void init()
    {
        cb_list.add("Fabric");
        cb_list.add("Vanilla");
        cb_list.add("Forge");
        cb_list.add("LabyMod");

        cb_changer = (ButtonWidget) this.addButton(new ButtonWidget(this.width / 2 - 155, this.height / 6 + 48 - 6, 150, 20, new TranslatableText("options.btmcconfig.cb_prefix").asFormattedString() + getCB(), (button) -> 
        {
            cb_changer.setMessage(new TranslatableText("options.btmcconfig.cb_prefix").asFormattedString() + cycleCB());
            BTMC.CONFIG.setKey("cb_value", getCBbyI(index));
        }));

        this.addButton(new ButtonWidget(this.width / 2 - 100, this.height / 6 + 268, 200, 20, I18n.translate("gui.done"), (button) -> 
        {
            this.minecraft.openScreen(this.parent);
        }));
    }

    public void render(int mouseX, int mouseY, float delta) 
    {
        this.renderBackground();
        this.drawCenteredString(this.font, this.title.asFormattedString(), this.width / 2, 20, 16777215);
        super.render(mouseX, mouseY, delta);
    }

    private String cycleCB()
    {
        try 
        {
            if (index < cb_list.size() - 1)
            {
                index++;
                return cb_list.get(index);
            }
            else
            {
                index = 0;
                return cb_list.get(index);
            }
        }
        catch (IndexOutOfBoundsException ioobe)
        {
            BTMC.LOGGER.info("Index Out Of Bounds!\nIndex size is " + (cb_list.size() - 1) + " but the user tried to get an item larger than " + (cb_list.size() - 1));
            return null;
        }
    }

    private String getCBbyI(int index)
    {
        return cb_list.get(index);
    }
}
