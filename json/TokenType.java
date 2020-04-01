package json;

/**
 * created by mercury on 2020-03-29
 */
public enum TokenType {

    START_OBJ,         // {
    END_OBJ,
    START_ARRAY,       // [
    END_ARRAY,
    NULL,
    NUMBER,
    STRING,
    BOOLEAN,
    COLON,      // :
    COMMA,      // ,
}
