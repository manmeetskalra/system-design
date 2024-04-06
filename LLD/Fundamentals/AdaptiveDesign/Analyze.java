package LLD.Fundamentals.AdaptiveDesign;

public class Analyze {
    private String jsonData;

    public Analyze() {

    }

    public Analyze(String jsonData) {
        this.jsonData = jsonData;
    }

    public void analyzeData() {
        System.out.println("Analyzed Data: " + jsonData);
    }
}
