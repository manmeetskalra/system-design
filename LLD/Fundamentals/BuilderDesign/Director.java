package LLD.Fundamentals.BuilderDesign;

public class Director {

    private DesktopBuilder desktopBuilder;

    public Director(DesktopBuilder desktopBuilder) {
        this.desktopBuilder = desktopBuilder;
    }

    public void buildDesktop() {
        this.desktopBuilder.buildMonitor();
        this.desktopBuilder.buildKeyboard();
        this.desktopBuilder.buildMouse();
        this.desktopBuilder.buildSpeaker();
        this.desktopBuilder.buildRam();
        this.desktopBuilder.buildProcessor();
        this.desktopBuilder.buildMotherboard();
    }

    public Desktop getDesktop() {
        return this.desktopBuilder.getDesktop();
    }
}
