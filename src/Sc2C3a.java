import c3a.*;
import sa.*;
import ts.Ts;

public class Sc2C3a extends SaDepthFirstVisitor<C3aOperand> {
    private C3a c3a;
    private Ts ts;

    public Sc2C3a(SaNode root, Ts table) {
        this.c3a = new C3a();
        this.ts = table;
        root.accept(this);
    }


    public C3a getC3a() {
        return this.c3a;
    }

    public Ts getTs() { return this.ts; }

    @Override
    public C3aOperand visit(SaProg node) {

        C3aFunction function = (C3aFunction) visit(node.getFonctions());
        if (function == null) System.out.println("fonction null");
        C3aInstFBegin c3aInstFBegin = new C3aInstFBegin(function.val,"entree " + "fonction");
        this.c3a.ajouteInst(c3aInstFBegin);
        return function;
    }

    @Override
    public C3aOperand visit(SaDecTab node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExp node) {

        SaExpInt expInt = (SaExpInt) node;
        System.out.println("Valeur " + expInt.getVal());
        return new C3aConstant(expInt.getVal());
    }

    @Override
    public C3aOperand visit(SaExpInt node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpVar node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstEcriture node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstTantQue node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaLInst node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaDecFonc node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaDecVar node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstAffect node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaLDec node) {

//       if (this.ts.getFct(node.getTete().getNom()).saDecFonc.getParametres() != null) {
//           visit(this.ts.getFct(node.getTete().getNom()).saDecFonc.getParametres().getQueue());
//       }

       if (this.ts.getFct(node.getTete().getNom()).saDecFonc.tsItem.identif != null) {
//           if (this.ts.getFct(node.getTete().getNom()).saDecFonc.getParametres() != null) {
//               visit(this.ts.getFct(node.getTete().getNom()).saDecFonc.getParametres());
//           }


//           visit((SaInstBloc) this.ts.getFct(node.getTete().getNom()).saDecFonc.getCorps());
//           System.out.println(" ICI " + this.ts.getFct(node.getTete().getNom()).saDecFonc.tsItem.nbArgs);
           return new C3aFunction(this.ts.getFct(node.getTete().getNom()).saDecFonc.tsItem);
        }
        else return null;
    }

    @Override
    public C3aOperand visit(SaVarSimple node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaAppel node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpAppel node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpAdd node) {
        C3aTemp temp = this.c3a.newTemp();
        C3aOperand op1 = visit(node.getOp1());
        C3aOperand op2 = visit(node.getOp1());
        C3aInstAdd instAdd =  new C3aInstAdd(op1, op2, temp, "");
        this.c3a.ajouteInst(instAdd);
        return temp;

    }

    @Override
    public C3aOperand visit(SaExpSub node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpMult node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpDiv node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpInf node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpEqual node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpAnd node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpOr node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpNot node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaExpLire node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstBloc node) {
        return visit(node.getVal());
    }

    @Override
    public C3aOperand visit(SaInstSi node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaInstRetour node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaLExp node) {
        return super.visit(node);
    }

    @Override
    public C3aOperand visit(SaVarIndicee node) {
        return super.visit(node);
    }
}
