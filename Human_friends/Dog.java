class Dog extends Pets {
    public Dog(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Гав!");
    }
}