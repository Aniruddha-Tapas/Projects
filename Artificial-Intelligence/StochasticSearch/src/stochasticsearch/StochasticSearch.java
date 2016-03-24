package stochasticsearch;

import java.util.Random;

/**
 *
 * @author ANIRUDDHA
 */
public class StochasticSearch {

    // The function whose max/min is to be found
    public static double func(double x){
        return -(x-1)*(x-1)+2;
    }
    
    public static void main(String[] args) {
        
        // Stochastic Search doesnt iterate in an order, it makes random guesses about the maximum and stores them as a reference for comparison.
        Random rand = new Random();
        double startPointX = 0;
        double max = func(startPointX);
        
        //Make 10 iterations
        for(int i=0;i<1000;i++){
            
            double index = 2*rand.nextDouble();
            if(func(index) > max){
                max = func(index);
            }
        }
        
        System.out.println("Maximum value y=f(x) is "+max);
    }
    
    
}
