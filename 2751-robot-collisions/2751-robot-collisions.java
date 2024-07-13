class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        // Add all the details of the robot in an array of list
        List<int[]> robots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // robots = [position, health, direction, index]
            robots.add(new int[] { positions[i], healths[i], directions.charAt(i), i });
        }
        // Sort the robots according to their positions
        Collections.sort(robots, (a, b) -> Integer.compare(a[0], b[0]));
        // Create a stack to store the position of each robot
        Stack<int[]> stack = new Stack<>();

        // Iterate to add robots inside the stack
        for (int[] robot : robots) {
            // if the current robot is moving left or the stack is empty or the peek element
            // of the stack is moving to the left then just add the robot in the stack.
            if (stack.isEmpty() == true || robot[2] == 'R' || stack.peek()[2] == 'L') {
                stack.push(robot);
            }
            // Check for different situations if the robot is moving to the left
            else {
                // Consider a boolean variable that will tell us whether to add or not the
                // current element
                boolean add = true; // initially consider it true
                // since the current robot is moving to the left,
                // we have to check all the robots in the stack which are moving in the right
                // also check whether add is true or not along with whether the stack is empty
                // or not
                while (!stack.isEmpty() && stack.peek()[2] == 'R' && add == true) {

                    // health of the robot at the top of the stack
                    int health = stack.peek()[1];

                    // Case 1: If the current health of the robot and the health of the top of the
                    // stack's
                    // robot are equal then pop the element and remove the current element and set
                    // the add
                    // equals to false
                    if (robot[1] == health) {
                        stack.pop();
                        add = false;
                    }

                    // Case 2: If the current health of the robot is greater than the health of the
                    // top
                    // of the stack's robot then pop the robot from the stack
                    else if (robot[1] > health) {
                        stack.pop();
                        robot[1] = robot[1] - 1;
                    }

                    // Case 3: If the current health of the robot is less than the health of the top
                    // of the stack's robot then decrement the health of the robot at the top of
                    // the stack and change add to false
                    else {
                        stack.peek()[1] -= 1;
                        add = false;
                    }
                }
                // if add equals to true then push it to the stack
                if (add) {
                    stack.push(robot);
                }
            }
        }
        /*
         * The stack contains the robots that survived after the collisions. Since
         * stacks don't maintain the order of elements based on the original indices, we
         * convert the stack to a list for further processing.
         */
        List<int[]> resultList = new ArrayList<>(stack);

        //This line sorts the resultList based on the original indices of the robots.
        resultList.sort(Comparator.comparingInt(a -> a[3]));
        
        List<Integer> result = new ArrayList<>();
        for (int robot[] : resultList) {
            result.add(robot[1]);
        }
        return result;
    }
}