/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linda.restaurantsalesapplication.app.factories;

import com.linda.restaurantsalesapplication.domain.ComboMeal;
import java.math.BigDecimal;

/**
 *
 * @author linda
 */
public class ComboMealFactory {
    
    public static ComboMeal getComboMeal(String name, BigDecimal discount)
    {
        ComboMeal combo = new ComboMeal();
        combo.setComboName(name);
        combo.setDiscAmount(discount);
        return combo;
        
    }
    
}
