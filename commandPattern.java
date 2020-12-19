import java.io.*;
import java.util.*;
import java.util.Scanner;


/// writng vendor classes

class light{
    public void turnOnLight(){
        System.out.println("Light is turned On \n");
    }
    public void turnOffLight(){
        System.out.println("Light is turned Off \n");

    }
}

class ceilingFan{
    public void turnOnFan(){
        System.out.println("Ceiling Fan is turned On \n");
    }
    public void turnOffFan(){
        System.out.println("Ceiling Fan is turned Off \n");

    }
}

class AC{
    public void turnOnAC(){
        System.out.println("AC is turned On \n");
    }
    public void turnOffAC(){
        System.out.println("AC is turned Off \n");

    }
}

interface command{                               //// writing a interface while will execute commands of vendor classes
     public void on();
     public void off();
}

class lightCommand implements command{         // all these imp classes will handle vendor classes
      light li;
      public lightCommand(light li){
          this.li = li;
      }
      public void on(){
          li.turnOnLight();
      }
      public void off(){
        li.turnOffLight();
    }
}

class ceilingFanCommand implements command{
     ceilingFan cf;
     public ceilingFanCommand(ceilingFan cf){
         this.cf = cf;
     }
    
    public void on(){
      cf.turnOnFan();
    }
    public void off(){
      cf.turnOffFan();
  }

}

class acCommand implements command{
    AC ac;
    public acCommand(AC ac){
        this.ac = ac;
    }
   
   public void on(){
       ac.turnOnAC();
   }
   public void off(){
      ac.turnOffAC();
   }

}

// This is the remote, it doesnt know about how light gets turned on it only knows how to 
// turn it ON!

class remote{                 
    command cmd;              
    public void setCommand(command cmd){
        this.cmd = cmd;
    }
    public void turnOnDevice(){
        cmd.on();
    }
    public void turnOffDevice(){
        cmd.off();
    }
}


public class commandPattern {

   public static void main(String[] args)
   {
    remote R1 = new remote();
    light whitelight = new light();
    ceilingFan fan = new ceilingFan();
    AC ac1 = new AC();

    lightCommand lc = new lightCommand(whitelight);
    ceilingFanCommand cf = new ceilingFanCommand(fan);
    acCommand aC = new acCommand(ac1);

    System.out.println("\nThis is Command Pattern \n");
    R1.setCommand(lc);
    R1.turnOnDevice();
    R1.turnOffDevice();
    R1.setCommand(cf);
    R1.turnOnDevice();


   }  
}
