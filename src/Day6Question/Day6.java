package Day6Question;

import java.util.ArrayList;

public class Day6 {

    ArrayList<Integer> numToAdd = new ArrayList<>();

    Day6(String input){

        String[] splitInput = input.split("\n");
        int[] charFound = new int[26];
        int numOfPeople = 0;
        for(String line:splitInput){
            numOfPeople++;
            String[] splitLine = line.split("");

            if(line.equals("")){
                int sumAmounts = 0;
                for (int j : charFound) {
                    if (j == numOfPeople-1) {
                        sumAmounts++;
                    }
                }
                numOfPeople = 0;
                charFound = new int[26];
                numToAdd.add(sumAmounts);

            }

            for(String letter:splitLine){
                switch (letter){
                    case"a":
                        charFound[0] += 1;
                        break;
                    case"b":
                        charFound[1] += 1;
                        break;
                    case"c":
                        charFound[2] += 1;
                        break;
                    case"d":
                        charFound[3] += 1;
                        break;
                    case"e":
                        charFound[4] += 1;
                        break;
                    case"f":
                        charFound[5] += 1;
                        break;
                    case"g":
                        charFound[6] += 1;
                        break;
                    case"h":
                        charFound[7] += 1;
                        break;
                    case"i":
                        charFound[8] += 1;
                        break;
                    case"j":
                        charFound[9] += 1;
                        break;
                    case"k":
                        charFound[10] += 1;
                        break;
                    case"l":
                        charFound[11] += 1;
                        break;
                    case"m":
                        charFound[12] += 1;
                        break;
                    case"n":
                        charFound[13] += 1;
                        break;
                    case"o":
                        charFound[14] += 1;
                        break;
                    case"p":
                        charFound[15] += 1;
                        break;
                    case"q":
                        charFound[16] += 1;
                        break;
                    case"r":
                        charFound[17] += 1;
                        break;
                    case"s":
                        charFound[18] += 1;
                        break;
                    case"t":
                        charFound[19] += 1;
                        break;
                    case"u":
                        charFound[20] += 1;
                        break;
                    case"v":
                        charFound[21] += 1;
                        break;
                    case"w":
                        charFound[22] += 1;
                        break;
                    case"x":
                        charFound[23] += 1;
                        break;
                    case"y":
                        charFound[24] += 1;
                        break;
                    case"z":
                        charFound[25] += 1;
                        break;
                }
            }

        }

        int sumAmounts = 0;
        for (int j : charFound) {
            if (j == numOfPeople-1) {
                sumAmounts++;
            }
        }
        numToAdd.add(sumAmounts);
    }


    public int getNum(int index){
        return numToAdd.get(index);
    }

    public int getFullNum(){
        int fullNum = 0;
        for(int num:numToAdd){
            fullNum += num;
        }
        return fullNum;
    }
}
