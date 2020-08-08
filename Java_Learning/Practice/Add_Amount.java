package tasks.task6_classes_and_objects;

public class Add_Amount {
    int amount = 50;
    int count = 0; // track number of transactions done on the Saving Box

    //Default Constructor -without any parameter
    public Add_Amount(){

    }
    //Constructor having a parameter which is the amount that will be added to Saving Box
    public Add_Amount(int addAmount) {
        this.count += 1;
        this.amount = this.amount + addAmount;
        System.out.println("Final amount in saving box: "+this.amount);
    }

    // Display number of transactions
    public void displayTransactions(){
        System.out.println("Number of transactions: "+count);
    }

    public static void main(String[] args) {
        Add_Amount a = new Add_Amount(150);
        a.displayTransactions();
    }
}
