/*
 * @(#)Token.java                        2.1 2003/10/07
 *
 * Copyright (C) 1999, 2003 D.A. Watt and D.F. Brown
 * Dept. of Computing Science, University of Glasgow, Glasgow G12 8QQ Scotland
 * and School of Computer and Math Sciences, The Robert Gordon University,
 * St. Andrew Street, Aberdeen AB25 1HG, Scotland.
 * All rights reserved.
 *
 * This software is provided free for educational use only. It may
 * not be used for commercial purposes without the prior written permission
 * of the authors.
 */

package Triangle.SyntacticAnalyzer;


public final class Token extends Object {

  protected int kind;
  protected String spelling;
  protected SourcePosition position;

  public Token(int kind, String spelling, SourcePosition position) {

    if (kind == Token.IDENTIFIER) {
      int currentKind = firstReservedWord;
      boolean searching = true;

      while (searching) {
        int comparison = tokenTable[currentKind].compareTo(spelling);
        if (comparison == 0) {
          this.kind = currentKind;
          searching = false;
        } else if (comparison > 0 || currentKind == lastReservedWord) {
          this.kind = Token.IDENTIFIER;
          searching = false;
        } else {
          currentKind ++;
        }
      }
    } else
      this.kind = kind;

    this.spelling = spelling;
    this.position = position;

  }

  public static String spell (int kind) {
    return tokenTable[kind];
  }

  public String toString() {
    return "Kind=" + kind + ", spelling=" + spelling +
      ", position=" + position;
  }

  // Token classes...

  public static final int

    // literals, identifiers, operators...
    INTLITERAL	= 0,
    CHARLITERAL	= 1,
    IDENTIFIER	= 2,
    OPERATOR	  = 3,

    // reserved words - must be in alphabetical order...
    ARRAY       = 4, // se elimina el token BEGIN
    CHOOSE      = 5, // se agrega el token CHOOSE
    CONST       = 6,
    DO          = 7,
    ELSE        = 8,
    ELSIF       = 9, // se agrega el token ELSIF
    END         = 10,
    FOR         = 11, // se agrega el token FOR
    FROM        = 12, // se agrega el token FROM
    FUNC        = 13,
    IF          = 14,
    IN          = 15,
    LET         = 16,
    LOOP        = 17, // se agrega el LOOP
    NOTHING     = 18, // se agrega el token NOTHING
    OF          = 19,
    PACKAGE     = 20, // se agrega el token PACKAGE
    PRIVATE     = 21, // se agrega el token PRIVATE
    PROC        = 22,
    RECORD      = 23,
    RECURSIVE   = 24, // se agrega el token RECURSIVE
    THEN	= 25,
    TO          = 26, // se agrega el token TO
    TYPE	= 27,
    UNTIL       = 28, // se agrega el token UNTIL
    VAR		= 29,
    WHEN        = 30, // se agrega el token WHEN
    WHILE	= 31,

    // punctuation...
    DOT		= 32,
    COLON	= 33,
    SEMICOLON	= 34,
    COMMA	= 35,
    BECOMES	= 36,
    IS		= 37,
    
    // NEW ONES
    PIPE        = 38, // se agrega el token PIPE |
    DOLLAR      = 39,   // se agrega el token DOLLAR $
    RANGE   = 40, // se agrega el token RANGE ..

    // brackets..
    LPAREN	= 41,
    RPAREN	= 42,
    LBRACKET	= 43,
    RBRACKET	= 44,
    LCURLY	= 45,
    RCURLY	= 46,

    // special tokens...
    EOT         = 47,
    ERROR	= 48;

 public static String[] tokenTable = new String[] {
    "<int>",
    "<char>",
    "<identifier>",
    "<operator>",
    "array",
    "choose",   // Se agrega el caracter de la palabra reservada choose
    "const",
    "do",
    "else",
    "elsif",    // Se agrega el caracter de la palabra reservada elsif
    "end",      // Se agrega el caracter de la palabra reservada for
    "for",      // Se agrega el caracter de la palabra reservada from
    "from",
    "func",
    "if",
    "in",
    "let",
    "loop",     // Se agrega el caracter de la palabra reservada loop
    "nothing",  // Se agrega el caracter de la palabra reservada nothing
    "of",
    "package",  // Se agrega el caracter de la palabra reservada package
    "private",  // Se agrega el caracter de la palabra reservada private
    "proc",
    "record",
    "recursive",// Se agrega el caracter de la palabra reservada recursive
    "then",
    "to",       // Se agrega el caracter de la palabra reservada to
    "type",
    "until",    // Se agrega el caracter de la palabra reservada until
    "var",
    "when",     // Se agrega el caracter de la palabra reservada when
    "while",
    ".",
    ":",
    ";",
    ",",
    ":=",
    "~",
    "|",    // Se agrega el caracter del simbolo |
    "$",    // Se agrega el caracter del simbolo $
    "..",   // Se agrega el caracter del simbolo ..
    "(",
    ")",
    "[",
    "]",
    "{",
    "}",
    "",
    "<error>"
  };

    public static final int firstReservedWord = Token.ARRAY;
    public static final int lastReservedWord = Token.WHILE;

}
