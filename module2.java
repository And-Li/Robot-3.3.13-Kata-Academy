
public class module2 {
    public static void main(String[] args) {
        Robot robot = new Robot(0,0, Direction.UP);
        moveRobot(robot,5 , 0);

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

        System.out.println("Now robot is " + robot.dir);

        boolean dirDown = robot.dir.equals(Direction.DOWN);
        boolean dirUp = robot.dir.equals(Direction.UP);
        boolean dirLeft = robot.dir.equals(Direction.LEFT);
        boolean dirRight = robot.dir.equals(Direction.RIGHT);

        if (robot.x < toX && dirDown) {
            System.out.println("He turned left");
            robot.turnLeft();
        } else if (robot.x < toX && dirUp) {
            System.out.println("He turned right");
            robot.turnRight();
        } else if (robot.x < toX && dirLeft) {
            System.out.println("He turned right");
            System.out.println("He turned right");
            robot.turnRight();
            robot.turnRight();
        } else if (robot.x < toX && dirRight) {
            System.out.println("No turns needed for X axis");
        }
        System.out.println("Now he is " + robot.dir);

        while (robot.x < toX) {
            //System.out.println(robot.dir);
            robot.x = robot.x + 1;
            robot.stepForward();
            System.out.println("He stepped forward to position " + robot.x);
            System.out.println("He needs to go to position " + toX);
        }
            System.out.println("Now robot's X is " + robot.x);

    }
}