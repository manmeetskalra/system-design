package LLD.Fundamentals.AbstractFactoryDesign;

public class MacFactory implements IFactory {

    public IButton createButton() {
        return new MacButton();
    }

    public ITextBox createTextBox() {
        return new MacTextBox();
    }
}
