import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.net.*;
import javax.net.ssl.HttpsURLConnection;


public class ProxyJavaScrapping{
 
    public boolean run(String ipAddress, int port, String url) {   
        while (true){
            if(createAndUseHTTPSProxy(ipAddress, port, url) == true){
                break;
            }
        }
        return true;
        
    }


    public boolean createAndUseHTTPSProxy(String ipAddress, int port, String website) {
        try {
           
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ipAddress, port));
           
            URL url = new URL(website);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection(proxy);
            int timeoutMillis = 5000;
            connection.setConnectTimeout(timeoutMillis);
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            
            System.out.println("Response Code: " + responseCode);

            connection.disconnect();
            if (responseCode == 200){
                System.out.println("connected!");
                System.out.println(ipAddress);
                System.out.println(port);
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    


    public  String get_proxy(String url){

        try {
            String r = get_request("https://www.sslproxies.org");
            ArrayList <String> dataList = ip_parser(r);
            ArrayList <String> cleanArrayList = new ArrayList<>();

            ArrayList <String> ipList = new ArrayList<>();
            ArrayList <Integer> portlist = new ArrayList<>();

            for (String data: dataList){
                if(data.contains(":")){
                    cleanArrayList.add(data);
                }
                
            }
            for (String ipAndPort: cleanArrayList){
                ipList.add(ipAndPort.split(":")[0]);
                portlist.add(Integer.parseInt(ipAndPort.split(":")[1]));
            }

            //System.out.println(ipList);
            //System.out.println(portlist);

            for (int k = 0; k < ipList.size(); k ++){
                if (true == run(ipList.get(k), portlist.get(k), url)){
                    break;
                }
            }
            


        } catch (IOException e) {
            e.printStackTrace();
        }
        

        return null;
    }
    
    public ArrayList<String> ip_parser(String data){
        

        ArrayList<Integer> tdList = new ArrayList<>();
        ArrayList<String> IPlist = new ArrayList<>();
        String tmp = "";
        int counter;
        tdList.add(0);
        int index = 0;
        while (true){
            index = data.indexOf("</td>", tdList.get(tdList.size()-1) + 1);
            if (index != -1){
                tdList.add(index);
            }else{
                break;
            }
        }
        tdList.remove(0);

        int i = 0;
        for (int j = 0; j < tdList.size(); j= j+8){
            tmp = "";
            counter = 0;
            while (true){

                tmp = data.substring(i-counter, i);
                
                if (data.substring(i-counter, i).contains(">")){
                    IPlist.add(tmp.replace(">", "") + 
                    data.substring(i, i+14).replace("<td>", ":")

                    .replace("</td>","")
                    .replace(("</td"),"")
                    .replace(("</t"),"")
                    .replace("</", "")
                    .replace("<", ""));
                    break;
                }
          
                counter = counter + 1;
            i = tdList.get(j);

        }
    }
    return IPlist;
    }
    public String get_request(String urlStr) throws IOException{
        
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();

        return response.toString();

    }

}

