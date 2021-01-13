package Day2Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Day2 {

    public static void main(String[] args) throws IOException{
        List<String> input = Files.readAllLines(Paths.get("src\\Day2Input.txt"));
        int validPass = 0;
        int notValid = 0;
        for(String line:input){
            String[] splitLine = line.split(" ");
            String numTo = splitLine[0];
            String[] numSplit = numTo.split("-");

            int startNum = Integer.parseInt(numSplit[0]);
            int endNum = Integer.parseInt(numSplit[1]);

            String ofChar = splitLine[1];
            String[] onlyChar = ofChar.split(":");
            char mainChar = onlyChar[0].charAt(0);

            String password = splitLine[2];
            int charCount = 0;

//            for(int i = 0; i < password.length(); i++){
//                if(password.charAt(i) == mainChar){
//                    charCount++;
//                }
//            }

            if(password.charAt(startNum-1) == mainChar || password.charAt(endNum-1) == mainChar){
                if(password.charAt(startNum-1) == mainChar && password.charAt(endNum-1) == mainChar){
                    notValid++;
                    continue;
                }
                validPass++;
            }else{
                notValid++;
            }

//            if (charCount >= startNum && charCount <= endNum) {
//                validPass++;
//            }else{
//                notValid++;
//            }

        }
        System.out.println(validPass);
        System.out.println(notValid);
    }
}
