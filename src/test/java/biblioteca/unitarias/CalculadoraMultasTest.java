package biblioteca.unitarias;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import biblioteca.CalculadoraMultas;

/** Pruebas unitarias iniciales de calcularMulta. Están incompletas a propósito. */
class CalculadoraMultasTest {

    private final CalculadoraMultas calculadora = new CalculadoraMultas();

    @Test
    @DisplayName("Un libro con tres días de retraso paga un día de multa")
    void libroConTresDiasPagaUnDia() {
        assertEquals(500, calculadora.calcularMulta(3, "libro"));
    }

    @Test
    @DisplayName("Una revista con cinco días de retraso paga tres días de multa")
    void revistaConCincoDiasPagaTresDias() {
        assertEquals(900, calculadora.calcularMulta(5, "revista"));
    }

    @Test
    @DisplayName("Rechaza un material desconocido")
    void rechazaUnMaterialDesconocido() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularMulta(5, "periodico"));
    }
}
