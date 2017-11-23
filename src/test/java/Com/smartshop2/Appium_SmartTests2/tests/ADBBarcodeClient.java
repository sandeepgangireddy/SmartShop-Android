package Com.smartshop2.Appium_SmartTests2.tests;

import java.io.IOException;

import java.io.PrintWriter;
import java.net.Socket;

import Com.smartshop2.Appium_SmartTests2.providers.AppiumConfigurationProvider;

/**
 * Created by orfeo.ciano on 11/11/2016.
 * <p>
 * Before using me remember to run on your shell
 * adb forward tcp:PORT tcp:PORT
 * <p>
 * i.e.
 * adb forward tcp:38300 tcp:38300
 */
public class ADBBarcodeClient {

    public void sendBarcode(String barcode) throws IOException {
    	String path = System.getProperty("user.home");
    	String command = path + "/Library/Android/sdk/platform-tools/adb forward tcp:38300 tcp:38300";
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
        Socket echoSocket = new Socket("localhost", 38300);
        PrintWriter out = new PrintWriter(echoSocket.getOutputStream(), true);
        out.println(barcode);
        out.close();
        echoSocket.close();
    }

    public static void main(String[] args){
        ADBBarcodeClient client = new ADBBarcodeClient();
        try {
            client.sendBarcode("5010102101791");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }
}