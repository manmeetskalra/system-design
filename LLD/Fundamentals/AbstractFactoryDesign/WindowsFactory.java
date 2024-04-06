package LLD.Fundamentals.AbstractFactoryDesign;

public class WindowsFactory implements IFactory {

    public IButton createButton() {
        return new WindowsButton();
    }

    public ITextBox createTextBox() {
        return new WindowsTextBox();
    }
}
