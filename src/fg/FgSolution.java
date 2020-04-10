package fg;
import util.graph.*;
import nasm.*;
import util.intset.*;

import java.awt.*;
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
		addDefUse(inst);
		this.out.put(inst, new IntSet(this.fg.inst2Node.size()));
		this.in.put(inst, new IntSet(this.fg.inst2Node.size()));
//		inst.accept(this);
	}

	for (NasmInst inst : this.nasm.listeInst) {

		IntSet inCopy = this.in.get(inst).copy();
		IntSet outCopy = this.out.get(inst).copy();

		// 1
		this.in.put(inst, this.use.get(inst));

		// 2



		if (!(this.in.get(inst).isEmpty())) {
			System.out.println(inst);
			NodeList pred;

			if ((pred = this.fg.inst2Node.get(inst).pred()) != null) {
				while (pred.head != null) {

					this.out.put(this.fg.node2Inst.get(pred.head), this.in.get(inst));
//					IntSet copy = this.out.get(this.fg.node2Inst.get(pred.head)).copy();
//					copy.union(this.in.get(inst));
//					this.out.put(this.fg.node2Inst.get(pred.head), copy);
					if (pred.tail == null) break;
					else pred = pred.tail;
				}
			}
		}
	}

	for (NasmInst inst : this.nasm.listeInst) {
		//3

		if (!(this.out.get(inst).isEmpty())) {
			IntSet copy = this.out.get(inst).copy();
			if ((copy.inter(this.def.get(inst))).isEmpty())


				System.out.println("JE RENTRE");
				System.out.println("VAR " + this.out.get(inst));
//				this.in.put(inst, this.out.get(inst));
			System.out.println("TRUC A ADD "  + this.out.get(inst));
				this.in.get(inst).union(this.out.get(inst));

//			this.in.put(inst, var);
		}
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

    	IntSet defSet = new IntSet(this.fg.inst2Node.size());
		IntSet useSet = new IntSet(this.fg.inst2Node.size());


		if (inst.destination != null) {
			if (inst.destination.isGeneralRegister()) {
				if (inst.destDef) {
					defSet.add(((NasmRegister) inst.destination).val);
				}

				if (inst.destUse) {
					useSet.add(((NasmRegister) inst.destination).val);
				}
			}
		}

		if (inst.source != null) {
			if (inst.source.isGeneralRegister()) {
				if (inst.srcDef) {
					defSet.add(((NasmRegister) inst.source).val);
				}

				if (inst.srcUse) {
					useSet.add(((NasmRegister) inst.source).val);
				}
			}
		}


    	this.def.put(inst, defSet);
    	this.use.put(inst, useSet);




	}


	public void addInOut(NasmInst inst) {



		IntSet defCopy = this.def.get(inst).copy();
		IntSet useCopy = this.use.get(inst).copy();

		IntSet outSet = this.out.get(inst).copy();
		IntSet inSet  = (useCopy.union((outSet.minus(defCopy))));


		NodeList succ = this.fg.inst2Node.get(inst).succ();
		ArrayList<IntSet> array = new ArrayList<>();

		if (succ != null) {

			while (succ.tail != null) {
				IntSet in = this.in.get(this.fg.node2Inst.get(succ.head));
				array.add(in);
				if (succ.tail != null) succ = succ.tail;
			}

			IntSet inSum = new IntSet(this.fg.inst2Node.size());
			IntSet res = new IntSet(this.fg.inst2Node.size());

			for  (IntSet in : array) {


				res = inSum.union(in);
				inSum = res;
				System.out.println("JE RENTRE");
			}

			outSet = res;


		}



		this.in.put(inst, inSet);
		this.out.put(inst, outSet);


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

    
