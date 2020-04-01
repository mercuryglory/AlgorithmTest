package json;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * created by mercury on 2020-03-29
 */
public class Parser {
    /**
     * 分析Object，使用map数据结构标识
     * @param tokenizer
     * @return
     * @throws Exception
     */
    public static Map<String, Object> parserObject(Tokenizer tokenizer) throws Exception {
        Map<String, Object> map = new HashMap<>();
        Token token = null;
        while (true) {
            token = tokenizer.get();
            if (token.type == TokenType.END_OBJ)
                break;
            if (token.type == TokenType.START_OBJ) {
                tokenizer.next();
                continue;
            }
            if (token.type == TokenType.COMMA) {
                tokenizer.next();
                continue;// 跳过,
            }
            String key = token.value;
            token = tokenizer.next();
            if (token.type != TokenType.COLON)
                throw new Exception();
            tokenizer.next();
            map.put(key, parserValue(tokenizer));
        }
        return map;
    }

    /**
     * 分析Array，使用list数据结构标识
     * @param tokenizer
     * @return
     * @throws Exception
     */
    public static List<Object> parserArray(Tokenizer tokenizer) throws Exception {
        List<Object> list = new LinkedList<>();
        Token token = null;
        while (true) {
            token = tokenizer.get();
            if (token.type == TokenType.END_ARRAY)
                break;
            if (token.type == TokenType.START_ARRAY) {
                tokenizer.next();
                continue;
            }
            if (token.type == TokenType.COMMA) {
                tokenizer.next();
                continue;
            }
            list.add(parserValue(tokenizer));
        }
        return list;
    }

    /**
     * 分析值，根据token再判断值的具体类型
     * @param tokenizer
     * @return
     * @throws Exception
     */
    public static Object parserValue(Tokenizer tokenizer) throws Exception {
        Token token = tokenizer.get();
        try {
            if (token.type == TokenType.START_OBJ) {
                return parserObject(tokenizer);
            } else if (token.type == TokenType.START_ARRAY) {
                return parserArray(tokenizer);
            } else if (token.type == TokenType.BOOLEAN) {
                return Boolean.valueOf(token.value);
            } else if (token.type == TokenType.STRING) {
                return token.value;
            } else if (token.type == TokenType.NUMBER) {
                return token.value;
            } else if (token.type == TokenType.NULL) {
                return null;
            }
            throw new Exception("");
        } finally {
            // object和array分析完后，要跳过其end的token
            // 其他类型分析完后，要跳过自身
            tokenizer.next();
        }
    }

}