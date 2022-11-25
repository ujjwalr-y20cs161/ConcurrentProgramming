
import java.util.Random;

class square extends Thread{
    int m;
    public square(int m){
        this.m = m;
    }

    public void run(){
        System.out.print("#"+Thread.currentThread().getId());
        System.out.println(">>>$2>"+(m*m));
    }

}
class cube extends Thread{
    int m;
    public cube(int m){
        this.m = m;
    }

    public void run(){
        System.out.print("#"+Thread.currentThread().getId());
        System.out.println(">>>$3>"+(m*m*m));
    }

}

class Randt extends Thread{
    int n;

    public void run(){
        Random r = new Random();
        for(int i = 0;i<5;i++){
            n = r.nextInt(10);

            System.out.println(">>>> $"+n);

            square s = new square(n);
            s.start();
            cube c = new cube(n);
            c.start();
            try{            
                Thread.sleep(1000);
            }catch(Exception e)
            {
                System.out.println("Refused to sleep");
            }

        }
    }
}
public class squareCube {
    public static void main(String [] args){
        Randt rn = new Randt();
        rn.start();
    }
}
