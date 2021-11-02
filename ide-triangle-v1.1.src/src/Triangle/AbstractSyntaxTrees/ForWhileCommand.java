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
public class ForWhileCommand extends Command{
    public ForWhileCommand (Declaration ie, Command cAST, Expression e2AST,SourcePosition thePosition) {
        super (thePosition);
        E2 = e2AST;
        loop = cAST;
        IE = ie;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitForWhileCommand(this, o);
    }
    public Declaration IE;
    public Expression E2;
    public Command loop;
}
