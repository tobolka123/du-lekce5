import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class PlantManager {
    private static List<Plant> listPlants = new ArrayList<>();
    public static final String OUTPUT_FILE = "rostlina.txt";


    private static Plant parsePlant(String line, int lineNumber) throws PlantExeption {
        String[] blocks = line.split(";");
        int numOfBlocks = blocks.length;
        if (numOfBlocks != 5) {
            throw new PlantExeption(
                    "Nesprávný počet položek na řádku: " + line +
                            "! Počet položek: " + numOfBlocks + ".");
        }
        String name;
        String description;
        name = blocks[0].trim();
        description = blocks[1].trim();
        LocalDate planted;
        try {
            planted = LocalDate.parse(blocks[2].trim());
        } catch (DateTimeParseException e) {
            throw new PlantExeption("Chybne zadane datum" + blocks[2]);
        }
        LocalDate watering;
        try {
            watering = LocalDate.parse(blocks[3].trim());
        } catch (DateTimeParseException e) {
            throw new PlantExeption("Chybne zadane datum" + blocks[3]);
        }
        int frequency;
        try {
            frequency = Integer.parseInt(blocks[4].trim());
        } catch (NumberFormatException e) {
            throw new PlantExeption("Chybně zadané číslo " + blocks[4] + " na řádku č. " + lineNumber + ": " + line + "!");
        }
        Plant newPlant = new Plant(name, description, planted, watering, frequency);
        return newPlant;
    }

    public static void addPlant(Plant plant) {
        listPlants.add(plant);
    }

    public static void loadFromFile(String filename) throws PlantExeption {
        int lineNumber = 1;
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(filename)))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                listPlants.add(parsePlant(line, lineNumber));
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            throw new PlantExeption("Nepodařilo se nalézt soubor " + filename + ": " + e.getLocalizedMessage());
        }
    }

    public static void loadToFile(List<Plant> dataToWrite) throws PlantExeption {
        try (PrintWriter outputWriter = new PrintWriter(new BufferedWriter(new FileWriter(OUTPUT_FILE)))) {
            for (Plant plant : dataToWrite) {
                outputWriter.println(plant);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printPlants () {
        for (Object lis : listPlants) {
            System.out.println(lis);
        }
    }
    public static void sort(){
        Collections.sort(listPlants);
    }
    public static void sortWatering() {
        Collections.sort(listPlants, new PlantWateringComparator());
    }
}

