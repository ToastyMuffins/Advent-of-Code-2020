package Day1Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<String> instructions = Files.readAllLines(Paths.get("src\\Day1Input.txt"));
        List<Integer> goodNumber = new ArrayList<>();
        for(int i =0; i<instructions.size();i++){
            int num1 = Integer.parseInt(instructions.get(i));
            for(int e=i+1; e<instructions.size();e++){
                int num2 = Integer.parseInt(instructions.get(e));
                for(int f = e+1; f<instructions.size();f++){
                    int num3 = Integer.parseInt(instructions.get(f));
                    int numCheck = num1 + num2 + num3;
                    if(numCheck == 2020){
                        int multiply = num1*num2*num3;
                        goodNumber.add(num1);
                        goodNumber.add(num2);
                        goodNumber.add(num3);
                        goodNumber.add(multiply);
                    }
                }

            }
        }
        System.out.println(goodNumber);
    }
}
