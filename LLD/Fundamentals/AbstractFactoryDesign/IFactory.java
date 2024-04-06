package LLD.Fundamentals.AbstractFactoryDesign;

public interface IFactory {

    IButton createButton();

    ITextBox createTextBox();
}
