package TP1;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.*;

public class Main extends JFrame{

    static JLabel title, sourceLabel, destinationLabel;
    static JComboBox sourceIndexes, destinationIndexes;
    static JTextArea informationOutput;

    static WeightedGraph w = new WeightedGraph();

    public static void main(String[] args) throws FileNotFoundException {

        w.createGraph("arrondissements.txt");

        JFrame frame = new JFrame();

        frame.getContentPane().setLayout(new FlowLayout());

        title = new JLabel("TP1 : GRAPHES");
        title.setBounds(400, 50, 2000, 100);
        informationOutput = new JTextArea(1000, 1000);
        informationOutput.setBounds(100, 150, 670, 550);
        sourceLabel = new JLabel("Point de depart");
        sourceLabel.setBounds(375, 710, 2000, 100);
        destinationLabel = new JLabel("Destination");
        destinationLabel.setBounds(610, 710, 2000, 100);

        sourceIndexes = new JComboBox(w.getNodes().keySet().toArray());
        destinationIndexes = new JComboBox(w.getNodes().keySet().toArray());

        JScrollPane scrollPane = new JScrollPane(informationOutput);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        informationOutput.setEditable(false);
        frame.getContentPane().add(title);
        frame.getContentPane().add(informationOutput);
        frame.getContentPane().add(sourceLabel);
        frame.getContentPane().add(destinationLabel);
        frame.getContentPane().add(sourceIndexes);
        frame.getContentPane().add(destinationIndexes);



        JButton refreshButton = new JButton("Mettre a jour la carte");
        JButton closestPathButton = new JButton("Plus court chemin");
        JButton treatRequestsButton = new JButton("Traiter les requetes");
        JButton quitterButton = new JButton("Quitter");

        sourceIndexes.setBounds(325, 780, 100, 40);
        sourceIndexes.setSize(200, 35);

        destinationIndexes.setBounds(550, 780, 100, 40);
        destinationIndexes.setSize(200, 35);

        refreshButton.setBounds(100, 850, 100, 40);
        refreshButton.setSize(200, 75);

        closestPathButton.setBounds(100, 750, 150, 40);
        closestPathButton.setSize(200, 75);

        treatRequestsButton.setBounds(325, 850, 100, 40);
        treatRequestsButton.setSize(200, 75);

        quitterButton.setBounds(550, 850, 100, 40);
        quitterButton.setSize(200, 75);

        frame.getContentPane().add(refreshButton);
        frame.getContentPane().add(closestPathButton);
        frame.getContentPane().add(treatRequestsButton);
        frame.getContentPane().add(quitterButton);

        frame.getContentPane().add(sourceIndexes);
        frame.getContentPane().add(destinationIndexes);

        scrollPane.setLayout(null);
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
                informationOutput.setText(w.printTrajectory(sourceIndexes.getSelectedIndex() + 1, destinationIndexes.getSelectedIndex() + 1));
            }
        });

        treatRequestsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    informationOutput.setText(w.traiterRequetes());
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        });

        quitterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }
}
