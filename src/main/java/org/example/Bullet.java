package org.example;

import java.util.List;

public class Bullet {
    private int x = -1;
    private int y = -1;
    private int dx = 0;
    private int dy = 0;

    private boolean active = false;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isActive() {
        return active;
    }

    public void shoot(char command, Player player) {
        if (command == 'e' && !active) {
            x = player.getX();
            y = player.getY();
            dx = player.getLastDx();
            dy = player.getLastDy();
            active = true;
        }
    }

    public void move(int[][] map, List<EnemyTank> enemies) {
        if (active) {
            for (int i = 0; i < 2; i++) {
                x += dx;
                y += dy;

                if (map[x][y] == 1) {
                    active = false;
                    break;
                } else {
                    for (EnemyTank enemy : enemies) {
                        if (x == enemy.getX() && y == enemy.getY()) {
                            System.out.println("Enemy hit");
                            enemies.remove(enemy);
                            active = false;
                            break;
                        }
                    }
                }
            }
        }
    }
}
