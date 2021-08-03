package ru.skillbox;

public class Country {
    private String name;
    private int population;
    private int areaInSquareKilometers;
    private String capitalName;
    private boolean accessToTheSea;

    public Country(String name, int population, int areaInSquareKilometers, String capitalName, boolean accessToTheSea) {
        this.name = name;
        this.population = population;
        this.areaInSquareKilometers = areaInSquareKilometers;
        this.capitalName = capitalName;
        this.accessToTheSea = accessToTheSea;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getAreaInSquareKilometers() {
        return areaInSquareKilometers;
    }

    public void setAreaInSquareKilometers(int areaInSquareKilometers) {
        this.areaInSquareKilometers = areaInSquareKilometers;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }

    public boolean isAccessToTheSea() {
        return accessToTheSea;
    }

    public void setAccessToTheSea(boolean accessToTheSea) {
        this.accessToTheSea = accessToTheSea;
        System.out.println(isAccessToTheSea() ? ("Yes") : ("No"));
    }

}
