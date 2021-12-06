package Sorting;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class Shaper {

    Shaper() throws FileNotFoundException, IOException {
        Random rand = new Random();
        BufferedWriter f = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + "\\Тесты\\Test1.txt")));
        BufferedWriter f1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + "\\Тесты\\Test2.txt")));
        BufferedWriter f2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + "\\Тесты\\Test3.txt")));
        BufferedWriter f3 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + "\\Тесты\\Test4.txt")));
        BufferedWriter f4 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(System.getProperty("user.dir") + "\\Тесты\\Test5.txt")));
        for (int i = 0; i < 49; i++) {
            for (int j = 0; j < 10; j++) {
                f.write(rand.nextInt(1000) + " ");
            }
            f.write(rand.nextInt(1000) + "\n");
        }
        for (int j = 0; j < 10; j++) {
            f.write(rand.nextInt(1000) + " ");
        }
        f.write(rand.nextInt(1000));
        for (int i = 0; i < 49; i++) {
            int k = rand.nextInt(1000);
            for (int j = k; j < k + 9; j++) {
                f1.write(j + " ");
            }
            f1.write((k + 9) + "\n");
        }
        int k = rand.nextInt(1000);
        for (int j = k; j < k + 9; j++) {
            f1.write(j + " ");
        }
        f1.write((k + 9));
        for (int i = 0; i < 49; i++) {
            k = rand.nextInt(1000);
            for (int j = k; j > k - 9; j--) {
                f2.write(j + " ");
            }
            f2.write((k - 9) + "\n");
        }
        k = rand.nextInt(100);
        for (int j = k; j > k - 10; j--) {
            f2.write(j + " ");
        }
        for (int i = 0; i < 49; i++) {
            k = rand.nextInt(1000);
            for (int j = k; j < k + 10; j++) {
                f3.write(j + " ");
            }
            for (int j = 0; j < 10; j++) {
                f3.write(rand.nextInt(1000) + " ");
            }
            f3.write(rand.nextInt(1000) + "\n");
        }
        k = rand.nextInt(1000);
        for (int j = k; j < k + 10; j++) {
            f3.write(j + " ");
        }
        for (int j = 0; j < 10; j++) {
            f3.write(rand.nextInt(1000) + " ");
        }
        f3.write(rand.nextInt(1000));
        for (int i = 0; i < 49; i++) {
            k = rand.nextInt(1000);
            for (int j = k; j < k + 10; j++) {
                f4.write(j + " ");
            }
            k = rand.nextInt(1000);
            for (int j = k; j < k + 10; j++) {
                f4.write(j + " ");
            }
            f4.write(k + 500 + "\n");
        }
        k = rand.nextInt(1000);
        for (int j = k; j < k + 10; j++) {
            f4.write(j + " ");
        }
        k = rand.nextInt(1000);
        for (int j = k; j < k + 10; j++) {
            f4.write(j + " ");
        }
        f.close();
        f1.close();
        f2.close();
        f3.close();
    }
}
