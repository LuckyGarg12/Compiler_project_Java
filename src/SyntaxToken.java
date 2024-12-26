public class SyntaxToken {
    Integer value;
    String name;
    SyntaxKind type;
    Integer pos;

    // For tokens with no value
    public SyntaxToken(String name, SyntaxKind tk, int pos) {
        this(name, tk, pos, null);
    }

    public SyntaxToken(String name, SyntaxKind tk, int pos, Integer value) {
        this.name = name;
        this.type = tk;
        this.value = value;
        this.pos = pos;
    }
}
