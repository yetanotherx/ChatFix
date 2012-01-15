package chatfix.obfuscation;

/**
 * Method name obfuscation, used whenever we use reflection. 
 * This lets us keep reflected obfuscated methods in a central
 * class to ease updating.
 * 
 * @author yetanotherx
 * 
 * @obfuscated
 */
public enum FieldObfuscation {

    /**
     * Location of the .minecraft directory in Minecraft.class
     */
    MINECRAFTDIR("aj");
    protected String variable;

    private FieldObfuscation(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }

    public static String getVariable(FieldObfuscation type) {
        return type.getVariable();
    }
}
