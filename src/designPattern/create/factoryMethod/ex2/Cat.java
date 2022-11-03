package designPattern.create.factoryMethod.ex2;

public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("고양이가 밥을 먹는다. 냠냠 맛있다.");
    }

    @Override
    public void sleep() {
        System.out.println("고양이가 잠을 잔다.");
    }
}
