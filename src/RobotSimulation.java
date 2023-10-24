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

        // activated robot initial position
        String initialPosition = scanner.nextLine();

        String[] activatedRobots = initialPosition.split(",");

        int startX = Integer.parseInt(activatedRobots[0]);
        int startY = Integer.parseInt(activatedRobots[1]);

        List<Robot> activatedRobotsList = new ArrayList<>();
        activatedRobotsList.add(new Robot(startX, startY));


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

        while (!activatedRobotsList.isEmpty()){
            Robot activatedRobotInitialPosition = activatedRobotsList.get(0);
            
            activatedRobotsList.remove(activatedRobotInitialPosition);
            
            List<Robot> activatedRobotFinalPosition = RobotSimulationProcess(n, activatedRobotInitialPosition, nonActivatedRobotsList, movement);
            robotIndex++;

            int len = activatedRobotFinalPosition.size();
            for (int i = 0; i < len-1; i++){
                activatedRobotsList.add(activatedRobotFinalPosition.get(i));
                nonActivatedRobotsList.remove(activatedRobotFinalPosition.get(i));
            }
            activatedRobotsPosition.add(activatedRobotFinalPosition.get(len-1));


        }

        // Output
        System.out.println("Activated robot position:");
        System.out.println(activatedRobotsPosition);
        System.out.println("Non-activated robot position:");
        System.out.println(nonActivatedRobotsList);

    }

    public static List<Robot> RobotSimulationProcess(int n, Robot robot, List<Robot> nonActivatedRobotsList, String movement){
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

        List<Robot> activatedLocation = new ArrayList<>();

        for (char move : movement.toCharArray()) {


            robot.move(move, n);
            String logMessage = "Robot " + robotIndex + " moved to (" + robot.x + ", " + robot.y + ")";      
            logger.log(Level.INFO, logMessage);
            // System.out.println("Robot " + robotIndex + " moved to (" + robot.x + ", " + robot.y + ")");

            // check for collisions
            for (Robot nonActivatedRobot : nonActivatedRobotsList) {

                if (robot.x == nonActivatedRobot.x && robot.y == nonActivatedRobot.y) {
                    activatedLocation.add(nonActivatedRobot);

                    String touchMessage = "Robot " + robotIndex + " touched the non-activated robot at (" + robot.x + ", " + robot.y + ")";
                    logger.log(Level.INFO, touchMessage);
                    // System.out.println("Robot " + robotIndex + " touched the non-activated robot at (" + robot.x + ", " + robot.y + ")");
                }

            }
        }
        activatedLocation.add(robot);

        return activatedLocation;

    }



}
