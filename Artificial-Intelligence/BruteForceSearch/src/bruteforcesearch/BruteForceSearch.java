package bruteforcesearch;
/**
 *
 * @author ANIRUDDHA
 */
public class BruteForceSearch {

    // The function whose max/min is to be found
    public static double func(double x){
        return -(x*x)+2;
    }
    
    public static void main(String[] args) {
    
        double startPositionX = -2;
        double maximumX = startPositionX;
        double dx = 0.01;
        double max = func(startPositionX);
        
        // Iterate through the function
        for (double i = startPositionX; i<2; i+= dx){
            if(func(i) > max ){
                max= func(i);
                maximumX = i;
            }
        }
        
        System.out.println("The maximum is at x= "+ maximumX + "and y= "+ func(maximumX));
        
    }
    
}
