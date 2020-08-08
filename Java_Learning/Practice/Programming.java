package tasks.task6_classes_and_objects;

public class Programming {
    StringBuilder msg = new StringBuilder("I love ");
    public Programming() {
        this.msg = this.msg.append("programming languages");
    }

    public Programming(String str) {
        this.msg = this.msg.append(str);
    }

    public void displayMsg(){
        System.out.println(msg.toString());
    }

    public static void main(String[] args) {
        Programming p1 = new Programming();
        p1.displayMsg();
        Programming p2 = new Programming("Java");
        p2.displayMsg();
        Programming p3 = new Programming("Java & JavaScript!!");
        p3.displayMsg();
    }
}
