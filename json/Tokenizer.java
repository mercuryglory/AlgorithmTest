package json;

import java.util.LinkedList;
import java.util.List;

/**
 * created by mercury on 2020-03-29
 */
public class Tokenizer {
    // 待分析的字符串
    private String json;
    // 读取字符时的索引位置
    private int index = 0;

    // 词法分析结果列表
    private List<Token> tokens = new LinkedList<Token>();
    // 获取词法分析结果时的索引位置
    private int tokenIndex = 0;

    /**
     * 构造函数，触发词法分析
     * @param json
     * @throws Exception
     */
    public Tokenizer(String json) throws Exception {
        this.json = json;
        this.init();
    }

    /**
     * 读取字符串中的字符，索引位置加1
     * @return
     */
    private Character read() {
        if (index < json.length()) {
            return json.charAt(index++);
        } else {
            return null;
        }
    }

    /**
     * 读取字符串中的字符，索引位置减1
     */
    private void unread() {
        index--;
    }

    /**
     * 进行词法分析
     * @throws Exception
     */
    private void init() throws Exception {
        Token token = null;
        while ((token = token()) != null) {
            tokens.add(token);
        }
    }

    /**
     * 按顺序读取字符串，获取词法分析结果
     * @return
     * @throws Exception
     */
    private Token token() throws Exception {
        Character c = read();
        if (c == null) {
            return null;
        }
        // 忽略空白字符、换行符等
        while (isSpace(c)) {
            c = read();
        }
        if (isNull(c)) {
            return new Token(TokenType.NULL, null);
        }
        if (c == '{') {
            return new Token(TokenType.START_OBJ, "{");
        }
        if (c == '}') {
            return new Token(TokenType.END_OBJ, "}");
        }
        if (c == '[') {
            return new Token(TokenType.START_ARRAY, "[");
        }
        if (c == ']') {
            return new Token(TokenType.END_ARRAY, "]");
        }
        if (c == ',') {
            return new Token(TokenType.COMMA, ",");
        }
        if (c == ':') {
            return new Token(TokenType.COLON, ":");
        }
        if (isTrue(c)) {
            return new Token(TokenType.BOOLEAN, "true");
        }
        if (isFalse(c)) {
            return new Token(TokenType.BOOLEAN, "false");
        }
        if (c == '"') {
            return new Token(TokenType.STRING, readString());
        }
        if (isNum(c)) {
            unread();
            return new Token(TokenType.NUMBER, readNum());
        }
        throw new Exception("");
    }

    /**
     * 读取字符串
     * @return
     */
    private String readString() {
        char c = read();
        StringBuffer sb = new StringBuffer();
        while (c != '"') {
            sb.append(c);
            if (isEscape(c)) {
                c = read();
                sb.append(c);
            }
            c = read();
        }
        return sb.toString();
    }

    /**
     * 读取数字，还未考虑所有数字表达形式
     * @return
     */
    private String readNum() {
        char c = read();
        StringBuffer sb = new StringBuffer();
        while (c != '"' && c != ':' && c != ',' && c != ']' && c != '}') {
            sb.append(c);
            c = read();
        }
        unread();
        return sb.toString();
    }

    /**
     * 判断是否为数字开头的特征
     * @param c
     * @return
     */
    private boolean isNum(char c) {
        if (Character.isDigit(c)) {
            return true;
        }
        return false;
    }

    /**
     * 判断是否为转义字符
     * @param c
     * @return
     */
    private boolean isEscape(char c) {
        if (c == '\\')
            return true;
        return false;
    }

    /**
     * 是否为true字符串
     * @param c
     * @return
     * @throws Exception
     */
    private boolean isTrue(char c) throws Exception {
        if (c == 't') {
            c = read();
            if (c == 'r') {
                c = read();
                if (c == 'u') {
                    c = read();
                    if (c == 'e') {
                        return true;
                    } else {
                        throw new Exception("Invalid JSON input.");
                    }
                } else {
                    throw new Exception("Invalid JSON input.");
                }
            } else {
                throw new Exception("Invalid JSON input.");
            }
        } else {
            return false;
        }
    }

    /**
     * 是否为false字符串
     * @param c
     * @return
     * @throws Exception
     */
    private boolean isFalse(char c) throws Exception {
        if (c == 'f') {
            c = read();
            if (c == 'a') {
                c = read();
                if (c == 'l') {
                    c = read();
                    if (c == 's') {
                        c = read();
                        if (c == 'e') {
                            return true;
                        } else {
                            throw new Exception("Invalid JSON input.");
                        }
                    } else {
                        throw new Exception("Invalid JSON input.");
                    }
                } else {
                    throw new Exception("Invalid JSON input.");
                }
            } else {
                throw new Exception("Invalid JSON input.");
            }
        } else {
            return false;
        }
    }

    /**
     * 是否为null字符串
     * @param c
     * @return
     * @throws Exception
     */
    private boolean isNull(char c) throws Exception {
        if (c == 'n') {
            c = read();
            if (c == 'u') {
                c = read();
                if (c == 'l') {
                    c = read();
                    if (c == 'l') {
                        return true;
                    } else {
                        throw new Exception("Invalid JSON input.");
                    }
                } else {
                    throw new Exception("Invalid JSON input.");
                }
            } else {
                throw new Exception("Invalid JSON input.");
            }
        } else {
            return false;
        }
    }

    /**
     * 是否为空字符
     * @param c
     * @return
     */
    private boolean isSpace(char c) {
        if (c == '\t')
            return true;
        if (c == '\n')
            return true;
        if (c == '\r')
            return true;
        if (c == '\0')
            return true;
        if (c == ' ')
            return true;
        return false;
    }

    /**
     * 获取词法分析的下一个结果
     * @return
     */
    public Token next() {
        if (tokenIndex + 1 < tokens.size())
            return tokens.get(++tokenIndex);
        return null;
    }

    /**
     * 获取当前位置的词法分析结果
     * @return
     */
    public Token get() {
        if (tokenIndex < tokens.size())
            return tokens.get(tokenIndex);
        return null;
    }
}
