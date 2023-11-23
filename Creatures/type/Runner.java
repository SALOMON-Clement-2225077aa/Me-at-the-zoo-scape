package Creatures.type;

public interface Runner {

    default void run() {
        System.out.println("The creature is running");
    }

}
