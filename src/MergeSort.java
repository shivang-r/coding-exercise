import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.stream.Stream;

/**
 * Java program to merge two sorted files into a third file preserving sorting order
 */

public class MergeSort {

    public static void main(String[] args) {
        // File path can be entered as input or read from properties however here it is hardcoded
        String inputFile1 = "C:\\res\\input\\inputFile1.txt";
        String inputFile2 = "C:\\res\\input\\inputFile2.txt";
        String outputFile = "C:\\res\\output\\outputFile.txt";
        mergeSortedFiles(inputFile1, inputFile2, outputFile);
    }

    /**
     * function to merge two sorted files and write the output to the output file
     * @param inputFile1 - path of first sorted file
     * @param inputFile2 - path of second sorted file
     * @param outputFile - path of the output file
     */
    public static void mergeSortedFiles(String inputFile1, String inputFile2, String outputFile) {
        try {
            Stream<String> stream1 = Files.lines(Paths.get(inputFile1), StandardCharsets.UTF_8);
            Stream<String> stream2 = Files.lines(Paths.get(inputFile2), StandardCharsets.UTF_8);
            // create output stream by concatenating input streams, sort it using a comparator
            Stream<String> outputStream = Stream.concat(stream1, stream2).sorted(Comparator.naturalOrder());
            // write the output to the output file
            Files.write(Paths.get(outputFile), (Iterable<String>) outputStream::iterator);
        } catch (IOException ioex) {
            System.out.println("Error occurred while streaming files");
        }
    }
}
