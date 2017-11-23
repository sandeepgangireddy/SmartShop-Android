package Com.smartshop2.Appium_SmartTests2.helper;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

/**
 * @author ramana.sadaneni
 *
 */

public class CSVFileReader {
	
	public static List<User> getUserdetails(){
		String csvFile = "/Users/ramana.sadaneni/sample.csv";

        CSVReader reader = null;
        List<User> userList=null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            
            userList = new ArrayList<User>();
            while ((line = reader.readNext()) != null ) {
            	User user = new User();
            	user.setUserName(line[0]);
            	user.setPassword(line[1]);
                System.out.println("Country [id= " + line[0] + ", code= " + line[1] );
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       
        return userList;

    }

	/**
	 * @return
	 */
	public static List<User> getSearchText(){
		String csvFile = "/Users/ramana.sadaneni/sampleSearch.csv";

        CSVReader reader = null;
        List<User> userList=null;
        try {
            reader = new CSVReader(new FileReader(csvFile));
            String[] line;
            
            userList = new ArrayList<User>();
            while ((line = reader.readNext()) != null ) {
            	User user = new User();
            	user.setUserSearchText(line[0]);
            	
                System.out.println("Country [id= " + line[0] );
                userList.add(user);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
       return userList;

    }
	
}
