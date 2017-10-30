package pl.SpringStore.services;

/**
 * Created by arabk on 27.10.2017.
 */
public interface EmailSender {

    void sendEmail(String to, String subject, String content);

}
