package org.example;

public class Player {

    private int x;
    private int y;
    private int lastDx = 0;
    private int lastDy = 1;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLastDx() {
        return lastDx;
    }

    public int getLastDy() {
        return lastDy;
    }

    public void move(char command, int[][] map) {
        if (command == 'a'){
            if (map[x][y - 1] != 1) {
                y--;
                lastDx = 0;
                lastDy = -1;
            }
        }
        else if (command == 'd'){
            if (map[x][y + 1] != 1) {
                y++;
                lastDx = 0;
                lastDy = 1;
            }
        }
        else if (command == 's'){
            if (map[x + 1][y] != 1) {
                x++;
                lastDx = 1;
                lastDy = 0;
            }
        }
        else if (command == 'w'){
            if (map[x - 1][y] != 1) {
                x--;
                lastDx = -1;
                lastDy = 0;
            }
        }
    }
}
