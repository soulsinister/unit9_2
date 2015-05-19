/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unit9_2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luis Miguel
 */
public class AlumnoTest {
    
    public Alumno alum;
    
    public AlumnoTest() {
        this.alum = new Alumno();
    }

    /**
     * Test of validaNif method, of class Alumno.
     */
    @Test
    public void testValidaNif() {
        boolean expecteds = true;
        boolean actual;
        
        // dni validado
        actual = alum.validaNif("48622226L");
        assertEquals(expecteds, actual);
        
        // dni sin 9 digitos
        expecteds = false;
        actual = alum.validaNif("");
        assertEquals(expecteds, actual);
        
        // dni sin letra
        actual = alum.validaNif("123456789");
        assertEquals(expecteds, actual);
        
        // dni con simbolos raros
        actual = alum.validaNif("12@4.678L");
        assertEquals(expecteds, actual);

    }

    /**
     * Test of calculaTasaMatricula method, of class Alumno.
     */
    @Test
    public void testCalculaTasaMatricula() {
        double expecteds = 250.00f;
        double deltaexpecteds = 2000;
        double actual;
        
        actual = alum.calculaTasaMatricula(35, false, false);
        assertEquals(expecteds, actual, expecteds);

        // control de (edad < 25) && (!familiaNumerosa) && (repetidor)
        actual = alum.calculaTasaMatricula(18, false, true);
        assertEquals(expecteds, actual, deltaexpecteds);
        
        actual = alum.calculaTasaMatricula(18, true, true);
        assertEquals(expecteds, actual, deltaexpecteds);
        
        actual = alum.calculaTasaMatricula(18, true, false);
        assertEquals(expecteds, actual, deltaexpecteds);
        
        actual = alum.calculaTasaMatricula(18, false, false);
        assertEquals(expecteds, actual, deltaexpecteds);
        
        // control (familiaNumerosa) || (edad >= 65)
        actual = alum.calculaTasaMatricula(55, true, true);
        assertEquals(expecteds, actual, deltaexpecteds);
        
        actual = alum.calculaTasaMatricula(65, false, true);
        assertEquals(expecteds, actual, deltaexpecteds);
        
        // control de (edad > 50) && (edad < 65)
        actual = alum.calculaTasaMatricula(55, true, true);
        assertEquals(expecteds, actual, deltaexpecteds);
    }
    
}
