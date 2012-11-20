package org.web;

import org.dao.TwitterDAO;
import org.model.Tweets;
import org.model.TwitterTimeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * User: asus
 * Date: 11/19/12
 * Time: 7:51 PM
 */
@Controller
public class TwitterController {
    @Autowired
    private TwitterDAO twitterDAO;

    @RequestMapping(value = "/nubefy/archive", method = RequestMethod.GET)
    public String attack() {
        TwitterTimeline timeline = new TwitterTimeline();
        List<Tweets> tweetsList = timeline.fetchTimeline();
        if (tweetsList != null)
            twitterDAO.saveTweets(tweetsList);
//        List<Tweets> tweetsList = new ArrayList<Tweets>();
//        Tweets t1 = new Tweets();
//        t1.setId(123L);
//        t1.setText("first id inserted");
//        tweetsList.add(t1);
//
//        Tweets t2 = new Tweets();
//        t2.setId(1234L);
//        t2.setText("second id inserted");
//        tweetsList.add(t2);


        return "successForm";
    }

}
