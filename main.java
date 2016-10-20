import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
// Class that will perform the following 2 functions
// 1. Read all the records line by line from CSV file
// 2. Parse all the records line by line in to an appropriate data structure which in this case is ArrayList
public class main {
	public static void main(String[] args) {
		// BufferredReader read the records from csv file whose link is mention below
		BufferedReader receivedBuffer = null;
		
						try {
							// here sliceBuffer is used to convert each of the array record into an appropriate location in data structure 
							String sliceBuffer;
							receivedBuffer = new BufferedReader(new FileReader("C:/Users/test1/Desktop/muneeb/Academic _Schedule.csv"));
							
							// How to read file in java line by line?
							while ((sliceBuffer = receivedBuffer.readLine()) != null) {
								System.out.println("CSV Record: " + sliceBuffer);
								System.out.println("Record in arrayDataStructure: " + csvToArrayListConverter(sliceBuffer) + "\n");
							}
							
						} catch (IOException e) {
							e.printStackTrace();
						} finally {
							try {
								if (receivedBuffer != null) receivedBuffer.close();
							} catch (IOException crunchifyException) {
								crunchifyException.printStackTrace();
							}
						}
					}
	
	// Here is the utility available which will convert CSV to ArrayList using Split Operation
	public static ArrayList<String> csvToArrayListConverter(String recordFromCsv) {
		ArrayList<String> InArray = new ArrayList<String>();
		
		if (recordFromCsv != null) {
			String[] splitData =recordFromCsv.split("\\s*,\\s*");
			for (int i = 0; i < splitData.length; i++) {
				if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
					InArray.add(splitData[i].trim());
				}
			}
		}
		
		return InArray;
	}
	
}