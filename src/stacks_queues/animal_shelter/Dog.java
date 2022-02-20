package stacks_queues.animal_shelter;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public String name() {
        return "Dog: " + name;
    }
}
