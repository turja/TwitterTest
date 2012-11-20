package org.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.model.Tweets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User: asus
 * Date: 11/20/12
 * Time: 2:57 AM
 */
@Repository
@Transactional
public class TwitterDAOImpl implements TwitterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private JdbcTemplate jt;

    @Transactional
    public void saveTweetsJT(final List<Tweets> tweetList) {
        for (Tweets tweets : tweetList) {
            jt.update("INSERT INTO tweets (id, text) VALUES (?, ?)", tweets.getId(), tweets.getText());
        }
    }

    @Transactional
    public void saveTweets(final List<Tweets> tweetList) {
        System.out.println("Count: " + tweetList.size());
        Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
        for (Tweets tweets : tweetList) {
            Session session = sessionFactory.getCurrentSession();
            session.save(tweets);
        }
        tx.commit();
    }
}
