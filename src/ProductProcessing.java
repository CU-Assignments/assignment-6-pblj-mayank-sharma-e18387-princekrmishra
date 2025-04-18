import java.util.*;
import java.util.stream.*;

class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return name + " - " + category + " - ₹" + price;
    }
}

public class ProductProcessing {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 75000),
            new Product("Smartphone", "Electronics", 45000),
            new Product("Desk", "Furniture", 15000),
            new Product("Chair", "Furniture", 5000),
            new Product("Book", "Stationery", 300)
        );

        // Group by category
        System.out.println("Products Grouped by Category:");
        Map<String, List<Product>> grouped = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        grouped.forEach((category, items) -> {
            System.out.println(category + ": " + items);
        });

        // Most expensive product in each category
        System.out.println("\nMost Expensive Product in Each Category:");
        Map<String, Optional<Product>> maxByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))));
        maxByCategory.forEach((cat, prod) -> System.out.println(cat + ": " + prod.get()));

        // Average price
        double average = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);
        System.out.println("\nAverage Price of All Products: ₹" + average);
    }
}
