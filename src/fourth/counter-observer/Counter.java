
public class Counter {
    private int val;

	public Counter() {
        this.reset();
	}

	public Counter up() {
		++this.val;
		return this;
	}

	public int value() {
        return this.val;
	}

	public Counter reset() {
        this.val = 0;
        return this;
	}
}

