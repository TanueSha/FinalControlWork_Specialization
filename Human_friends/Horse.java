class Horse extends PackAnimals {
    public Horse(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Иго-го!");
    }
}
