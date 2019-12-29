package argumentCaptor;

public class DataMatch {
    public SomeData doSomething(SomeData test) {
        return test;
    }

    public SomeData dontKnow(SomeData d) {
        return d;
    }
}
