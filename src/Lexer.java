import java.util.Scanner;

public class Lexer {

    private String text;
    private int pos = 0;

    // Moves pointer ahead
    private void nextPos() {
        pos++;
    }

    // Returns the character at current position of pointer 
    private char curChar() {
        if (pos<text.length()) return text.charAt(pos);
        else return '\0'; // For EndOfFile
    }
    
    // Constructor for Lexer
    // For testing, Taking Input from terminal
    public Lexer() {
        Scanner scanner = new Scanner(System.in);

        text = scanner.nextLine();

        scanner.close();
    }

    // Intializes lexer for given text
    public Lexer(String text) {
        this.text = text;
    }

    // Returns the next token
    public SyntaxToken nextToken() {
        String name = "";
        SyntaxKind tk = null;
        Integer value = null;
        int start = pos;

        // EOF token
        if (curChar() == '\0') {
            name += curChar();
            tk = SyntaxKind.EndOfFileToken;
        }

        // WhiteSpace token
        else if (Character.isWhitespace(curChar())) {
            name += curChar();
            tk = SyntaxKind.WhitespaceToken;
            nextPos();
        }

        // Number Token
        else if (Character.isDigit(curChar())) {
            while (Character.isDigit(curChar())) {
                name += curChar();
                nextPos();
            }
            value = Integer.parseInt(name);
            tk = SyntaxKind.NumberToken;
        }

        // Plus Operator Token
        else if (curChar() == '+') {
            name += curChar();
            tk = SyntaxKind.PlusToken;
            nextPos();
        }

        // Minus Operator Token
        else if (curChar() == '-') {
            name += curChar();
            tk = SyntaxKind.MinusToken;
            nextPos();
        }

        // Star Operator Token
        else if (curChar() == '*') {
            name += curChar();
            tk = SyntaxKind.StarToken;
            nextPos();
        }

        // Slash Operator Token
        else if (curChar() == '/') {
            name += curChar();
            tk = SyntaxKind.SlashToken;
            nextPos();
        }

        // Open Parenthesis Token
        else if (curChar() == '(') {
            name += curChar();
            tk = SyntaxKind.OpenParenthesisToken;
            nextPos();
        }

        // Close Parenthesis Token
        else if (curChar() == ')') {
            name += curChar();
            tk = SyntaxKind.CloseParenthesisToken;
            nextPos();
        }

        // Anything else
        else {
            name += curChar();
            tk = SyntaxKind.BadToken;
            nextPos();
        }

        return new SyntaxToken(name, tk, start, value);
    }

    public static void main(String[] args) {
        Lexer l1 = new Lexer();
        SyntaxToken token;
        do {
            token = l1.nextToken();
            System.out.print("Name: "+token.name+" type: " + token.type + " Pos: " + token.pos);
            if (token.value != null) {
                System.out.print(" Value: " + token.value);
            }
            System.out.println();

        } while (token.type != SyntaxKind.EndOfFileToken);
        
    }
}
