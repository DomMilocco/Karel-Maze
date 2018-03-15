import kareltherobot.*; 
/**
 * @author : Foley, Mr.
 * teacher : moi
 * due date: when I ask for it.
 */
public class SmartBot extends Robot
{
    public SmartBot(int st, int av, Direction dir, int numbeepers) {
        super(st, av, dir, numbeepers);
    }

    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }

    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }

    public void stepBack()
    {
        turnAround();
        move();
        turnAround();
    }

    public boolean beeperIsToFront()
    {
        boolean rValue = false;
        if (frontIsClear())
        {
            move();
            rValue = nextToABeeper();
            turnAround();
            move();
            turnAround();
        }
        return rValue;
    }

    public boolean beeperIsToLeft()
    {
        boolean rValue = false;
        turnLeft();
        if (frontIsClear())
        {
            move();
            rValue = nextToABeeper();
            turnAround();
            move();
            turnAround();
        }
        turnRight();
        return rValue;
    }

    public boolean beeperIsToRight()
    {
        boolean rValue = false;
        turnRight();
        if (frontIsClear())
        {
            move();
            rValue = nextToABeeper();
            turnAround();
            move();
            turnAround();
        }
        turnLeft();
        return rValue;
    }

    public void faceWest(){
        while(! facingWest()){
            turnLeft();
        }
    }

    public void faceEast(){
        while(! facingEast()){
            turnLeft();
        }
    }

    public void faceNorth(){
        while(! facingNorth()){
            turnLeft();
        }
    }

    public void faceSouth(){
        while(! facingSouth()){
            turnLeft();
        }
    }

    public boolean twoOrMorebeepersOnCorner(){
        if (nextToABeeper()){
            pickBeeper(); //  will pick up a beeper
            if(nextToABeeper()){
                putBeeper();
                return true;
            }
            putBeeper(); // will place a bepper
        }
        return false;
    }

    public void moveTobeeper(){
        do{
            move();
        }
        while(!nextToABeeper());
    }

    public void pickAllbeepers(){
        while(nextToABeeper()) 
            pickBeeper();
    }

    public void superBall(){
        if(frontIsClear()){
            move();
            superBall();
            move();
        }
        else{
            turnRight();
        }
    }

    public boolean wallToRight(){
        turnRight();
        boolean value = !frontIsClear();
        System.out.println(value);
        turnLeft();
        return value;
    }

    public boolean wallToLeft(){
        turnLeft();
        boolean value = !frontIsClear();
        System.out.println(value);
        turnRight();
        return value;
    }
    public int beeperCount = 0;
    public void runTrail()
    {while(true){
            if(beeperCount!=2){
                beeperCount = 0;
                if(frontIsClear()){
                    if(wallToRight()){
                        move();
                    } else if(!wallToLeft()){

                        move();
                    }else {
                        turnRight();
                        move();
                    }
                } else{
                    if(!wallToRight()){
                        turnRight();
                        move();
                    } else if(!wallToLeft()){
                        turnLeft();
                        move();
                    }else{
                        turnAround();
                    }
                }
                while (nextToABeeper()){
                    pickBeeper();
                    beeperCount += 1;
                }

            } else if(beeperCount == 2){
                turnOff();
                break;
            }
        }
    }
}

