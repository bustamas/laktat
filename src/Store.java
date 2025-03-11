/*
* File: Store.java
* Author: Bús Tamás
* Copyright: 2025, Bús Tamás
* Group: Szoft I/N
* Date: 2025-03-11
* Github: https://github.com/bustamas/
* Licenc: MIT
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    public static ArrayList<Employee> readFile() {
        ArrayList<Employee> empList = new ArrayList<>();
        try {
            tryReadFile(empList);
        } catch (FileNotFoundException e) {
            System.err.println("Hiba! A fájl nem található!");
            System.err.println(e.getMessage());
        }
        return empList;
    }
    public static void tryReadFile(ArrayList<Employee> empList) throws FileNotFoundException {
        File file = new File("laktatkft.txt");
        try (Scanner sc = new Scanner(file, "utf8")) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArray = line.split(";");
                Employee emp = new Employee();
                emp.setNev(lineArray[0]);
                emp.setHely(lineArray[1]);
                emp.setUtca(lineArray[2]);
                String[] szuletesArray = lineArray[3].split("-");
                String ev = szuletesArray[0];
                String ho = String.format("%02d", Integer.parseInt(szuletesArray[1]));
                String nap = String.format("%02d", Integer.parseInt(szuletesArray[2]));
                String szuletesDateStr = ev + "-" + ho + "-" + nap;
                try {
                    emp.setSzuletes(LocalDate.parse(szuletesDateStr));
                } catch (Exception e) {
                    System.err.println("Hiba a dátum formátumban: " + szuletesDateStr);
                    continue;
                }
                emp.setFizetes(Double.parseDouble(lineArray[4]));
                empList.add(emp);
            }
        }
    }
}