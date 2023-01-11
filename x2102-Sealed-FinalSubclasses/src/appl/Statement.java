package appl;

@SuppressWarnings("preview")
public sealed abstract class Statement permits Assignment, Loop, Choice, Call {
	public abstract void execute();
}
