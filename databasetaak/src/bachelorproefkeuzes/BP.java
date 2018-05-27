/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bachelorproefkeuzes;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Jonathan
 */
public class BP {
    private SimpleStringProperty titel;
    private SimpleStringProperty beschrijving;

    public BP(String titel, String beschrijving) {
        this.titel = new SimpleStringProperty(titel);
        this.beschrijving = new SimpleStringProperty(beschrijving);
    }
    
    public SimpleStringProperty titelProperty() {
        return titel;
    }
    
    public SimpleStringProperty beschrijvingProperty() {
        return beschrijving;
    }
    
    
}
