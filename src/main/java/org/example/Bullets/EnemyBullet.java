package org.example.Bullets;

import org.example.Targets.EnemyTank;
import org.example.Game.Map;
import org.example.Targets.Player;

public class EnemyBullet extends BulletBase {

    @Override
    public void handleCollision(Map map, Object target) {
        Player player = (Player) target;
        if (x == player.getX() && y == player.getY()) {
            System.out.println("Game Over");
            System.exit(0);
        }
    }

    public void shoot(EnemyTank enemyTank, Player player) {
        if (!isActive()) {
            setX(enemyTank.getX());
            setY(enemyTank.getY());
            if (Math.abs(player.getX() - x) > Math.abs(player.getY() - y)) {
                if (player.getX() > x) {
                    setDirection(1, 0);
                } else {
                    setDirection(-1, 0);
                }
            } else {
                if (player.getY() > y) {
                    setDirection(0, 1);
                } else {
                    setDirection(0, -1);
                }
            }
            setActive(true);
        }
    }
}
