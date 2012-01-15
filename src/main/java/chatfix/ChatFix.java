package chatfix;

import chatfix.config.CFConfiguration;
import chatfix.exception.InitializationException;
import chatfix.obfuscation.Obfuscation;
import net.minecraft.client.Minecraft;

/**
 * Main controller class. Uses a pseudo-JavaBeans paradigm.
 * 
 * @author yetanotherx
 */
public class ChatFix {

    public static final String VERSION = "1.0";
    public static final String MCVERSION = "1.1";
    protected Minecraft minecraft;
    protected Obfuscation obfuscation;
    protected CFDebug debugger;
    protected CFConfiguration configuration;

    public ChatFix(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    public void initialize() {
        this.obfuscation = new Obfuscation(this);
        this.configuration = new CFConfiguration(this);
        this.debugger = new CFDebug(this);

        try {
            this.obfuscation.initialize();
            this.configuration.initialize();
            this.debugger.initialize();
        } catch (InitializationException e) {
            e.printStackTrace();
            return;
        }

    }

    public CFConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(CFConfiguration configuration) {
        this.configuration = configuration;
    }

    public CFDebug getDebugger() {
        return debugger;
    }

    public void setDebugger(CFDebug debugger) {
        this.debugger = debugger;
    }

    public Minecraft getMinecraft() {
        return minecraft;
    }

    public void setMinecraft(Minecraft minecraft) {
        this.minecraft = minecraft;
    }

    public Obfuscation getObfuscation() {
        return obfuscation;
    }

    public void setObfuscation(Obfuscation obfuscation) {
        this.obfuscation = obfuscation;
    }

    public static String getVersion() {
        return VERSION + " for Minecraft version " + MCVERSION;
    }
}
