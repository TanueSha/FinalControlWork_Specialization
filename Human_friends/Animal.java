abstract class Animal {
    protected String name;
    protected String birthDate;
    protected String[] commands;
    private static int animalCount = 0;

    public Animal(String name, String birthDate, String[] commands) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
        animalCount++;
    }

    public abstract void makeSound();

    public static int getAnimalCount() {
        return animalCount;
    }

    public void addCommand(String newCommand) {
        String[] newCommands = new String[this.commands.length + 1];
        System.arraycopy(this.commands, 0, newCommands, 0, this.commands.length);
        newCommands[this.commands.length] = newCommand;
        this.commands = newCommands;
    }

    public void showCommands() {
        System.out.println(name + " умеет: " + String.join(", ", commands));
    }
}
