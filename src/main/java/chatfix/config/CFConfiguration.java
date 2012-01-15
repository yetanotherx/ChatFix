package chatfix.config;

import chatfix.ChatFix;
import chatfix.InitializationFactory;
import chatfix.obfuscation.Obfuscation;
import java.io.File;

/**
 * Stores and reads ChatFix settings
 * 
 * @author yetanotherx
 * 
 */
public class CFConfiguration implements InitializationFactory {

    protected ChatFix controller;
    protected boolean debugMode = false;
    protected String updateFile = "https://raw.github.com/yetanotherx/ChatFix/master/updates.yml";
    protected Configuration config = null;

    public CFConfiguration(ChatFix controller) {
        this.controller = controller;
    }

    @Override
    public void initialize() {

        File file = new File(Obfuscation.getChatFixDir(), "Configuration.yml");
        file.getParentFile().mkdirs();

        config = new Configuration(file);
        config.load();

        if (!file.exists()) {
            config.setProperty("debug", this.debugMode);
            config.setProperty("updateFile", this.updateFile);
            
            config.save();
        }

        this.debugMode = config.getBoolean("debug", debugMode);
        this.updateFile = config.getString("updateFile", this.updateFile);
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public String getUpdateFile() {
        return updateFile;
    }
}
