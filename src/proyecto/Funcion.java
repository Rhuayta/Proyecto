/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import org.nfunk.jep.JEP;

/**
 *
 * @author H P
 */
public class Funcion {
      private String expresion = "";
    
    
    public Funcion(String expresion){
        this.expresion = expresion;
    }
    
    public double evaluar(double x){  
       JEP j = new JEP(); 
       j.addStandardFunctions();
       j.addStandardConstants();
       j.addVariable("x", x);
       j.parseExpression(this.expresion);
       
        if (!j.hasError()) {
            return j.getValue();
        } else {
            return Double.NaN;
        }           
    }
    
    
    
}
