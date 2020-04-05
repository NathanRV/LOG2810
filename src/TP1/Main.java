package TP1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class Main extends JFrame{
    static JLabel title;
    static JComboBox sourceIndexes, destinationIndexes;
    static JTextArea informationOutput;

    static WeightedGraph w = new WeightedGraph();

    public static void createAndShowGUI() {
        JFrame frame = new JFrame("LOG2810 - TP1");

        frame.setSize(1000, 1200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());

        title = new JLabel("TP1 : GRAPHES");

        informationOutput = new JTextArea(40, 80);
        informationOutput.setBounds(100, 150, 670, 550);
        informationOutput.setLineWrap(true);
        informationOutput.setWrapStyleWord(true);
        informationOutput.setMargin( new Insets(20,20,0,20) );
        informationOutput.setEditable(false);

        JScrollPane scroll = new JScrollPane(informationOutput);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        JButton closestPathButton = new JButton("Plus court chemin");
        sourceIndexes = new JComboBox(w.getNodes().keySet().toArray());
        destinationIndexes = new JComboBox(w.getNodes().keySet().toArray());
        JButton refreshButton = new JButton("Mettre a jour la carte");
        JButton treatRequestsButton = new JButton("Traiter les requetes");
        JButton quitterButton = new JButton("Quitter");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 3, 10, 10));
        buttonPanel.add(closestPathButton);
        buttonPanel.add(sourceIndexes);
        buttonPanel.add(destinationIndexes);
        buttonPanel.add(refreshButton);
        buttonPanel.add(treatRequestsButton);
        buttonPanel.add(quitterButton);

        frame.getContentPane().add(title);
        frame.getContentPane().add(scroll);
        frame.getContentPane().add(buttonPanel);

        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    w.createGraph("arrondissements.txt");
                } catch (FileNotFoundException ex) {
                    informationOutput.setText("Le fichier arrondissements.txt n'existe pas dans le bon dossier!");
                }
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


    public static void main(String[] args) throws FileNotFoundException {
        w.createGraph("arrondissements.txt");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });


    }
}
