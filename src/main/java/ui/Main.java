package ui;

import model.Headlines;
import service.NewsService;
import service.WriterService;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Headlines headlines = NewsService.getHeadlines();
            if(headlines!=null) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Please provide full file path:");
                //String path = "/Users/marcintkaczyk/Documents/news.txt";
                String path = scanner.nextLine();
                WriterService.writeToFile(Path.of(path), headlines);
            }
        }
        catch (Exception e){
            e.getLocalizedMessage();
        }
    }
}
