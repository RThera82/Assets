public class Computer extends Asset{
    Computer(String Id, String Model, String BDate, String State, Location location){
        super(Id,Model,BDate,State,location);
    }
    private String CPU,RAM,Hard,Graphic;
    public void setComputerThings(String CPU,String RAM,String Hard,String Graphic){
        this.CPU=CPU;
        this.RAM=RAM;
        this.Hard=Hard;
        this.Graphic=Graphic;
    }
    public String getCPU(){
        return CPU;
    }
    public String getRAM(){
        return RAM;
    }
    public String getHard(){
        return Hard;
    }
    public String getGraphic(){
        return Graphic;
    }
    Computer computer;
    public String ShowThingsC(Computer computer){
        this.computer=computer;
        String wordC=computer.ShowThings();
        wordC+="   "+computer.getGraphic()+ "   " +computer.getCPU()+"   "+ computer.getHard()+"   " +computer.getID()+"   " +computer.getRAM()+"   ";
        return wordC;
    }
}
