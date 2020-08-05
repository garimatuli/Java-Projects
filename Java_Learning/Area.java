package july28;

public interface Area {
    // Interfaces generally contains only method definition, not method body
    int area();

    // New Feature in Java allows method body in interfaces if we use static or default keyword
    default int sum(){
        int a = 20;
        return a + 10;
    }
}
