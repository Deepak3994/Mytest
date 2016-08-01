/**
 *
 * We show the implementation of a protocol of registering and unregistering
 * event observers. Once registered, the 'CounterObserver' instance receives
 * a callback each time the counter is 'reset'. Notice the way 'reset' is
 * overridden in this class. The observer is notified with the value of the
 * counter before it was actually reset. 
 *
 * Note that only one observer may be registered to receive notifications
 * at any point in time. Only the currently registered observer may be
 * unregistered. This implements one possible register-receive-unregister
 * protocol.
 * 
 **/

public class CounterSource extends Counter {
	private CounterObserver observer;

    public CounterSource() {
        this.observer = null;
    }

    // ensures at most one active (non-null) observer
    public boolean register(CounterObserver target) {
        if (this.observer != null || target == null) {
            return false;
        }
        
        this.observer = target;
        
        return true;
    }
    
    // (observer != null & taregt != null) => (observer = null).
    public boolean unregister(CounterObserver target) {
    	if (this.observer == null || target == null) {
            return false;
    	}

        if (this.observer == target) {
            this.observer = null;
        }

        return (this.observer == null);
    }

    private void notifyReset(int val) {
        if (this.observer != null) {
            this.observer.counterReest(val);
        }
    }

    @Override
    public Counter reset() {
    	int val = this.value();
        super.reset();
        this.notifyReset(val);

        return this;
    }
}