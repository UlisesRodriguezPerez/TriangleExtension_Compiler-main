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
public class SeqPackageDeclaration extends Declaration{
    
    public SeqPackageDeclaration (Declaration d1AST, Declaration d2AST, SourcePosition sourcePosition) {
        super(sourcePosition);
        this.d1AST = d1AST;
        this.d2AST = d2AST;
  }
  
  public Object visit(Visitor v, Object o) {
    return v.visitSeqPackageDeclaration(this, o);
  }

  public Declaration d1AST;
  public Declaration d2AST;
}


