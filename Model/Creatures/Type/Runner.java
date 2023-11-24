package Model.Creatures.Type;

public interface Runner {

    default void run() {
        System.out.println("The creature is running");
    }

}
