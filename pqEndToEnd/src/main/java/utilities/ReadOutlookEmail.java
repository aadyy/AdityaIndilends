//package utilities;
//
//import java.util.Properties;
//
//import org.simplejavamail.outlookmessageparser.model.OutlookMessage;
//
//import com.mysql.cj.Session;
//
//public class ReadOutlookEmail {
//	
//	public void readOutLookFun() {
//		String protocol="imaps";
//		Properties props = new Properties();
//		props.setProperty("mail.store.protocol", protocol);
//		                 
//		//extra codes required for reading OUTLOOK mails during IMAP-start
//		    props.setProperty("mail.imaps.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//		    props.setProperty("mail.imaps.socketFactory.fallback", "false");
//		    props.setProperty("mail.imaps.port", "993");
//		    props.setProperty("mail.imaps.socketFactory.port", "993");
//		//extra codes required for reading OUTLOOK mails during IMAP-end
//		                 
//		Session session = Session.getDefaultInstance(props, null);
//		Store store = session.getStore(protocol);
//		store.connect("imap-mail.outlook.com", emailAddress, password);
//		Folder inbox = store.getFolder("INBOX");
//		inbox.open(Folder.READ_WRITE);
//		 
//		//search for all "unseen" messages
//		Flags seen = new Flags(Flags.Flag.SEEN);
//		FlagTerm unseenFlagTerm = new FlagTerm(seen, false);
//		Message messages[] = inbox.search(unseenFlagTerm);
//
//	}
//	
//	
//	 
//
//}
