/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package smstool;

/**
 *
 * @author QWERTY
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCVS1 {

     
     public static String[] strarray;
     public static List<String> Name = new ArrayList();
     public static List<String> PhoneNo = new ArrayList();
     public static List<String> Email = new ArrayList();
     public static List<String> Address = new ArrayList();
    
 
  public static void main(String[] args) {

	ReadCVS obj = new ReadCVS();
	//obj.run();

  }


  public void run(String csvFile) {
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";

        	try {
                    int i=-1;
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {

		        // use comma as separator
			String[] data = line.split(cvsSplitBy);
			System.out.println("Detail [Name= " + data[0] + " , Phone NO=" + data[1] + ", Email=" + data[2] + ", Address=" + data[3] + "]");
                        Name.add(data[0]);
                        PhoneNo.add(data[1]);
                        Email.add(data[2]);
                        Address.add(data[3]);
                       
                }
             //   System.out.println("Contents of al: " + PhoneNo );
              //  strarray = PhoneNo.toArray(new String[0]);
               // for(int j =0;j<strarray.length;j++){
                //  System.out.println("Contents of al: " + strarray[j] );
                //    }
        } catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	System.out.println("Done");
  }

}