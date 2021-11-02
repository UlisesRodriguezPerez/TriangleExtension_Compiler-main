/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Triangle.AbstractSyntaxTrees;

import Triangle.SyntacticAnalyzer.SourcePosition;

public class LongIdentifier extends Identifier {

  public LongIdentifier (Identifier piAST,Identifier iAST, SourcePosition thePosition, String theSpelling) {
    super (theSpelling, thePosition);
    this.piAST = piAST;
    this.iAST = iAST;
  }

  public Object visit(Visitor v, Object o) {
    return v.visitLongIdentifier(this, o);
  }

  public Identifier piAST;
  public Identifier iAST; 
}
