package models;

import models.interfaces.IMesicniMereni;
import models.interfaces.ITeplota;

import java.util.ArrayList;
import java.util.List;

public class Mesic implements IMesicniMereni {

    public final int monthIndex;

    private List<ITeplota> dayTemps = new ArrayList<>();

    public Mesic(int cisloMesice) {
        this.monthIndex = cisloMesice;
    }

    /**
     * Generuje nahodne teploty pro vsech 31 dni v mesici, pricemz i-ta a (i+1). teplota se lisi nejvyse
     * o hodnotu range
     * @param start pocatecni teplota pro prvni den
     * @param range interval <-range,range> pro generovani odchylky mezi sousednimi merenimi
     */
    @Override
    public void generuj(double start, double range) {
        dayTemps.clear();
        for (int i = 0; i < 31; i++) {

            Teplota d = new Teplota(i+1);

            if (i == 0) {
                d.setTemperature(start);
            } else {
                double tempVariation = random(-range, range);
                double yesterdayTemp = dayTemps.get(dayTemps.size()-1).getTemperature();
                d.setTemperature(yesterdayTemp + tempVariation);
            }
            dayTemps.add(d);
        }
    }

    @Override
    public List<ITeplota> asList() {
        return dayTemps;
    }

    private double random(double min, double max) {
        return ((Math.random() * (max - min)) + min);
    }
}
