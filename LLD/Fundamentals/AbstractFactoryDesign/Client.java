package LLD.Fundamentals.AbstractFactoryDesign;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the machine type (Mac/Windows): ");
        String osType = scanner.nextLine();

        // directly call the static function
        IFactory factory = GUIAbstractFactory.CreateFactory(osType);

        if (factory == null) {
            System.out.println("Invalid machine type.");
        }

        if (factory != null) {
            IButton button = factory.createButton();
            button.press();

            ITextBox textbox = factory.createTextBox();
            textbox.showText();
        }

        scanner.close(); // Close the scanner when done
    }
}
