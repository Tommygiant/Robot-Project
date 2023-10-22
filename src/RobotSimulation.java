import java.util.*;
import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;



public class RobotSimulation {
    private static int robotIndex = 0;

    public static void main(String[] args) {

        // input
        Scanner scanner = new Scanner(System.in);

        // n x n grid
        String grid = scanner.nextLine();
        int n = Integer.parseInt(grid);

        // activated robots set
        String initialPosition = scanner.nextLine();
        String[] activatedRobots = initialPosition.split(" ");
        List<Robot> activatedRobotsList = new ArrayList<>();

        for (String position : activatedRobots) {
            String[] parts = position.split(",");
            int startX = Integer.parseInt(parts[0]);
            int startY = Integer.parseInt(parts[1]);
            if (startX >= n || startY >= n){
                System.out.println("Invalid starting position. The starting position must be within the grid boundaries.");
                return;
            }
            activatedRobotsList.add(new Robot(startX, startY));
        }

        // non-activated robots set

        String[] nonActivatedRobots = scanner.nextLine().split(" ");
        List<Robot> nonActivatedRobotsList = new ArrayList<>();

        for (String position : nonActivatedRobots) {
            String[] parts = position.split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            if (x >= n || y >= n){
                System.out.println("Invalid non-activated robot position. The position must be within the grid boundaries.");
                return;
            }
            nonActivatedRobotsList.add(new Robot(x, y));
        }

        String movement = scanner.nextLine();

        // Simulation Process

        List<Robot> activatedRobotsPosition = new ArrayList<>();

        for (Robot activatedRobotInitialPosition : activatedRobotsList){
            Robot activatedRobotFinalPosition = RobotSimulationProcess(n, activatedRobotInitialPosition, nonActivatedRobotsList, movement);
            robotIndex++;
            activatedRobotsPosition.add(activatedRobotFinalPosition);
        }

        // Output
        System.out.println("Activated robot position:");
        System.out.println(activatedRobotsPosition);
        System.out.println("Non-activated robot position:");
        System.out.println(nonActivatedRobotsList);

    }

    public static Robot RobotSimulationProcess(int n, Robot robot, List<Robot> nonActivatedRobotsList, String movement){
        Logger logger = Logger.getLogger("RobotSimulation");
        FileHandler fileHandler;

        try {
            // This sets the log file to "robot_simulation.log".
            fileHandler = new FileHandler("robot_simulation.log");
            logger.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        for (char move : movement.toCharArray()) {


            robot.move(move, n);
            String logMessage = "Robot " + robotIndex + " moved to (" + robot.x + ", " + robot.y + ")";
            logger.log(Level.INFO, logMessage);
            //System.out.println("Robot " + robotIndex + " moved to (" + robot.x + ", " + robot.y + ")");

            // check for collisions
            for (Robot nonActivatedRobot : nonActivatedRobotsList) {

                if (robot.x == nonActivatedRobot.x && robot.y == nonActivatedRobot.y) {
                    String touchMessage = "Robot " + "robotIndex" + " touched the non-activated robot at (" + robot.x + ", " + robot.y + ")";
                    logger.log(Level.INFO, touchMessage);
                    //System.out.println("Robot " + robotIndex + " touched the non-activated robot at (" + robot.x + ", " + robot.y + ")");
                }

            }
        }
        return robot;

    }



}
