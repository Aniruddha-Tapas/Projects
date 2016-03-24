package hillclimbing;

/**
 *
 * @author ANIRUDDHA
 */
public class HillClimbing {

    // The function whose max/min is to be found
    public static double func(double x){
        return -(x-1)*(x-1)+2;
    }
    
    public static void main(String[] args) {
        
        double dx = 0.01;
        double actualPointX = -2;
        double max = func(actualPointX);
        
        // Keep iterating or climbing up the slope while slope is +ve
        while(func(actualPointX + dx) > max){
            max = func(actualPointX + dx); //Update the max
            System.out.println("x: "+actualPointX + " y: "+func(actualPointX)); //Print out the points
            actualPointX += dx;
        }
        
        System.out.println("Local Maximum is at "+max);
        
    }
    
}
