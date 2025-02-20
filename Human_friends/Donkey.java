class Donkey extends PackAnimals {
    public Donkey(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " говорит: И-а!");
    }
}