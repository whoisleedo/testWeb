package com.example.testweb.listener.session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.concurrent.atomic.AtomicInteger;

public class ActiveSessionListener implements HttpSessionListener {

    private static final Logger log = LoggerFactory.getLogger(ActiveSessionListener.class);

    private final AtomicInteger activeSessions = new AtomicInteger();

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        activeSessions.incrementAndGet();
        log.info("create a new session , active session count:{}" , getActiveSessions());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        activeSessions.decrementAndGet();
        log.info("session destroyed, active session count:{}" , getActiveSessions());

    }

    public int getActiveSessions() {
        return activeSessions.get();
    }
}
