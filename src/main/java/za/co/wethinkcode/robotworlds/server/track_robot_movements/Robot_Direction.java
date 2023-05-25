package za.co.wethinkcode.robotworlds.server.track_robot_movements;

public enum Robot_Direction {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public int getRobotAngle() {
        switch (this){
            case NORTH: return 0;
            case EAST: return 90;
            case SOUTH: return 180;
            case WEST: return 270;
        }
        throw new IllegalStateException();
    }
}
