class Hamster extends Pets {
    public Hamster(String name, String birthDate, String[] commands) {
        super(name, birthDate, commands);
    }
    @Override
    public void makeSound() {
        System.out.println(name + " издаёт пищащие звуки!");
    }
}
