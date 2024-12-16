package org.example.Game;

import org.example.Bullets.BulletBase;
import org.example.Bullets.EnemyBullet;
import org.example.Bullets.PlayerBullet;
import org.example.Targets.EnemyTank;
import org.example.Targets.Player;

import java.util.List;
import java.util.Random;

public class Rules {
    private Map map;
    private Player player;
    private List<BulletBase> bullets;
    private List<EnemyTank> enemies;
    private EnemyTank enemyTank;
    private Random random;

    private int moveCounter = 0;

    public Rules(Map map, Player player, List<BulletBase> bullets, List<EnemyTank> enemies, EnemyTank enemyTank, Random random) {
        this.map = map;
        this.player = player;
        this.bullets = bullets;
        this.enemies = enemies;
        this.enemyTank = enemyTank;
        this.random = random;
    }

    public void processInput(char command) {
        if (command == 'a') {
            if (!map.isWall(player.getX(), player.getY() - 1)) {
                player.setY(player.getY() - 1);
                player.setLastDx(0);
                player.setLastDy(-1);
            }
        } else if (command == 'd') {
            if (!map.isWall(player.getX(), player.getY() + 1)) {
                player.setY(player.getY() + 1);
                player.setLastDx(0);
                player.setLastDy(1);
            }
        } else if (command == 'w') {
            if (!map.isWall(player.getX() - 1, player.getY())) {
                player.setX(player.getX() - 1);
                player.setLastDx(-1);
                player.setLastDy(0);
            }
        } else if (command == 's') {
            if (!map.isWall(player.getX() + 1, player.getY())) {
                player.setX(player.getX() + 1);
                player.setLastDx(1);
                player.setLastDy(0);
            }
        } else if (command == 'e') {
            PlayerBullet bullet = new PlayerBullet();
            bullet.setX(player.getX());
            bullet.setY(player.getY());
            bullet.setDirection(player.getLastDx(), player.getLastDy());
            bullet.setActive(true);
            bullets.add(bullet);
        }
    }


    public void progressGameFrame() {
        for (EnemyTank enemy : enemies) {
            BulletBase bullet = enemy.getBullet();
            bullet.move(map, enemies, player);
        }

        for (int i = 0; i < bullets.size(); i++) {
            BulletBase bullet = bullets.get(i);
            bullet.move(map, enemies, player);
            if (!bullet.isActive()) {
                bullets.remove(i);
                i--;
            }
        }

        for (EnemyTank enemy : enemies) {
            enemy.move(map);
            enemy.shootAtPlayer(enemy, player);
        }

        moveCounter++;
        if (moveCounter >= 8) {
            enemyTank.spawnTank(enemies, map, player, random);
            moveCounter = 0;
        }

        if (enemies.isEmpty()){
            System.out.println("You Won");
            System.exit(0);
        }
    }

}
