public class Location {
    private String Uniname;
    private String Owner;
    private String Location;
    private  String [] owners=new String[1000];
    Location(String Uniname,String Owner,String Location){
        this.Uniname=Uniname;
        this.Owner=Owner;
        this.Location=Location;
        setOwners(Owner);
    }
    Location(){

    }
    public String getUniname() {
        return Uniname;
    }

    public String getOwner() {
        return Owner;
    }

    public String getLocation() {
        return Location;
    }
    public void setOwners(String add) {
        for(int i=0;i<owners.length;i++){
            if(owners[i]!=null){
                owners[i]=add;
                break;
            }
        }
    }
    public boolean VerifyOwner(String check){
        for(int i=0;i< owners.length;i++){
            if(owners[i].equals(check))
                return true;
        }
        return false;
    }
}
