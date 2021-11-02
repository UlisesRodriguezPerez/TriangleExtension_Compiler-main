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
public class ForIdentifierExpression extends Declaration{
    public ForIdentifierExpression (Identifier iAST, Expression e1AST, SourcePosition thePosition) {
        super (thePosition);
        E1 = e1AST;
        I = iAST;
    }

    @Override
    public Object visit(Visitor v, Object o) {
        return v.visitForIdentifierExpression(this, o);
    }
    public Identifier I;
    public Expression E1;
}
