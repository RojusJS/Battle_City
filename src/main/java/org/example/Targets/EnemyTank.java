package org.example.Targets;

import org.example.Bullets.EnemyBullet;
import org.example.Game.Map;

import java.util.List;
import java.util.Random;

public class EnemyTank {
    private int x;
    private int y;
    private Random random = new Random();
    private EnemyBullet enemyBullet = new EnemyBullet();
    private int shootCooldown = 0;

    public EnemyTank(int x, int y) {
        this.x = x;
        this.y = y;
    }

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

    public EnemyBullet getBullet() {
        return enemyBullet;
    }

    public int getRandomDirection(){
        return random.nextInt(4);
    }

    public int getShootCooldown() {
        return shootCooldown;
    }

    public void setShootCooldown(int shootCooldown) {
        this.shootCooldown = shootCooldown;
    }

    public void move(Map map) {
        if (getRandomDirection() == 0 && !map.isWall(getX() - 1, getY()))
            setX(getX() - 1); // i virsu
        else if (getRandomDirection() == 1 && !map.isWall(getX() + 1, getY()))
            setX(getX() + 1); // i apacia
        else if (getRandomDirection() == 2 && !map.isWall(getX(), getY() - 1))
            setY(getY() - 1); // i kaire
        else if (getRandomDirection() == 3 && !map.isWall(getX(), getY() + 1))
            setY(getY() + 1); // i desine
    }

    public void shootAtPlayer(EnemyTank enemyTank, Player player) {
        if (getShootCooldown() == 0) {
            enemyBullet.shoot(enemyTank, player);
            setShootCooldown(4);
        } else {
            setShootCooldown(getShootCooldown() - 1);
        }
    }
    public void spawnTank(List<EnemyTank> enemies, Map map, Player player, Random random) {
        if (enemies.size() < 4) {
            int newX, newY;
            do {
                newX = random.nextInt(map.getHeight());
                newY = random.nextInt(map.getWidth());
            } while (map.isWall(newX, newY) || (newX == player.getX() && newY == player.getY()));
            enemies.add(new EnemyTank(newX, newY));
        }
    }

}
