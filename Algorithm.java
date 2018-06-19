package Aishwarya;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class Algorithm
{
public void solve(int[] weight, int[] valu, int X, int Y, Map <Integer, Integer>knapsackMap)
    {
int NEGATIVE_INFINITY = Integer.MIN_VALUE;
int[][] m = new int[Y + 1][X + 1];
int[][] sol = new int[Y + 1][X + 1];

for (int i = 1; i <= Y; i++)
        {
for (int j = 0; j <= X; j++)
            {
int m1 = m[i - 1][j];
int m2 = NEGATIVE_INFINITY; 
if (j >= weight[i])
                    m2 = m[i - 1][j - weight[i]] + valu[i];
                /** select max of m1, m2 **/
m[i][j] = Math.max(m1, m2);
sol[i][j] = m2 > m1 ? 1 : 0;
            }
        }        
int[] selected = new int[Y + 1];
for (int y = Y, x = X; y > 0; y--)
        {
if (sol[y][x] != 0)
            {
selected[y] = 1;
                x = x - weight[y];
            }
else
selected[y] = 0;
        }
System.out.println("\nSelected  : ");
for (int i = 1; i < Y + 1; i++)
if (selected[i] == 1){
System.out.print(i +" ");
            }
else {
knapsackMap.remove(i);
          }
System.out.println();
System.out.println("values choosed \n");
        Integer overAllValue = 0;
for(Map.Entry<Integer,Integer> entry : knapsackMap.entrySet()){
	System.out.print(entry.getValue()+"   ");
	overAllValue += entry.getValue();
        }
System.out.println();
System.out.println("Overall Value  : \n"+overAllValue);
    }
public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);



        Algorithm ks = new Algorithm();

System.out.println("Number of elements");
int y = scan.nextInt();

int[] weight = new int[y + 1];
int[] valu = new int[y + 1];

System.out.println("\nEnter weight for "+ y +" elements");

for (int i = 1; i <= y; i++)
weight[i] = scan.nextInt();

System.out.println("\nEnter value for "+ y +" elements");

for (int i = 1; i <= y; i++)
valu[i] = scan.nextInt();

        Map<Integer, Integer>knapsackMap = new HashMap<Integer, Integer>();
        // consider user asking overall value from value object, if its wait change valu to weight in the map.
for(int i=1; i <= y; i++){
	knapsackMap.put(i, valu[i]);
        }

System.out.println("\nweight ");

int X = scan.nextInt();

ks.solve(weight, valu, X, y,knapsackMap);
scan.close();
    }
}
