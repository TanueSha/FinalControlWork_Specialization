class Cat extends Pets {
    public Cat(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " говорит: Мяу!");
    }
}
