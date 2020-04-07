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
        this.nasm.ajouteInst(new NasmAdd(null, dest, op2,""));

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
        /** ICI **/
        return inst.result.accept(this);
    }

    @Override
    public NasmOperand visit(C3aInstFBegin inst) {


        this.currentFct = inst.val;

        Boolean variable = false;

        if (inst.val.saDecFonc.getVariable() != null) variable = true;

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        NasmRegister esp = new NasmRegister(Nasm.REG_ESP);
        esp.colorRegister(Nasm.REG_ESP);
        this.nasm.newRegister();

        NasmRegister ebp = new NasmRegister(Nasm.REG_EBP);
        ebp.colorRegister(Nasm.REG_EBP);
        this.nasm.newRegister();



        if (this.currentFct.identif.equals("main")) {
            NasmRegister reg_eax = this.nasm.newRegister();
            reg_eax.colorRegister(Nasm.REG_EAX);

            NasmRegister reg_ebx = this.nasm.newRegister();
            reg_ebx.colorRegister(Nasm.REG_EBX);

            this.nasm.ajouteInst(new NasmCall(label, new NasmLabel(inst.val.identif),""));
            this.nasm.ajouteInst(new NasmMov(label, reg_ebx, new NasmConstant(0), ""));
            this.nasm.ajouteInst(new NasmMov(label, reg_eax, new NasmConstant(1), ""));
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

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;


        NasmOperand jump = inst.result.accept(this);
        NasmOperand op1 = inst.op1.accept(this);
        NasmOperand op2 = inst.op2.accept(this);


        NasmRegister rX = new NasmRegister(this.nasm.getTempCounter());



//        this.nasm.ajouteInst(new NasmMov(label, rX, new NasmConstant(1),""));
        this.nasm.ajouteInst(new NasmCmp(label, op1, op2,""));
        this.nasm.ajouteInst(new NasmJl(label, jump,""));
//        this.nasm.ajouteInst(new NasmMov(label, rX, new NasmConstant(0),""));

        return jump;
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

        NasmRegister reg_eax = new NasmRegister(Nasm.REG_EAX);
        NasmLabel sinput = new NasmLabel("sinput");
        NasmLabel readline = new NasmLabel("readline");
        NasmLabel atoi = new NasmLabel("atoi");


        this.nasm.ajouteInst(new NasmMov(label, reg_eax, sinput,""));
        this.nasm.ajouteInst(new NasmCall(label, readline, ""));
        this.nasm.ajouteInst(new NasmCall(label, atoi, ""));

        NasmRegister reg = this.nasm.newRegister();

        this.nasm.ajouteInst(new NasmMov(label, reg, reg_eax, ""));
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
        this.nasm.ajouteInst(new NasmSub(label, dest, op2,""));
        return dest;
    }

    @Override
    public NasmOperand visit(C3aInstAffect inst) {

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        this.nasm.ajouteInst(new NasmMov(label,inst.result.accept(this), inst.op1.accept(this), ""));
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

        NasmRegister rX = null;




        if (dest.isGeneralRegister()) {
            System.out.println("ici2" + ((NasmRegister) dest).val);

            System.out.println(this.nasm.getTempCounter());
            ((NasmRegister) dest).colorRegister(Nasm.REG_EAX);
        }

        if (op1 instanceof NasmRegister) {
            if (((NasmRegister) op1).val == Nasm.REG_EAX) rX = new NasmRegister(0);
            else if (((NasmRegister) op1).val == Nasm.REG_EBX) rX = new NasmRegister(1);
            else if (((NasmRegister) op1).val == Nasm.REG_ECX) rX = new NasmRegister(2);
            else if (((NasmRegister) op1).val == Nasm.REG_EDX) rX = new NasmRegister(3);
//            rX = this.nasm.newRegister();
            this.nasm.ajouteInst(new NasmMov(label, dest, rX, ""));

        }

        else this.nasm.ajouteInst(new NasmMov(label, dest, op1, ""));






        if (!(op2 instanceof NasmRegister)) {
//            NasmRegister r = this.nasm.newRegister();
            NasmRegister r = new NasmRegister(this.nasm.getTempCounter());
            System.out.println(this.nasm.getTempCounter());
            System.out.println(r.val);
            this.nasm.ajouteInst(new NasmMov(label, r, op2,""));
            this.nasm.ajouteInst(new NasmDiv(label, r,""));
        }
        else this.nasm.ajouteInst(new NasmDiv(label, op2,""));

        if (dest.isGeneralRegister()) {

            if (((NasmRegister) dest).val == Nasm.REG_EAX) rX = new NasmRegister(0);
            else if (((NasmRegister) dest).val == Nasm.REG_EBX) rX = new NasmRegister(1);
            else if (((NasmRegister) dest).val == Nasm.REG_ECX) rX = new NasmRegister(2);
            else if (((NasmRegister) dest).val == Nasm.REG_EDX) rX = new NasmRegister(3);
//            this.nasm.newRegister();
            this.nasm.ajouteInst(new NasmMov(label, rX, dest,""));
        }


        return dest;
    }

    @Override
    public NasmOperand visit(C3aInstFEnd inst) {
        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;


        NasmRegister reg_esp = new NasmRegister(Nasm.REG_ESP);
        reg_esp.colorRegister(Nasm.REG_ESP);
        NasmRegister reg_ebp = new NasmRegister(Nasm.REG_EBP);
        reg_ebp.colorRegister(Nasm.REG_EBP);

        if (this.currentFct.saDecFonc.getVariable() != null) {
            int nb_var = this.currentFct.saDecFonc.getVariable().length();
            Nasm.REG_ESP = Nasm.REG_ESP + nb_var;
            this.nasm.ajouteInst(new NasmAdd(label, reg_esp, new NasmConstant(4*nb_var),""));
        }
        else {
            this.nasm.ajouteInst(new NasmAdd(label, reg_esp, new NasmConstant(0),""));
        }

        this.nasm.ajouteInst(new NasmPop(label,reg_ebp,inst.comment ));
        this.nasm.ajouteInst(new NasmRet(label, ""));
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfEqual inst) {

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        NasmOperand jumpAdress = inst.result.accept(this);
        NasmOperand dest = inst.op1.accept(this);
        NasmOperand source = inst.op2.accept(this);

        NasmOperand resLabel = inst.result.accept(this);

        if (dest instanceof NasmConstant) {
            NasmRegister register = this.nasm.newRegister();
            this.nasm.ajouteInst(new NasmMov(label, register, dest,""));
            this.nasm.ajouteInst(new NasmCmp(null, register, source, ""));
            this.nasm.ajouteInst(new NasmJe(null, jumpAdress,""));
        }
        else {
            this.nasm.ajouteInst(new NasmCmp(label, dest, source, ""));
            this.nasm.ajouteInst(new NasmJe(null, jumpAdress,""));
        }


        return resLabel;
    }

    @Override
    public NasmOperand visit(C3aInstJumpIfNotEqual inst) {
        return null;
    }

    @Override
    public NasmOperand visit(C3aInstJump inst) {

        NasmOperand label = (inst.label != null) ?
                inst.label.accept(this) :
                null;

        NasmOperand adress = inst.result.accept(this);


//        this.nasm.ajouteInst(new NasmMov(null, new NasmRegister(Nasm.REG_EAX), new NasmConstant(1),""));
        this.nasm.ajouteInst(new NasmJmp(null, adress, ""));

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


        NasmRegister reg_eax = new NasmRegister(Nasm.REG_EAX);
        reg_eax.colorRegister(Nasm.REG_EAX);

        NasmOperand exp = inst.op1.accept(this);

        if (exp instanceof NasmRegister) {
            exp = new NasmRegister(((NasmRegister) exp).val);
        }


        this.nasm.ajouteInst(new NasmMov(label, reg_eax, exp,""));

        this.nasm.ajouteInst(new NasmCall(null, new NasmLabel("iprintLF"),""));

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
        this.nasm.newRegister();
//        if (reg.isGeneralRegister()) reg.colorRegister(oper.num);
        return reg;
    }

    @Override
    public NasmOperand visit(C3aVar oper) {


        if (oper.index != null) {
            NasmOperand off = oper.index.accept(this);
        }

        NasmLabel var_nom = new NasmLabel(oper.item.identif);
        return null;
    }

    @Override
    public NasmOperand visit(C3aFunction oper) {


        return oper.accept(this);
    }
}
