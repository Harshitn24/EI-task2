import java.util.ArrayList;
import java.util.List;

public class MarsRoverSimulation {
    public static void main(String[] args) {
        Grid grid = Grid.getInstance(10, 10);
        grid.addObstacle(2, 2); // Add an obstacle at position (3,3)
        grid.addObstacle(3, 5);

        Rover rover = new Rover(0, 0, 'N', grid);

        // List of commands
        List<Command> commands = new ArrayList<>();
        commands.add(new MoveForwardCommand(rover));
        commands.add(new MoveForwardCommand(rover));
        commands.add(new TurnRightCommand(rover));
        commands.add(new MoveForwardCommand(rover));
        commands.add(new MoveForwardCommand(rover));
        // commands.add(new TurnLeftCommand(rover));
        // commands.add(new MoveForwardCommand(rover)); // Example of additional move

        // Execute commands
        for (Command command : commands) {
            command.execute();
        }

        // Print final position and direction
        System.out.println("------------------------------------------------------------");
        System.out.println("Final Positing and Direction");
        rover.getPosition();
    }
}
