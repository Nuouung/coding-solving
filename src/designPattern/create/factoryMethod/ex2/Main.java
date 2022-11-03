package designPattern.create.factoryMethod.ex2;

import java.util.Scanner;

public class Main {

    private static AnimalEmulator animalEmulator;

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        configure(in.nextLine());

        Animal animal = animalEmulator.create();

        if (animal instanceof Dog) {
            System.out.println("강아지를 고르셨군요!");
        } else if (animal instanceof Cat) {
            System.out.println("고양이를 고르셨군요!");
        }

        animal.eat();
        animal.sleep();
    }

    private static void configure(String command) throws Exception {
        if (command == null || command.equals("")) throw new Exception("명령어를 입력해주세요");

        if (command.equals("강아지 만들어줘")) {
            animalEmulator = new DogEmulator();
        } else if (command.equals("고양이 만들어줘")) {
            animalEmulator = new CatEmulator();
        } else {
            throw new Exception("'강아지 만들어줘' 혹은 '고양이 만들어줘'의 명령어만 허용 가능합니다.");
        }
    }
}
