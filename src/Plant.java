import java.time.LocalDate;

public class Plant implements Comparable<Plant> {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequency;
    private static final String reg = ";";

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequency) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        if (frequency < 0) {
            try {
                throw new PlantExeption("frakvence nesmi bit zaporna: " + frequency);
            } catch (PlantExeption e) {
                throw new RuntimeException(e);
            }
        }
        this.frequency = frequency;
    }

    public Plant(String name, LocalDate planted, int frequency) {
        this.name = name;
        this.notes = "";
        this.planted = planted;
        this.watering = LocalDate.now();
        if (frequency < 0) {
            try {
                throw new PlantExeption("frakvence nesmi bit zaporna: " + frequency);
            } catch (PlantExeption e) {
                throw new RuntimeException(e);
            }
        }
        this.frequency = frequency;
    }

    public Plant(String name) {
        this.name = name;
        this.notes = "";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequency = 7;
    }


    @Override
    public String toString() {
        return name + reg + "\t"+ notes + reg+"\t" + planted+ reg +"\t" + watering + reg +"\t" + frequency;
    }

    public String getName() {
        return name;
    }

    public String getNotes() {
        return notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public void setWatering(LocalDate watering) throws PlantExeption {
        if (watering.isBefore((planted))) {
            try {
                throw new PlantExeption("rostlina nesmi bit zalita pred zasezenim");
            } catch (PlantExeption e) {
                throw new RuntimeException(e);
            }
        }
        this.watering = watering;
    }

    public void setFrequency(int frequency) throws PlantExeption {
        if (frequency < 0) {
            try {
                throw new PlantExeption("frakvence nesmi bit zaporna: " + frequency);
            } catch (PlantExeption e) {
                throw new RuntimeException(e);
            }
        }
        this.frequency = frequency;

    }

    public String getWateringInfo() {
        LocalDate nextwatering = watering.plusDays(frequency);
        return name + " posledni zaliti: " + planted + " zalij: " + nextwatering;
    }
    @Override
    public int compareTo(Plant second) {
        return this.name.compareTo(second.name);
    }
}



