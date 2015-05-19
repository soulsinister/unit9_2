package unit9_2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase a probar - Caja blanca
 * @author Rosa Medina
 * @author Luis Miguel Rubio Toledo
 */
public class Alumno {
    public boolean validaNif(String nif) {
        if (nif.length() != 9 || nif == null) {
            return false;
        }
        String dni = nif.substring(0, 8);
        char letra = nif.charAt(8);
        Pattern pattern = Pattern.compile("[0-9]{8,8}");
        Matcher matcher = pattern.matcher(dni);
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        long ldni = 0;
        try {
            ldni = Long.parseLong(dni);
        } catch (NumberFormatException e) {
            return false;
        }
        int indice = (int) (ldni % 23);
        char letraEsperada = letras.charAt(indice);
        return matcher.matches() && letra == letraEsperada;
    }   
    public float calculaTasaMatricula(int edad, boolean familiaNumerosa,
            boolean repetidor) {
        float tasa = 500.00f;
        if ((edad < 25) && (!familiaNumerosa) && (repetidor)) {
            tasa = tasa + 1500.00f;
        } else {
            if ((familiaNumerosa) || (edad >= 65)) {
                tasa = tasa / 2;
            }
            if ((edad > 50) && (edad < 65)) {
                tasa = tasa - 100.00f;
            }
        }
        return tasa;
    }
}
