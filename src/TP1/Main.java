package TP1;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Main extends JFrame /*implements ItemListener*/{

    static JTextField sourceField, destinationField;
    static JLabel title, informationOutput;
    //static JComboBox pathIndexesList; supposed to replace jtextfield on the next commit

    static WeightedGraph w = new WeightedGraph();

    public static void main(String[] args) throws FileNotFoundException {

        w.createGraph("arrondissements.txt");
        String pathIndexes[] = new String[w.getNodes().values().toArray().length];
        for(WeightedGraph.Node node : w.getNodes().values()) {
            int i = 1;
            pathIndexes[i] = Integer.toString(node.getIndex());
            i++;
        }

        JFrame frame = new JFrame();

        Main main = new Main();

        frame.getContentPane().setLayout(new FlowLayout());
        JButton refreshButton = new JButton("Mettre a jour la carte");
        title = new JLabel("TP1 : GRAPHES");
        informationOutput = new JLabel("");
        informationOutput.setBounds(450, 50, 2000, 600);
        //pathIndexesList = new JComboBox(w.getNodes().values().toArray());

        //pathIndexesList.addItemListener(main);

        title.setBounds(450, 50, 2000, 100);
        informationOutput.setBounds(150, 200, 2000, 400);

        frame.getContentPane().add(title);
        frame.getContentPane().add(informationOutput);
        //frame.getContentPane().add(pathIndexesList);

        sourceField = new JTextField("", 10);
        destinationField = new JTextField("", 10);


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
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                informationOutput.setText(w.printGraph());
            }
        });

        closestPathButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                informationOutput.setText(w.printTrajectory(Integer.parseInt(sourceField.getText()), Integer.parseInt(destinationField.getText())));
            }
        });

        treatRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                informationOutput.setText("need to do some changes to driver.java to print this");
            }
        });

        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });



        Driver driver = new Driver("arrondissements.txt", "requetes.txt");

        driver.doAll();

        System.out.println();
        System.out.println("15, 16, 7, 14, 4, 10, 12, 19, 17, 13, 8, 3, 19, 3, 5, 16, 7, 3, 12");
    }
//    public void itemStateChanged(ItemEvent e) {
//        if(e.getSource() == pathIndexesList) {}
//    }
}
