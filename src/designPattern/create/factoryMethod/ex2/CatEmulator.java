package designPattern.create.factoryMethod.ex2;

public class CatEmulator implements AnimalEmulator {

    @Override
    public Animal create() {
        return new Cat();
    }
}
