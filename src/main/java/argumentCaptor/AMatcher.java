package argumentCaptor;

public class AMatcher {
    public String str;
    public AMatcher(String s) {
        this.str = s;
    }
    public void test(DataMatch dataMatch) {
        SomeData data = new SomeData("Some test data");
        dataMatch.doSomething(data);
    }

    public void secondTest(DataMatch dataMatch) {
        SomeData data = new SomeData("I am the happiest person in the world");
        dataMatch.dontKnow(data);
    }

}
