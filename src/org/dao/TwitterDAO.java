package org.dao;

import org.model.Tweets;

import java.util.List;

/**
 * User: asus
 * Date: 11/20/12
 * Time: 2:57 AM
 */
public interface TwitterDAO {
    void saveTweets(final List<Tweets> tweetList);
    void saveTweetsJT(final List<Tweets> tweetList);
}
