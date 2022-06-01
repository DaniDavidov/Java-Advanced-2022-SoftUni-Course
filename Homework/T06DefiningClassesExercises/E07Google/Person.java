package T06DefiningClassesExercises.E07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parents> parents;
    private List<Children> children;
    private List<Pokemon> pokemons;

    public Person(String name) {
        this.name = name;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.pokemons = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(name).append("\n");
        stringBuilder.append("Company:").append("\n");
        if (company != null) {
            stringBuilder.append(company).append("\n");
        }
        stringBuilder.append("Car:").append("\n");
        if (car != null) {
            stringBuilder.append(car).append("\n");
        }
        stringBuilder.append("Pokemon:").append("\n");
        for (Pokemon pokemon : pokemons) {
            stringBuilder.append(pokemon).append("\n");
        }
        stringBuilder.append("Parents:").append("\n");
        for (Parents parents : parents) {
            stringBuilder.append(parents).append("\n");
        }
        stringBuilder.append("Children:").append("\n");
        for (Children children : children) {
            stringBuilder.append(children).append("\n");
        }

        return stringBuilder.toString();
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Parents> getParents() {
        return parents;
    }

    public void setParents(List<Parents> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
