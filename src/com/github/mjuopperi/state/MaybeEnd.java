package com.github.mjuopperi.state;

public class MaybeEnd extends State {

    @Override
    public State advance(char ch) {
        if (ch != '/') {
            return new InsideBlockComment();
        } else {
            return new InitialState();
        }
    }
}
