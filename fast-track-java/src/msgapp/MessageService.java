import java.util.Collection;

class MessageService {
    //TODO: COMPLETE ME!!!
    public static boolean send(String senderId, String text,  
                               MessageReceiver receiver)
    {
    }

    public static boolean send(String senderId, String text,  
                               Collection<MessageReceiver> contacts)
    {
    	boolean result = false;

    	try {
            Message m = Message.create(text, senderId);
            for (MessageReceiver c: contacts) {
        	    c.receive(m);
            }
            result = true;
        } catch (MessageTooLongException ex) {
        }

        return result;
    }
}