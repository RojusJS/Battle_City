package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[][] map = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1,},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1,},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1,},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1,},
            {1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1,},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,},
    };

    static Player player = new Player(1, 1);
    static Bullet bullet = new Bullet();

    static List<EnemyTank> enemies = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        enemies.add(new EnemyTank(5, 5));
        enemies.add(new EnemyTank(3, 3));
        enemies.add(new EnemyTank(7, 10));

        while (true) {
            renderMap();
            String input = scanner.nextLine();

            if (!input.isEmpty()) {
                player.move(input.charAt(0), map);
                bullet.shoot(input.charAt(0), player);

                for (EnemyTank enemy : enemies) {
                    enemy.move(map);
                }

                bullet.move(map, enemies);
                for (EnemyTank enemy : enemies) {
                    if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                        System.out.println("Game Over");
                        System.exit(0);
                    }
                }
                if (enemies.isEmpty()) {
                    System.out.println("You win");
                    System.exit(0);
                }
            }
        }
    }

    private static void renderMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                boolean enemyFlag = false;

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
                } else if (map[i][j] == 1) {
                    System.out.print("@");
                } else if (bullet.isActive() && i == bullet.getX() && j == bullet.getY()) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
