public class AnimalHierarchy {
    public static void main(String[] args) {
        Dog dog = new Dog("Шарик", "2021-06-10", new String[]{"Голос", "Лежать"});
        Cat cat = new Cat("Барсик", "2022-03-15", new String[]{"Сидеть"});
        Horse horse = new Horse("Буцефал", "2020-05-02", new String[]{"Бег", "Прыжок"});

        dog.makeSound();
        cat.makeSound();
        horse.makeSound();
    }
}
