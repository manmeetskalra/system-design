package LLD.Fundamentals.BuilderDesign;

public class HPDesktop implements DesktopBuilder {

    private Desktop desktop;

    HPDesktop() {
        desktop = new Desktop();
    }

    public void buildMonitor() {
        desktop.setMonitor("HP monitor");
    }

    public void buildMouse() {
        desktop.setMouse("mouse");
    }

    public void buildKeyboard() {
        desktop.setKeyboard("keyboard");
    }

    public void buildSpeaker() {
        desktop.setSpeaker("speaker");
    }

    public void buildRam() {
        desktop.setRam("ram");
    }

    public void buildProcessor() {
        desktop.setProcessor("processor");
    }

    public void buildMotherboard() {
        desktop.setMotherboard("motherboard");
    }

    public Desktop getDesktop() {
        return desktop;
    }
}
