import java.util.Date;
import java.util.Calendar;
import java.util.Random;

class Message {
    private String id;
    private String text;
    private String idSender;
    private Date   timeReceived;
    private ReadState read;
    private DeliveryState delivery;

    public static enum DeliveryState {
        UNSENT, DELIVERED, READ
    }

    public static enum ReadState {
    	READ, UNREAD
    }

    protected Message(String id, String text, String sender) {
        this.id = id;
        this.text = text;
        this.idSender = sender;
        this.timeReceived = sNow.getTime();
        this.read = ReadState.UNREAD;
        this.delivery = DeliveryState.UNSENT;
    }

    public String getId() {
        return this.id;
    }

    public String read() {
    	this.read = ReadState.READ;
        return this.text;
    }

    public void setDeliveryState(DeliveryState ds) {
        switch (this.delivery) {
            case UNSENT : {
                assert(ds == DeliveryState.UNSENT ||
                       ds == DeliveryState.DELIVERED || 
                       ds == DeliveryState.READ);
            }
            break;
            case DELIVERED :{
                assert(ds == DeliveryState.READ);
            }
            break;
            case READ : {
                assert(false);
            }
            break;
        }

        delivery = ds;
    }

    public String getSenderId() {
        return this.idSender;
    }

    public Date getReceiveTime() {
        return this.timeReceived;
    }

    private static int      sMsgId  = 0X0000CAFE;
    private static Calendar sNow    = Calendar.getInstance();
    private static Random   sRandom = new Random(sMsgId);

    private static String nextMessageId() {
        sMsgId += sRandom.nextInt();
        return String.valueOf(sMsgId);
    }

    // factory method
    public static Message create(String text, String idSender) 
                                               throws MessageTooLongException
    {
        assert(text != null && idSender != null);

        if (text.length() > 140) throw new MessageTooLongException();
        Message m = new Message(Message.nextMessageId(), idSender, text);
        return m;
    }
}
