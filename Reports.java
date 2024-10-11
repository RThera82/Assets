import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
public class Reports {
    String one,two;

    public String Find(String one,String two){
        this.one=one;
        this.two=two;
        Scanner scanner=new Scanner(one);
        while(scanner.hasNext()){
            String line=scanner.nextLine();
            if(line.contains(two))
                return line;
            else
                return "Bad parameter";
        }
        return "Bad way";
    }
    Date date,date1,date2;
    Asset asset=new Asset();
    public void RepDate(Date date, Date date1,Date date2){
        this.date=date;
        this.date1=date1;
        this.date2=date2;
        int day=date.getDay();
        int day1=date1.getDay();
        int day2=date2.getDay();
        int month=date.getMonth();
        int month1=date1.getMonth();
        int month2=date2.getMonth();
        int year=date.getYear();
        int year1=date1.getYear();
        int year2=date2.getYear();
        if(day-day1<day2){
            if(year-year1<year2)
                if(month-month1<month2){
                    System.out.println(Arrays.toString(asset.getDates()));
                }
        }
    }
    String RepLines[]=new String[1000];
    public void setRepLines(String one){
        for(int i=0;i<RepLines.length;i++){
            if(RepLines[i]==null){
                RepLines[i]=one;
            }
        }
    }
    public void ShowLines(){
        for(int i= RepLines.length;i>0;i--){
            if(RepLines[i]!=null)
                System.out.println(RepLines[i]);
        }
    }
}
