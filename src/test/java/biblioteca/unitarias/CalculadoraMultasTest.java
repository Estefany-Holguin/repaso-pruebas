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
    @Test
    @DisplayName("Rechaza un número de días negativo")
    void rechazaUnNumeroDeDiasNegativo() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularMulta(-1, "libro"));
    }
    @Test
    @DisplayName("Rechaza un número de días mayor a 90")
    void rechazaUnNumeroDeDiasMayorA90() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularMulta(91, "revista"));
    }
    @Test
    @DisplayName("Un libro con 2 dias de retraso no paga multa")
    void libroConDosDiasNoPagaMulta() {
        assertEquals(0, calculadora.calcularMulta(2, "libro"));
    }
    @Test
    @DisplayName("un libro con 11 dias paga el doble de la tarifa diaria")
    void libroCon11DiasPagaElDobleDeLaTarifaDiaria() {
        assertEquals(5000, calculadora.calcularMulta(11, "libro"));
    }
    @Test
    @DisplayName("una revista con 3 dias paga la tarifa diaria")
    void revistaCon3DiasPagaLaTarifaDiaria() {
        assertEquals(300, calculadora.calcularMulta(3, "revista"));
    }
}
