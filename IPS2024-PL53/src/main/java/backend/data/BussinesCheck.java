package backend.data;

public class BussinesCheck {

    public static boolean isFalse(boolean condition) {
        return !condition;  // Devuelve true si la condición es false, de lo contrario devuelve false
    }
    
    public static boolean isFalse(boolean condition, String errorMsg) {
        return !condition;  // El mensaje de error ya no es necesario en este caso, porque no lanzaremos una excepción
    }
    
    public static boolean isTrue(boolean condition) {
        return condition;  // Devuelve el valor de la condición directamente
    }
    
    public static boolean isTrue(boolean condition, String msg) {
        return condition;  // El mensaje de error ya no es necesario si solo necesitamos el valor booleano
    }
}

