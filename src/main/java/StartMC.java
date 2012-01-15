
import chatfix.obfuscation.FieldObfuscation;
import chatfix.vendor.org.joor.Reflect;
import java.io.File;
import net.minecraft.client.Minecraft;

/**
 * Starts the Minecraft main class by setting the minecraft directory
 * 
 * @author yetanotherx
 */
public class StartMC {

    public static void main(String[] args) {
        try {
            // This overrides it to a local copy, to preserve my production copy
            // It also ensures that I start with a fresh bin directory
            Reflect.on(Minecraft.class).field(FieldObfuscation.MINECRAFTDIR.getVariable()).set(null, new File("."));

            Minecraft.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
