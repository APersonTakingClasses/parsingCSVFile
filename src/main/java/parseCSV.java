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

        CSVParser parser = CSVParser.parse(data, StandardCharsets.US_ASCII, CSVFormat.DEFAULT);
        //CSVParser parser = CSVParser.parse(data, CSVFormat.DEFAULT);
        // do parsing
        //CSVFormat.EXCEL.withDelimiter(',').withHeader("street", "city", "zip", "state", "beds", "baths", "sq__ft", "type", "sale_date", "price", "latitude", "longitude");
        /**street,city,zip,state,beds,
         * baths,sq__ft,type,sale_date,
         * price,latitude,longitude**/
        List<CSVRecord> allInfo = parser.getRecords();

        List<String> headers;
        Double prices = 0.0;
        Double maxP = 0.0;
        Double minP = Double.valueOf(allInfo.get(1).get(9));
        Double sqft = 0.0;

        headers = allInfo.get(0).toList();
        //prices = Double.valueOf(allInfo.get(1).get(9));

        for(int i = 1; i<986; i++){
            prices += Double.valueOf(allInfo.get(i).get(9));
            sqft += Double.valueOf(allInfo.get(i).get(6));
            if(minP > Double.valueOf(allInfo.get(i).get(9))) minP = Double.valueOf(allInfo.get(i).get(9));
            if(maxP < Double.valueOf(allInfo.get(i).get(9))) maxP = Double.valueOf(allInfo.get(i).get(9));
        }
        prices /= 986;
        sqft /= 986;

        //prices = Collections.singletonList(allInfo.get(Integer.parseInt("price")).toString());

        System.out.println("Headers: "+headers);
        System.out.println("Avg Prices: "+prices);
        System.out.println("Avg Sq__Ft: "+sqft);
        System.out.println("Min Price: "+minP);
        System.out.println("Max Price: "+maxP);
    }

}
