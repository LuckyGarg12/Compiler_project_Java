public class Token {
    Integer value;
    String name;
    TokenKind type;
    Integer pos;

    public Token(String name, TokenKind tk, int pos) {
        this(name, tk, pos, null);
    }

    public Token(String name, TokenKind tk, int pos, Integer value) {
        this.name = name;
        this.type = tk;
        this.value = value;
        this.pos = pos;
    }
}
