import java.util.Collection;

class MessageService {
    public static boolean send(String senderId, String text,  
                                              Collection<Contact> contacts)
    {
    	boolean result = false;

    	try {
            Message m = Message.create(text, senderId);
            for (Contact c: contacts) {
        	    c.receive(m);
            }
            result = true;
        } catch (MessageTooLongException ex) {
        }

        return result;
    }
}