package com.github.mjuopperi.state;

public class InsideBlockComment extends State {

    @Override
    public State advance(char ch) {
        if (ch != '*') {
            return this;
        } else {
            return new MaybeEnd();
        }
    }
}
