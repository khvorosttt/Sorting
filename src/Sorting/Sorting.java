/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Lenovo
 */
public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        Shaper s= new Shaper();
        FileIn();
        /*show(A[0]);
        Bubble(A[0]);
        show(A[0]);
        show(A[1]);
        ShellSort(A[1]);
        show(A[1]);
        show(A[2]);
        Quick_recursion(0, A[2].length - 1, A[2]);
        show(A[2]);*/
    }

    public static void FileIn() throws FileNotFoundException, IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(new FileInputStream(System.getProperty("user.dir") + "\\Тесты\\Test1.txt")));
        BufferedWriter f1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + "\\Тесты\\Out.txt")));
        int[][] A = new int[50][10];
        for (int i = 0; i < 50; i++) {
            String[] data = f.readLine().split(" ");
            A[i]=new int[10];
            for(int j=0;j<10;j++){
                A[i][j]=Integer.parseInt(data[j]);
            }
            
            //Bubble(A[i]);
            ShellSort(A[i]);
            //Quick_recursion(0, A[i].length - 1, A[i]);
            showFile(A[i], f1);
        }
        f1.close();
    }

    //Сортировка пузырьком
    public static void Bubble(int[] A) {
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length - i - 1; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                    //show(A);
                }
            }
        }
    }
    public static void showFile(int[] A, BufferedWriter f1) throws FileNotFoundException, IOException{
        
        for(int i=0;i<A.length-1;i++){
            f1.write(A[i]+" ");
        }
        f1.write(A[A.length-1]+"\n");
    }
    //показ результата
    public static void show(int[] A) {
        for (int i = 0; i < A.length - 1; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.print(A[A.length - 1]);
        System.out.println();
    }

    //Сортировка методом Шелла
    public static void ShellSort(int[] A) {
        List<Integer> f = Fibonacci(A);
        while (!f.isEmpty()) {
            int k = f.get(0);
            f.remove(0);
            for (int i = 0; i < A.length - k; i++) {
                int j = i;
                while (j + k < A.length) {
                    if (A[j] > A[j + k]) {
                        int temp = A[j];
                        A[j] = A[j + k];
                        A[j + k] = temp;
                        //show(A);
                    }
                    j = j + k;
                }
            }
        }
    }

    //формирование последовательности Фибоначчи
    public static List<Integer> Fibonacci(int[] A) {
        List<Integer> f = new ArrayList<>();
        f.add(1);
        int N = A.length;
        f = Recursion(f, N);
        Collections.sort(f, Collections.reverseOrder());
        return f;
    }

    public static List<Integer> Recursion(List<Integer> f, int N) {//рекурсивный алгоритм нахождения чисел Фибоначчи
        if (f.get(f.size() - 1) > N) {
            f.remove(f.size() - 1);
            return f;
        } else {
            if (f.size() == 1) {
                f.add(1);
            } else {
                f.add(f.get(f.size() - 1) + f.get(f.size() - 2));
            }
            return Recursion(f, N);
        }
    }

    //Быстрая сортировка(В порядке возрастания)
    public static void Quick_recursion(int left, int right, int[] A) {
        if (left < right) {
            int median = (int) (Math.random() * (right - left) + left);
            int X = A[median];//Число, с которым будет происходить сравнение
            int L = left;
            int R = right;
            while (L <= R) {
                while (A[L] < X) {//поиск первого слева элемента, который больше Х
                    L++;
                }
                while (A[R] > X) {//поиск первого элемента с конца справа, который меньше Х
                    R--;
                }
                if (L <= R) {//Если условие выполняется, то происходит обмен
                    int temp = A[L];
                    A[L] = A[R];
                    A[R] = temp;
                    L++;
                    R--;
                    //show(A);
                }
            }
            //сортировка оставшейся части массива
            Quick_recursion(left, R, A);
            Quick_recursion(L, right, A);
        }

    }
}
