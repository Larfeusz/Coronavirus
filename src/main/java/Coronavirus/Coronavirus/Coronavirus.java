package Coronavirus.Coronavirus;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.*;
import java.time.LocalDate;

public class Coronavirus {

    public double getActiveCases()  {

        try {
            FileWriter writer;

            LocalDate today = LocalDate.now();

            Document document =
                    Jsoup.connect(
                            "https://www.worldometers.info/coronavirus/country/poland/")
                            .get();
            String text = document.
                    getElementsByClass("number-table-main").first().text();

            File file = new File( "./CoronavirusData1.txt" );

            writer = new FileWriter(file);
            writer.write(document.getElementsByClass("number-table-main").first().text()+" cases in: "+today);

            return Double.parseDouble(text.replace(",","."));
        }
        catch (FileNotFoundException e){
            System.out.println("Nie znaleziono pliku!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }
}