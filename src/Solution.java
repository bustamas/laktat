/*
* File: Solution.java
* Author: Bús Tamás
* Copyright: 2025, Bús Tamás
* Group: Szoft I/N
* Date: 2025-03-11
* Github: https://github.com/bustamas/
* Licenc: MIT
*/

import java.util.ArrayList;

public class Solution {
    public static void startSolution() {
        ArrayList<Employee> empList = Store.readFile();
        if (!empList.isEmpty()) {
            System.out.println(empList.get(0).getNev());
            calcAverageSalary(empList); 
        } else {
            System.out.println("Nincs alkalmazott az adatbázisban.");
        }
    }
    public static void calcAverageSalary(ArrayList<Employee> empList) {
        double totalSalary = 0;
        int count = 0;
        for (Employee emp : empList) {
            if (emp.getHely().equals("Budapest")) {
                totalSalary += emp.getFizetes();
                count++;
            }
        }
        if (count > 0) {
            double averageSalary = totalSalary / count;
            System.out.println("A Budapesten dolgozó alkalmazottak átlagfizetése: " + averageSalary);
        } else {
            System.out.println("Nincsenek alkalmazottak Budapesten.");
        }
    }
}
    

    
