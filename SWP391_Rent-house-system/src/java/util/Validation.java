/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class Validation {
    public String getCurrentDate() {
        long timeInMillis = System.currentTimeMillis();
        Calendar cal1 = Calendar.getInstance();
        cal1.setTimeInMillis(timeInMillis);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy     hh:mm:ss a");
        String date = dateFormat.format(cal1.getTime());
        return date;
    }
}
