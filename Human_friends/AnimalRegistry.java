import java.util.*;

public class AnimalRegistry {
    private static List<Animal> animals = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить животное");
            System.out.println("2. Показать команды животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Показать список животных по дате рождения");
            System.out.println("5. Показать общее количество животных");
            System.out.println("6. Выход");
            System.out.print("Выберите действие: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1 -> addAnimal();
                case 2 -> showAnimalCommands();
                case 3 -> trainAnimal();
                case 4 -> showAnimalsByBirthDate();
                case 5 -> System.out.println("Общее количество животных: " + Animal.getAnimalCount());
                case 6 -> System.exit(0);
                default -> System.out.println("Неверный выбор, попробуйте снова.");
            }
        }
    }

    private static void addAnimal() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (гггг-мм-дд): ");
        String birthDate = scanner.nextLine();
        System.out.print("Введите тип животного (Dog, Cat, Hamster, Horse, Donkey): ");
        String type = scanner.nextLine();

        Animal animal = switch (type.toLowerCase()) {
            case "dog" -> new Dog(name, birthDate, new String[]{"Сидеть", "Лежать"});
            case "cat" -> new Cat(name, birthDate, new String[]{"Мяукать", "Спать"});
            case "hamster" -> new Hamster(name, birthDate, new String[]{"Бегать по кругу"});
            case "horse" -> new Horse(name, birthDate, new String[]{"Бег", "Прыжок"});
            case "donkey" -> new Donkey(name, birthDate, new String[]{"Нести груз"});
            default -> {
                System.out.println("Неизвестный тип животного.");
                yield null;
            }
        };
        
        if (animal != null) {
            animals.add(animal);
            System.out.println("Животное добавлено!");
        }
    }

    private static void showAnimalCommands() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        animals.stream().filter(a -> a.name.equals(name)).findFirst()
                .ifPresentOrElse(Animal::showCommands, () -> System.out.println("Животное не найдено."));
    }

    private static void trainAnimal() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите новую команду: ");
        String newCommand = scanner.nextLine();
        animals.stream().filter(a -> a.name.equals(name)).findFirst()
                .ifPresentOrElse(a -> {
                    a.addCommand(newCommand);
                    System.out.println("Команда добавлена!");
                }, () -> System.out.println("Животное не найдено."));
    }

    private static void showAnimalsByBirthDate() {
        animals.stream().sorted(Comparator.comparing(a -> a.birthDate))
                .forEach(a -> System.out.println(a.name + " (Дата рождения: " + a.birthDate + ")"));
    }
}
