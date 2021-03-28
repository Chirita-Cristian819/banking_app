/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import org.json.JSONException;
import org.json.JSONObject;


/**
 *
 * @author Cristi
 */
public class ScoreCalculator {
    
    private final RequestHandler handler = new RequestHandler();

    public double calculateDTI(String email) throws JSONException {

        String responseText = handler.RetrieveCredentials(email, "clienti");
        JSONObject record = new JSONObject(responseText);
        
        double DTI;
        double extraDebt = 0;
        
        int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
        
        if (randomNum > 50 && randomNum < 55) {
            extraDebt = ThreadLocalRandom.current().nextDouble(0, 400);
        } else if (randomNum == 75) {
            extraDebt = ThreadLocalRandom.current().nextInt(400, 3000);
        } else {
            extraDebt = 0;
        }

        if (record.getDouble("venitLunar") > 0) {
            DTI = (record.getDouble("datoriiActive") + extraDebt) / record.getDouble("venitLunar");
        } else {
            DTI = 1;
        }

        return DTI;
    }
    
    private ArrayList<JSONObject> StringToJSONArray(String email) throws JSONException {
        ArrayList<JSONObject> entriesJSON = new ArrayList<>();

        String[] entries = handler.RetrieveCredentials(email, "credite").split("(?<=}),\\{");
        
        for (int i = 1; i < entries.length; i++) {
            entries[i] = "{" + entries[i];
        }
        
        for (String entry : entries) {
            try {
                entriesJSON.add(new JSONObject(entry));
            } catch (JSONException e) {
                System.out.println("wrong JSON format");
            }
            
        }
 
        return entriesJSON;

    }
    
    public double Score(String email, double collateral, double loanValue, String[] ClientInfo) throws JSONException, ParseException {
        double score = 0, DTI;
        ArrayList<JSONObject> CrediteJSONArray = StringToJSONArray(email);
        
        DTI = calculateDTI(email);
        
        //debt to income
        if (DTI >= 0 && DTI <= 44)
            score = 30 * (1 - DTI / 44);
            
        //collaterals
        if (loanValue < 1000) {
            if (collateral > 10 / 100 * loanValue) {
                if (collateral > 50 / 100 * loanValue)
                    score = score + 40 * (collateral * 2 / loanValue);
                else 
                    score = score + 40 + 20 * ( (collateral * 2 / loanValue) - 1);
            }
        } else if (loanValue >= 1000 && loanValue < 3000) {
            if (collateral > 15 / 100 * loanValue) {
                if (collateral > 50 / 100 * loanValue)
                    score = score + 40 * (collateral * 2 / loanValue);
                else 
                    score = score + 40 + 20 * ( (collateral * 2 / loanValue) - 1);
            }
        } else if (loanValue >= 3000) {
            if (collateral > 20 / 100 * loanValue) {
                if (collateral > 50 / 100 * loanValue)
                    score = score + 40 * (collateral * 2 / loanValue);
                else 
                    score = score + 40 + 20 * ( (collateral * 2 / loanValue) - 1);
            }
        }

        
        //payment history
        if (CrediteJSONArray.get(0).toString().equals("{}")) {
            score = score + 25;
        } else {
            int delays = 0, totalDays = 0, cancelled = 0;
            double TotalPaidPercent = 0, count = 0;
            
            for (JSONObject CrediteJSON : CrediteJSONArray) {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate dateStart = LocalDate.parse(CrediteJSON.getString("dataAcordare").substring(0, 10), formatter);
                LocalDate dateEnd = LocalDate.parse(CrediteJSON.getString("dataRestituire").substring(0, 10), formatter);

                long daysBetween = DAYS.between(dateStart, dateEnd);

                delays += CrediteJSON.getInt("zileIntarziere");
                totalDays += daysBetween;
                
                if(CrediteJSON.getInt("anulat") == 1){
                    cancelled = 1;
                    TotalPaidPercent += CrediteJSON.getDouble("procentPlatit");
                    count++;
                }

            }
            
            if(cancelled == 0)
                score = score + 30 - 15 * (delays / totalDays );
            else{
                score = score + 30 * TotalPaidPercent / (count * 100);
            }
            
        }
        
        
        System.out.println("Score after DTI + collaterals + payment history: " + score);

        //**Details about client**
        //ClientInfo[0] = age
        int age = Integer.parseInt(ClientInfo[0]);
        if (age >= 18 && age < 25) {
            score = score - 2;
        } else if (age >= 30 && age < 50) {
            score = score + 2;
        } else if (age > 50) {
            score = score - 2;
        }
       
        //ClientInfo[1] = married && ClientInfo[2] = spouse income
        if (ClientInfo[1].equals("true")) {
            if (Float.parseFloat(ClientInfo[2]) == 0) {
                score = score - 2;
            } else if (Float.parseFloat(ClientInfo[2]) < 600) {
                score = score - 1;
            } else if (Float.parseFloat(ClientInfo[2]) > 1200) {
                score = score + 2;
            }
        } else if (ClientInfo[1].equals("false")) {
            score = score + 2;
        }
        
        //ClientInfo[3] = number of children
        int numberOfChildren = Integer.parseInt(ClientInfo[3]);
        
        if (numberOfChildren == 0) {
            score = score + 2;
        } else if (numberOfChildren == 2) {
            score = score - 2;
        } else if (numberOfChildren == 3) {
            score = score - 4;
        } else if (numberOfChildren > 3) {
            score = score - 6;
        }
        
        //ClientInfo[4] = customer seniority
        int years = Integer.parseInt(ClientInfo[4]);
        
        if (years < 2) {
            score = score - 1;
        } else if (years >= 2 && years < 5) {
            score = score + 1;
        } else {
            score = score + 3;
        }
        
        //ClientInfo[5] = field of activity
        String field = ClientInfo[5];
        
        if (Arrays.asList("IT", "Sports", "Retail", "Law Enforcement", "Army", "Banking").contains(field)) {
            score = score + 2;
        } else if (Arrays.asList("e-Commerce", "Medical", "Law", "Tourism", "Education", "Accountancy").contains(field)) {
            score = score + 1;
        } else if (Arrays.asList("Administration", "Agriculture", "Food Service", "Logistics").contains(field)) {
            score = score - 1;
        } else if (Arrays.asList("Entertainment", "Transport services", "Cosmetics", "Client Support").contains(field)) {
            score = score - 2;
        } else if (field.equals("Free Agent")) {
            score = score - 4;
        } else {
            score = score - 3;
        }

        
        return score;
    }
    
    public static void main(String[] args) throws JSONException, ParseException{

        String[] info = {"30", "true", "0", "3", "2", "IT"};
        
        System.out.println("");
        System.out.println("Final score: " + new ScoreCalculator().Score("adina.gheorghe90@gmail.com", 400, 1000, info));
        
        System.out.println(new ScoreCalculator().StringToJSONArray("adina.gheorghe90@gmail.com"));
        
    }
    
}