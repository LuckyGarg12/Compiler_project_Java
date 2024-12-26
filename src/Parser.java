import java.util.ArrayList;
import java.util.Scanner;

public class Parser {

    private final SyntaxToken[] tokens;
    private int position;

    public Parser(String text) {

        ArrayList <SyntaxToken> tokenList = new ArrayList<SyntaxToken>();
        Lexer lex = new Lexer(text);
        SyntaxToken token;

        do
        {
            token = lex.nextToken();

            if (token.type != SyntaxKind.WhitespaceToken && token.type != SyntaxKind.BadToken) {
                tokenList.add(token);
            }
        } while (token.type != SyntaxKind.EndOfFileToken);

        tokens = new SyntaxToken[tokenList.size()];
        tokenList.toArray(tokens);
    }

    SyntaxToken peek(int offset) {
        int index = position+offset;
        if (index >= tokens.length) {
            return tokens[tokens.length-1];
        }
        return tokens[index];
    }

    SyntaxToken currentToken() {
        return peek(0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Parser p1 = new Parser(scanner.nextLine());
        System.out.println(p1.currentToken().type);

        scanner.close();
    }
}
