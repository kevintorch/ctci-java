package stacks_queues.animal_shelter;

import java.util.LinkedList;

public class AnimalQueue {
    private final LinkedList<Dog> dogs = new LinkedList<>();
    private final LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0;

    public void enqueue(Animal animal) {
        order++;
        animal.setOrder(order);

        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    public Animal dequeueAny() {
        if (dogs.isEmpty()) return dequeueCat();
        if (cats.isEmpty()) return dequeueDog();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) {
            return dequeueDog();
        } else {
            return dequeueCat();
        }
    }

    public Animal peek() {
        if (dogs.isEmpty()) return cats.peek();
        if (cats.isEmpty()) return dogs.peek();

        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)) return dog;
        else return cat;
    }

    public Dog dequeueDog() {
        return dogs.pollFirst();
    }

    public Cat dequeueCat() {
        return cats.pollFirst();
    }

    public int size() {
        return cats.size() + dogs.size();
    }

}
