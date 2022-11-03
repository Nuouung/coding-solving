package designPattern.create.factoryMethod.ex2;

public class DogEmulator implements AnimalEmulator {
    @Override
    public Animal create() {
        return new Dog();
    }
}
