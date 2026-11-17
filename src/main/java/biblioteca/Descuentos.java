package biblioteca;

public class Descuentos {

    public int aplicardescuento(String tipoUsuario) {

        // Caso de error
        if (tipoUsuario.equals("negativo")) {
            throw new IllegalArgumentException();
        }

        // Arreglos con los tipos y sus descuentos
        String[] tipos = {"externo", "estudiante", "docente"};
        int[] descuentos = {0, 10, 20};

        // Buscamos con for + if
        for (int i = 0; i < tipos.length; i++) {
            if (tipos[i].equals(tipoUsuario)) {
                return descuentos[i];
            }
        }

        // Si no encuentra el tipo (por si acaso)
        return 0;
    }
}
