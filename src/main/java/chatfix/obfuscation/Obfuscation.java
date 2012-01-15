package chatfix.obfuscation;

import chatfix.ChatFix;
import chatfix.InitializationFactory;
import deobf.EntityPlayerSP;
import deobf.GuiScreen;
import deobf.Packet3Chat;
import java.io.File;
import net.minecraft.client.Minecraft;

/**
 * Main obfuscation class
 * Combines all obfuscated classes and methods into a single class
 * Eases updates, cleans up the rest of the codebase.
 * 
 * @author yetanotherx
 * 
 * @obfuscated
 */
public class Obfuscation implements InitializationFactory {

    protected ChatFix controller;
    protected Minecraft minecraft;
    
    public Obfuscation(ChatFix controller) {
        this.controller = controller;
    }

    @Override
    public void initialize() {
        this.minecraft = this.controller.getMinecraft();
    }

    public void sendChat(String chat) {
        getPlayer().a(chat);
    }

    /**
     * Displays a chat message on the screen, if the player is currently playing
     * @param chat 
     */
    public void showChatMessage(String chat) {
        if (getPlayer() != null) {
            getPlayer().b(chat);
        }
    }

    public void showGuiScreen(GuiScreen screen) {
        GuiScreen currentScreen = getCurrentScreen();
        if (currentScreen != null) {
            minecraft.a((GuiScreen) null);
        }
        minecraft.a(screen);
    }    

    public EntityPlayerSP getPlayer() {
        return getPlayer(minecraft);
    }

    public GuiScreen getCurrentScreen() {
        return getCurrentScreen(minecraft);
    }

    public static EntityPlayerSP getPlayer(Minecraft mc) {
        return mc.h;
    }
    
    public static GuiScreen getCurrentScreen(Minecraft mc) {
        return mc.s;
    }

    public static String getChatFromPacket(Packet3Chat packet) {
        return packet.a;
    }

    public static File getMinecraftDir() {
        return Minecraft.b();
    }

    public static File getChatFixDir() {
        return new File(getMinecraftDir(), "mods" + File.separator + "ChatFix");
    }
}
