package com.mars.rover;

class Rover {
    private int x;
    private int y;
    private String direction;

    public Rover(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}

class NavigateMarsRover {

    static Rover navigateMarsRover(Rover rover, String traverseDirection) throws Exception {

        int x = rover.getX();
        int y = rover.getY();
        if (x < 0 || y < 0) {
            throw new Exception(" X and Y cannot be Negative integers");
        }
        String currentDirection = rover.getDirection();

        // possible directions are N E W S. North --  East -- West -- South
        String directionToTraverse = traverseDirection;

        //1 2 N
        //L M L M L M L M M
        //expected output is 1 3 N
        for (int i = 0; i < directionToTraverse.length(); i++) {
            switch (directionToTraverse.charAt(i)) {
                case 'L':
                    // spin Left from the currentDirection
                    if ("N".equals(currentDirection)) currentDirection = "W";
                    else if ("E".equals(currentDirection)) currentDirection = "N";
                    else if ("W".equals(currentDirection)) currentDirection = "S";
                    else if ("S".equals(currentDirection)) currentDirection = "E";
                    break;
                case 'R':
                    // spin Right from the currentDirection
                    if ("N".equals(currentDirection)) currentDirection = "E";
                    else if ("E".equals(currentDirection)) currentDirection = "S";
                    else if ("W".equals(currentDirection)) currentDirection = "N";
                    else if ("S".equals(currentDirection)) currentDirection = "W";
                    break;
                case 'M':
                    // move the Rover by 1 grid in the direction of currentDirection.
                    // If currentDirection = N then move up in the direction of North
                    // If N then move up y = y+1.
                    // If E then move right x = x + 1
                    // If W then move left x = x - 1
                    // If S then move down y = y - 1
                    if ("N".equals(currentDirection)) y = y + 1;
                    else if ("E".equals(currentDirection)) x = x + 1;
                    else if ("W".equals(currentDirection)) x = x - 1;
                    else if ("S".equals(currentDirection)) y = y - 1;
                    break;
                default:
                    break; // if the traverse direction is anything other than L | R | M then skip/ignore it
            }
        }
        rover.setX(x);
        rover.setY(y);
        rover.setDirection(currentDirection);
        return rover;
    }
}

public class MarsRover {
    public static void main(String[] args) throws Exception {

        //int x = 1, y = 2;
        //String currentDirection = "N";
        Rover rover1 = new Rover(1, 2, "N");
        Rover rover2 = new Rover(3, 3, "E");

        rover1 = NavigateMarsRover.navigateMarsRover(rover1, "LMLMLMLMM");
        rover2 = NavigateMarsRover.navigateMarsRover(rover2, "MMRMMRMRRM");

        System.out.println("X Y N values for Rover 1: " + rover1.getX() + " " + rover1.getY() + " " + rover1.getDirection());
        System.out.println("X Y N values for Rover 2: " + rover2.getX() + " " + rover2.getY() + " " + rover2.getDirection());

    }

}
