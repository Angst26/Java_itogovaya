import java.util.*;

public class LaptopStore {
    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>(Arrays.asList(
                new Laptop("Dell", "XPS 13", 16, 512, "Windows", "Silver"),
                new Laptop("Apple", "MacBook Air", 8, 256, "macOS", "Space Gray"),
                new Laptop("Lenovo", "ThinkPad X1", 16, 1024, "Windows", "Black"),
                new Laptop("HP", "Spectre x360", 16, 512, "Windows", "Blue")
        ));

        filterLaptops(laptops);
    }
    public static void filterLaptops(Set<Laptop> laptops) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> filterCriteria = new HashMap<>();

        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - ОЗУ");
        System.out.println("2 - Объем ЖД");
        System.out.println("3 - Операционная система");
        System.out.println("4 - Цвет");

        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                System.out.println("Введите минимальное значение ОЗУ:");
                filterCriteria.put("ram", scanner.nextLine());
                break;
            case "2":
                System.out.println("Введите минимальный объем ЖД:");
                filterCriteria.put("storage", scanner.nextLine());
                break;
            case "3":
                System.out.println("Введите операционную систему:");
                filterCriteria.put("os", scanner.nextLine());
                break;
            case "4":
                System.out.println("Введите цвет:");
                filterCriteria.put("color", scanner.nextLine());
                break;
            default:
                System.out.println("Некорректный ввод.");
                return;
        }

        for (Laptop laptop : laptops) {
            boolean matches = true;
            for (Map.Entry<String, String> entry : filterCriteria.entrySet()) {
                switch (entry.getKey()) {
                    case "ram":
                        if (laptop.getRam() < Integer.parseInt(entry.getValue())) {
                            matches = false;
                        }
                        break;
                    case "storage":
                        if (laptop.getStorage() < Integer.parseInt(entry.getValue())) {
                            matches = false;
                        }
                        break;
                    case "os":
                        if (!laptop.getOperatingSystem().equalsIgnoreCase(entry.getValue())) {
                            matches = false;
                        }
                        break;
                    case "color":
                        if (!laptop.getColor().equalsIgnoreCase(entry.getValue())) {
                            matches = false;
                        }
                        break;
                }
            }
            if (matches) {
                System.out.println(laptop);
            }
        }
    }
}
