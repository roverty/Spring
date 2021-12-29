import java.util.Collection;

import org.springframework.validation.Errors;

/**
 ** Clase de utileria que contiene métodos para realizar validaciones de los datos que
 * contienen las
 * entidades de negocio. Estos validadores se pueden aplicar a cualquier capa (Web,
 * servicios,
 * validacion de notificaciones xml).
 * @author Jorge Rodríguez Campos (jorge.rodriguez@synergyj.com)
 */
public class CustomValidator {

  /**
   * Property name que indica que un campo debe ser obligatorio.
   */
  public static final String REQUIRED_MESSAGE_KEY = "required";

  /**
   * property name que asocia al mensaje enviado a la vista cuando una lista esta nula o
   * vacia.
   */
  public static final String EMPTY_LIST_MESSAGE_KEY = "custom.validation.empty.list";

  /**
   * Valor menor al especificado. Su valor debe estar configurado en un archivo properties
   * de
   * mensajes: custom.validation.notGreaterThanValue
   */
  public static String NOT_GREATER_THAN_MESSAGE_KEY =
    "custom.validation.not.greater.than.value";

  /**
   * Mensaje empleado para indicar que una cadena no cumple con la longitud requerida.
   */
  public static String NOT_IN_LENGTH = "custom.validation.string.length";

  /**
   * Esta cadena se imprimirá en las visas en caso de que no se encuentre el nombre del
   * property
   * en el archovo messages.properties.
   */
  public static String DEFAULT_MESSAGE =
    "message key not found in properties file (add it)";

  /**
   * Verifica que el valor de un campo no sea menor al valor referenciado. El mensaje
   * generado
   * acepta un argumento para indicar el valor de referencia.
   * @author Jorge A. Rodríguez Campos (jorge.rodriguez@synergj.com,
   *         jorgerdc79@hotmail.com)
   * @param fieldName
   * @param value
   * @param referencedValue
   * @param errors
   */
  public static void rejectIfNotGreaterThan(String fieldName, double value,
    double referencedValue, Errors errors) {
    if (value <= referencedValue) {
      errors.rejectValue(fieldName, NOT_GREATER_THAN_MESSAGE_KEY, new Object[] { value },
        DEFAULT_MESSAGE);
    }
  }

  /**
   * Verifica que una lista no sea nula o vacia.
   * @author Jorge A. Rodríguez Campos (jorge.rodriguez@synergj.com,
   *         jorgerdc79@hotmail.com)
   * @param fieldName
   * @param value
   * @param errors
   */
  public static void rejectIfEmpty(String fieldName, Collection<?> value, Errors errors) {
    if (value == null || value.size() == 0) {
      errors.rejectValue(fieldName, EMPTY_LIST_MESSAGE_KEY, DEFAULT_MESSAGE);
    }
  }

  /**
   * Rechaza un campo vacío
   * @author David Eduardo Gómez Noguera (david.gomez@ife.org.mx)
   * @param fieldName
   * @param value
   * @param errors
   */
  public static void rejectIfEmpty(String fieldName, String value, Errors errors) {
    if (value == null || value.trim().length() == 0) {
      errors.rejectValue(fieldName, REQUIRED_MESSAGE_KEY, DEFAULT_MESSAGE);
    }
  }

  /**
   * Verifica que una cadena tenga como longitud minima y máxima la especificada en los
   * parámetros.
   * @param fieldName
   * @param value
   * @param minValue
   * @param maxValue
   */
  public static void rejectIfNotInLength(String fieldName, String value, int minValue,
    int maxValue, Errors errors) {
    int length = value == null ? 0 : value.trim().length();
    if (value == null || length < minValue || length > maxValue) {
      errors.rejectValue(fieldName, NOT_IN_LENGTH, new Object[] { minValue, maxValue },
        DEFAULT_MESSAGE);
    }
  }

}
