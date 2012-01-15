package chatfix;

import chatfix.exception.InitializationException;
import chatfix.obfuscation.Obfuscation;
import chatfix.util.ConsoleLogFormatter;
import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Debugging helper class
 * 
 * @author yetanotherx
 * 
 */
public class CFDebug implements InitializationFactory {

    protected ChatFix controller;
    protected File debugFile;
    protected boolean debugMode = false;
    protected final static Logger logger = Logger.getLogger("ChatFix");

    public CFDebug(ChatFix controller) {
        this.controller = controller;
    }

    @Override
    public void initialize() throws InitializationException {

        ConsoleLogFormatter formatter = new ConsoleLogFormatter();
        ConsoleHandler handler = new ConsoleHandler();
        handler.setFormatter(formatter);
        
        logger.setUseParentHandlers(false);
        logger.addHandler(handler);
        
        try {
            this.debugFile = new File(Obfuscation.getChatFixDir(), "ChatFix-debug.txt");
            this.debugMode = controller.getConfiguration().isDebugMode();
            
            if (this.debugMode) {
                FileHandler newHandler = new FileHandler(this.debugFile.getAbsolutePath());
                newHandler.setFormatter(formatter);
                logger.addHandler(newHandler);
            }

        } catch (IOException e) {
            e.printStackTrace(System.err);
            throw new InitializationException();
        }

    }

    /**
     * Shows a message if debug mode is true
     * @param message 
     */
    public void debug(String message) {
        if (debugMode) {
            logger.info("ChatFix Debug - " + message);
        }
    }

    public void info(String message) {
        logger.info(message);
    }
    
    public void info(String message, Throwable e) {
        logger.log(Level.INFO, message, e);
    }
}
