import java.util.Collection;
import java.util.LinkedList;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {



    public static void insertSorted(LinkedList<Integer> list, int value) {
        if(list != null){ //is the list existant?

            if(list.isEmpty()){list.add(value);} // if theres nothing in the list, just add it
            else if(value > list.getLast()){list.add(value);} // if the element were adding is smaller than all the emelents in the list, add it tothe beginning
            else if(value < list.getFirst()){list.add(0,value);}// if the element were adding is larger than all the emelents in the list, add it to the end
            else{
                for(int i = 0;i< list.size()-1;i++){                    // else, lets find where it fits!
                    if(list.get(i)<= value && value <= list.get(i+1)){
                        list.add(i+1,value); //found where it fits, now get out of the loop
                        break;
                    }
                }
            }
        }

    }


    public static void removeMaximumValues(LinkedList<String> list, int N) {
        if (list != null && !list.isEmpty() && N > -1) {
            String largest = list.get(0);
            for (int i = 0; i < list.size(); i++) {
                int val = list.get(i).compareTo(largest);
                if (val > 0) {
                    largest = list.get(i);
                }

            }
            boolean notAllGone = true;
            while (notAllGone) {
                notAllGone = list.removeFirstOccurrence(largest);
            }



            N = N - 1;
            if (N != 0 && list.size() > 0) {
                removeMaximumValues(list, N);
            }



        }
    }

    public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
        boolean hasOverlappingElement = false;
        if(one == null || two == null || one.isEmpty() ||  two.isEmpty() || two.size() > one.size()) {
            return false;
        }
        try{
            for(int i = 0; i < one.size(); i++ ){
                if(one.get(i) == two.get(0)){
                    hasOverlappingElement = true;//if we come a cross an int in one that is the begining of two
                    for(int j =1;j<two.size();j++){
                        if(two.get(j)!=one.get(i+j)){
                            return false;
                        }
                    }
                }

            }

            if(!hasOverlappingElement){return false;}
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("index out of bounds");
            return false;
        }

        return true;





		/* IMPLEMENT THIS METHOD! */

        //return true; // this line is here only so this code will compile if you don't modify it
    }


    public static void main(String[] args){
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);

        l2.add(2);
        l2.add(3);
        l2.add(4);
        System.out.println(LinkedListUtils.containsSubsequence(l1,l2));

    }


    }
