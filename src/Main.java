import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws PlantExeption {
        Plant fialka = new Plant("fialka", "",
                LocalDate.of(2023, 10, 18),
                LocalDate.of(2023, 10, 21),
                3);
        PlantManager.addPlant(fialka);
        System.out.println(fialka.getWateringInfo());
        PlantManager.loadFromFile("pl");
        PlantManager.printPlants();
        List<Plant> dat = new ArrayList<>();
        dat.add(fialka);
        PlantManager.loadToFile(dat);
    }
}