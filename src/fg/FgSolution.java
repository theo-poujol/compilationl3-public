package fg;
import util.graph.*;
import nasm.*;
import util.intset.*;
import java.io.*;
import java.util.*;

public class FgSolution implements NasmVisitor <Void>{
    int iterNum = 0;
    public Nasm nasm;
    Fg fg;
    public Map< NasmInst, IntSet> use;
    public Map< NasmInst, IntSet> def;
    public Map< NasmInst, IntSet> in;
    public Map< NasmInst, IntSet> out;
    
    public FgSolution(Nasm nasm, Fg fg){
	this.nasm = nasm;
	this.fg = fg;
	this.use = new HashMap< NasmInst, IntSet>();
	this.def = new HashMap< NasmInst, IntSet>();
	this.in =  new HashMap< NasmInst, IntSet>();
	this.out = new HashMap< NasmInst, IntSet>();



	for (NasmInst inst : this.nasm.listeInst) {
		inst.accept(this);
	}





    }
    
    public void affiche(String baseFileName){
	String fileName;
	PrintStream out = System.out;
	
	if (baseFileName != null){
	    try {
		baseFileName = baseFileName;
		fileName = baseFileName + ".fgs";
		out = new PrintStream(fileName);
	    }
	    
	    catch (IOException e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
	
	out.println("iter num = " + iterNum);
	for(NasmInst nasmInst : this.nasm.listeInst){
	    out.println("use = "+ this.use.get(nasmInst) + " def = "+ this.def.get(nasmInst) + "\tin = " + this.in.get(nasmInst) + "\t \tout = " + this.out.get(nasmInst) + "\t \t" + nasmInst);
	}
    }



    public void addDefUse(NasmInst inst) {

    	IntSet intSet = new IntSet(this.fg.inst2Node.size());

    	if (inst.destination.isGeneralRegister()) {
			if (inst.destDef) {

			}

			if (inst.destUse) {

			}
		}


    	if (inst.source.isGeneralRegister()) {
			if (inst.srcDef) {

			}

			if (inst.srcUse) {

			}
		}

	}


	@Override
	public Void visit(NasmAdd inst) {
		return null;
	}

	@Override
	public Void visit(NasmCall inst) {
		return null;
	}

	@Override
	public Void visit(NasmDiv inst) {
		return null;
	}

	@Override
	public Void visit(NasmJe inst) {
		return null;
	}

	@Override
	public Void visit(NasmJle inst) {
		return null;
	}

	@Override
	public Void visit(NasmJne inst) {
		return null;
	}

	@Override
	public Void visit(NasmMul inst) {
		return null;
	}

	@Override
	public Void visit(NasmOr inst) {
		return null;
	}

	@Override
	public Void visit(NasmCmp inst) {
		return null;
	}

	@Override
	public Void visit(NasmInst inst) {
		return null;
	}

	@Override
	public Void visit(NasmJge inst) {
		return null;
	}

	@Override
	public Void visit(NasmJl inst) {
		return null;
	}

	@Override
	public Void visit(NasmNot inst) {
		return null;
	}

	@Override
	public Void visit(NasmPop inst) {
		return null;
	}

	@Override
	public Void visit(NasmRet inst) {
		return null;
	}

	@Override
	public Void visit(NasmXor inst) {
		return null;
	}

	@Override
	public Void visit(NasmAnd inst) {
		return null;
	}

	@Override
	public Void visit(NasmJg inst) {
		return null;
	}

	@Override
	public Void visit(NasmJmp inst) {
		return null;
	}

	@Override
	public Void visit(NasmMov inst) {
		return null;
	}

	@Override
	public Void visit(NasmPush inst) {
		return null;
	}

	@Override
	public Void visit(NasmSub inst) {
		return null;
	}

	@Override
	public Void visit(NasmEmpty inst) {
		return null;
	}

	@Override
	public Void visit(NasmAddress operand) {
		return null;
	}

	@Override
	public Void visit(NasmConstant operand) {
		return null;
	}

	@Override
	public Void visit(NasmLabel operand) {
		return null;
	}

	@Override
	public Void visit(NasmRegister operand) {
		return null;
	}
}

    
