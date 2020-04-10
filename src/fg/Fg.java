package fg;
import nasm.*;
import util.graph.*;
import util.graph.Node;
import java.util.*;
import java.io.*;

public class Fg implements NasmVisitor <Void> {
    public Nasm nasm;
    public Graph graph;
    Map< NasmInst, Node> inst2Node;
    Map<Node, NasmInst> node2Inst;
    Map< String, NasmInst> label2Inst;

    public Fg(Nasm nasm){
	this.nasm = nasm;
	this.inst2Node = new HashMap< NasmInst, Node>();
	this.node2Inst = new HashMap<Node, NasmInst>();
	this.label2Inst = new HashMap< String, NasmInst>();
	this.graph = new Graph();


	Node node;
    for (NasmInst nasmInst : this.nasm.listeInst) {

        node = this.graph.newNode();
        addVertex(nasmInst, node);
    }

    for (NasmInst nasmInst : this.nasm.listeInst) {
//        visit(nasmInst);
        nasmInst.accept(this);
    }

//    this.nasm.listeInst.get(0).accept(this);



    }

    public void affiche(String baseFileName){
	String fileName;
	PrintStream out = System.out;

	if (baseFileName != null){
	    try {
		baseFileName = baseFileName;
		fileName = baseFileName + ".fg";
		out = new PrintStream(fileName);
	    }
	    
	    catch (IOException e) {
		System.err.println("Error: " + e.getMessage());
	    }
	}
	
	for(NasmInst nasmInst : nasm.listeInst){
	    Node n = this.inst2Node.get(nasmInst);
	    out.print(n + " : ( ");
	    for(NodeList q=n.succ(); q!=null; q=q.tail) {
		out.print(q.head.toString());
		out.print(" ");
	    }
	    out.println(")\t" + nasmInst);
	}
    }

    public void addVertex(NasmInst inst, Node node) {


        this.inst2Node.put(inst, node);
        this.node2Inst.put(node, inst);

        if (inst.label != null) {
            String nom = inst.label.toString();
            this.label2Inst.put(nom, inst);
        }
    }

    public void addSimpleEdge(NasmInst inst, Node source) {

        int cpt = 0;
        for (NasmInst nasmInst : this.nasm.listeInst) {
            if (nasmInst.equals(inst)) break;
            cpt++;
        }

        NasmInst nextInst = this.nasm.listeInst.get(cpt+1);
        Node dest = this.inst2Node.get(nextInst);


        if (dest != null)
        {
            this.graph.addEdge(source,dest);
            this.node2Inst.get(dest).accept(this);
        }

    }


    
    public Void visit(NasmAdd inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmCall inst) {

        Node nodeCall = null;


        for (NasmInst instCall : this.nasm.listeInst) {


            NasmLabel instLabel = (NasmLabel) inst.address;
            if (instCall.label != null)
            {
                NasmLabel instCallLabel = (NasmLabel) instCall.label;
                if (instCallLabel.val.equals(instLabel.val)) {
                    nodeCall = this.inst2Node.get(instCall);
                    break;
                }
            }

        }


        if (nodeCall != null) {
            this.graph.addEdge(this.inst2Node.get(inst),nodeCall);
            this.node2Inst.get(nodeCall).accept(this);
        }


//        visit(this.node2Inst.get(nodeCall));

        return null;
    }

    public Void visit(NasmDiv inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmJe inst) {
        addSimpleEdge(inst, this.inst2Node.get(inst));

        Node nodeJump = null;
        for (NasmInst posInst : this.nasm.listeInst) {
            if (inst.address.equals(posInst.label)) {
                nodeJump = this.inst2Node.get(posInst);
                break;
            }
        }

        this.graph.addEdge(this.inst2Node.get(inst),nodeJump);
        return null;
    }


    public Void visit(NasmJle inst)  {
        addSimpleEdge(inst, this.inst2Node.get(inst));

        Node nodeJump = null;
        for (NasmInst posInst : this.nasm.listeInst) {
            if (inst.address.equals(posInst.label)) {
                nodeJump = this.inst2Node.get(posInst);
                break;
            }
        }

        this.graph.addEdge(this.inst2Node.get(inst),nodeJump);
        return null;
    }

    public Void visit(NasmJne inst) {
        addSimpleEdge(inst, this.inst2Node.get(inst));

        Node nodeJump = null;
        for (NasmInst posInst : this.nasm.listeInst) {
            if (inst.address.equals(posInst.label)) {
                nodeJump = this.inst2Node.get(posInst);
                break;
            }
        }

        this.graph.addEdge(this.inst2Node.get(inst),nodeJump);
        return null;
    }

    public Void visit(NasmMul inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmOr inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmCmp inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmInst inst) {
//        Node node = this.graph.newNode();
//        addVertex(inst, node);

        if (inst instanceof NasmInt) addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmJge inst) {
        addSimpleEdge(inst, this.inst2Node.get(inst));

        Node nodeJump = null;
        for (NasmInst posInst : this.nasm.listeInst) {
            if (inst.address.equals(posInst.label)) {
                nodeJump = this.inst2Node.get(posInst);
                break;
            }
        }

        this.graph.addEdge(this.inst2Node.get(inst),nodeJump);
        return null;
    }

    public Void visit(NasmJl inst) {
        addSimpleEdge(inst, this.inst2Node.get(inst));

        Node nodeJump = null;
        for (NasmInst posInst : this.nasm.listeInst) {
            if (inst.address.equals(posInst.label)) {
                nodeJump = this.inst2Node.get(posInst);
                break;
            }
        }

        this.graph.addEdge(this.inst2Node.get(inst),nodeJump);
        return null;
    }

    public Void visit(NasmNot inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmPop inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmRet inst) {

//        addSimpleEdge(inst, this.inst2Node.get(inst));

        NasmInst nextInst = null;
        int cpt = 0;
        for (NasmInst nasmInst : this.nasm.listeInst) {
            if (nasmInst.equals(inst)) break;
            cpt++;
        }
        if (cpt+1 < this.nasm.listeInst.size()) {
            nextInst = this.nasm.listeInst.get(cpt+1);
            this.graph.addEdge(this.inst2Node.get(inst),this.inst2Node.get(nextInst));
        }
        return null;
    }

    public Void visit(NasmXor inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmAnd inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmJg inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));

        Node nodeJump = null;
        for (NasmInst posInst : this.nasm.listeInst) {
            if (inst.address.equals(posInst.label)) {
                nodeJump = this.inst2Node.get(posInst);
                break;
            }
        }

        this.graph.addEdge(this.inst2Node.get(inst),nodeJump);
        return null;
    }

    public Void visit(NasmJmp inst) {

        Node nodeJump = null;
        for (NasmInst posInst : this.nasm.listeInst) {
            if (inst.address.equals(posInst.label)) {
                nodeJump = this.inst2Node.get(posInst);
                break;
            }
        }

        this.graph.addEdge(this.inst2Node.get(inst),nodeJump);
        return null;
    }

    public Void visit(NasmMov inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmPush inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmSub inst) {

        addSimpleEdge(inst, this.inst2Node.get(inst));
        return null;
    }

    public Void visit(NasmEmpty inst) {
//        Node node = this.graph.newNode();
//        addVertex(inst, node);
//        this.graph.addNOEdge();
        return null;
    }


    public Void visit(NasmAddress operand){return null;}
    public Void visit(NasmConstant operand){return null;}
    public Void visit(NasmLabel operand){return null;}
    public Void visit(NasmRegister operand){return null;}


}
