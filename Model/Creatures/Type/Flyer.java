package Model.Creatures.Type;

public interface Flyer {

    default void fly() {
        System.out.println("The creature is flying");
    }

}
