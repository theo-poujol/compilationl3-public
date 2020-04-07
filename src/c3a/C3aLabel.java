package c3a;

public class C3aLabel extends C3aOperand{
    public int number; // numéro de l'étiquette
    private int line;   // ligne de l'opération correspondant à l'étiquette
    private String format;
    //    public String name;
    
    //    public C3aLabel(int number, int line, String name){
    public C3aLabel(int number){
	this.number = number;
	this.line = 0;
	//	this.name = name;
    }

    public C3aLabel(String format) { this.format = format; }

    public int getNumber(){return this.number;}
    public int getLine(){return this.line;}

    public String getFormat() { return this.format; }
    public String toString(){
	return "l" + this.number;
    }
    
    public <T> T accept(C3aVisitor <T> visitor) {
        return visitor.visit(this);
    }
}
