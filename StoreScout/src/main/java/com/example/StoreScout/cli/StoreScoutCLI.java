package com.example.StoreScout.cli;

import com.example.StoreScout.service.StoreScoutService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class StoreScoutCLI implements CommandLineRunner {

    private final StoreScoutService service;

    public StoreScoutCLI(StoreScoutService service) {
        this.service = service;
    }

    @Override
    public void run(String... args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("🛒 Welcome to StoreScout CLI");
        System.out.println("Type 'help' for commands");

        while (true) {
            System.out.print("storescout> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) continue;

            String[] cmd = input.split(" ");

            try {
                switch (cmd[0]) {
                    case "list" -> service.listProducts();
                    case "view" -> service.viewProduct(Integer.parseInt(cmd[1]));
                    case "categories" -> service.categories();
                    case "category" -> service.byCategory(cmd[1]);
                    case "help" -> showHelp();
                    case "exit" -> {
                        System.out.println("👋 Exiting StoreScout");
                        System.exit(0);
                    }
                    default -> System.out.println("❌ Unknown command. Type 'help'.");
                }
            } catch (Exception e) {
                System.out.println("⚠ Error: " + e.getMessage());
            }
        }
    }

    private void showHelp() {
        System.out.println("""
                Commands:
                list                   → List all products
                view <id>             → View product by id
                categories             → List categories
                category <name>        → Products by category
                help                   → Show help
                exit                   → Exit
                """);
    }
}
