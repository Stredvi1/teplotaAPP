package models.interfaces;

public interface ITeplota {

    /**
     * Den mereni teploty v mesici
     * @return vraci den mereni 1..31
     */
    int getDay();

    /**
     * Teplota odpovidajici prislusnemu dni
     * @return teplota
     */
    double getTemperature();

}
