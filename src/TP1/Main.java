package TP1;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Main extends JFrame implements ActionListener {

    static JTextField sourceField, destinationField;

    public static void main(String[] args) throws FileNotFoundException {

        JFrame frame = new JFrame();
        frame.getContentPane().setLayout(new FlowLayout());

        sourceField = new JTextField("", 10);
        destinationField = new JTextField("", 10);

        JButton refreshButton = new JButton("Mettre a jour la carte");
        JButton closestPathButton = new JButton("Plus court chemin");
        JButton treatRequestsButton = new JButton("Traiter les requetes");
        JButton quitterButton = new JButton("Quitter");

        refreshButton.setBounds(100, 850, 100, 40);
        refreshButton.setSize(200, 75);

        sourceField.setBounds(100, 750, 150,40);
        destinationField.setBounds(260, 750, 150,40);
        closestPathButton.setBounds(440, 750, 150, 40);

        treatRequestsButton.setBounds(325, 850, 100, 40);
        treatRequestsButton.setSize(200, 75);

        quitterButton.setBounds(550, 850, 100, 40);
        quitterButton.setSize(200, 75);

        frame.getContentPane().add(refreshButton);
        frame.getContentPane().add(closestPathButton);
        frame.getContentPane().add(treatRequestsButton);
        frame.getContentPane().add(quitterButton);

        frame.getContentPane().add(sourceField);
        frame.getContentPane().add(destinationField);

        frame.setSize(1000, 1200);
        frame.setLayout(null);
        frame.setVisible(true);

        Driver driver = new Driver("arrondissements.txt", "requetes.txt");

        driver.doAll();

        System.out.println();
        System.out.println("15, 16, 7, 14, 4, 10, 12, 19, 17, 13, 8, 3, 19, 3, 5, 16, 7, 3, 12");
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("Plus court chemin")) {

        }
    }

}
