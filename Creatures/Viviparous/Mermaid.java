package Creatures.Viviparous;

public class Mermaid extends Viviparous {

    public Mermaid(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {
        System.out.println("SPLOUCH");
    }
}
