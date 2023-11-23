package Creatures.Viviparous;

public class Nymph extends Viviparous {

    public Nymph(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {
        System.out.println("");
    }
}
