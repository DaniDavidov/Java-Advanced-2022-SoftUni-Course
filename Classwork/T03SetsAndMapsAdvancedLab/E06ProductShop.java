package T03SetsAndMapsAdvancedLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shopsByProducts = new TreeMap<>();

        String line = scanner.nextLine();
        while (!line.equals("Revision")) {
            String[] data = line.split(", ");
            String shop = data[0];
            String product = data[1];
            double price = Double.parseDouble(data[2]);

            shopsByProducts.putIfAbsent(shop, new LinkedHashMap<>());
            shopsByProducts.get(shop).put(product, price);

            line = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Double>> entry : shopsByProducts.entrySet()) {
            System.out.println(entry.getKey() + "->");
            entry.getValue().forEach((k, v) -> System.out.printf("Product: %s, Price: %.1f%n", k, v));
        }

    }
}
