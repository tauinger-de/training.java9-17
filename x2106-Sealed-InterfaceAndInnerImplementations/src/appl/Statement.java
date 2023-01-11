package appl;

@SuppressWarnings("preview")
public sealed interface Statement {
	public abstract void execute();

	public static final class Assignment implements Statement {
		@Override public void execute() { }
	}
	public static final class Loop implements Statement {
		@Override public void execute() { }
	}
	public static final class Choice implements Statement {
		@Override public void execute() { }
	}
	public static final class Call implements Statement {
		@Override public void execute() { }
	}
}
