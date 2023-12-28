/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilitarios;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author rafae
 */
public class Utils {
    
    static NumberFormat formatandoValores = new DecimalFormat("R$ #,###0.00");
    
    public static String doubleToString(Double valor){
        return formatandoValores.format(valor);
    }
    
}
