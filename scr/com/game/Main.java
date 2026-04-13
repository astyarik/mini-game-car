package com.game;

import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);

        boolean win = false;
        Trans car = new Trans();
        car.speed = 1;
        car.fuel = 40;
        car.name = "Speedr";
        car.crd = new byte[] {0, 0};

        int minX = 10;
        int maxX = 20;
        int minY = 10;
        int maxY = 20;

        int X_fuel = rand.nextInt(maxX - minX + 1) + minX;
        int Y_fuel = rand.nextInt(maxY - minY + 1) + minY;

        while(car.fuel > 0) {

            System.out.println("Координаты:\nX: " + car.crd[0] + "\nY: " + car.crd[1]);
            System.out.println("Вам нужно до\nX: " + X_fuel + "\nY: " + Y_fuel);
            System.out.println("Пойти на:\n1. +X\n2. +Y");

            if (car.crd[0] == X_fuel && car.crd[1] == Y_fuel) {
                win = true;
                break;
            }
            int choise = 0;
            try {
                choise = scan.nextInt();
            }
            catch (Exception e) {
                System.out.println("Введите правильное число!");
                scan.nextLine();
                continue;
            }
            if(choise == 1) {
                car.crd[0] += car.speed;
                car.fuel -= car.speed;
                System.out.println("Ваше топливо: " + car.fuel);
                continue;
            }
            if(choise == 2){
                car.crd[1] += car.speed;
                if (Math.random() < 0.4) {
                    car.fuel -= car.speed + 1;
                    System.out.println("Ой-ой! Из-за неисправности вы потратили на 1л больше!");
                } else {
                    car.fuel -= car.speed;
                }
                System.out.println("Ваше топливо: " + car.fuel);
                continue;
            }
        }
        if (win) {
            System.out.println("Вы выиграли!");
        } else {
            System.out.println("Вы проиграли!");
        }
    }

}
