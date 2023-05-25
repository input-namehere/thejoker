package za.co.wethinkcode.robotworlds.server.world_bots;
import za.co.wethinkcode.robotworlds.server.commands.Command;
import za.co.wethinkcode.robotworlds.server.world.Config_World.*;
import za.co.wethinkcode.robotworlds.server.commands.*;
import za.co.wethinkcode.robotworlds.server.track_robot_movements.*;
import za.co.wethinkcode.robotworlds.server.world.Obstacle;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private final Position TOP_LEFT = new Position(-200,100);
    private final Position BOTTOM_RIGHT = new Position(100,-200);
    public static final Position CENTRE = new Position(0,0);
    private Position position;
    private Robot_Direction currentDirection;
    public static final String[] TYPES_OF_ROBOTS = new String[]{"iRobot", "sniper", "Tank", "Bomber"};

    private String status;
    private String name;
    private List<Command> commandHistory = new ArrayList<>();
    private String state;
    private String make;
    private Obstacle obstacle;
    private  int maximumAmmunition;
    private int maxShield;
    private int visibilityDistance;
    private  int fireDistance;

    private int currentShield;
    private int currentAmmunition;
    private int kills=0;


    public Obstacle getObstacle() {
        return obstacle;
    }

    public String getMake() {
        return make;
    }

    public String getStateToBeReturnedToTheUser() {
        return stateToBeReturnedToTheUser;
    }

    public void setStateToBeReturnedToTheUser(String stateToBeReturnedToTheUser) {
        this.stateToBeReturnedToTheUser = stateToBeReturnedToTheUser;
    }

    private String stateToBeReturnedToTheUser;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }



    public Robot(String make, String name) {
        this.make = make;
        this.name = name;
        this.state="normal";
        this.status = "Ready";
        this.position = CENTRE;
        this.currentDirection = Robot_Direction.NORTH;
        this.obstacle = obstacle;

        switch (make.toLowerCase()){
            case "sniper":
                this.make = "sniper";
                this.fireDistance = 18;
                this.maximumAmmunition = 3;
                this.maxShield = 1;
                this.visibilityDistance = 20;
                break;
        }


    }


    public Robot() {
    }

    public boolean handleCommand(Command command) {
        return command.execute(this);
    }





    public boolean updatePosition(int nrSteps){
        int newX = this.position.getX();
        int newY = this.position.getY();

        if (Robot_Direction.NORTH.equals(this.currentDirection)) {
            newY = newY + nrSteps;
        } else if (Robot_Direction.EAST.equals(this.currentDirection)) {
            newX = newX + nrSteps;
        } else if (Robot_Direction.WEST.equals(this.currentDirection)) {
            newX = newX - nrSteps;
        } else if (Robot_Direction.SOUTH.equals(this.currentDirection)) {
            newY = newY - nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (newPosition.isIn(TOP_LEFT,BOTTOM_RIGHT)){
            this.position = newPosition;
            return true;
        }
        return false;
    }


    public List<Command> getCommandHistory() {
        return commandHistory;
    }


    public void setCommandHistory(Command command) {
        this.commandHistory.add(command);
    }


    public String getStatus() {
        return this.status;
    }


    public void setStatus(String status) {
        this.status = status;
    }


    public Robot_Direction getCurrentDirection() {
        return this.currentDirection;
    }



    public String getRobotType() { return make; }



    public Robot_Direction getDirection() {
        return this.currentDirection;
    }

    public int getVisibilityDistance() {
        return visibilityDistance;
    }

    public int getFiringDistance() {
        return fireDistance;
    }

    public int getMaxShield() {
        return maxShield;
    }
    public int getMaxAmmo() {
        return maximumAmmunition;
    }

    public int getCurrentAmmo() {
        return this.currentAmmunition;
    }

    public int getCurrentShield() {
        return this.currentShield;
    }

    public void setCurrentDirection(Robot_Direction direction) {
        this.currentDirection = direction;
    }


    public Position getPosition() {
        return this.position;
    }


    public String getName() {
        return name;
    }






    public void setPosition(Position position) {
        this.position = position;
    }


    public void decreaseShield() {
        this.currentShield--;
        System.out.println(currentShield);
    }


    public void decreaseAmmo() {
        this.currentAmmunition--;
    }

    public void setMaxShield(int maxShield) {
        this.maxShield = maxShield;
        this.currentShield = maxShield;
    }

    public void resetShield() {
        this.currentShield = maxShield;
    }

    public void resetAmmo() {
        this.currentAmmunition = this.maximumAmmunition;
    }


    public int getKills() {
        return this.kills;
    }

    public boolean hasDied() {
        return currentShield==0;
    }

//    @Override
//    public String toString() {
//        return "name : " +name+
//                "\nposition : [" +position.getX()+ ", " +position.getY()+ "]" +
//                "\ndirection : " +currentDirection.toString()+
//                "\nshields : " +currentShield+
//                "\nshots : " +currentAmmunition+
//                "\nstatus : "+status;
//    }

    @Override
    public String toString() {
        return "[" + this.position.getX() + "," + this.position.getY() + "]";
    }


    public void addKill() {
        kills++;
    }


}

