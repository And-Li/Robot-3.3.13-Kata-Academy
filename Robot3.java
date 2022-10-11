public class Robot3 {
    public static void main(String[] args) {
        Robot robot = new Robot(6,15, Direction.UP);
        moveRobot(robot,10 , 12);
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
        int x = robot.getX();
        int y = robot.getY();
        Direction dir = robot.getDirection();

        while (x < toX && dir != Direction.LEFT){
            robot.turnRight();
            while (x < toX) {
                robot.stepForward();   // робот делает шаг вперед
            }
        }

        while (x > toX && dir != Direction.RIGHT) {
            robot.turnRight();
            robot.stepForward();   // и робот делает шаг вперед
        }
        while (y < toY && dir != Direction.UP) {   // пока Y меньше нужного
            robot.turnRight();
            robot.stepForward();  // робот делает шаг вперед
        }
        while (y > toY && dir != Direction.DOWN) {   // пока Y меньше нужного
            robot.turnRight();
            robot.stepForward();  // и робот делает шаг вперед
        }
        if (x == toX) {
            System.out.println("X correct");
        }
        if (y == toY) {
            System.out.println("Y correct");
        }
    }
}