import java.util.Scanner;

public class Lexer {

    private String exp;
    private int pos = 0;

    // Moves pointer ahead
    private void nextPos() {
        pos++;
    }

    // Returns the character at current position of pointer 
    private char curChar() {
        if (pos<exp.length()) return exp.charAt(pos);
        else return '\0'; // For EndOfFile
    }
    
    // Constructor for Lexer
    // Will take the program file as input
    // For testing, Taking Input from terminal
    public Lexer() {
        Scanner scanner = new Scanner(System.in);

        exp = scanner.nextLine();

        scanner.close();
    }

    // Returns the next token
    public Token nextToken() {
        String name = "";
        TokenKind tk = null;
        Integer value = null;
        int start = pos;

        // EOF token
        if (curChar() == '\0') {
            name += curChar();
            tk = TokenKind.EndOfFileToken;
        }

        // WhiteSpace token
        else if (Character.isWhitespace(curChar())) {
            name += curChar();
            tk = TokenKind.WhitespaceToken;
            nextPos();
        }

        // Number Token
        else if (Character.isDigit(curChar())) {
            while (Character.isDigit(curChar())) {
                name += curChar();
                nextPos();
            }
            value = Integer.parseInt(name);
            tk = TokenKind.NumberToken;
        }

        else if (curChar() == '+') {
            name += curChar();
            tk = TokenKind.PlusToken;
            nextPos();
        }
        else if (curChar() == '-') {
            name += curChar();
            tk = TokenKind.MinusToken;
            nextPos();
        }
        else if (curChar() == '*') {
            name += curChar();
            tk = TokenKind.StarToken;
            nextPos();
        }
        else if (curChar() == '/') {
            name += curChar();
            tk = TokenKind.SlashToken;
            nextPos();
        }
        else if (curChar() == '(') {
            name += curChar();
            tk = TokenKind.OpenParenthesisToken;
            nextPos();
        }
        else if (curChar() == ')') {
            name += curChar();
            tk = TokenKind.CloseParenthesisToken;
            nextPos();
        }

        else {
            name += curChar();
            tk = TokenKind.BadToken;
        }

        return new Token(name, tk, start, value);
    }

    public static void main(String[] args) {
        Lexer l1 = new Lexer();
        Token token;
        do {
            token = l1.nextToken();
            System.out.print("Name: "+token.name+" type: " + token.type + " Pos: " + token.pos);
            if (token.value != null) {
                System.out.print(" Value: " + token.value);
            }
            System.out.println();

        } while (token.type != TokenKind.EndOfFileToken);
        
    }
}
