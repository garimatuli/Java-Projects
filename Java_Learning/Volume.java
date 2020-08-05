package july28;

public interface Volume {
    // New Feature in Java allows method body in interfaces if we use static or default keyword
    static int volume(){
        int a = 10;
        return a*a*a;
    }

    default int sum(){
        int a = 2000;
        return a + 1000;
    }
}
