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

        for (int i = 0; i < this.c3a.listeInst.size(); ++i) {
            visit(this.c3a.listeInst.get(i));
        }

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

//        if (dest.isGeneralRegister()) {
//            NasmRegister reg = (NasmRegister) dest;
//            this.nasm.ajouteInst(new NasmMov(label, reg, op1, ""));
//            this.nasm.ajouteInst(new NasmAdd(label, reg, op2,""));
//        }
//
//        else {
//            this.nasm.ajouteInst(new NasmMov(label, dest, op1, ""));
//            this.nasm.ajouteInst(new NasmAdd(label, dest, op2,""));
//        }





        return dest;
    }

    @Override
    public NasmOperand visit(C3aInstCall inst) {

        System.out.println("je CALL");
        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;







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


        this.currentFct = inst.val;

        Boolean variable = false;

        if (inst.val.saDecFonc.getVariable() != null) variable = true;

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        NasmLabel ebp =  new NasmLabel("ebp");
        NasmLabel esp =  new NasmLabel("esp");


        if (this.currentFct.identif.equals("main")) {
            NasmLabel eax =  new NasmLabel("eax");
            NasmLabel ebx =  new NasmLabel("ebx");

            this.nasm.ajouteInst(new NasmCall(label, new NasmLabel(inst.val.identif),""));
            this.nasm.ajouteInst(new NasmMov(label, ebx, new NasmConstant(0), ""));
            this.nasm.ajouteInst(new NasmMov(label, eax, new NasmConstant(1), ""));
            this.nasm.ajouteInst(new NasmInt(null,""));

        }



        this.nasm.ajouteInst(new NasmPush(new NasmLabel(inst.val.identif), ebp,""));
        this.nasm.ajouteInst(new NasmMov(label, ebp,esp,""));

        if (variable) {
            int nb_varLoc = inst.val.saDecFonc.getVariable().length();
            Nasm.REG_EBP = Nasm.REG_EBP - 4*nb_varLoc;
            this.nasm.ajouteInst(new NasmSub(label, esp, new NasmConstant(4*nb_varLoc),""));
        }

        else {
            this.nasm.ajouteInst(new NasmSub(label, esp, new NasmConstant(0),""));
        }



        return null;
    }

    @Override
    public NasmOperand visit(C3aInst inst) {

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        return inst.accept(this);
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
        return dest;
    }

    @Override
    public NasmOperand visit(C3aInstRead inst) {

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        NasmLabel eax = new NasmLabel("eax");
        NasmLabel sinput = new NasmLabel("sinput");
        NasmLabel readline = new NasmLabel("readline");
        NasmLabel atoi = new NasmLabel("atoi");


        this.nasm.ajouteInst(new NasmMov(label, eax, sinput,""));
        this.nasm.ajouteInst(new NasmCall(label, readline, ""));
        this.nasm.ajouteInst(new NasmCall(label, atoi, ""));

        NasmRegister reg = this.nasm.newRegister();

        this.nasm.ajouteInst(new NasmMov(label, reg, eax, ""));
        return reg;
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
        return dest;
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
        return dest;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;


        NasmLabel esp = new NasmLabel("esp");
        NasmLabel ebp = new NasmLabel("ebp");

        if (this.currentFct.saDecFonc.getVariable() != null) {
            int nb_var = this.currentFct.saDecFonc.getVariable().length();
            Nasm.REG_ESP = Nasm.REG_ESP + nb_var;
            this.nasm.ajouteInst(new NasmAdd(label, esp, new NasmConstant(4*nb_var),""));
        }
        else {
            this.nasm.ajouteInst(new NasmAdd(label, esp, new NasmConstant(0),""));
        }

        this.nasm.ajouteInst(new NasmPop(label,ebp,inst.comment ));
        this.nasm.ajouteInst(new NasmRet(label, ""));
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

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        NasmOperand op = inst.op1.accept(this);


        if (op instanceof NasmRegister) {
            this.nasm.ajouteInst(new NasmMov(label, new NasmAddress(op) ,op,""));
        }

        return op;
    }

    @Override
    public NasmOperand visit(C3aInstWrite inst) {

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;


        NasmLabel eax = new NasmLabel("eax");
        NasmOperand exp = inst.op1.accept(this);
        this.nasm.ajouteInst(new NasmMov(label, eax, exp,""));

        this.nasm.ajouteInst(new NasmCall(label, new NasmLabel("iprintLF"),""));
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

        NasmRegister reg = new NasmRegister(oper.num);
//        if (reg.isGeneralRegister()) reg.colorRegister(oper.num);
        return reg;
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
