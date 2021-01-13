package Day4Question;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Day4 {

    public static void main(String[] args) throws IOException {
        List<String> input = Files.readAllLines(Paths.get("src\\Day4Input.txt"));
        Map<String,String> passport = Collections.synchronizedMap(new HashMap<>());
        int validPass = 0, failedPass = 0;

        for (String line : input) {
            if (line.equals("")) {
                if (isValidPassport(passport)) {
                    validPass++;
                } else {
                    failedPass++;
                }
                passport.clear();
                continue;
            }
            String[] lineSplit = line.split(" ");
            for (String part : lineSplit) {
                String[] partSplit = part.split(":");
                passport.put(partSplit[0], partSplit[1]);
            }

        }
        System.out.println("Passed: " +validPass + " Failed: " + failedPass);
    }




    private static boolean isValidHeight(Map<String, String> passport){
        if(passport.containsKey("hgt")){
            if(passport.get("hgt").contains("in")){
                int inches = Integer.parseInt(passport.get("hgt").replace("in",""));
                return isBetween(inches,59,76);

            }else if(passport.get("hgt").contains("cm")){
                int centimeters = Integer.parseInt(passport.get("hgt").replace("cm",""));
                return isBetween(centimeters,150,193);

            }else{
                return false;
            }
        }
        return false;
    }

    private static boolean isValidHair(Map<String, String> passport){
        if(passport.containsKey("hcl")){
            String hcl = passport.get("hcl");
            return hcl.length() == 7 && hcl.charAt(0) == '#' && !hcl.matches("[^a-f0-9]");
        }

        return false;
    }

    private static boolean isValidBirth(Map<String, String> passport){
        if(passport.containsKey("byr")){
            int byr = Integer.parseInt(passport.get("byr"));
            return isBetween(byr,1920,2002);
        }
        return false;
    }

    private static boolean isValidIssue(Map<String, String> passport){
        if(passport.containsKey("iyr")){
            int iyr = Integer.parseInt(passport.get("iyr"));
            return isBetween(iyr,2010,2020);
        }
        return false;
    }

    private static boolean isValidExpire(Map<String, String> passport){
        if(passport.containsKey("eyr")){
            int byr = Integer.parseInt(passport.get("eyr"));
            return isBetween(byr,2020,2030);
        }
        return false;
    }

    private static boolean isValidEyeColor(Map<String,String> passport){
        if(passport.containsKey("ecl")){
            String ecl = passport.get("ecl");
            return ecl.matches("amb|blu|brn|gry|grn|hzl|oth");
        }
        return false;
    }

    private static boolean isValidPID(Map<String,String> passport){
        if(passport.containsKey("pid")){
            String pid = passport.get("pid");
            return pid.length() == 9;
        }
        return false;
    }

    public static boolean isBetween(int value, int min, int max)
    {
        return((value >= min) && (value <= max));
    }


    private static boolean isValidPassport(Map<String, String> passport) {
        return isValidBirth(passport)
                && isValidIssue(passport)
                && isValidExpire(passport)
                && isValidHeight(passport)
                && isValidHair(passport)
                && isValidEyeColor(passport)
                && isValidPID(passport);
    }
}
