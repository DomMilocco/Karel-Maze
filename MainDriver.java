/**
   @Author: Dom Milocco
      Date: 2/4/14
   Teacher: Foley, Mr.
  */
import kareltherobot.*;
import java.awt.Color;

public class MainDriver implements Directions
{
    public static void main(String args[])  {
        SmartBot canti = new SmartBot(8,2,South,0); 
        canti.runTrail();
}
static{
        World.reset(); 
        World.readWorld("amazeing.kwld"); 
        World.setBeeperColor(Color.red);
        World.setStreetColor(Color.blue);
        World.setNeutroniumColor(Color.green.darker());
        World.setDelay(2);  
        World.setVisible(true);
}
}