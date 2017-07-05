package com.xgy.tcpserver;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gowild.cn on 2017/7/5.
 */
public class SessionManager {

    private Map<Integer, Session> sessionMap = new HashMap<>();

    public void createSession(Socket socket) {
        Session session = new Session();
        session.setId(CommonService.generateSessionId());
        session.setSocket(socket);
        sessionMap.put(session.getId(), session);
    }

    public Session getSession(int sessionId) {
        if (sessionMap.containsKey(sessionId)) {
            return sessionMap.get(sessionId);
        }
        return null;
    }

    public void removeSession(Session session) throws Exception{
        if (!sessionMap.containsValue(session)) {
            throw new Exception("会话不存在");
        }
        sessionMap.remove(session.getId());
    }

    public int getSessionCount() {
        return sessionMap.size();
    }


}
