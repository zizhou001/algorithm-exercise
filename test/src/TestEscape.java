/**
 * @author zizhou
 * @create 2023-11-26 12:58
 */
public class TestEscape {

    private final String[] states = {"he", "hhh"};
    private final int value = 3;

    public String[] getStates() {
        return states;
    }

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
        TestEscape testEscape = new TestEscape();
        String [] s = testEscape.getStates();
        s[0] = "changed";
        System.out.println(testEscape.getStates()[0]);

        testEscape.getStates()[0] = "changed2";
        System.out.println(testEscape.getStates()[0]);

    }
}
