package com.github.mjuopperi;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

public class CommentRemoverSpec {

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }
    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    private final File validJava = new File(this.getClass().getResource("../../../resources/ValidJava").getFile());
    private final File javaWihtoutComments = new File(this.getClass().getResource("../../../resources/JavaWithoutComments").getFile());
    private final File javaWihtDoubleSlashInsideStrings = new File(this.getClass().getResource("../../../resources/JavaWithDoubleSlashInsideStrings").getFile());

    @Test
    public void shouldRemoveCommentsFromValidJava() {
        CommentRemover.removeComments(validJava);
        String expected = fileToString(javaWihtoutComments);
        assertEquals(expected, output.toString());
    }

    @Test
    public void shouldLeaveJavaWihtoutCommentsAsIs() {
        CommentRemover.removeComments(javaWihtoutComments);
        String expected = fileToString(javaWihtoutComments);
        assertEquals(expected, output.toString());
    }

    @Test
    public void shouldNotRemoveCommentlikeConstructsInsideStringLiterals() {
        CommentRemover.removeComments(javaWihtDoubleSlashInsideStrings);
        String expected = fileToString(javaWihtDoubleSlashInsideStrings);
        assertEquals(expected, output.toString());
    }

    private String fileToString(File file) {
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(Paths.get(file.toURI()));
            return new String(bytes, "UTF-8");
        } catch (IOException e) {
            return null;
        }
    }
}
