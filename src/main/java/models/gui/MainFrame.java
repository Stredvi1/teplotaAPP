package models.gui;

import models.interfaces.IMesicniMereni;
import models.interfaces.ITeplota;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final IMesicniMereni mereni;

    JPanel graphPanel = new JPanel();
    JPanel panelMain = new JPanel(new BorderLayout());

    public MainFrame(int width, int height, IMesicniMereni mereni) {
        super("Měření teplot");

        this.mereni = mereni;

        setSize(width, height);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        initGui();
        setVisible(true);
    }

    private void initGui() {

        panelMain.add(initDataInputPanel(), BorderLayout.NORTH);
        panelMain.add(initGraphPanel(), BorderLayout.SOUTH);
        add(panelMain);
    }

    private JPanel initDataInputPanel() {
        JPanel dataInputPanel = new JPanel(new FlowLayout((FlowLayout.CENTER)));
        JLabel lblStartingTemp = new JLabel("First temperature:");
        JTextField tfStartingTemp = new JTextField("", 6);
        dataInputPanel.add(lblStartingTemp);
        dataInputPanel.add(tfStartingTemp);

        JLabel lblRange = new JLabel("Temperature range:");
        JTextField tfRange = new JTextField("", 6);
        dataInputPanel.add(lblRange);
        dataInputPanel.add(tfRange);

        JButton submitData = new JButton("Generate!");
        submitData.addActionListener(e -> {
            mereni.generuj(Double.parseDouble(tfStartingTemp.getText()), Double.parseDouble(tfRange.getText()));
            panelMain.remove(1);
            panelMain.add(initGraphPanel(), BorderLayout.SOUTH);
            panelMain.repaint();
            panelMain.updateUI();
        });
        dataInputPanel.add(submitData);
        return dataInputPanel;
    }

    private JPanel initGraphPanel() {
        TempGraph graph = new TempGraph(mereni.getClass().getName(), mereni.asList());
        graphPanel = graph.getChartPanel();

        return graphPanel;
    }
}
