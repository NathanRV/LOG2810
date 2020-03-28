package TP1;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException{

        WeightedGraph w = new WeightedGraph();
        Scanner read = new Scanner(System.in);
        String menu = "Veuillez choisir parmi les options (a) a (d) : \n" +
                      "(a) Mettre a jour la carte \n" +
                      "(b) Determiner le plus court chemin securitaire \n" +
                      "(c) Traiter les requêtes.\n" +
                      "(d) Quitter \n";
        System.out.println(menu);
        String input = read.nextLine();

        while (!input.equals("d")) {
            w.createGraph("arrondissements.txt");
            if (input.equals("a")) {
                w.printGraph();
            } else if (input.equals("b")) {
                System.out.print("Veuillez entrer un point de depart : ");
                int indexSource = read.nextInt();
                System.out.print("Veuillez entrer un point de destination : ");
                int indexDestination = read.nextInt();
                w.printTrajectory(indexSource, indexDestination);
            } else if (input.equals("c")) {
                w.traiterRequetes();
            } else {
                System.out.println(menu + "Veuillez choisir une option entre (a) et (d) en saisissant la lettre correspondante. ex: a");
            }
            input = read.nextLine();
        }

    }


}
