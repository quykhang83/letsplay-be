// package com.ctu.utils;

// import java.time.ZonedDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.List;
// import java.util.Timer;
// import java.util.TimerTask;

// import javax.annotation.PostConstruct;
// import javax.ejb.Singleton;
// import javax.ejb.Startup;
// import javax.inject.Inject;

// import com.ctu.daos.RequestDAO;
// import com.ctu.model.Request;

// @Startup
// @Singleton
// public class InitRemindNotificationTimer {
//     @Inject
//     RequestDAO requestDAO;
    
//     @PostConstruct
//     public void init(){
//         Timer timer = new Timer();
//         TimerTask timerTask = new TimerTask();
//         timer.schedule(null, 0, 0);
//     }

//     public List<Request> getPendingRequests(){
//         ZonedDateTime zonedDateNow = ZonedDateTime.now();
//         String now = zonedDateNow.format(DateTimeFormatter.ISO_LOCAL_DATE);
//         String next3days = zonedDateNow.plusDays(3).format(DateTimeFormatter.ISO_LOCAL_DATE);

//         List<Request> pendingRequests = requestDAO.getPendingRequestsInNext3Days(now, next3days);

//         return pendingRequests;
//     }
// }
