package Creatures.Type;

public interface Swimmer {

    default void swim() {
        System.out.println("The creature is swimming");
    }

}
