package lsp.example1;

class Bird {
    void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {
    void fly() {
        throw new UnsupportedOperationException("Penguins can't fly");
    }
}

public class Problematic {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly(); // Works fine

        Bird penguin = new Penguin();
        penguin.fly(); // Throws UnsupportedOperationException
    }
}
