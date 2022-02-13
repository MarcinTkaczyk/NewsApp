package service;

import model.Article;
import model.Headlines;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterService {
    public static void writeToFile(Path path, Headlines headlines){
       try (BufferedWriter writer = Files.newBufferedWriter(path, StandardCharsets.UTF_8);){
           for(Article article : headlines.getArticles()){
               writer.write(article.getTitle()+":"+article.getDescription()+":"+article.getAuthor());
               writer.newLine();
           }
           System.out.println("Successfully saved to file");
       }
       catch (IOException e){
           System.out.println("Could not save to file");
       }
    }
}
