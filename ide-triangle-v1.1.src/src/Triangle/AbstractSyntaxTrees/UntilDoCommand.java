/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;
import Triangle.SyntacticAnalyzer.SourcePosition;

/**
 *
 * @author emema
 */
public class UntilDoCommand extends Command{
    public UntilDoCommand (Command cAST, Expression eAST,SourcePosition thePosition) {
        super (thePosition);
        E = eAST;
        C = cAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitUntilDoCommand(this, o);
    }

    public Expression E;
    public Command C;
}
