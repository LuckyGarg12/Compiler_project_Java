public class Token {
    Integer value;
    String name;
    SyntaxKind type;
    Integer pos;

    // For tokens with no value
    public Token(String name, SyntaxKind tk, int pos) {
        this(name, tk, pos, null);
    }

    public Token(String name, SyntaxKind tk, int pos, Integer value) {
        this.name = name;
        this.type = tk;
        this.value = value;
        this.pos = pos;
    }
}
