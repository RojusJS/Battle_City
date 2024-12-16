package org.example.Tests;

import org.example.Targets.EnemyTank;
import org.example.Game.Map;
import org.example.Targets.Player;
import org.example.Game.Rules;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMovementTest {

    @Test
    public void testPlayerDoesNotMoveIntoWall() {
        Map map = new Map();
        Player player = new Player(1, 1);
        Rules rules = new Rules(map, player, new ArrayList<>(), new ArrayList<>(), new EnemyTank(5, 5), new Random());

        rules.processInput('a');

        assertEquals(1, player.getX());
        assertEquals(1, player.getY());
    }
}
