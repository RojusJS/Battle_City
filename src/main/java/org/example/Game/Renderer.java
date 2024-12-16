package org.example.Game;

import org.example.Bullets.BulletBase;
import org.example.Bullets.EnemyBullet;
import org.example.Targets.EnemyTank;
import org.example.Targets.Player;

import java.util.List;

public class Renderer {
    private Map map;
    private List<EnemyTank> enemies;
    private Player player;
    private List<BulletBase> bullets;

    boolean enemyFlag = false;
    boolean playerBulletFlag = false;
    boolean enemyBulletFlag = false;

    public Renderer(Map map, List<EnemyTank> enemies, Player player, List<BulletBase> bullets) {
        this.map = map;
        this.enemies = enemies;
        this.player = player;
        this.bullets = bullets;
    }

    public void renderMap() {
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                enemyFlag = false;
                for (EnemyTank enemy : enemies) {
                    if (i == enemy.getX() && j == enemy.getY()) {
                        System.out.print("E");
                        enemyFlag = true;
                    }
                }
                if (i == player.getX() && j == player.getY()) {
                    System.out.print("P");
                } else if (enemyFlag) {
                    continue;
                } else if (map.map[i][j] == 1) {
                    if (map.isWall(i, j)) {
                        System.out.print("@");
                    } else {
                        System.out.print(" ");
                    }
                } else {
                    playerBulletFlag = false;
                    renderPlayerBullets(i, j);
                    if (!playerBulletFlag) {
                        enemyBulletFlag = false;
                        renderEnemiesBullets(i, j);
                        if (!enemyBulletFlag) {
                            System.out.print(" ");
                        }
                    }
                }
            }
            System.out.println();
        }
    }

    private void renderPlayerBullets(int i, int j) {
        for (BulletBase bullet : bullets) {
            if (bullet.isActive() && i == bullet.getX() && j == bullet.getY()) {
                System.out.print("*");
                playerBulletFlag = true;
                break;
            }
        }
    }

    private void renderEnemiesBullets(int i, int j) {
        for (EnemyTank enemy : enemies) {
            EnemyBullet enemyBullet = enemy.getBullet();
            if (enemyBullet.isActive() && i == enemyBullet.getX() && j == enemyBullet.getY()) {
                System.out.print("+");
                enemyBulletFlag = true;
                break;
            }
        }
    }
}
