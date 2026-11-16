package biblioteca;

import java.util.Map;

/** Cálculo de la multa por devolver un material de la biblioteca con retraso. */
public class CalculadoraMultas {

    private static final int DIAS_DE_GRACIA = 2;
    private static final int DIAS_CON_TARIFA_NORMAL = 10;
    private static final int DIAS_MAXIMOS = 90;
    private static final Map<String, Integer> TARIFA_POR_DIA = Map.of("libro", 500, "revista", 300);
    private static final Map<String, Integer> TOPE_DE_MULTA = Map.of("libro", 20000, "revista", 9000);

    /**
     * Calcula la multa, en pesos, de una devolución con retraso.
     * Los días de retraso se cuentan 1, 2, 3... Los días 1 y 2 son de gracia (no se cobran).
     * Del día 3 al día 10 se cobra la tarifa diaria normal. Desde el día 11 se cobra el doble.
     * La multa nunca supera el tope del material.
     */
    public int calcularMulta(int diasRetraso, String material) {
        validar(diasRetraso, material);

        int multa = 0;
        for (int dia = 1; dia <= diasRetraso; dia++) {
            multa += costoDelDia(dia, TARIFA_POR_DIA.get(material));
        }
        return Math.min(multa, TOPE_DE_MULTA.get(material));
    }

    private static void validar(int diasRetraso, String material) {
        if (!TARIFA_POR_DIA.containsKey(material)) {
            throw new IllegalArgumentException("Tipo de material no válido");
        }
        if (diasRetraso < 0 || diasRetraso > DIAS_MAXIMOS) {
            throw new IllegalArgumentException("Los días deben estar entre 0 y 90");
        }
    }

    private static int costoDelDia(int dia, int tarifaPorDia) {
        if (dia <= DIAS_DE_GRACIA) {
            return 0;
        }
        if (dia <= DIAS_CON_TARIFA_NORMAL) {
            return tarifaPorDia;
        }
        return tarifaPorDia * 2;
    }
}
