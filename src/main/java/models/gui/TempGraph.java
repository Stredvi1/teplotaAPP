package models.gui;

import models.interfaces.IMesicniMereni;
import models.interfaces.ITeplota;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.List;

public class TempGraph extends ApplicationFrame {

        private List<ITeplota> data;
        private ChartPanel chartPanel;

        public TempGraph(final String title, List<ITeplota> data) {

            super(title);

            this.data = data;
            final XYSeries series = new XYSeries("Temperature");

            for (ITeplota t: data) {
                series.add(t.getDay(), t.getTemperature());
            }

            final XYSeriesCollection dataT = new XYSeriesCollection(series);
            final JFreeChart chart = ChartFactory.createXYLineChart(
                    "XY Series Demo",
                    "Days",
                    "Temperature",
                    dataT,
                    PlotOrientation.VERTICAL,
                    true,
                    true,
                    false
            );

            chartPanel = new ChartPanel(chart);
            chartPanel.setPreferredSize(new java.awt.Dimension(900, 500));
        }

    public ChartPanel getChartPanel() {
        return chartPanel;
    }
}
