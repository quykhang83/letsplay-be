// package com.aavn.utils;

// import java.sql.Timestamp;
// import java.time.Instant;
// import java.time.ZoneId;
// import java.time.ZonedDateTime;
// import java.time.temporal.ChronoUnit;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;
// import java.util.Set;

// import javax.annotation.PostConstruct;
// import javax.annotation.Resource;
// import javax.ejb.ScheduleExpression;
// import javax.ejb.Singleton;
// import javax.ejb.Startup;
// import javax.ejb.Timeout;
// import javax.ejb.TimerConfig;
// import javax.ejb.TimerService;
// import javax.inject.Inject;

// import com.aavn.daos.DeviceDAO;
// import com.aavn.daos.ManagerDAO;
// import com.aavn.daos.RequestDAO;
// import com.aavn.exception.EmptyDeviceException;
// import com.aavn.exception.EmptyEntityException;
// import com.aavn.exception.InternalServerError;
// import com.aavn.exception.InvalidManagerMailException;
// import com.aavn.firebase.FirebaseMessagingSnippets;
// import com.aavn.model.Device;
// import com.aavn.model.Manager;
// import com.aavn.model.Request;
// import com.aavn.services.EmailService;
// import com.aavn.services.TemplateService;
// import com.google.firebase.messaging.FirebaseMessagingException;

// @Singleton
// @Startup
// public class InitRemindNotificationTimer {

//     @Inject
//     private RequestDAO requestDAO;
//     @Inject
//     private ManagerDAO managerDAO;
//     @Inject
//     DeviceDAO deviceDAO;

//     @Inject
//     private EmailService email;

//     @Resource
//     private TimerService timerService;

//     @PostConstruct
//     public void init() {
//         // timerService.createSingleActionTimer(5000, new TimerConfig());
//         String timeZone = System.getenv("TIMEZONE_SYSTEM");
//         ScheduleExpression schedule = new ScheduleExpression();
//         schedule.hour("7").minute("30").second("0").timezone(timeZone);

//         TimerConfig config = new TimerConfig();
//         config.setInfo("Reminder Notification System");
//         config.setPersistent(false);

//         timerService.createCalendarTimer(schedule, config);
//         System.out.println("It is time to create a Report! " + timeZone);
//     }

//     @Timeout
//     public void createReports(javax.ejb.Timer timer) {

//         List<Request> pendingRequests = getPendingRequests(3);
//         List<Request> expiredRequests = getExpiredRequests();

//         int total_request_num = pendingRequests.size() + expiredRequests.size();

//         if (pendingRequests.size() == 0 && expiredRequests.size() == 0)
//             return;

//         // Group pending requests by manager email

//         Map<String, List<Request>> groupedPendingRequests = new HashMap<>();
//         for (Request request : pendingRequests) {
//             String email = request.getManager().getEmail();

//             List<Request> emailRequests = groupedPendingRequests.getOrDefault(email, new ArrayList<>());
            
//             emailRequests.add(request);
//             groupedPendingRequests.put(email, emailRequests);
//         }

//         // Group expired requests by manager email
//         Map<String, List<Request>> groupedExpiredRequests = new HashMap<>();
//         for (Request request : expiredRequests) {
//             String email = request.getManager().getEmail();

//             List<Request> emailRequests = groupedExpiredRequests.getOrDefault(email, new ArrayList<>());
            
//             emailRequests.add(request);
//             groupedExpiredRequests.put(email, emailRequests);
//         }

//         // Send each group of pending request to corresponding manager

//         TemplateService temp = new TemplateService(); // Initialize template service
//         String subject = temp.getPendingReminderSubject(); // Get pre-defined email subject

//         for (Map.Entry<String, List<Request>> entry : groupedPendingRequests.entrySet()) {
//             List<Request> emailRequests = entry.getValue();
//             String body = temp.getPendingReminderTemplate(emailRequests, 3, total_request_num, pendingRequests.size(),
//                     emailRequests.size());
//             List<String> to = new ArrayList<String>();
//             to.add(entry.getKey());
//             email.sendEmail(subject, body, to);
//         }

//         // Send each group of expired request to corresponding manager

//         subject = temp.getExpiredReminderSubject(); // Get pre-defined email subject

//         for (Map.Entry<String, List<Request>> entry : groupedExpiredRequests.entrySet()) {
//             List<Request> emailRequests = entry.getValue();
//             String body = temp.getExpiredReminderTemplate(emailRequests, total_request_num, expiredRequests.size(),
//                     emailRequests.size());
//             List<String> to = new ArrayList<String>();
//             to.add(entry.getKey());
//             email.sendEmail(subject, body, to);
//         }

//         // pushReminderRequestsByFCM(pendingRequests, "ApproveMe AAVN\n✒ Pending Request
//         // ✒",
//         // "requests need to be resolved!");
//         // pushReminderRequestsByFCM(expiredRequests, "ApproveMe AAVN\n❌ Expired Request
//         // ❌",
//         // "requests had beed expired!");

//     }

//     public void pushReminderRequestsByFCM(List<Request> requests, String title, String body) {
//         Map<String, List<Request>> requestMapEmails = new HashMap<String, List<Request>>();

//         for (Request request : requests) {
//             List<Request> tempRequests = new ArrayList<Request>();
//             String managerMail = request.getManager().getEmail();
//             if (requestMapEmails.get(managerMail) != null) {
//                 tempRequests = requestMapEmails.get(managerMail);
//             }

//             tempRequests.add(request);
//             requestMapEmails.put(managerMail, tempRequests);

//         }
//         for (Map.Entry<String, List<Request>> requestMapEmail : requestMapEmails.entrySet()) {
//             // System.out.println(set.getKey() + ": " + set.getValue());
//             Manager manager = null;
//             try {
//                 manager = managerDAO.getManagerByEmail(requestMapEmail.getKey());
//             } catch (EmptyEntityException e) {
//                 throw new InvalidManagerMailException(requestMapEmail.getKey());
//             }
//             Set<Device> devices = manager.getDevices();

//             // tokens.addAll(deviceDAO.getTokenDevicesByUserId(user.getUserId()));

//             List<String> tokens = new ArrayList<String>();
//             List<String> failedTokens = new ArrayList<>();
//             FirebaseMessagingSnippets fbms = new FirebaseMessagingSnippets();
//             for (Device device : devices) {
//                 // fbms.sendToToken(device.getFcmToken(), title,
//                 // requestMapEmail.getValue().size() + " " + body,
//                 // "https://www.google.com/");
//                 // System.out.println(device.getFcmToken());
//                 tokens.add(device.getFcmToken());
//             }
//             try {
//                 failedTokens = fbms.sendMulticastAndHandleErrors(tokens, title,
//                         requestMapEmail.getValue().size() + " " + body,
//                         "https://www.google.com/");

//                 if (failedTokens.size() > 0) {
//                     for (String failedToken : failedTokens) {
//                         deviceDAO.deleteDeviceByToken(failedToken);
//                         System.out.println("Deleted: " + failedToken);
//                     }
//                 }
//             } catch (FirebaseMessagingException | EmptyDeviceException e) {
//                 throw new InternalServerError(e.getMessage());
//             }

//         }
//     }

//     public List<Request> getPendingRequests(int ndays) {

//         Timestamp now = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));

//         ZonedDateTime zonedDateTime = now.toInstant().atZone(ZoneId.of("UTC"));
//         Timestamp tomorrow = Timestamp.from(zonedDateTime.plus(1, ChronoUnit.DAYS).toInstant());
//         Timestamp newNextNdays = Timestamp.from(zonedDateTime.plus(ndays, ChronoUnit.DAYS).toInstant());

//         List<Request> pendingRequests = requestDAO.getPendingRequestsInNextNDays(tomorrow, newNextNdays);

//         return pendingRequests;
//     }

//     public List<Request> getExpiredRequests() {

//         Timestamp now = Timestamp.from(Instant.now().truncatedTo(ChronoUnit.SECONDS));

//         List<Request> pendingRequests = requestDAO.getExpiredRequests(now);

//         return pendingRequests;
//     }
// }