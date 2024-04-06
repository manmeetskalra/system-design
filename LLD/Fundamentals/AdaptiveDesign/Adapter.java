package LLD.Fundamentals.AdaptiveDesign;

public class Adapter extends Analyze {

    private XMLData xmlData;

    public Adapter(XMLData xmlData) {
        this.xmlData = xmlData;
    }

    @Override
    public void analyzeData() {
        System.out.println("Converting XML Data: " + xmlData.getXMLData() + " to JSON");
        System.out.println("Analyzing Json data");
    }

}
