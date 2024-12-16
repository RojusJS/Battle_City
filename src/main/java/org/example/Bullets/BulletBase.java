package org.example.Bullets;

import org.example.Game.Map;
import org.example.Targets.EnemyTank;
import org.example.Targets.Player;

import java.util.List;


public abstract class BulletBase {
    protected int x = -1;
    protected int y = -1;
    protected int dx = 0;
    protected int dy = 0;
    protected boolean active = false;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setDirection(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }

    public void move(Map map, List<EnemyTank> enemies, Player player) {
        if (active) {
            for (int i = 0; i < 2; i++) {
                x += dx;
                y += dy;

                if (x < 0 || x >= map.getHeight() || y < 0 || y >= map.getWidth() || map.isWall(x, y)) {
                    active = false;
                    break;
                }

                if (this instanceof PlayerBullet) {
                    handleCollision(map, enemies);
                } else if (this instanceof EnemyBullet) {
                    handleCollision(map, player);
                }

                if (!active) {
                    break;
                }
            }
        }
    }

    public abstract void handleCollision(Map map, Object target);
}
