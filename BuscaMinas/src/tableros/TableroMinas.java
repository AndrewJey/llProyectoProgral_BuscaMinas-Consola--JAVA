/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Paquetes
package tableros;
/**
 *
 ** @author Andrey B & Jeycon M
 ** @date 2016-07-07 Jueves
 **/
public class TableroMinas extends Tablero{
    /**
     * Constructor heredado de la clase Tablero
     * @param tablero
     * @param minas
     * @param lados
     * @param x
     * @param y
     **/
    public TableroMinas(String[][] tablero, String[][] minas, int lados, int x, int y) {
        super(tablero, minas, lados, x, y);
    }
    /**
     * Método para llenar tablero, con minas y numeros
     * @param minas
     * @param lados
     * @return minas
     **/
    public String[][] llenarMinas(String[][] minas, int lados){
        if (lados < 4 || lados > 22 || minas == null || minas.length != lados) throw new IllegalArgumentException("Usa un tablero de 4 a 22 lados.");
        for (String[] fila : minas) if (fila == null || fila.length != lados) throw new IllegalArgumentException("El tablero debe ser cuadrado.");
        java.util.List<Integer> posiciones = new java.util.ArrayList<Integer>();
        for (int i = 0; i < lados * lados; i++) posiciones.add(i);
        java.util.Collections.shuffle(posiciones);
        for (int i = 0; i < lados; i++) java.util.Arrays.fill(minas[i], "[0]");
        for (int i = 0; i < lados * 2; i++) minas[posiciones.get(i) / lados][posiciones.get(i) % lados] = "[M]";
        for (int fila = 0; fila < lados; fila++) for (int columna = 0; columna < lados; columna++) {
            if ("[M]".equals(minas[fila][columna])) continue;
            int vecinas = 0;
            for (int df = -1; df <= 1; df++) for (int dc = -1; dc <= 1; dc++) {
                int f = fila + df, c = columna + dc;
                if (f >= 0 && f < lados && c >= 0 && c < lados && "[M]".equals(minas[f][c])) vecinas++;
            }
            minas[fila][columna] = "[" + vecinas + "]";
        }
        return minas;
    }
    /**
     * Método toString de mi clase TableroMinas, (no se utiliza)
     * @return TableroMinas
     **/
    @Override
    public String toString() {
        return "TableroMinas{" + '}';
    }
}
