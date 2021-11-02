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
public class PackageDeclaration extends Declaration{
    
    public PackageDeclaration (Identifier iAST, Declaration dAST, SourcePosition sourcePosition) {
        super(sourcePosition);
        this.iAST = iAST;
        this.dAST = dAST;
  }
  
    @Override
  public Object visit(Visitor v, Object o) {
    return v.visitPackageDeclaration(this, o);
  }

  public Identifier iAST;
  public Declaration dAST;
}


