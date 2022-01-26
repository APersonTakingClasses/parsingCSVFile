import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

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
        CSVFormat.EXCEL.withDelimiter(',').withHeader("street", "city", "zip", "state", "beds", "baths", "sq__ft", "type", "sale_date", "price", "latitude", "longitude");
        /**street,city,zip,state,beds,
         * baths,sq__ft,type,sale_date,
         * price,latitude,longitude**/
        List<String> headers;
        List<Float> prices = null;
        List<Double> sqft;

        List<CSVRecord> allInfo = parser.getRecords();

        headers = allInfo.get(0).stream().toList();
        //prices = allInfo.get(Integer.parseInt("price")).stream().toList();
        /**
        for (CSVRecord strings : allInfo) {
            prices.add(strings.get("j"));
        }

            prices = allInfo.get(Integer.parseInt("j"));
        //prices = Collections.singletonList(allInfo.get(Integer.parseInt("price")).toString());
         **/
        System.out.println("Headers: "+headers);
        //System.out.println("Avg Prices: "+prices.toString());
        System.out.println("Avg Sq__Ft: ");
        System.out.println("Min Price: ");
        System.out.println("Max Prices: ");
    }

}
