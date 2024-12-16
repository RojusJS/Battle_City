package org.example.Game;

import org.example.Bullets.BulletBase;
import org.example.Targets.EnemyTank;
import org.example.Targets.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player(1, 1);
        Map map = new Map();
        Random random = new Random();
        List<EnemyTank> enemies = new ArrayList<>();
        List<BulletBase> bullets = new ArrayList<>();
        EnemyTank enemyTank = new EnemyTank(5, 5);

        Rules rules = new Rules(map, player, bullets, enemies, enemyTank, random);
        Renderer renderer = new Renderer(map, enemies, player, bullets);
        enemies.add(new EnemyTank(5, 5));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            renderer.renderMap();
            String input = scanner.nextLine();

            if (input.isEmpty()) {
                continue;
            }
            char command = input.charAt(0);

            rules.processInput(command);
            rules.progressGameFrame();
        }
    }
}
