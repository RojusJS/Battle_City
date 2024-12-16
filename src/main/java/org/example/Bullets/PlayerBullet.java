package org.example.Bullets;

import org.example.Targets.EnemyTank;
import org.example.Game.Map;

import java.util.List;

public class PlayerBullet extends BulletBase {

    @Override
    public void handleCollision(Map map, Object target) {
        List<?> enemies = (List<?>) target;
        for (int i = 0; i < enemies.size(); i++) {
            EnemyTank enemy = (EnemyTank) enemies.get(i);
            if (x == enemy.getX() && y == enemy.getY()) {
                System.out.println("Enemy hit");
                enemies.remove(i);
                setActive(false);
                break;
            }
        }
    }
}
