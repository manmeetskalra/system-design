package LLD.Fundamentals.BuilderDesign;

public class Client {

    public static void main(String[] args) {
        HPDesktop hp = new HPDesktop();
        DellDesktop dell = new DellDesktop();

        Director dir1 = new Director(hp);
        Director dir2 = new Director(dell);
        dir1.buildDesktop();
        dir2.buildDesktop();

        Desktop d1 = dir1.getDesktop();
        Desktop d2 = dir2.getDesktop();

        d1.showSpecs();
        d2.showSpecs();
    }

}
