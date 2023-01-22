package models.interfaces;

import java.util.List;

public interface IMesicniMereni {
    /**
     * Generuje nahodne teploty pro vsech 31 dni v mesici, pricemz i-ta a (i+1). teplota se lisi nejvyse
     * o hodnotu range
     * @param start pocatecni teplota pro prvni den
     * @param range interval <-range,range> pro generovani odchylky mezi sousednimi merenimi
     */
    void generuj(double start, double range);

    /**
     * Vraci seznam vsech teplot typu ITeplota
     * @return
     */
    List<ITeplota> asList();
}
