package appl;

@SuppressWarnings("preview")
public abstract sealed class Statement permits Assignment, Loop, Choice, Call {
	public abstract void execute();
}
