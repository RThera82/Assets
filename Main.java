import java.io.*;
import java.util.Date;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Asset asset1=new Asset();
        Asset assetwork=new Asset();
        boolean condition=false;
        int save=10;
        File file1=new File("c:/project/users.txt");
        //System.out.println(file1.getAbsoluteFile());
        String userfile=LoadAllData(file1);
        Scanner scanner=new Scanner(userfile);
        File file2=new File("c:/project/Repairs.txt");
        String Repairsfile=LoadAllData(file2);
        Scanner scanner1=new Scanner(Repairsfile);
        File file3=new File("c:/project/Assets.txt");
        String Assetsfile=LoadAllData(file3);
        Scanner scanner2=new Scanner(Assetsfile);
        Scanner input=new Scanner(System.in);
        Date date=new Date();
        //System.out.println(userfile.replace("reza","sara"));
        System.out.println("Welcome to SUTech Asset Manager 1.0");
        System.out.println("Username:");
        String user=input.next();
        while(condition==false){
            while(scanner.hasNext()){
                String line= scanner.nextLine();
                if(line.startsWith(user)){
                    System.out.println("Pass:");
                    String pass=input.next();
                    while(!line.endsWith(pass)){
                        System.out.println("Password does not match!");
                        System.out.println("Pass;");
                        pass=input.next();
                    }
                    if(line.endsWith(pass)){
                        condition=true;
                        break;
                    }
                }
            }
            if(condition==false){
                scanner=new Scanner(userfile);
                System.out.println("Username not register");
                System.out.println("Username:");
                user=input.next();
            }
        }
        boolean con=false;
        //System.out.println(condition);
        //System.out.println(user);
        if(user.equals("admin")&& condition==true){
            System.out.println("1-View All Assets");
            System.out.println("2-Repair an Asset");
            System.out.println("3-Add an Asset");
            System.out.println("4-Edit an Asset");
            System.out.println("5-Add a User");
            System.out.println("6-Edit a User");
            System.out.println("7-Change Password");
            System.out.println("8-Retire an Asset");
            System.out.println("9-Reports");
            System.out.println("10-Exit");
            System.out.println("\nEnter your choice number:");
            int choose=input.nextInt();
            while(choose!=10){
                switch(choose){
                    case 1:
                        System.out.println(Assetsfile);
                        break;
                    case 2:
                        System.out.println("Please enter the ID of asset");
                        String asre=input.next();
                        System.out.println("Please etner date");
                        String keepdate=input.next();
                        date=new Date(keepdate);
                        System.out.println("This is ID:"+asre+"and this is time:"+date.toString());
                        CheckLine(Repairsfile,asre);
                        break;
                    case 3:
                        System.out.println("Please now enter University name,Owner and location in sequence");
                        Location location1=new Location(input.next(),input.next(),input.next());
                        System.out.println("Please enter the type of your asset that you want to edit(computer,switch,printer)");
                        String type=input.next();
                        switch(type){
                            case "computer":
                                System.out.println("Now enter ID,model,BDate and state in sequence");
                                Computer computer1=new Computer(input.next(),input.next(),input.next(),input.next(),location1);
                                System.out.println("Now enter CPU,RAM,Hard and graphic in sequence");
                                computer1.setComputerThings(input.next(),input.next(),input.next(),input.next());
                                computer1.setIDS(computer1);
                                assetwork.setAsset(computer1);
                                //System.out.println(computer1.ShowThingsC(computer1));
                                Assetsfile+="\n"+computer1.ShowThingsC(computer1);
                                break;
                            case "switch":
                                System.out.println("Now enter ID,model,BDate and state in sequence");
                                Switch switch1=new Switch(input.next(),input.next(),input.next(),input.next(),location1);
                                System.out.println("Now enter portnum and manageable in sequence");
                                switch1.setSwitchThings(input.next(),input.next());
                                switch1.setIDS(switch1);
                                assetwork.setAsset(switch1);
                                Assetsfile+="\n"+switch1.ShowThingsS(switch1);
                                System.out.println(switch1.ShowThingsS(switch1));
                                break;
                            case "printer":
                                System.out.println("Now enter ID,model,BDate and state in sequence");
                                Printer printer1=new Printer(input.next(),input.next(),input.next(),input.next(),location1);
                                System.out.println("Now enter BW");
                                printer1.setBW(input.next());
                                printer1.setIDS(printer1);
                                assetwork.setAsset(printer1);
                                Assetsfile+="\n"+printer1.ShowThingsP(printer1);
                                System.out.println(printer1.ShowThingsP(printer1));
                                break;
                            default:
                                System.out.println("Bad input");
                        }
                        break;
                    case 4:
                        System.out.println("Please enter ID");
                        String ediID=input.next();
                    case 5:
                        System.out.println("Please enter the username that you want to add");
                        String newuser=input.next();
                        System.out.println("Please enter the password that you want to add");
                        String newpass2=input.next();
                        String add=newuser+ "   "+newpass2;
                        userfile+="\n"+add;
                        System.out.println(userfile);
                        break;
                    case 6:
                        System.out.println("Please enter username:");
                        String use=input.next();
                        while(!Lines(userfile,use)){
                            System.out.println("Wrong");
                            System.out.println("Please enter username:");
                            use=input.next();
                        }
                        if(Lines(userfile,use)){
                            System.out.println("Enter new username");
                            String newUser=input.next();
                            Scanner scanner4=new Scanner(userfile);
                            while(scanner4.hasNext()){
                                String line9=scanner4.nextLine();
                                if(line9.startsWith(use)){
                                    userfile=userfile.replace(use,newUser);
                                    System.out.println(userfile);
                                    break;
                                }
                            }
                        }
                        break;
                    case 7:
                        System.out.println("Please enter password:");
                        String pasch=input.next();
                        while(!EndLines(userfile,pasch)){
                            System.out.println("Wrong");
                            System.out.println("Please enter password");
                            pasch=input.next();
                        }
                        if(EndLines(userfile,pasch)){
                            System.out.println("Enter new password");
                            String newPass=input.next();
                            Scanner scanner5=new Scanner(userfile);
                            while(scanner5.hasNext()){
                                String line12=scanner5.nextLine();
                                if(line12.endsWith(pasch)){
                                    userfile=userfile.replace(pasch,newPass);
                                    System.out.println(userfile);
                                    break;
                                }
                            }
                        }
                        break;
                    case 8:
                        System.out.println("Please enter an ID:");
                        String check=input.next();
                        asset1.setEsghat(check);
                        break;
                    case 9:
                        System.out.println("1-Find Asset by model");
                        System.out.println("2-All Repairs by User");
                        System.out.println("3-All Users");
                        System.out.println("4-Asset Repairs");
                        System.out.println("5-Repairs by Date");
                        System.out.println("6-Troubleshooting");
                        System.out.println("7-Find Assets by Owner");
                        System.out.println("\nPlease choose!");
                        int choosereport=input.nextInt();
                        switch(choosereport){
                            case 1:
                                Reports reports=new Reports();
                                System.out.println("Please enter some part of your device mode(like HP)");
                                String findmodel=input.next();
                                System.out.println(reports.Find(Assetsfile,findmodel));
                                break;
                            case 2:
                                System.out.println("Please enter ID");
                                System.out.println("Please enter ID");
                                String IDRepair=input.next();
                                while(scanner2.hasNext()){
                                    String line20=scanner2.nextLine();
                                    if(line20.startsWith(IDRepair)){
                                        System.out.println(line20);
                                        break;
                                    }
                                    else{
                                        System.out.println("Not found");
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                System.out.println(userfile);
                                break;
                            case 4:
                                System.out.println("Please enter ID");
                                String IDRE=input.next();
                                Reports reports4=new Reports();
                                while(scanner2.hasNext()){
                                    String line21=scanner2.nextLine();
                                    if(line21.startsWith(IDRE)){
                                        reports4.setRepLines(IDRE);
                                        break;
                                    }
                                }
                                reports4.ShowLines();
                                break;
                            case 5:
                                System.out.println("Please enter first date");
                                String firstdate=input.next();
                                Date date1=new Date(firstdate);
                                System.out.println("Please etner second date");
                                String seconddate=input.next();
                                Date date2=new Date(seconddate);
                                Reports reports2=new Reports();
                                reports2.RepDate(date1,date2,date);
                                break;
                            case 6:
                                Reports reports1=new Reports();
                                System.out.println("Please enter the cause of the problem!");
                                String trouble=input.next();
                                System.out.println(reports1.Find(Repairsfile,trouble));
                                break;
                            case 7:
                                System.out.println("Please enter owner's name:");
                                String ownername=input.next();
                                Asset show=new Asset();
                                show.ViewOwner(ownername);
                                break;
                        }
                            break;
                    case 10:
                        save=10;
                        break;
                }
                con=true;
                save=10;
                System.out.println("1-View All Assets");
                System.out.println("2-Repair an Asset");
                System.out.println("3-Add an Asset");
                System.out.println("4-Edit an Asset");
                System.out.println("5-Add a User");
                System.out.println("6-Edit a User");
                System.out.println("7-Change Password");
                System.out.println("8-Retire an Asset");
                System.out.println("9-Reports");
                System.out.println("10-Exit");
                System.out.println("\nEnter your choice number:");
                choose=input.nextInt();
            }
        }
        if(condition==true && con==true){
            System.out.println("1-View All Assets");
            System.out.println("2-Repair an Asset");
            System.out.println("3-Add an Asset");
            System.out.println("4-Edit an Asset");
            System.out.println("5-Change Password");
            System.out.println("6-Retire an Asset");
            System.out.println("7-Reports");
            System.out.println("8-Exit");
            System.out.println("\nEnter your choice number:");
            int choose=input.nextInt();
            while (choose!=8){
                switch (choose){
                    case 1:
                        System.out.println(Assetsfile);
                        break;
                    case 2:
                        System.out.println("Please enter the ID of asset");
                        String asre=input.next();
                        System.out.println("Please etner date");
                        String keepdate=input.next();
                        date=new Date(keepdate);
                        System.out.println("This is ID:"+asre+"and this is time:"+date.toString());
                        CheckLine(Repairsfile,asre);
                        break;
                    case 3:
                        System.out.println("Please now enter University name,Owner and location in sequence");
                        Location location1=new Location(input.next(),input.next(),input.next());
                        System.out.println("Please enter the type of your asset that you want to edit(computer,switch,printer)");
                        String type=input.next();
                        switch(type){
                            case "computer":
                                System.out.println("Now enter ID,model,BDate and state in sequence");
                                Computer computer1=new Computer(input.next(),input.next(),input.next(),input.next(),location1);
                                System.out.println("Now enter CPU,RAM,Hard and graphic in sequence");
                                computer1.setComputerThings(input.next(),input.next(),input.next(),input.next());
                                computer1.setIDS(computer1);
                                assetwork.setAsset(computer1);
                                //System.out.println(computer1.ShowThingsC(computer1));
                                Assetsfile+="\n"+computer1.ShowThingsC(computer1);
                                break;
                            case "switch":
                                System.out.println("Now enter ID,model,BDate and state in sequence");
                                Switch switch1=new Switch(input.next(),input.next(),input.next(),input.next(),location1);
                                System.out.println("Now enter portnum and manageable in sequence");
                                switch1.setSwitchThings(input.next(),input.next());
                                switch1.setIDS(switch1);
                                assetwork.setAsset(switch1);
                                Assetsfile+="\n"+switch1.ShowThingsS(switch1);
                                System.out.println(switch1.ShowThingsS(switch1));
                                break;
                            case "printer":
                                System.out.println("Now enter ID,model,BDate and state in sequence");
                                Printer printer1=new Printer(input.next(),input.next(),input.next(),input.next(),location1);
                                System.out.println("Now enter BW");
                                printer1.setBW(input.next());
                                printer1.setIDS(printer1);
                                assetwork.setAsset(printer1);
                                Assetsfile+="\n"+printer1.ShowThingsP(printer1);
                                System.out.println(printer1.ShowThingsP(printer1));
                                break;
                            default:
                                System.out.println("Bad input");
                        }
                        break;
                    case 4:
                        System.out.println("Please enter ID");
                        String ediID=input.next();
                    case 5:
                        System.out.println("Please enter password:");
                        String pasch=input.next();
                        while(!EndLines(userfile,pasch)){
                            System.out.println("Wrong");
                            System.out.println("Please enter password");
                            pasch=input.next();
                        }
                        if(EndLines(userfile,pasch)){
                            System.out.println("Enter new password");
                            String newPass=input.next();
                            Scanner scanner5=new Scanner(userfile);
                            while(scanner5.hasNext()){
                                String line12=scanner5.nextLine();
                                if(line12.endsWith(pasch)){
                                    userfile=userfile.replace(pasch,newPass);
                                    System.out.println(userfile);
                                    break;
                                }
                            }
                        }
                        break;
                    case 6:
                        System.out.println("Please enter an ID:");
                        String check=input.next();
                        asset1.setEsghat(check);
                        break;
                    case 7:
                        System.out.println("1-Find Asset by model");
                        System.out.println("2-All Repairs by User");
                        System.out.println("3-Asset Repairs");
                        System.out.println("4-Repairs by Date");
                        System.out.println("5-Troubleshooting");
                        System.out.println("6-Find Assets by Owner");
                        System.out.println("\nPlease choose!");
                        int choosereport=input.nextInt();
                        switch(choosereport){
                            case 1:
                                Reports reports=new Reports();
                                System.out.println("Please enter some part of your device mode(like HP)");
                                String findmodel=input.next();
                                System.out.println(reports.Find(Assetsfile,findmodel));
                                break;
                            case 2:
                                System.out.println("Please enter ID");
                                System.out.println("Please enter ID");
                                String IDRepair=input.next();
                                while(scanner2.hasNext()){
                                    String line20=scanner2.nextLine();
                                    if(line20.startsWith(IDRepair)){
                                        System.out.println(line20);
                                        break;
                                    }
                                    else{
                                        System.out.println("Not found");
                                        break;
                                    }
                                }
                                break;
                            case 3:
                                System.out.println("Please enter ID");
                                String IDRE=input.next();
                                Reports reports4=new Reports();
                                while(scanner2.hasNext()){
                                    String line21=scanner2.nextLine();
                                    if(line21.startsWith(IDRE)){
                                        reports4.setRepLines(IDRE);
                                        break;
                                    }
                                }
                                reports4.ShowLines();
                                break;
                            case 4:
                                System.out.println("Please enter first date");
                                String firstdate=input.next();
                                Date date1=new Date(firstdate);
                                System.out.println("Please etner second date");
                                String seconddate=input.next();
                                Date date2=new Date(seconddate);
                                Reports reports2=new Reports();
                                reports2.RepDate(date1,date2,date);
                                break;
                            case 5:
                                Reports reports1=new Reports();
                                System.out.println("Please enter the cause of the problem!");
                                String trouble=input.next();
                                System.out.println(reports1.Find(Repairsfile,trouble));
                                break;
                            case 6:
                                System.out.println("Please enter owner's name:");
                                String ownername=input.next();
                                Asset show=new Asset();
                                show.ViewOwner(ownername);
                                break;
                        }
                        break;
                    case 8:
                        save=10;
                        break;
                }
                save=10;
                System.out.println("1-View All Assets");
                System.out.println("2-Repair an Asset");
                System.out.println("3-Add an Asset");
                System.out.println("4-Edit an Asset");
                System.out.println("5-Change Password");
                System.out.println("6-Retire an Asset");
                System.out.println("7-Reports");
                System.out.println("8-Exit");
                System.out.println("\nEnter your choice number:");
                choose=input.nextInt();
            }

        }
        System.out.println(save);
        if(save==10){
            try {
                SaveAllData(file1,userfile);
                SaveAllData(file2,Assetsfile);
                SaveAllData(file3,Repairsfile);
                System.out.println("Everything is saved!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
    public static String LoadAllData(File file) throws FileNotFoundException {
        String way=file.getAbsolutePath();
        if(way.equals("c:\\project\\users.txt")){
            Scanner scanner1=new Scanner(file);
            String users="";
            while(scanner1.hasNext()){
                String line1= scanner1.nextLine();
                users+="\n"+line1;
            }
            return users;
        }
        if(way.equals("c:\\project\\Assets.txt")){
            Scanner scanner1=new Scanner(file);
            String Assets="";
            while(scanner1.hasNext()){
                String line1= scanner1.nextLine();
                Assets+="\n"+line1;
            }
            return Assets;
        }
        if(way.equals("c:\\project\\Repairs.txt")){
            Scanner scanner1=new Scanner(file);
            String repair="";
            while(scanner1.hasNext()){
                String line1= scanner1.nextLine();
                repair+="\n"+line1;
            }
            return repair;
        }
        else
            return "";
    }
    public static void SaveAllData(File file, String save) throws IOException {
        FileWriter wr=new FileWriter(file);
        wr.write("\n"+save);
        wr.close();
    }
    public static void CheckLine(String one,String two){
        boolean condition=false;
        Scanner scanner=new Scanner(one);
        while(condition==false){
            while(scanner.hasNext()){
                String line=scanner.nextLine();
                if(line.startsWith(two)){
                    System.out.println(line);
                    break;
                }
            }
            if(condition==false){
                System.out.println("Invalid input");
                break;
            }
        }
    }
    public static boolean Lines(String one,String two){
        boolean condition=false;
        Scanner scanner=new Scanner(one);
        while(condition==false){
            while(scanner.hasNext()){
                String line= scanner.nextLine();
                if(line.startsWith(two)){
                    condition=true;
                    return condition;
                }
            }
        }
        return false;
    }
    public static boolean EndLines(String one,String two){
        boolean condition=false;
        Scanner scanner=new Scanner(one);
        while(condition==false){
            String line=scanner.nextLine();
            if(line.endsWith(two)){
                condition=true;
                return condition;
            }
        }
        return condition;
    }
    }
