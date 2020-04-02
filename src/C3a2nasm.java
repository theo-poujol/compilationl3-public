import c3a.*;
import nasm.*;
import ts.Ts;
import ts.TsItemFct;

public class C3a2nasm implements C3aVisitor<NasmOperand> {

    private C3a c3a;
    private Nasm nasm;
    private Ts tableGlobale;
    private TsItemFct currentFct;


    public C3a2nasm(C3a c3a, Ts table) {
        this.c3a = c3a;
        this.tableGlobale = table;
        this.nasm = new Nasm(this.tableGlobale);
        this.currentFct = this.tableGlobale.getFct("main");
    }


    public Nasm getNasm() { return this.nasm;}


    @Override
    public NasmOperand visit(C3aInstAdd inst) {

        NasmOperand label = (inst.label != null) ?
                            inst.label.accept(this) :
                            null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);

        this.nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
        this.nasm.ajouteInst(new NasmAdd(label, dest, op2,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstCall inst) {

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;


        NasmOperand temp = inst.result.accept(this);


        Nasm.REG_ESP = Nasm.REG_ESP - 4;

        NasmOperand r = inst.result.accept(this);
        NasmOperand nom = inst.op1.accept(this);
        this.nasm.ajouteInst(new NasmSub(label, new NasmLabel("esp"), new NasmConstant(4), ""));
        this.nasm.ajouteInst(new NasmCall(label,nom,""));


        this.nasm.ajouteInst(new NasmPop(label, r, ""));


        Nasm.REG_ESP = Nasm.REG_ESP + 4*inst.op1.val.getNbArgs();
        this.nasm.ajouteInst(new NasmAdd(null, new NasmLabel("esp"), new NasmConstant(4*inst.op1.val.getNbArgs()), ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {

        NasmLabel ebp =  new NasmLabel("ebp");
        NasmLabel esp =  new NasmLabel("esp");

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        this.nasm.ajouteInst(new NasmPush(label, ebp,""));
        this.nasm.ajouteInst(new NasmMov(label, ebp,esp,""));

        int nb_varLoc = inst.val.saDecFonc.getVariable().length();
        Nasm.REG_EBP = Nasm.REG_EBP - 4*nb_varLoc;
        this.nasm.ajouteInst(new NasmSub(label, ebp, new NasmConstant(4*nb_varLoc),""));

        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfLess inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstMult inst) {
        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);

        this.nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
        this.nasm.ajouteInst(new NasmMul(label, dest, op2,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstSub inst) {
        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);

        this.nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
        this.nasm.ajouteInst(new NasmMul(label, dest, op2,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstDiv inst) {
        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);
        NasmOperand dest = inst.result.accept(this);

        this.nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
        this.nasm.ajouteInst(new NasmDiv(label, op2,""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstParam inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstReturn inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aConstant oper) {
        return new NasmConstant(oper.val);
    }

    @Override
    public NasmOperand visit(C3aLabel oper) {

        return new NasmLabel(oper.toString());
    }

    @Override
    public NasmOperand visit(C3aTemp oper) {

        return new NasmRegister(oper.num);
    }

    @Override
    public NasmOperand visit(C3aVar oper) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {


        return oper.accept(this);
    }
}
