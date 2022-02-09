package service;

import model.Headlines;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class NewsService {
        private static final String URI = "https://newsapi.org/v2/top-headlines?country=pl&category=business&apiKey=f9e1bc5e5c5946d7ac74ac2b7fbffe4d";

        public static Headlines getHeadlines(){
                Client client = ClientBuilder.newClient();
                WebTarget webTarget = client.target(URI);
                Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
                Response response = invocationBuilder.get();
                Headlines headlines = response.readEntity(Headlines.class);
                if(headlines.getStatus().equals("ok")){
                        return headlines;
                }
                else{
                        System.out.println("Could not get articles");
                        return null;
                }
            }
}
