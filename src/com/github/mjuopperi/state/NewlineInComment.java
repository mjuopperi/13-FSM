package com.github.mjuopperi.state;

public class NewlineInComment extends State {

    @Override
    public State advance(char ch) {
        if (ch != '\n') {
            return this;
        } else {
            write(ch);
            return new InitialState();
        }
    }
}
