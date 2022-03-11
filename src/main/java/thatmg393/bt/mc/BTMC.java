package thatmg393.bt.mc;

import net.fabricmc.api.ModInitializer;

import net.minecraft.text.TranslatableText;
import thatmg393.bt.mc.config.SimpleConfig;
import thatmg393.bt.mc.config.SimpleConfig.CType;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BTMC implements ModInitializer 
{
    public static final String MOD_ID = "btmc";
    public static final String MOD_NAME = "BetterMC";

    public static Logger LOGGER = LogManager.getLogger();
    public static SimpleConfig CONFIG = new SimpleConfig(MOD_ID + "-config");

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing!");
        if (!CONFIG.setKey("cb_value", "Fabric"))
        {
            CONFIG.addKey("cb_value", "Fabric");
        }
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

    public TranslatableText getTBText(String key)
    {
        return new TranslatableText(key);
    }

}