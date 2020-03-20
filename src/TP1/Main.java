package TP1;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        //w.traiterRequetes();

        //TODO
        Driver driver = new Driver("arrondissements.txt", "requetes.txt");

        driver.doAll();


        System.out.println();
        System.out.println("15, 16, 7, 14, 4, 10, 12, 19, 17, 13, 8, 3, 19, 3, 5, 16, 7, 3, 12");
    }
}
