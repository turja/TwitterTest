package org.model;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * User: asus
 * Date: 11/20/12
 * Time: 2:33 AM
 */
public class TwitterTimeline {
    List<Tweets> tweetsList;
    private String fetchUrl = "https://api.twitter.com/1/statuses/user_timeline.json?" +
            "include_entities=true&include_rts=true&screen_name=nubefy&count=10";

    public List<Tweets> fetchTimeline() {
        try {
            URLConnection urlConnection = new URL(fetchUrl).openConnection();
            urlConnection.connect();
            JsonReader reader = new JsonReader(
                    new InputStreamReader(urlConnection.getInputStream()));
            JsonParser parser = new JsonParser();
            JsonElement rootElement = parser.parse(reader);
            JsonArray tweetsJson = rootElement.getAsJsonArray();
            tweetsList = new ArrayList();
            Gson myGson = new Gson();
            for (JsonElement tweetElement : tweetsJson) {
                Tweets myTweet = myGson.fromJson(tweetElement, Tweets.class);
                tweetsList.add(myTweet);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
        }

        return tweetsList;
    }
}
