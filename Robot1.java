public class Robot1 {
    public static void main(String[] args) {
        Robot robot = new Robot(3,4, Direction.UP);
        moveRobot(robot,6 , 4);
    }
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
    public static class Robot {
        int x;
        int y;
        Direction dir;
        public Robot (int x, int y, Direction dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
        public Direction getDirection() {return dir;}
        public int getX() {return x;}
        public int getY() {return y;}
        public void turnLeft() {
            if      (dir == Direction.UP)    {dir = Direction.LEFT;}
            else if (dir == Direction.DOWN)  {dir = Direction.RIGHT;}
            else if (dir == Direction.LEFT)  {dir = Direction.DOWN;}
            else if (dir == Direction.RIGHT) {dir = Direction.UP;}
        }
        public void turnRight() {
            if      (dir == Direction.UP)    {dir = Direction.RIGHT;}
            else if (dir == Direction.DOWN)  {dir = Direction.LEFT;}
            else if (dir == Direction.LEFT)  {dir = Direction.UP;}
            else if (dir == Direction.RIGHT) {dir = Direction.DOWN;}
        }
        public void stepForward() {
            if (dir == Direction.UP)    {y++;}
            if (dir == Direction.DOWN)  {y--;}
            if (dir == Direction.LEFT)  {x--;}
            if (dir == Direction.RIGHT) {x++;}
        }
    }
    public static void moveRobot(Robot robot, int toX, int toY) {

        System.out.println("Initial position is " + robot.dir); // проверяем начальное направление робота

        boolean dirDown = robot.dir.equals(Direction.DOWN); // вводи переменные, обозначающие направление робота
        boolean dirUp = robot.dir.equals(Direction.UP);     // чтобы код дальше был более понятен
        boolean dirLeft = robot.dir.equals(Direction.LEFT);
        boolean dirRight = robot.dir.equals(Direction.RIGHT);

        if (robot.x < toX && dirDown) {           // если координата Х робота меньше нужной и голова повёрнута вниз, то
            System.out.println("He turned left"); // он поворачивает налево один раз - в сторону увеличения оси Х
            robot.turnLeft();
        } else if (robot.x < toX && dirUp) {       // если Х меньше нужного и голова повернута вверх, то
            System.out.println("He turned right"); // он поворачивает направо один раз
            robot.turnRight();
        } else if (robot.x < toX && dirLeft) {     // если Х меньше нужного и голова повернута влево, то
            System.out.println("He turned right"); // он дважды поворачивает направо
            System.out.println("He turned right");
            robot.turnRight();
            robot.turnRight();
        } else if (robot.x < toX && dirRight) {               // если Х меньше нужного и голова повернута вправо, то
            System.out.println("No turns needed for X axis"); // он никуда не поворачивает
        }
        System.out.println("Now he is " + robot.dir); // проверяем real-time направление робота

        while (robot.x < toX) {    // пока Х меньше нужного
            //robot.x++;           // прибавляем 1 к Х
            robot.stepForward();   // и робот делает шаг вперед
            System.out.println("He stepped forward to position " + robot.x); // проверяем настоящую позицию на каждом витке
            System.out.println("He needs to go to position " + toX);         // проверяем нужную позицию
        }
        /*while (robot.x > toX) {    // пока Х меньше нужного
            //robot.x++;           // прибавляем 1 к Х
            robot.turnRight();
            robot.turnRight();
            robot.stepForward();   // и робот делает шаг вперед
            System.out.println("He stepped forward to position " + robot.x); // проверяем настоящую позицию на каждом витке
            System.out.println("He needs to go to position " + toX);         // проверяем нужную позицию
        }*/

            System.out.println("Now robot's X is " + robot.x); // после завершения цикла проверяем настоящую позицию

        if (robot.y < toY && dirDown) {            // если координата Y робота меньше нужной и голова повёрнута вниз, то
            System.out.println("He turned right"); // он дважды поворачивает направо
            System.out.println("He turned right");
            robot.turnRight();
            robot.turnRight();
        } else if (robot.y < toY && dirUp) {                  // если Y меньше нужного и голова повернута вверх, то
            System.out.println("No turns needed for X axis"); // он никуда не поворачивает
        } else if (robot.y < toY && dirLeft) {                // если Х меньше нужного и голова повернута влево, то
            System.out.println("He turned right");            // он поворачивает направо
            robot.turnRight();
        } else if (robot.y < toY && dirRight) {   // если Х меньше нужного и голова повернута вправо, то
            System.out.println("He turned left"); // он поворачивает налево один раз - в сторону увеличения оси Х
            robot.turnLeft();
        }
        System.out.println("Now he is " + robot.dir); // проверяем real-time направление робота
        robot.dir = Direction.UP;                     // мощный костыль, чтобы stepForward работал корректно

        while (robot.y < toY) {   // пока Х меньше нужного
            //robot.y++;          // прибавляем 1 к Х
            robot.stepForward();  // и робот делает шаг вперед
            System.out.println("He stepped forward to position " + robot.y); // проверяем настоящую позицию на каждом витке
            System.out.println("He needs to go to position " + toY);         // проверяем нужную позицию
        }
        System.out.println("Now robot's Y is " + robot.y); // после завершения цикла проверяем настоящую позицию
        System.out.println("Now robot's X is " + robot.x);
        if (robot.x == toX) {
            System.out.println("X correct");
        }
        if (robot.y == toY) {
            System.out.println("Y correct");
        }
    }
}