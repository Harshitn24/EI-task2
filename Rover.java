// Command Interface
interface Command {
    void execute();
}

// Rover class with basic movements
class Rover {
    private int x, y;
    private char direction; // 'N', 'E', 'S', 'W'
    private Grid grid;

    public Rover(int x, int y, char direction, Grid grid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.grid = grid;
    }

    public void moveForward() {
        switch (direction) {
            case 'N':
                if (grid.isObstacle(x, y + 1) || y + 1 >= grid.getHeight()) {
                    System.out.println("Obstacle Detected!!! Move Not Counted!!");
                    break;
                }
                y++;
                break;
            case 'S':
                if (grid.isObstacle(x, y - 1) || y - 1 < 0) {
                    System.out.println("Obstacle Detected!!! Move Not Counted!!");
                    break;
                }
                y--;
                break;
            case 'E':
                if (grid.isObstacle(x + 1, y) || x + 1 >= grid.getWidth()) {
                    System.out.println("Obstacle Detected!!! Move Not Counted!!");
                    break;
                }
                x++;
                break;
            case 'W':
                if (grid.isObstacle(x - 1, y) || x - 1 < 0) {
                    System.out.println("Obstacle Detected!!! Move Not Counted!!");
                    break;
                }
                x--;
                break;
        }
        System.out.println("Rover moved to: (" + x + ", " + y + ")");
    }

    public void turnLeft() {
        direction = switch (direction) {
            case 'N' -> 'W';
            case 'W' -> 'S';
            case 'S' -> 'E';
            case 'E' -> 'N';
            default -> direction;
        };
        System.out.println("Rover facing: " + direction);
    }

    public void turnRight() {
        direction = switch (direction) {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> direction;
        };
        System.out.println("Rover facing: " + direction);
    }

    public void getPosition() {
        System.out.println("Rover is at: (" + x + ", " + y + ") facing " + direction);
    }
}

// Concrete command classes for the rover actions
class MoveForwardCommand implements Command {
    private Rover rover;

    public MoveForwardCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.moveForward();
    }
}

class TurnLeftCommand implements Command {
    private Rover rover;

    public TurnLeftCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnLeft();
    }
}

class TurnRightCommand implements Command {
    private Rover rover;

    public TurnRightCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.turnRight();
    }
}

class GetPosition implements Command {
    private Rover rover;

    public GetPosition(Rover rover) {
        rover.getPosition();
    }

    @Override
    public void execute() {
        rover.getPosition();
    }
}
