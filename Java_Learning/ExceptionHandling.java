package july30;

//try{} catch{} finally throw throws Exceptions Error

import java.util.Scanner;

public class ExceptionHandling {

    // throw & throws
    public static void add() throws ArrayIndexOutOfBoundsException{
        int myArr[]= {1,2,3};
        System.out.println("Throwing Exception ");
        throw new ArrayIndexOutOfBoundsException("Passing Msg : "+ myArr[0]+ ", "+myArr[2]+"\n");
    }

    public static void main(String[] args)  {

        try {
            int c=10/0; // will cause ArithmeticException(/ by zero)

            int[] arr= {1,2,3,4};
            System.out.println(arr[4]); //will cause ArrayIndexOutOfBoundsException

            //the input string is of illegal format for parsing as it is null.
            int a = Integer.parseInt(null);  //java.lang.NumberFormatException: null
        }
        //handling multiple exception using single catch block
        catch (ArithmeticException | NumberFormatException e){
            System.out.println(e.getMessage()); // / by zero
            System.out.println(e); // java.lang.ArithmeticException: / by zero
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e); // java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
        }
        finally {
            System.out.println("Out of try-catch block"+"\n"); // Out of try-catch block
        }


        //throw
        try{
            int m = 4/2; // When no exception then we can throw an explicit exception message
//            int n= 4/0; // When exception occurs , catch {} executes, explicit throw of exception not done in this case
            throw new ArithmeticException("Throwing an explicit exception");
        }catch (Exception e){
            System.out.println("Exception is: " +e);
        }finally {
            System.out.println("Executing finally block irrespective of exception occurred or not \n");
        }

        // Nested try-catch blocks
        try{
            int ar[] ={1,2,3};
            try{
                String s = "2345";
                System.out.println(ar[s.length()]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Nested/Inner Exception : "+e.getMessage()); //Nested/Inner Exception : Index 4 out of bounds for length 3
            }
            int a=10/0;
        }catch (ArithmeticException e){
            System.out.println("Exception from Outer try block"+e+"\n"); // Exception from Outer try blockjava.lang.ArithmeticException: / by zero
        }

        // throw & throws
        try{
            add();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Explicitly Thrown Exception using throw is Caught here & passed message displayed: \n"+e+"\n");
            // Output: java.lang.ArrayIndexOutOfBoundsException: Passing Msg : 1, 3
        }

        // throw & throws
        ExceptionHandling exceptionHandling= new ExceptionHandling();
        try{
            exceptionHandling.add();
        }
        catch(ArithmeticException e){
            System.out.println(e); // If we don't catch the exception in the block below,
                                  // then, Error occurs due to exception mismatch as we are throwing exception A but catching exception B
        }
        catch(Exception e){
                System.out.println(e+"\n"); // java.lang.ArrayIndexOutOfBoundsException: Passing Msg : 1, 3
        }


        Scanner in = new Scanner(System.in);
        try{
            System.out.println("Enter an integer: ");
            int i = in.nextInt(); //Garima
        }catch (Exception e){
            System.out.println("Exception occurred: "+e+"\n"); // Exception occurred: java.util.InputMismatchException
        }
        in.close();
    }
}

/* Following are some scenarios where an exception occurs:
->A user has entered an invalid data.
->A file that needs to be opened cannot be found.
->A network connection has been lost in the middle of communications or the JVM has run out of memory.

three categories of Exceptions:
-> Checked exceptions − A checked exception is an exception that is checked (notified) by the compiler at compilation-time,
these are also called as compile time exceptions.
These exceptions cannot simply be ignored, the programmer should take care of (handle) these exceptions.
For example, SQLException, IOException, ClassNotFoundException etc.
For example, if you use FileReader class in your program to read data from a file, if the file specified in its constructor doesn't exist, then a FileNotFoundException occurs, and the compiler prompts the programmer to handle the exception.
-> Unchecked exceptions − An unchecked exception is an exception that occurs at the time of execution.
These are also called as Runtime Exceptions.
These include programming bugs, such as logic errors or improper use of an API.
Runtime exceptions are ignored at the time of compilation.
For example, ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException etc.
For example, if you have declared an array of size 5 in your program, and trying to call the 6th element of the array then an ArrayIndexOutOfBoundsExceptionexception occurs.
 -> Errors − These are not exceptions at all, but problems that arise beyond the control of the user or the programmer.
 Errors are typically ignored in your code because you can rarely do anything about an error. For example, if a stack overflow occurs, an error will arise.
 They are also ignored at the time of compilation.

If a method does not handle a checked exception, the method must declare it using the throws keyword.
The throws keyword appears at the end of a method's signature.
You can throw an exception, either a newly instantiated one or an exception that you just caught, by using the throw keyword.
Difference between throws and throw keywords:
throws is used to postpone the handling of a checked exception and throw is used to invoke an exception explicitly.

Error vs Exception
Error: An Error indicates serious problem that a reasonable application should not try to catch.
Exception: Exception indicates conditions that a reasonable application might try to catch.
 */
