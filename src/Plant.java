import java.time.LocalDate;

public class Plant {
    private String name;
    private String notes;
    private LocalDate planted;
    private LocalDate watering;
    private int frequency;

    public Plant(String name, String notes, LocalDate planted, LocalDate watering, int frequency) {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        this.watering = watering;
        this.frequency = frequency;
    }
    public Plant(String name, LocalDate planted, int frequency) {
        this.name = name;
        this.notes = "";
        this.planted = planted;
        this.watering = LocalDate.now();
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
        return
                "Jmeno: '" + name + '\'' +
                ", notes: '" + notes + '\'' +
                ", zasezeno: " + planted +
                ", naposledy zalito: " + watering +
                ", frekvence zalevani: " + frequency;
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


    public String getWateringInfo() {
        LocalDate nextwatering = watering.plusDays(frequency);
        return name+" posledni zaliti: "+planted+" zalij: "+nextwatering;
    }
}
