class Grid {
    private static Grid instance;
    private int width, height;
    private boolean[][] obstacles;

    private Grid(int width, int height) {
        this.width = width;
        this.height = height;
        this.obstacles = new boolean[width][height];
    }

    public static Grid getInstance(int width, int height) {
        if (instance == null) {
            instance = new Grid(width, height);
        }
        return instance;
    }

    public boolean isObstacle(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) {
            return false;
        }
        return obstacles[x][y];

    }

    public void addObstacle(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height)
            return;
        obstacles[x][y] = true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
