package org.example.Tests;

import org.example.Game.Map;
import org.example.Targets.Player;
import org.example.Bullets.BulletBase;
import org.example.Targets.EnemyTank;
import org.example.Game.Rules;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TankSpawningTest {

    @Test
    public void testTankSpawnsAfterEightMoves() {
        Map map = new Map();
        Player player = new Player(1, 1);
        List<BulletBase> bullets = new ArrayList<>();
        List<EnemyTank> enemies = new ArrayList<>();
        Rules rules = new Rules(map, player, bullets, enemies, new EnemyTank(5, 5), new Random());
        enemies.add(new EnemyTank(5, 5));

        for (int i = 0; i < 8; i++) {
            rules.progressGameFrame();
        }

        assertEquals(2, enemies.size());
    }
}
