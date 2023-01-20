package appl;

@SuppressWarnings("preview")
public sealed interface Statement {
    public abstract void execute();
}

final class Assignment implements Statement {
    @Override
    public void execute() {
    }
}

final class Loop implements Statement {
    @Override
    public void execute() {
    }
}

final class Choice implements Statement {
    @Override
    public void execute() {
    }
}

final class Call implements Statement {
    @Override
    public void execute() {
    }
}
