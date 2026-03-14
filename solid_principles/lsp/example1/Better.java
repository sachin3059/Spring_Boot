package lsp.example1;

interface Flyable {
    void fly();
}

class Sparrow implements Flyable {
    public void fly() {
        System.out.println("Flying");
    }
}

class Penguin {
    void swim() {
        System.out.println("Swimming");
    }
}


public class Better {
    public static void main(String[] args) {
        Flyable sparrow = new Sparrow();
        sparrow.fly(); // Works fine

        Penguin penguin = new Penguin();
        penguin.swim(); // Works fine
    }
}
