package stacks_queues.animal_shelter;

public abstract class Animal {
    protected String name;
    private int order;

    protected Animal(String name) {
        this.name = name;
    }

    public abstract String name();

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOlderThan(Animal a) {
        return this.order < a.getOrder();
    }
}
