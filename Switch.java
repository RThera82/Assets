public class Switch extends Asset {
    Switch(String Id,String Model,String BDate,String State,Location location){
        super(Id,Model,BDate,State,location);
    }
    private String portnum,Manageable;
    public void setSwitchThings(String portnum,String Manageable){
        this.portnum=portnum;
        this.Manageable=Manageable;
    }
    public String getportnum(){
        return portnum;
    }
    public String getManageable(){
        return Manageable;
    }
    Switch switch2;
    public String ShowThingsS(Switch switch2){
        this.switch2=switch2;
        String wordS=switch2.ShowThings();
        wordS+="   "+switch2.getManageable()+"   "+switch2.getportnum();
        return wordS;
    }
}
