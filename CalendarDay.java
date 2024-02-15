import java.util.*;

class CalenderDay {
    public static void main(String... abc) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer,Integer> month = new HashMap<>();
        HashMap<Integer,String> day = new HashMap<>();

        month.put(1,0);
        month.put(2,3);
        month.put(3,3);
        month.put(4,6);
        month.put(5,1);
        month.put(6,4);
        month.put(7,6);
        month.put(8,2);
        month.put(9,5);
        month.put(10,0);
        month.put(11,3);
        month.put(12,5);
        
        day.put(0,"Sunday");
        day.put(1,"Monday");
        day.put(2,"Tuesday");
        day.put(3,"Wednesday");
        day.put(4,"Thursday");
        day.put(5,"Friday");
        day.put(6,"Saturday");

        System.out.print("Enter day month year: ");
        int dd = scan.nextInt();
        int mm = scan.nextInt();
        int yyyy = scan.nextInt();

        int centuryCode = 0;
        String temp = String.valueOf(yyyy);

        //finding the century code
        if(temp.charAt(1) == '0')
            centuryCode = 6;
        else if(temp.charAt(1) == '1')
            centuryCode = 4;
        else if(temp.charAt(1) == '2')
            centuryCode = 2;
        else if(temp.charAt(1) == '3')
            centuryCode = 0;
        else if(temp.charAt(1) == '6')
            centuryCode = 6;
        else if(temp.charAt(1) == '7')
            centuryCode = 4;
        else if(temp.charAt(1) == '8')
            centuryCode = 2;
        else if(temp.charAt(1) == '9')
            centuryCode = 0;

        //divide the last two digit by 4
        int quotient = (yyyy%100)/4;
        int monthCode = month.get(mm);
        String dayName = "";

        int sum = (yyyy%100) + quotient + monthCode + centuryCode + dd;

        if(yyyy%4 == 0) {
            if(yyyy%100 != 0 && mm > 2) {
                dayName = day.get((sum%7));
            }
            else if(yyyy%400 == 0 && mm > 2) {
                dayName = day.get((sum)%7);
            }
            else 
               dayName = day.get((sum%7)-1);
        }
        else {
            dayName = day.get(sum%7);
        }

        System.out.println(dayName);
    }
}