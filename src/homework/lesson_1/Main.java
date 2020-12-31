package homework.lesson_1;

public class Main {
    public static final int BOUND = 100;
    public static void main(String[] args) {
        // Спортсмены
        IAthlete[] athletes = new IAthlete[] {
                new Human("Петя", BOUND),
                new Cat("Муся", BOUND),
                new Robot("Микро", BOUND),
                new Human("Саша", BOUND),
                new Cat("Киса", BOUND),
                new Robot("Дройд", BOUND),
                new Human("Вася", BOUND),
                new Cat("Барсик", BOUND),
                new Robot("Трон", BOUND)
        };
        // Препятствия
        System.out.println("-----Преодоления препятствий-----");
        ILet[] lets = new ILet[] {
                new Treadmill(EAction.Run, BOUND),
                new Wall(EAction.Jump, BOUND),
                new Treadmill(EAction.Run, BOUND),
                new Wall(EAction.Jump, BOUND),
                new Treadmill(EAction.Run, BOUND),
                new Wall(EAction.Jump, BOUND),
                new Treadmill(EAction.Run, BOUND),
                new Wall(EAction.Jump, BOUND)
        };
        // Спортсмены преодолевают препятствия
        for (ILet let : lets)
            for (IAthlete athlete: athletes)
                athlete.letsMake(let);
        // Итоги соревнований
        System.out.println("--------------Итоги--------------");
        for (IAthlete athlete: athletes)
            athlete.printStatus();
    }
}
