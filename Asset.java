import java.util.Date;

public class Asset {
    private String Id;
    private String Model;
    private String BDate;

    private String State;
    private Location location;
    private String [] IDSS=new String[1000];
    Asset(String Id,String Model,String BDate,String State,Location location){
        this.Id=Id;
        this.Model=Model;
        this.BDate=BDate;
        this.State=State;
        this.location=location;
    }
    public String getState() {
        return State;
    }
    Asset(){
    }
    String check;
    public void ViewOwner(String check){
        this.check=check;
        Location location1=new Location();
        if(location1.VerifyOwner(check)){
            System.out.println("Owner name name:"+location1.getOwner());
            System.out.println("Location name:"+location1.getLocation());
            System.out.println("Collage name:"+location1.getUniname());
            System.out.println("ID:" +ID);
            System.out.println("Model:" + Model);
            System.out.println("State:" +State);
            System.out.println("BDate:"+BDate);

        }
        else
            System.out.println("Invalid input");
    }
    public String getID(){
        return Id;
    }
    public void setIDS(Asset asset){
        for(int i=0;i<IDSS.length;i++){
            if(IDSS[i]!=null){
                IDSS[i]=asset.getID();
                break;
            }
        }
    }
    private String ID;
    public void checkIDBrooke(String ID){
        this.ID=ID;
        boolean con=false;
        for(int i=0;i<IDSS.length;i++){
            if(IDSS[i]==ID){
                con=true;
                State="brooke";
                break;
            }
            else{
                System.out.println("ID not found!");
                break;
            }
        }
    }
    String ID2;
    public boolean checkID(String ID2) {
        this.ID2 = ID2;
        for (int i = 0; i < IDSS.length; i++) {
            if (IDSS[i] == ID)
                return true;
        }
        return false;
    }
    public String ShowThings(){
        String word="";
        word+=Id+"   "+ Model+"   "+BDate+"   "+State+"   "+location.getUniname()+"   "+location.getOwner()+"   "+location.getLocation();
        return word;
    }
    Asset assetarray[]=new Asset[1000];
    Asset asset2;
    public void setAsset(Asset asset) {
        this.asset2 = asset;
        for(int i=0;i<assetarray.length;i++){
            if(assetarray[i]==null){
                assetarray[i]=asset2;
                break;
            }
        }
    }
    String id;
    public void setEsghat(String id){
        this.id=id;
        for(int i=0;i<assetarray.length;i++){
            if(assetarray[i].getID()==id){
                State="Esghat";
            }
        }
    }

    private Date[]dates=new Date[1000];
    public void RepDates(Date date){
        for(int i=0;i<dates.length;i++){
            if(dates[i]==null){
                dates[i]=date;
                break;
            }
        }
    }
    public Date[] getDates() {
        return dates;
    }
}
