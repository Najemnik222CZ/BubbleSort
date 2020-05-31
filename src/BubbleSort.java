import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Michal
 */
public class BubbleSort {
    public static void main(String[] args) {
        double[] data = RandomGen( 100_000, true);
        System.out.println(Arrays.toString(bubbleSort(data, true)));
//        System.out.println(Arrays.toString(bubbleSort(data, false)));
//        System.out.println(Arrays.toString(bubbleSortII(data, true)));
//        System.out.println(Arrays.toString(bubbleSortII(data, false)));
//        System.out.println(Arrays.toString(bubbleSortIII(data, true)));
//        System.out.println(Arrays.toString(bubbleSortIII(data, false)));
//        Change(-50, -60);
//        System.out.println(X);
//        System.out.println(Y);
        
    }
    
    static double x = 0;
    
    public static double[] bubbleSort(double[] data, boolean ascending){
        if (ascending) {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length-1; j++) {
                    if (data[j] > data[j+1]) {
                        x = data[j+1];
                        data[j+1] = data[j];
                        data[j] = x;
                    }
                }
            }
        } else {
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data.length-1; j++) {
                    if (data[j] < data[j+1]) {
                        x = data[j];
                        data[j] = data[j+1];
                        data[j+1] = x;
                    }
                }
            }
        }
        return data;
    }
    
    public static double[] bubbleSortII(double[] data, boolean ascending){
        boolean T = false;
        if (ascending) {
            while (!T) {
                T = true;
                for (int i = 0; i < data.length-1; i++) {
                    if (data[i] > data[i+1]) {
                        x = data[i];
                        data[i] = data[i+1];
                        data[i+1] = x;
                        T = false;
                    }
                }
            }
        } else {
            while (!T) {
                T = true;
                for (int i = 0; i < data.length-1; i++) {
                    if (data[i] < data[i+1]) {
                        x = data[i+1];
                        data[i+1] = data[i];
                        data[i] = x;
                        T = false;
                    }
                }
            }
        }
        return data;
    }
    
    public static double[] bubbleSortIII(double[] data, boolean ascending){
        boolean T = true;
        if (ascending) {
            while (T) {
                T = false;
                for (int i = 0; i < data.length-1; i++) {
                    if (data[i] > data[i+1]) {
                        data[i] = data[i] + data[i+1];
                        data[i+1] = data[i] - data[i+1];
                        data[i] = data[i] - data[i+1];
                    }
                }
                for (int i = 0; i < data.length-1; i++) {
                    if (data[i] > data[i+1]) {
                        T = true;
                        break;
                    }
                }
            }
        } else {
            while (T) {
                T = false;
                for (int i = 0; i < data.length-1; i++) {
                    if (data[i] < data[i+1]) {
                        data[i+1] = data[i+1] + data[i];
                        data[i] = data[i+1] - data[i];
                        data[i+1] = data[i+1] - data[i];
                    }
                }
                for (int i = 0; i < data.length-1; i++) {
                    if (data[i] < data[i+1]) {
                        T = true;
                        break;
                    }
                }
            }
        }
        
        return data;
    }
    
    private static double[] RandomGen(int a, boolean T){
        double[] x = new double[a];
        Random r = new Random();
        for (int i = 0; i < x.length; i++) {
            x[i] = T ? r.nextInt(x.length+1) : a;
        }
        return x;
    }
    
    private static double X;
    private static double Y;
    private static void Change(int x, int y){
        x = x + y;
        y = x - y;
        x = x - y;
        
        X = x;
        Y = y;
    }
}
