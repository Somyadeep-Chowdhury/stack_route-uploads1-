package com.stackroute.javape3;

public class Addition {
    public  int[][] addMatrix(int[][] first, int[][] second,int x, int y)
    {

        int[][] c= new int[x][y];
//        Scanner sc= new Scanner(System.in);
//        System.out.println("Enter numbers of rows:");
//        x=sc.nextInt();
//        System.out.println("Enter numbers of columns:");
//        y=sc.nextInt();
//
//        int[][] a= new int[x][y];
//        int[][] b= new int[x][y];
//        int[][] c= new int[x][y];
//        System.out.println("Enter input of first element:");
//            for(int i=0 ;i<x ;i++)
//            {
//                for(int j=0 ;j<y ;j++)
//                {
//                    a[i][j] = sc.nextInt();
//                }
//            }
//        System.out.println("Enter input of second element:");
//        for(int i=0 ;i<x ;i++)
//        {
//            for(int j=0 ;j<y ;j++)
//            {
//                b[i][j] = sc.nextInt();
//            }
//        }
//        System.out.println("Addition of matrix is:");
        for(int i=0 ;i<x ;i++)
        {
            for(int j=0 ;j<y ;j++)
            {
                c[i][j] = first[i][j] + second[i][j];
            }
        }
        return c;
    }
}
