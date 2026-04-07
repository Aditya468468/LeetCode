class Robot {
    int width, height;
    int x, y;
    int dir; // 0=East, 1=North, 2=West, 3=South

    int[][] directions = {
        {1, 0},   // East
        {0, 1},   // North
        {-1, 0},  // West
        {0, -1}   // South
    };

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.dir = 0;
    }

    public void step(int num) {
        int perimeter = 2 * (width + height) - 4;
        num %= perimeter;

        while (num > 0) {
            int nx = x + directions[dir][0];
            int ny = y + directions[dir][1];

            if (nx < 0 || nx >= width || ny < 0 || ny >= height) {
                dir = (dir + 1) % 4;
                continue;
            }

            x = nx;
            y = ny;
            num--;
        }

        // Special case: at origin after full cycle
        if (x == 0 && y == 0 && num == 0) {
            dir = 3; // South
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}