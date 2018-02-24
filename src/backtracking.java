public class backtracking {
    static int count;
    int gdfkg = 0;

    //chosen is the permutation of the string im building up
    public static void permute(String s){
        permuteHelper(s, ""); // Initially, nothing is chosen
    }

    private static void permuteHelper(String s, String chosen) {

        // if/else
        if (s.isEmpty()) { //means we have not more leters to choose form in s, we have one full permutation complete and stored in chosen
            System.out.println(chosen);
            count += 1;
            System.out.println(count);


        } else {
            // choose, explore, unchoose
            for (int i = 0; i < s.length(); i++) {
                //choose that letter
                char c = s.charAt(i);


                //explore
                chosen += c;
                StringBuilder sb = new StringBuilder(s);
                sb.deleteCharAt(i);
                s = sb.toString();
                permuteHelper(s, chosen);

                //unchoose
                sb.insert(i, c);
                s = sb.toString();
                StringBuilder sb2 = new StringBuilder(chosen);
                sb2.deleteCharAt(sb2.toString().length() - 1);
                chosen = sb2.toString();
            }

        }
    }

        public static void main(String[] args){

        backtracking.permute("bat");
    }



    }


