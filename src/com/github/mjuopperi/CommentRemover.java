package com.github.mjuopperi;

import com.github.mjuopperi.state.InitialState;
import com.github.mjuopperi.state.State;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CommentRemover {
    public static void removeComments(File file) {
        State state = new InitialState();
        try (FileInputStream fileInput = new FileInputStream(file)) {
            int r;
            while ((r = fileInput.read()) != -1) {
                state = state.advance((char) r);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
