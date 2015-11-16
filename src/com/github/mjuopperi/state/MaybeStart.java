package com.github.mjuopperi.state;

public class MaybeStart extends State {

    @Override
    public State advance(char ch) {
        if (ch == '/') {
            return new NewlineInComment();
        } else if (ch == '*') {
            return new InsideBlockComment();
        } else {
            write("/" + ch);
            return new InitialState();
        }
    }
}
