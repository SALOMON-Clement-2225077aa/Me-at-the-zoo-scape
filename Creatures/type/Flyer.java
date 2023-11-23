package Creatures.type;

public interface Flyer {

    default void fly() {
        System.out.println("The creature is flying");
    }

}
