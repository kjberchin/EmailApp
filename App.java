import javax.mail.*;
import javax.mail.internet.InternetAddress;
import java.util.Properties;

public class App{
	public static void main(String[] args) {
		String host = "imap.gmail.com"; // Gmail IMAP server
        String username = "kaidenberchin@gmail.com"; // Your Gmail address
        String password = "Hingadingadurgen03!!!"; // Your Gmail password

        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imaps");

        try {
            Session session = Session.getInstance(properties, null);
            Store store = session.getStore("imaps");
            store.connect(host, username, password);

            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            Message[] messages = inbox.getMessages();
            for (Message message : messages) {
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + InternetAddress.toString(message.getFrom()));
            }

            inbox.close(false);
            store.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}