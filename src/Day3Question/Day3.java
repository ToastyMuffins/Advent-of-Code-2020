package Day3Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Day3 {
    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("src\\day3Input.txt"));
        int[] downSlope = {1,1,1,1,2};
        int[] rightSlope = {1,3,5,7,1};
        int mapPosition = 0;
        int noTree = 0;
        int hitTree = 0;
        List<Integer> noTreeTotal = new ArrayList<Integer>();
        List<Integer> hitTreeTotal = new ArrayList<Integer>();

        for (int slope = 0; slope < downSlope.length; slope++) {
            for (int line = 0; line < input.size(); line += downSlope[slope]) {

                String currentLine = input.get(line);
                if (currentLine.charAt(mapPosition) == '.') {
                    noTree++;
                } else {
                    hitTree++;
                }
                mapPosition += rightSlope[slope];
                if (mapPosition >= currentLine.length()) {
                    mapPosition -= currentLine.length();
                }
            }
            noTreeTotal.add(noTree);
            hitTreeTotal.add(hitTree);
            noTree = 0;
            hitTree = 0;
            mapPosition = 0;
        }

        int Start = 1;

        for(int slope:hitTreeTotal){
            Start *= slope;
        }
        System.out.println(noTreeTotal);
        System.out.println(hitTreeTotal);
        System.out.println(Start);

    }

}
