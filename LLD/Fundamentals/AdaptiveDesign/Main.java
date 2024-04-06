package LLD.Fundamentals.AdaptiveDesign;

public class Main {
    public static void main(String[] args) {
        XMLData xmlData = new XMLData("Dummy XML Data");
        Analyze analyze = new Adapter(xmlData);
        Client client = new Client();
        client.processData(analyze);
    }
}
