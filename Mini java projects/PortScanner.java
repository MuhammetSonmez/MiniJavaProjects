import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.io.IOException;
import java.net.UnknownHostException;

public class PortScanner {

    public ArrayList <Integer> checkAllPorts(String ip){
        ArrayList <Integer> portList = new ArrayList<>();
        int port = 1;
        while (port <= 65535){
            try {
                Socket socket = new Socket();
                socket.connect(new java.net.InetSocketAddress(ip, port), 100);
                //System.out.println("Port " + port + " available.");
                socket.close();
                portList.add(port);
            } catch (IOException e) {
                //System.out.println("Port " + port + " closed.");
            }
            //System.out.println("processing: %"+ (double) (port/65535) * 100 );
            System.out.println(String.format("processing: %%%.2f", ((float) port / 65535) * 100.0));

            port += 1;
        }
        return portList;
    }
    
    public boolean checkPort(String ip,int port){
        try {
            Socket socket = new Socket();
            socket.connect(new java.net.InetSocketAddress(ip, port), 100); 
            System.out.println("Port " + port + " available.");
            socket.close();
            return true;
        } catch (IOException e) {
            System.out.println("Port " + port + " closed.");
            return false;
        }    
    }
    

    public String nsLookUp(String domainName){

        String ipAddress = resolveIP(domainName);

        if (ipAddress != null) {
            System.out.println("domain name: " + domainName);
            System.out.println("IP adress: " + ipAddress);
        } else {
            System.err.println("IP cannot resolved.");
        }
        return ipAddress;
    }

    public static String resolveIP(String domainName) {
        try {
            InetAddress inetAddress = InetAddress.getByName(domainName);
            return inetAddress.getHostAddress();
        } catch (UnknownHostException e) {
            System.err.println("IP cannot resolved.: " + e.getMessage());
            return null;
        }
    }




}
