import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
}

class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() {
        return quantity * product.getPrice();
    }
}

class Cart {
    private ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        items.add(new CartItem(product, quantity));
    }

    public void showCart() {
        double total = 0;
        System.out.println("\n🛒 Cart Items:");
        for (CartItem item : items) {
            System.out.println(item.getProduct().getName() + " x" + item.getQuantity() +
                    " = ₹" + item.getTotalPrice());
            total += item.getTotalPrice();
        }
        System.out.println("Total: ₹" + total);
    }
}

public class OnlineShoppingCartApp {
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "T-Shirt", 499),
            new Product(2, "Jeans", 999),
            new Product(3, "Shoes", 1299)
        };

        Cart cart = new Cart();
        Scanner sc = new Scanner(System.in);

        System.out.println("🛍 Welcome to Online Shop");
        while (true) {
            System.out.println("\nAvailable Products:");
            for (Product p : products) {
                System.out.println(p.getId() + ". " + p.getName() + " - ₹" + p.getPrice());
            }
            System.out.print("Enter product ID to add to cart (0 to checkout): ");
            int id = sc.nextInt();
            if (id == 0) break;

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            for (Product p : products) {
                if (p.getId() == id) {
                    cart.addItem(p, qty);
                }
            }
        }

        cart.showCart();
        sc.close();
    }
}

