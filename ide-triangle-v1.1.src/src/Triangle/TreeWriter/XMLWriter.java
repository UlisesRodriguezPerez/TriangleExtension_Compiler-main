package Triangle.TreeWriter;

import Triangle.AbstractSyntaxTrees.DoUntilCommand;
import Triangle.AbstractSyntaxTrees.DoWhileCommand;
import Triangle.AbstractSyntaxTrees.ForDoCommand;
import Triangle.AbstractSyntaxTrees.ForIdentifierExpression;
import Triangle.AbstractSyntaxTrees.ForUntilCommand;
import Triangle.AbstractSyntaxTrees.ForWhileCommand;
import Triangle.AbstractSyntaxTrees.LongIdentifier;
import Triangle.AbstractSyntaxTrees.PackageDeclaration;
import Triangle.AbstractSyntaxTrees.PackageIdentifier;
import Triangle.AbstractSyntaxTrees.PrivateDeclaration;
import Triangle.AbstractSyntaxTrees.Program;
import Triangle.AbstractSyntaxTrees.RecursiveDeclaration;
import Triangle.AbstractSyntaxTrees.SeqPackageDeclaration;
import Triangle.AbstractSyntaxTrees.UntilDoCommand;
import Triangle.AbstractSyntaxTrees.VarDeclarationBecomes;
import Triangle.AbstractSyntaxTrees.WhileDoCommand;

import java.io.FileWriter;
import java.io.IOException;

public class XMLWriter {

  private String fileName;

  public XMLWriter(String fileName) {
    this.fileName = fileName;
  }

  // Draw the AST representing a complete program.
  public void write(Program ast) {
    // Prepare the file to write
    try {
      FileWriter fileWriter = new FileWriter(fileName+".xml");

      //XML header
      fileWriter.write("<?xml version=\"1.0\" standalone=\"yes\"?>\n");

      XMLWriterVisitor layout = new XMLWriterVisitor(fileWriter); 
      ast.visit(layout, null);

      fileWriter.close();

    } catch (IOException e) {
      System.err.println("Error while creating file for print the AST");
      e.printStackTrace();
    }
  }

}
