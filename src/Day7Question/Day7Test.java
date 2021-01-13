package Day7Question;

import junit.framework.TestCase;

public class Day7Test extends TestCase {
    public void testEmptyForm(){
        assertEquals(0,bagChecker(""));
    }

    public void testSingleBag(){
        assertEquals(1,bagChecker("red"));
    }

    public void testDoubleBag(){
        assertEquals(2,bagChecker("red,blue"));
    }

    public void testColorDescriber(){
        assertEquals(1, bagChecker("faded red"));
    }

    public void testBagCounter(){
        assertEquals(3, bagChecker("3 faded red bags"));
        assertEquals(4, bagChecker("3 faded red bags, 1 bright blue bag"));
    }

    public void testMultipleBags(){
        assertEquals(7,bagChecker("3 faded red bags.\n" +
                                                "3 faded red bags, 1 bright blue bag."));
    }

    public int bagChecker(String input){
        int numOfBags = 0;
        String[] splitBags = input.split("[,]|[ ]");
        int numOfBagsToAdd = 1;
        for(String color:splitBags){
            System.out.println(color);
            if(color.length()<2){
                char[] charCheck = color.toCharArray();
                for(char character:charCheck){
                    if(Character.isDigit(character)){
                        numOfBagsToAdd = Integer.parseInt(color);
                        break;
                    }
                }
            }
            if(color.equals("red")||color.equals("blue")){
                numOfBags+=numOfBagsToAdd;
            }
        }
        return numOfBags;
    }
}
