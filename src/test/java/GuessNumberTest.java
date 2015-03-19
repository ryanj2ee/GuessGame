package test.java;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import main.java.*;


public class GuessNumberTest {
    // EOL could be different on different systems, read and store it
    private static final String EOL =  System.getProperty("line.separator");
    private static final String PROMPT_MSG =
            "Guess a number between 1 and 100 and type \"ready\" when you are ready to begin or \"quit\" to exit";
    private static final String PROMPT_MSG2 = "Let me guess, is the number 50 ? " +
            "Type \"Yes\" or tell me if your number is \"higher\" or \"lower\" than this";
    private static final String PROMPT_MSG3 = "Let me guess, is the number 25 ? " +
            "Type \"Yes\" or tell me if your number is \"higher\" or \"lower\" than this";
    private static final String PROMPT_MSG4 = "The Number You Guessed is 25";
    final InputStream consoleInput = System.in;
    final PrintStream consoleOutput = System.out;

    @Test
    public void testTypeNotReady() {
        try {
            final PipedOutputStream testInput = new PipedOutputStream();
            final PipedOutputStream out = new PipedOutputStream();
            final PipedInputStream testOutput = new PipedInputStream(out);
            System.setIn(new PipedInputStream(testInput));
            System.setOut(new PrintStream(out));

           new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //printToMain-->System.in-->Main-->Scanner
                        PrintStream printToMain = new PrintStream(testInput);
                        BufferedReader testReader = new BufferedReader(new InputStreamReader(testOutput));
                        assertEquals(PROMPT_MSG, testReader.readLine());
                        printToMain.println("ready");
                        printToMain.flush();
                        assertEquals(PROMPT_MSG2, testReader.readLine());
                        printToMain.println("lower");
                        printToMain.flush();
                        assertEquals(PROMPT_MSG3, testReader.readLine());
                        printToMain.println("Yes");
                        printToMain.flush();
                        assertEquals(PROMPT_MSG4, testReader.readLine());

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
                new Main().execute();
            }
        catch(Exception e) {
            e.printStackTrace();
        }
        System.setOut(consoleOutput);
        System.setIn(consoleInput);
    }
}