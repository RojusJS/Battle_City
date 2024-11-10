package org.example;

import java.util.Random;

public class EnemyTank {
    private int x;
    private int y;
    private Random random = new Random();

    public EnemyTank(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void move(int[][] map) {
        int direction = random.nextInt(4);
        if (direction == 0 && map[x - 1][y] != 1)
            x--;
        else if (direction == 1 && map[x + 1][y] != 1)
            x++;
        else if (direction == 2 && map[x][y - 1] != 1)
            y--;
        else if (direction == 3 && map[x][y + 1] != 1)
            y++;
    }
}
