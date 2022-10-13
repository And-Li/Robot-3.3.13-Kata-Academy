public class Robot3 {
    public static void main(String[] args) {
        Robot robot = new Robot(8,1, Direction.UP);
        moveRobot(robot,4 ,2 );
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
        int x = robot.x;
        int y = robot.y;
        Direction dir = robot.getDirection();

        if (x < toX) {
            while (dir != Direction.RIGHT) {
                robot.turnRight();
                dir = robot.getDirection();
                System.out.println("Turning right");
                System.out.println(dir);}
        }
        while (x < toX) {
                System.out.println("stepping forward");
                robot.stepForward();   // робот делает шаг вперед
                x++;

        }
        if (x > toX) {
            while (dir != Direction.LEFT) {
                robot.turnRight();
                dir = robot.getDirection();
                System.out.println("Turning right");
                System.out.println(dir);}
        }
        while (x > toX) {
            System.out.println("stepping forward");
            robot.stepForward();   // робот делает шаг вперед
            x--;

        }
        if (y < toY) {
            while (dir != Direction.UP) {
                robot.turnRight();
                dir = robot.getDirection();
                System.out.println("Turning right");
                System.out.println(dir);}
        }
        while (y < toY) {
            System.out.println("stepping forward");
            robot.stepForward();   // робот делает шаг вперед
            y++;

        }
        if (y > toY) {
            while (dir != Direction.DOWN) {
                robot.turnRight();
                dir = robot.getDirection();
                System.out.println("Turning right");
                System.out.println(dir);}
        }
        while (y > toY) {
            System.out.println("stepping forward");
            robot.stepForward();   // робот делает шаг вперед
            y--;

        }

        if (x == toX) {
            System.out.println(x);
            System.out.println(toX);
            System.out.println("X correct");
        }
        if (y == toY) {
            System.out.println(y);
            System.out.println(toY);
            System.out.println("Y correct");
        }
    }
}