import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



import java.net.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;

class Result {

    /*
     * Complete the 'getUserTransaction' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER uid
     *  2. STRING txnType
     *  3. STRING monthYear
     *
     *  https://jsonmock.hackerrank.com/api/transactions/search?txnType=
     */
    public static JSONArray getArray (int uid, String txnType, String monthYear) {
        String inputLine = ""; 
        JSONArray jsonArray = new JSONArray();
        JSONArray finalArray = new JSONArray();
        try{
            for (int m=1 ; m<=3 ; m++){
             URL url = new URL("https://jsonmock.hackerrank.com/api/transactions/search?userId="+uid+"&txnType="+txnType+"&monthYear="+monthYear+"&page="+m);
             HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
             int responseCode = con.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Scanner sc = new Scanner(con.getInputStream());
                while (sc.hasNext()){
                    inputLine = inputLine + sc.nextLine();
                }
                //sc.close();
            } else {
                System.out.println("Get not working");
            }
                JSONParser jsonParser =  new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(inputLine);
                jsonArray = (JSONArray) jsonObject.get("data");
                finalArray.add(jsonArray);
                //System.out.println(finalArray);
            }
            
        } catch (Exception err) {
           // System.out.println(err);
        }
        return finalArray;
    }

    public static List<Integer> getUserTransaction(int uid, String txnType, String monthYear) {
            List<Integer> arr = new ArrayList<Integer>(); double sumAmount = 0.0, avgAmount = 0.0; int count = 0;
    
               JSONArray jsonArray = (JSONArray) getArray(uid, txnType, monthYear);

                // calculate average amount
                for(int k =0; k < jsonArray.size(); k++) {
                    JSONArray a = (JSONArray) jsonArray.get(k);
                    count = count + a.size();
                for (int i = 0 ; i < a.size(); i++){
                    JSONObject dataObj = (JSONObject) a.get(i);
                    String amount = (String) dataObj.get("amount");
                    String amountStr = amount.replaceAll("[$,]", "");
                    sumAmount = sumAmount + Double.parseDouble(amountStr);
                }
              //  System.out.println(sumAmount);
                }
                avgAmount = sumAmount / count; 
              //  System.out.println(avgAmount);

                // find amounts > averagre amount
                for(int k =0; k < jsonArray.size(); k++) {
                    JSONArray a = (JSONArray) jsonArray.get(k);
                for (int i = 0 ; i < a.size(); i++){
                    JSONObject dataObj = (JSONObject) a.get(i);
                    String amount = (String) dataObj.get("amount");
                    String amountStr = amount.replaceAll("[$,]", "");
                    double amountDb = Double.parseDouble(amountStr);
                    if (amountDb > avgAmount ) {
                    Long ids = (Long) dataObj.get("id");
                    String id = ids.toString();
                    int id1 = Integer.parseInt(id);
                    arr.add(id1);
                    }   
                }
                }
           // System.out.println(arr);
            //arr.add(1);
            return arr;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int uid = Integer.parseInt(bufferedReader.readLine().trim());

        String txnType = bufferedReader.readLine();

        String monthYear = bufferedReader.readLine();

        List<Integer> result = Result.getUserTransaction(uid, txnType, monthYear);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
