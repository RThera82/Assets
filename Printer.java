public class Printer extends Asset {
    Printer(String Id,String Model,String BDate,String State,Location location){
        super(Id,Model,BDate,State,location);
    }
    private String BW;
    public void setBW(String BW){
        this.BW=BW;
    }
    public String getBW(){
        return BW;
    }
    Printer printer;
    public String ShowThingsP(Printer printer){
        this.printer=printer;
        String wordP=printer.ShowThings();
        wordP+="   "+getBW();
        return wordP;
    }
}
