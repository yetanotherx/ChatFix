package chatfix;

import chatfix.config.ConfigurationNode;
import chatfix.exception.ConfigurationException;
import chatfix.util.ChatColor;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.reader.UnicodeReader;

public class Updater extends Thread {

    protected ChatFix controller;
    protected final int updaterVersion = 1;

    public Updater(ChatFix controller) {
        this.controller = controller;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void run() {
        InputStream is = null;
        ConfigurationNode node = new ConfigurationNode(new HashMap<String, Object>());

        try {
            URL url = new URL(controller.getConfiguration().getUpdateFile());
            url.openConnection();
            is = url.openStream();

            Yaml yaml = new Yaml();
            Object out = yaml.load(new UnicodeReader(is));

            try {
                if (null != out) {
                    node.setRoot((Map<String, Object>) out);
                }
            } catch (ClassCastException e) {
                throw new ConfigurationException("Root document must be an key-value structure");
            }

            String currentVersion = node.getString("updaterVersion" + this.updaterVersion + ".current");
            List<String> supportedVersions = node.getStringList("updaterVersion" + this.updaterVersion + ".supported", new ArrayList<String>());

            if (currentVersion != null && !currentVersion.equals(ChatFix.VERSION) && !(currentVersion + "beta").equals(ChatFix.VERSION)) {
                if (supportedVersions != null && !supportedVersions.contains(ChatFix.VERSION)) {
                    controller.getObfuscation().showChatMessage(ChatColor.RED + "Your ChatFix version is out of date! ");
                    controller.getObfuscation().showChatMessage(ChatColor.RED + "The latest version is " + currentVersion + ". http://bit.ly/wecui");

                }
            }

        } catch (Exception e) {
            controller.getDebugger().info("Error in fetching update file!", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
    }
}
