package desktoprestconsumer.model.Rest;

public class PersonWithCoincidences {
    private String name;
    private int coincidences;

    public void setName(String name) {
        this.name = name;
    }

    public void setCoincidences(int coincidences) {
        this.coincidences = coincidences;
    }

    public String getName() {
        return name;
    }

    public int getCoincidences() {
        return coincidences;
    }
}