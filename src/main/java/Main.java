import models.Mesic;
import models.gui.MainFrame;
import models.interfaces.IMesicniMereni;
import models.interfaces.ITeplota;

public class Main {
    public static void main(String[] args) {
       /*
       * Jsou dána dole zadaná dvě rozhraní ITeplota a IMesicniMereni (věnujte pozornost dokumentačním komentářům).
       * Vaším úkolem je tato rozhraní implementovat třídami tak, aby bylo možné vygenerovat si fiktivní měření
       * teploty (generuj) v jednom měsíci (tj. celkem 31 měření), přičemž pro sousední hodnoty teplot platí,
       * že se liší maximálně o zadaný parametr (range) a zároveň hodnota pro 1. den měření je přesně rovna
       * zadané teplotě (start).
       *
       * Následně vytvořené třídy použijte v aplikaci, která v GUI umožní zadat výše uvedené hodnoty
       * pro generování (start a range) a po stisku tlačítka zobrazí graf teplot, např. pomocí knihovny JFreeChart.
       *
       *
       * Doporučení:
       *
       * 1. Knihovnu do projektu vložte pomocí Mavenu - závislost vypadá takto:
       * <!-- https://mvnrepository.com/artifact/org.jfree/jfreechart -->
        * <dependency>
            * <groupId>org.jfree</groupId>
            * <artifactId>jfreechart</artifactId>
            * <version>1.5.2</version>
        * </dependency>
        *
        *
        * 2. Pro potřebné "ovládnutí" knihovny zkuste tento link na stackoverflow.
        * (https://stackoverflow.com/questions/16714738/xy-plotting-with-java)
       */


        IMesicniMereni leden = new Mesic(1);

//        leden.generuj(1, 10);
//
//
//        for (ITeplota t : leden.asList()) {
//            System.out.println(t);
//        }

        MainFrame appWindow = new MainFrame(1000, 600, leden);


    }
}