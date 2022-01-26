import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class parseCSV {
    public static void main(String[] args) throws IOException {
        //greeting message
        System.out.println("\n---Parse CSV File Code---\n");

        // make parser
        File data = new File("C:\\Users\\firew\\IdeaProjects\\parsingCSVFile\\real-estate-data.csv");
        File excelFile = new File("C:\\Users\\firew\\IdeaProjects\\parsingCSVFile\\workbook.xlsx");

        CSVParser parser = CSVParser.parse(data, StandardCharsets.US_ASCII, CSVFormat.EXCEL);

        // do parsing
        CSVFormat.EXCEL.withDelimiter(',');
        /**street,city,zip,state,beds,
         * baths,sq__ft,type,sale_date,
         * price,latitude,longitude**/
        CSVFormat.EXCEL.withHeader("street", "city", "zip", "state", "beds",
                "baths", "sq__ft", "type", "sale_date",
                "price", "latitude", "longitude");

        // display parsed info

        // parsed info calculations
    }

}
