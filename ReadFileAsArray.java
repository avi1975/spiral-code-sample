
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class ReadFileAsArray {
	public static void main(String[] args) {
		String file = "content1.txt";
		ReadFileAsArray readFileAs2DArray = new ReadFileAsArray();
        System.out.println(Arrays.deepToString(readFileAs2DArray.readFileContentAs2DArray(file)));
        System.out.println(Arrays.toString(readFileAs2DArray.readFileContentAs2DArray(file)));
    }

	public String[][] readFileContentAs2DArray(String file) {
		String[][] twoDArr = null;
		Scanner scanner = null;
        try {
            scanner = new Scanner(new File(file));
            ArrayList<String> lines = new ArrayList<String>();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lines.add(line);
            }
            if(lines.size() ==0) {
            	System.out.println("Empty file: " + file);
            	return twoDArr;
            }
            twoDArr = new String[lines.size()][lines.get(0).split(" ").length];
            for (int lineCount=0; lineCount < lines.size(); lineCount++) {
            	
                String[] strArr = lines.get(lineCount).split(" ");
                for ( int i = 0 ; i < strArr.length ; i++) {
                	twoDArr[lineCount][i] = strArr[i];
            	}
                
			}
           // System.out.println(Arrays.deepToString(twoDArr));
        } catch (IOException e) {
            System.out.println("IOException" + e.getStackTrace());
        } finally {
        	scanner.close();
        }
		return twoDArr;
	}

}
