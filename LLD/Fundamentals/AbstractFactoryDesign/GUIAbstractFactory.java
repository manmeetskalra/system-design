package LLD.Fundamentals.AbstractFactoryDesign;

public class GUIAbstractFactory {
    public static IFactory CreateFactory(String osType) {
        IFactory factory = null;
        if (osType.equalsIgnoreCase("Mac")) {
            factory = new MacFactory();
        } else if (osType.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        }
        return factory;
    }
}
