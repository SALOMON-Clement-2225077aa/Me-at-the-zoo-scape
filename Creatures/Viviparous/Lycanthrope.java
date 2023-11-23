package Creatures.Viviparous;

public class Lycanthrope extends Viviparous {

    public Lycanthrope(String species, String gender, double weight, double size, int age) {
        super(species, gender, weight, size, age);
    }

    @Override
    public void makeSound() {
        System.out.println("WAF WAF WAF");
    }

}
