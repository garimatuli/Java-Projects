package task2;

public class FlowChart {
    public static void main(String args[]){
        int a =10, b = 20, c=30;
        double avg = (a+b+c)/3;
        System.out.println("Average = "+avg);
        if (avg>a && avg>b && avg>c){
            System.out.println("avg "+avg+" is higher than "+a+","+b+","+c);
        }
        else if (avg>a && avg>b){
            System.out.println("avg "+avg+" is higher than a,b - "+a+","+b);
        }
        else if (avg>a && avg>c){
            System.out.println("avg "+avg+" is higher than a,c - "+a+","+c);
        }
        else if (avg>b && avg>c){
            System.out.println("avg "+avg+" is higher than b,c - "+b+","+c);
        }
        else if (avg>a){
            System.out.println("avg "+avg+" is just higher than a - "+a);
        }
        else if (avg>b){
            System.out.println("avg "+avg+" is just higher than b - "+b);
        }
        else if (avg>c){
            System.out.println("avg "+avg+" is just higher than c - "+c);
        }
    }
}
