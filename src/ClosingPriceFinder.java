import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Java program to find closing price for each CUSIP present in the input file
 * Each cusip may have an arbitrary number of prices (one per line)
 * The prices can be considered to be ordered by time (earliest->latest)
 */

public class ClosingPriceFinder {

    public static String CUSIP_HEADER = "CUSIP";

    public static void main(String args[]) {
        // File path can be entered as input or read from properties however here it is hard coded
        String inputFile1 = "C:\\res\\input\\cusip.txt";
        findClosingPrice(inputFile1);
    }

    /**
     * function to find the closing price of each CUSIP present in the file
     * closing price is the last price traded for that day.
     * Assuming the file is sorted closing price should be the last record under any CUSIP.
     *
     * @param inputFile - path to the input file
     */
    public static void findClosingPrice(String inputFile) {
        try {
            Scanner scanner = new Scanner(new File(inputFile));
            //declare price as string as price here is just used for display purpose
            String price = null;
            readNextLine(scanner);
            while (scanner.hasNextLine()) {
                String nextLine = readNextLine(scanner);
                if (!CUSIP_HEADER.equals(nextLine)) {
                    price = nextLine;
                } else {
                    System.out.println("Closing Price for this CUSIP is - " + price);
                }
            }
            System.out.println("Closing Price for this CUSIP is - " + price);
        } catch (FileNotFoundException fex) {
            System.out.println("File not found for input file - " + inputFile);
        }
    }

    /**
     * utility function to read lines
     * @param scanner
     * @return
     */
    public static String readNextLine(Scanner scanner) {
        if (scanner.hasNextLine()) {
            return scanner.nextLine();
        } else {
            return null;
        }
    }
}
