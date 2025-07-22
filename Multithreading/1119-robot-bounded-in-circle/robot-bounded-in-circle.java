class Solution {
    private enum Direction{
        NORTH, SOUTH, EAST, WEST;
    }
    public boolean isRobotBounded(String instructions) {
        int x=0, y=0;
        Direction dir = Direction.NORTH;

        for(char instruction: instructions.toCharArray()){
            if(instruction == 'G'){
                switch(dir){
                    case dir.NORTH: y++; break;
                    case dir.EAST:  x++; break;
                    case dir.SOUTH: y--; break;
                    case dir.WEST:  x--; break;
                }
            }
            else if(instruction == 'L'){
                dir = turnLeft(dir);
            }
            else if(instruction == 'R'){
                dir = turnRight(dir);
            }
        }

        // Robot is bounded if it's back at origin or not facing North
        return (x == 0 && y == 0) || dir != Direction.NORTH;
    }

    private Direction turnLeft(Direction dir) {
        switch (dir) {
            case dir.NORTH: return Direction.WEST;
            case dir.WEST:  return Direction.SOUTH;
            case dir.SOUTH: return Direction.EAST;
            case dir.EAST:  return Direction.NORTH;
            default:    return dir; // Should not happen
        }
    }

    private Direction turnRight(Direction dir) {
        switch (dir) {
            case dir.NORTH: return Direction.EAST;
            case dir.EAST:  return Direction.SOUTH;
            case dir.SOUTH: return Direction.WEST;
            case dir.WEST:  return Direction.NORTH;
            default:    return dir; // Should not happen
        }
    }
}