package org.example.Tests;

import org.example.Bullets.BulletBase;
import org.example.Game.Map;
import org.example.Game.Rules;
import org.example.Targets.EnemyTank;
import org.example.Targets.Player;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerShootingTest {

    @Test
    public void testPlayerShootsBulletRight() {
        Map map = new Map();
        Player player = new Player(1, 1);
        List<BulletBase> bullets = new ArrayList<>();
        Rules rules = new Rules(map, player, bullets, new ArrayList<>(), new EnemyTank(5, 5), new Random());

        player.setLastDx(0);
        player.setLastDy(1);
        rules.processInput('e');

        assertEquals(1, bullets.size());
        BulletBase bullet = bullets.get(0);

        assertTrue(bullet.isActive());
        assertEquals(1, bullet.getX());
        assertEquals(1, bullet.getY());
        assertEquals(0, bullet.getDx());
        assertEquals(1, bullet.getDy());
    }
}
