/*
* File: Solution.java
* Author: Bús Tamás
* Copyright: 2025, Bús Tamás
* Group: Szoft I/N
* Date: 2025-03-11
* Github: https://github.com/bustamas/
* Licenc: MIT
*/

import java.io.IOException;
import java.util.ArrayList;

public class Solution {
    public static void startSolution() {
        ArrayList<Employee> empList = Store.readFile();
        if (!empList.isEmpty()) {
            System.out.println(empList.get(0).getNev());  // Kiírjuk az első alkalmazott nevét
        } else {
            System.out.println("Nincs alkalmazott az adatbázisban.");
        }
        
    }
    public static void tryTask01(ArrayList<Employee> empList) throws IOException{
        for (Employee emp : empList) {
            if (emp.getHely().equals("Budapest")){
                System.out.println(emp.getNev()+"\n");
            }
        }
    }
}

    

    
