package com.github.mjuopperi.state;

public abstract class State {

    public static void write(char ch) { System.out.print(ch); }
    public static void write(String str) { System.out.print(str); }

    public abstract State advance(char ch);
}
