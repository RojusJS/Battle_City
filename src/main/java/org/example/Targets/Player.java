package org.example.Targets;

public class Player {

    private int x;
    private int y;
    private int lastDx = 0;
    private int lastDy = 1;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLastDx(int lastDx) {
        this.lastDx = lastDx;
    }

    public void setLastDy(int lastDy) {
        this.lastDy = lastDy;
    }

}
