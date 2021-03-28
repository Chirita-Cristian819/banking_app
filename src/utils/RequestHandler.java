/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import static org.hamcrest.CoreMatchers.equalTo;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertThat;

public class RequestHandler{
    
    public ArrayList<JSONObject> Retrieve(String table) throws JSONException{
        
        ArrayList<JSONObject> entriesJSON = new ArrayList<>();
        
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            HttpGet httpget = new HttpGet("http://localhost:8080/RESTful-DB.Service/webresources/entities."+ table);
            httpget.addHeader("accept", "application/json");

            HttpResponse httpresponse = httpclient.execute(httpget);
            System.out.println(httpresponse.getStatusLine());

            Scanner sc = new Scanner(httpresponse.getEntity().getContent());

            String output, str = "";
            while(sc.hasNext()) {
               str = str + sc.nextLine();
            }

            String[] entries = str.split("(?<=}),");

            int last = entries.length - 1;
            entries[0] = entries[0].substring(1);
            entries[last] = entries[last].substring(0, entries[last].length() - 1);

            for (String entry : entries) {
                entriesJSON.add(new JSONObject(entry));
            }

            return entriesJSON;

        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
    
     return entriesJSON;   
        
    }
    
    public String RetrieveCredentials(String email, String table) throws JSONException{
        
        String str = "";
        
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            //Creating a HttpGet object
            HttpGet httpget = new HttpGet("http://localhost:8080/RESTful-DB.Service/webresources/entities." + table + "/findByEmail/"+ email);
            httpget.addHeader("accept", "application/json");

            //Executing the Get request
            HttpResponse httpresponse = httpclient.execute(httpget);
            System.out.println(httpresponse.getStatusLine());

            Scanner sc = new Scanner(httpresponse.getEntity().getContent());

            while(sc.hasNext()) {
               str = str + sc.nextLine();
            }
          
            str = str.substring(1, str.length() - 1);
            if(str.isEmpty()) return "{}";
                else return str;

        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
     return str;

    }
    
    public String GetById(String id) throws JSONException{
     String str = "";
        
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            //Creating a HttpGet object
            HttpGet httpget = new HttpGet("http://localhost:8080/RESTful-DB.Service/webresources/entities.angajati/" + id);
            httpget.addHeader("accept", "application/json");

            //Executing the Get request
            HttpResponse httpresponse = httpclient.execute(httpget);
            System.out.println(httpresponse.getStatusLine());

            Scanner sc = new Scanner(httpresponse.getEntity().getContent());

            while(sc.hasNext()) {
               str = str + sc.nextLine();
            }
            
            str = str.substring(1, str.length() - 1);
            if(str.isEmpty()) return "{}";
                else return str;

        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
     return str;   
    }
    
    public String GetCode(String email) throws JSONException{
     String str = "";
        
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            //Creating a HttpGet object
            HttpGet httpget = new HttpGet("http://localhost:8080/RESTful-DB.Service/webresources/entities.angajati/recovery_code/" + email);
            httpget.addHeader("accept", "text/plain");
            
            //Executing the Get request
            HttpResponse httpresponse = httpclient.execute(httpget);
            System.out.println(httpresponse.getStatusLine());

            Scanner sc = new Scanner(httpresponse.getEntity().getContent());

            while(sc.hasNext()) {
               str = str + sc.nextLine();
            }

            return str;

        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
     return str;   
    }
    
    public void DeleteCode(String email){
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            HttpDelete httpdelete = new HttpDelete("http://localhost:8080/RESTful-DB.Service/webresources/entities.angajati/recovery_code/" + email);
            
            
            HttpResponse httpresponse = httpclient.execute(httpdelete);

        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
    
    }
    
    public String RetrieveTransactions(String email){
        
        String str = "";
        
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            HttpGet httpget = new HttpGet("http://localhost:8080/RESTful-DB.Service/webresources/entities.clienti/GetTransactions/"+ email);
            httpget.addHeader("accept", "text/plain");

            HttpResponse Response = httpclient.execute(httpget);
            System.out.println(Response.getStatusLine());
            
            if (Response.getStatusLine().getStatusCode() == 200) {

                Scanner sc = new Scanner(Response.getEntity().getContent());
                while (sc.hasNext()) {
                    str = str + "\r\n" + sc.nextLine();
                }
            }
            return str;

        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
     return str;

    }
    
    public void AddAccount(String nume, String prenume, String rol, String email, String parola, String telefon, String idangajat)
            throws IOException, JSONException{
    
        String URL = "http://localhost:8080/RESTful-DB.Service/webresources/entities.angajati/" + idangajat;
        System.out.println(URL);
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPut httpPut = new HttpPut(URL);

            JSONObject json = new JSONObject();
            
            json.put("parola", parola);
            json.put("email", email);
            json.put("idangajat", Integer.parseInt(idangajat));
            json.put("nume", nume);
            json.put("prenume", prenume);
            json.put("rol", rol);
            json.put("telefon", telefon);
            
            System.out.println(json.toString());
            
            httpPut.setEntity(new StringEntity(json.toString()));
            httpPut.setHeader("Accept", "application/json");
            httpPut.setHeader("Content-type", "application/json");
            
            CloseableHttpResponse response = client.execute(httpPut);
            assertThat(response.getStatusLine().getStatusCode(), equalTo(204));
            
        }
    
    }
    
    
    public void AddAngajat(String nume, String prenume, String rol, String cod_inreg, String email, String telefon)
            throws IOException, JSONException{
    
        String URL = "http://localhost:8080/RESTful-DB.Service/webresources/entities.angajati";
        
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(URL);
            
            JSONObject json = new JSONObject();
            
            json.put("codInregistrare", cod_inreg);
            json.put("idangajat", 30000);
            json.put("email", email);
            json.put("nume", nume);
            json.put("prenume", prenume);
            json.put("rol", rol);
            json.put("telefon", telefon);
            
            httpPost.setEntity(new StringEntity(json.toString()));
            httpPost.setHeader("Accept", "application/json");
             httpPost.setHeader("Content-type", "application/json");            
            CloseableHttpResponse response = client.execute(httpPost);
            assertThat(response.getStatusLine().getStatusCode(), equalTo(204));
        }
        catch(ClientProtocolException e){
            System.err.println(e);
        }
    
    
    }
    
    public void DeleteAngajat(String id){
        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();

            HttpDelete httpdelete = new HttpDelete("http://localhost:8080/RESTful-DB.Service/webresources/entities.angajati/" + id);
            
            
            HttpResponse httpresponse = httpclient.execute(httpdelete);
            System.out.println(httpresponse.getStatusLine());

        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
    
    }
    
    public void AddClient(String nume, String prenume, String email, String telefon, int varsta, String angajat, double venit_lunar, String adresa)
            throws IOException, JSONException{
    
        String URL = "http://localhost:8080/RESTful-DB.Service/webresources/entities.clienti";   
        
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(URL);
            
            JSONObject json = new JSONObject();

            json.put("idclient", 30000);
            json.put("email", email);
            json.put("nume", nume);
            json.put("prenume", prenume);
            json.put("telefon", telefon);
            json.put("soldCurent", 0);
            json.put("creditActiv", "nu");
            json.put("varsta", varsta);
            json.put("angajat", angajat);
            json.put("venitLunar", venit_lunar);
            json.put("datoriiActive", 0);
            json.put("adresa", adresa);
            json.put("vechimeClient", 0);
            
            httpPost.setEntity(new StringEntity(json.toString()));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json"); 
            
            CloseableHttpResponse response = client.execute(httpPost);
            assertThat(response.getStatusLine().getStatusCode(), equalTo(204));

        }
        catch(ClientProtocolException e){
            System.err.println(e);
        }
    
    
    }
    
    
    public void AddCredit(double valoareCredit, double rataLunara, int duration, String emailAngajat, String emailClient)
            throws IOException, JSONException{
    
        String URL = "http://localhost:8080/RESTful-DB.Service/webresources/entities.credite";   
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateStart = LocalDate.parse(LocalDate.now().toString(), formatter);
        
        String dataAcordare = dateStart.toString();
        String dataRestituire = dateStart.plusMonths(duration).toString();

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(URL);
            
            String angajat = RetrieveCredentials(emailAngajat, "angajati");
            String client = RetrieveCredentials(emailClient, "clienti");

            JSONObject json = new JSONObject();
            JSONObject angajatObj = new JSONObject(angajat);
            JSONObject clientObj = new JSONObject(angajat);

            json.put("idcredit", 30000);
            json.put("idcreditor", angajatObj);
            json.put("idclient", clientObj);
            json.put("valoareCredit", valoareCredit);
            json.put("rataLunara", rataLunara);
            json.put("dataAcordare", dataAcordare);
            json.put("dataRestituire", dataRestituire);
            json.put("anulat", 0);
            json.put("procentPlatit", 0);
            
            System.out.println(json);
            
            httpPost.setEntity(new StringEntity(json.toString()));
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json"); 
            
            CloseableHttpResponse response = httpClient.execute(httpPost);
            assertThat(response.getStatusLine().getStatusCode(), equalTo(204));
         

        }
        catch(ClientProtocolException e){
            System.err.println(e);
        }
    
    
    }
    
    public static void main(String[] args) throws IOException, JSONException {
        System.out.println(new RequestHandler().GetCode("cristianchirita9889@gmail.com"));    
        //new RequestHandler().AddCredit(900, 300, 3, "chiritastefan@gmail.com", "adina.gheorghe90@gmail.com");
    }
    
    
}