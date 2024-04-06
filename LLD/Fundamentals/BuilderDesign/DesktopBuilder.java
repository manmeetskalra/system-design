package LLD.Fundamentals.BuilderDesign;

public interface DesktopBuilder {

    void buildMonitor();

    void buildMouse();

    void buildKeyboard();

    void buildSpeaker();

    void buildRam();

    void buildProcessor();

    void buildMotherboard();

    Desktop getDesktop();

}
