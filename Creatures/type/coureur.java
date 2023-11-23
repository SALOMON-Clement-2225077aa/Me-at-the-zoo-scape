package Creatures.type;

public interface coureur {

    default void run() {
        System.out.println("The creature is running");
    }

}
