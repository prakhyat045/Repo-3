package src.main.java.com.zs.assignment1.systeminfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Matrix_operations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String choice = "y";
        do {

            System.out.println("1. Addition of two matrices");
            System.out.println("2. Subtraction of two matrices");
            System.out.println("3. Multiplication of two matrices");
            System.out.println("4. Scalar multiplication of a matrix");
            System.out.println("5. Transpose of a matrix");
            System.out.println("Enter your choice ");
            int i = sc.nextInt();
            switch(i)
            {
                case 1:
                    System.out.println("Enter rows and columns for matrix A and matrix B." +
                            "\n(Note: For matrix addition rows and columns of both the matrix should be same.");
                    System.out.println("Enter number of rows");
                    int rows = sc.nextInt();
                    System.out.println("Enter number of columns");
                    int cols = sc.nextInt();
                    addition(rows,cols);
                    break;
                case 2:
                    System.out.println("Enter rows and columns for matrix A and matrix B." +
                            "\n(Note: For matrix subtraction rows and columns of both the matrix should be same.");
                    System.out.println("Enter number of rows");
                    rows = sc.nextInt();
                    System.out.println("Enter number of columns");
                    cols = sc.nextInt();
                    subtraction(rows,cols);
                    break;
                case 3:
                    multiplication();


            }
            sc.nextLine();
            System.out.println("Do you wish to continue.(Y/n)");
            choice = sc.nextLine();
        }while(choice.equalsIgnoreCase("Y"));
    }


    public static List<List<Integer>> matrixInput(int rows, int cols){

        Scanner sc = new Scanner(System.in);
        List<List<Integer>> matrix = new ArrayList<List<Integer>>();
        for(int i =0; i<rows; i++){
            matrix.add(new ArrayList<Integer>());
            for(int j = 0; j<cols; j++){
                int temp = sc.nextInt();
                matrix.get(i).add(temp);
            }
        }
        return matrix;
    }

    public static void matrixPrint(List<List<Integer>> matrix, int rows, int cols){
        for(int i =0; i<rows; i++){
            for(int j =0; j<cols; j++){
                System.out.print(matrix.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }


    public static void addition(int rows , int cols){

        System.out.println("Enter values for matrix A");
        List<List<Integer>> matA = matrixInput(rows,cols);
        System.out.println("Enter values for matrix B");
        List<List<Integer>> matB = matrixInput(rows,cols);

        List<List<Integer>> matResult = new ArrayList<List<Integer>>();

        for(int i =0; i<rows; i++) {
            matResult.add(new ArrayList<Integer>());
            for(int  j =0; j<cols; j++){
                matResult.get(i).add(matA.get(i).get(j)+matB.get(i).get(j));
            }
        }
        matrixPrint(matResult,rows,cols);
    }

    public static void subtraction(int rows , int cols){

        System.out.println("Enter values for matrix A");
        List<List<Integer>> matrixA = matrixInput(rows,cols);
        System.out.println("Enter values for matrix B");
        List<List<Integer>> matrixB = matrixInput(rows,cols);

        List<List<Integer>> matResult = new ArrayList<List<Integer>>();

        for(int i =0; i<rows; i++) {
            matResult.add(new ArrayList<Integer>());
            for(int  j =0; j<cols; j++){
                matResult.get(i).add(matrixA.get(i).get(j)-matrixB.get(i).get(j));
            }
        }
        matrixPrint(matResult,rows,cols);
    }

    public static void multiplication(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Note: Number of columns for matrix A and number of rows for matrix B should be same.");
        int rowA, colA, rowB, colB;
        String choice = "N";
        do{
            System.out.println("Enter number of rows for matrix A");
            rowA = sc.nextInt();
            System.out.println("Enter number of columns for matrix A");
            colA = sc.nextInt();
            System.out.println("Enter number of rows for matrix B");
            rowB = sc.nextInt();
            System.out.println("Enter number of columns for matrix B");
            colB = sc.nextInt();

            if(colA != rowB){
                System.out.println("Matrix multiplication is not possible. Number of columns for matrix A and number of rows for matrix B should be same.");
                System.out.println("Please enter values again. Do you wish to continue(Y/n) ");
                sc.nextLine();
                choice = sc.nextLine();
            }
            else{
                choice = "n";
            }
        }while(choice.equalsIgnoreCase("Y"));

        List<List<Integer>> matrixA = matrixInput(rowA,colA);
        List<List<Integer>> matrixB = matrixInput(rowB,colB);
    }
}
