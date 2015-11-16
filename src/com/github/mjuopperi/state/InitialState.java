package com.github.mjuopperi.state;

public class InitialState extends State {

    @Override
    public State advance(char ch) {
        if (ch != '/') {
            write(ch);
            return this;
        } else {
            return new MaybeStart();
        }
    }
}
