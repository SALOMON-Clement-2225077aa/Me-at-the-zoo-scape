package Creatures.type;

public interface volant {

    default void fly() {
        System.out.println("The creature is flying");
    }

}
