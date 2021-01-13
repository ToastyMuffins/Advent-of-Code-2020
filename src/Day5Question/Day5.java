package Day5Question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Day5 {

    private int currentRow;
    private int currentColumn;
    private int highestID;
    private ArrayList<Integer> IDs = new ArrayList<>();

    Day5(String input){
        String[] splitInput = input.split("\n");
        int rowMax = 127;
        int columnMax = 7;
        for(String instructions: splitInput){
            StringBuilder sb = new StringBuilder(instructions);
            rowMax = 127;
            columnMax = 7;
            int rowChange = 64;
            int columnChange = 4;
            for(int i=0;i<sb.length(); i++){
                char current = sb.charAt(i);
                switch (current){
                    case 'F':
                        rowMax -= rowChange;
                        rowChange/=2;
                        break;
                    case 'B':
                        rowChange/=2;
                        break;
                    case 'R':
                        columnChange/=2;
                        break;
                    case 'L':
                        columnMax -= columnChange;
                        columnChange/=2;
                        break;
                }
            }
            currentRow = rowMax;
            currentColumn = columnMax;
            checkHighestID(getSeatID());
            IDs.add(getSeatID());
        }
        Collections.sort(IDs);
        int checker = 13;
        for(int counter: IDs){
            if(counter != checker){
                System.out.println(checker);
                break;
            }
            checker++;
        }
    }

    public int getRow(){
        return currentRow;
    }

    public int getColumn(){
        return currentColumn;
    }

    public int getSeatID(){
        return currentRow*8+currentColumn;
    }

    private void checkHighestID(int ID){
        if(ID > highestID){
            highestID = ID;
        }
    }

    public int getHighestID(){
        return highestID;
    }

}
