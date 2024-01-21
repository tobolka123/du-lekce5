import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws PlantExeption {
        Plant fialka = new Plant("eialka", "",
                LocalDate.of(2023, 10, 18),
                LocalDate.of(2023, 10, 21),
                3);
        PlantManager.addPlant(fialka);
        System.out.println(fialka.getWateringInfo());
        PlantManager.loadFromFile("pl");
        PlantManager.printPlants();
        System.out.println("\n");
        List<Plant> dat = new ArrayList<>();
        dat.add(fialka);
        PlantManager.loadToFile(dat);
        PlantManager.loadFromFile("rostlina.txt");
        PlantManager.sort();
        PlantManager.printPlants();
        System.out.println("\n");
        PlantManager.sortWatering();
    }
}