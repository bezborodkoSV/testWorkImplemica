package taskTwo;

import java.io.*;
import java.util.Arrays;

public class GraphDijkstra {
    public static final int SIZE=4;

    public static void main(String[] args) throws IOException {

        int end = 3; // end node index

        int[][]matrix = new int[SIZE][SIZE];
        int[] minSize=new int[SIZE];
        int[] visit=new int[SIZE];
        int temp, minindex,min;
        int beginIndex=0;

        for (int i = 0; i <SIZE ; i++) {
          matrix[i][i]=0;
            for (int j = 0; j < SIZE; j++) {

//                String s1= String.valueOf(matrix[i][j]);

                if (Integer.valueOf(matrix[i][j])!=null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("From  " + (i + 1) + "->" + " To "+(j + 1) + "===");
                    String str = bufferedReader.readLine();
                    if (!str.isEmpty()) {
                        int num = Integer.parseInt(str);
                        System.out.println(num + " num");
                        matrix[i][j] = num;
                        matrix[j][i] = num;
                    } else {
                        matrix[i][j] = 0;

                    }
                }
            }
        }


//        sout
        for (int i = 0; i < SIZE; i++) {
            System.out.println(Arrays.toString(matrix[i]));

        }
//        end sout

        for (int i = 0; i<SIZE; i++) {
            minSize[i] = 10000;
            visit[i] = 1;
        }
        minSize[beginIndex] = 0;
        // Algorithm step
        do {
            minindex = 10000;
            min = 10000;
            for (int i = 0; i<SIZE; i++) {
                // If the vertex has not yet been bypassed and the weight is less than min
                if ((visit[i] == 1) && (minSize[i]<min)) {
                    // Reassigning Values
                    min = minSize[i];
                    minindex = i;
                }
            }
            // Add the found minimum weight to the current vertex weight and compare with the current minimum vertex weight
            if (minindex != 10000)
            {
                for (int i = 0; i<SIZE; i++)
                {
                    if (matrix[minindex][i] > 0)
                    {
                        temp = min + matrix[minindex][i];
                        if (temp < minSize[i])
                        {
                            minSize[i] = temp;
                        }
                    }
                }
                visit[minindex] = 0;
            }
        } while (minindex < 10000);

        // Path recovery
        int[] ver=new int[SIZE]; // array visited vertex

        ver[0] = end + 1; //first element -->last vertex
        int k = 1; // previous index
        int weight = minSize[end]; // weight last vertex

        while (end != beginIndex) // until you reach the first top
        {
            for (int i = 0; i<SIZE; i++) // sea all vertex
                if (matrix[i][end] != 0){
                    int tem = weight - matrix[i][end]; // determine the weight of the path from the previous vertex
                    if (tem == minSize[i]) {
                        weight = tem; // save new weight
                        end = i;       // save previous vertex
                        ver[k] = i + 1; // save in array
                        k++;
                    }
                }
        }


        System.out.println("\n min path: \n");
        for (int i = k - 1; i >= 0; i--) {
            System.out.println(ver[i]);
        }




    }




}
