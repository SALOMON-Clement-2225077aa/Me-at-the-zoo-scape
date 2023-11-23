package Creatures.Oviparous;

public class Dragon extends Oviparous {

    public Dragon(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {
        System.out.println("AGROUUUUUUUUUUUUU");
    }
}