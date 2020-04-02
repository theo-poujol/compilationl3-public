import c3a.C3a;
import c3a.C3aVisitor;
import nasm.Nasm;
import nasm.NasmOperand;
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
    }


    public Nasm getNasm() { return this.nasm;}
}
