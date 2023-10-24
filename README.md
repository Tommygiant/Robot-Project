# Robot-Project

A simple Java program to simulate the robot movements on a grid

### Table Content
* Design Document
   * Functionality Requirements
   * Workflow Diagram
* Instructions for use
   * Compile and Run the program
   * Enter the input set
   * Review output
   * Review log file
* Change Log

***

## Functionality Requirements

1. Correct reading of data according to system input
2. Ability to accurately record robot movement paths and collision position information
3. Multiple activated robots can be sequentially moving and the final position information as expected output
4. Ability to activate the non-activated robot after touching
5. **Check for invalid input to avoid out of bounds**

## Workflow Diagram
![Screen Shot 2023-10-22 at 8 07 12 pm](https://github.com/Tommygiant/Robot-Project/assets/78850099/ff60e911-5b07-49b3-a90a-cce494eef7b0)



## Enter the following input parameters as described in the problem statement:
- Dimensions of the grid (n)
- The initial position of the first activated robot (x, y)
- A list of the non-activated robots' positions (x1, y1 x2, y2 x3, y3 ...)
- The robot movement sequence (e.g., DRUR)
  
![Screen Shot 2023-10-22 at 3 43 16 pm](https://github.com/Tommygiant/Robot-Project/assets/78850099/29ffe2c3-3539-4b37-9363-5c5a1846371e)


## Review output
![Screen Shot 2023-10-22 at 3 43 38 pm](https://github.com/Tommygiant/Robot-Project/assets/78850099/acbc3dfc-8d36-4f7e-be79-767efb079fde)
## Review log file
*check robot_simulation.log for all the position and collision information records*
![捕获](https://github.com/Tommygiant/Robot-Project/assets/78850099/893ca604-8bb9-4e7c-a97a-fa6192d1b24c)

## Change Log

### v0.1 (2023/10/22 15:00 +15:30)
- Fixed robot movement coordinate values updated error
![Screen Shot 2023-10-22 at 3 45 07 pm](https://github.com/Tommygiant/Robot-Project/assets/78850099/6d9dfa6a-c15f-4a0e-9402-59fa6c80cda7)

### v0.2 (2023/10/22 15:00 +16:00)
- Handle multi activated robots sequential movement
![Screen Shot 2023-10-22 at 3 41 43 pm](https://github.com/Tommygiant/Robot-Project/assets/78850099/e94fbf99-b264-45a0-9e05-ba2e661522eb)

### v0.3 (2023/10/24 18:00 +18:30)
- Robot movements direction updated
- Update data format of activated robot initial position
- Update simulation method ensure non-activated robot can be activated by touching
