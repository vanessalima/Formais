/* AWK.java */
/* Generated By:JavaCC: Do not edit this line. AWK.java */
/* AWK Parser */
class AWK implements AWKConstants {

  // Processa o código e gera a tabela de tokens
  public void processa() throws ParseException, TokenMgrError{
    Token t;
    String nomeToken;
    do {
        // Pega o próximo token gerado pelo Léxico.
        t = getNextToken();
        // Pega o proximo token do tipo t.kind
        nomeToken = tokenImage[t.kind];
        // Seta a localização do token
        String location = "@(" + t.beginLine + ", " + t.beginColumn + ")";
        // Imprime as informações do token. Se for EOF não imprime image, pois ela não existe.
        if(t.kind == EOF)
            System.out.println(String.format("%-15s %-20s <EOF>", location, nomeToken));
        else
            System.out.println(String.format("%-15s %-20s %s", location, nomeToken, t.image));
    } while (!(nomeToken.equals("<EOF>"))); // Termina o loop se EOF
    System.out.println(String.format("%s", t.image));
  }

  /* Main entry point. */
  public static void main(String args[]) {
    try
    {
      // Define o analisador léxico de acordo com a entrada do sistema
      AWK analisadorLexico = new AWK(System.in);
      // Roda o loop de processamento enquanto não encontrar EOF
      //analisadorLexico.processa();

      // Define o analisador sintático de acordo com a entrada do sistema
      AWK analisadorSintatico = new AWK(System.in);
      // Roda o loop de processamento enquanto não encontrar EOF
      analisadorSintatico.javacc_input();

      // Processo Finalizado
      System.out.println("Analisado com sucesso!");
    }
    catch(ParseException e)
    {
      System.out.println(e.getMessage());
        System.out.println("Ocorreu uma excecao!");
    }
    catch(TokenMgrError e)
    {
        System.out.println(e.getMessage());
        System.out.println("Existem erros no codigo! Por favor, verifica-los.");
    }
  }

/*******************************************************
                AWK SIMPLIFIED GRAMMAR
*******************************************************/
  final public 
void javacc_input() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case BEGIN:
      case END:
      case LBRACKET:
      case LPAREN:
      case REFERENCE:
      case CREMENT_OP:
      case PLUS:
      case MINUS:
      case NEGATION:
      case IDENTIFIER:
      case INTEGER:
      case FLOAT:
      case NUM_EXP:
      case STRING:{
        ;
        break;
        }
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      Pattern();
      jj_consume_token(LBRACE);
      Action();
      jj_consume_token(RBRACE);
    }
    jj_consume_token(0);
  }

  final public void Pattern() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case BEGIN:{
      jj_consume_token(BEGIN);
      break;
      }
    case END:{
      jj_consume_token(END);
      break;
      }
    case LBRACKET:
    case LPAREN:
    case REFERENCE:
    case CREMENT_OP:
    case PLUS:
    case MINUS:
    case NEGATION:
    case IDENTIFIER:
    case INTEGER:
    case FLOAT:
    case NUM_EXP:
    case STRING:{
      Expression();
      break;
      }
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Action() throws ParseException {
    Statement02();
  }

  final public void Statement02() throws ParseException {
    label_2:
    while (true) {
      jj_consume_token(LBRACE);
      label_3:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IF:
        case BREAK:
        case CONTINUE:
        case NEXT:
        case GETLINE:
        case PRINT:
        case ATAN2:
        case ASSORT:
        case LBRACKET:
        case IDENTIFIER:{
          ;
          break;
          }
        default:
          jj_la1[2] = jj_gen;
          break label_3;
        }
        Statement();
      }
      jj_consume_token(RBRACE);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LBRACE:{
        ;
        break;
        }
      default:
        jj_la1[3] = jj_gen;
        break label_2;
      }
    }
  }

  final public void Statement() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IF:
    case BREAK:
    case CONTINUE:
    case NEXT:{
      Control_Statements();
      break;
      }
    case GETLINE:
    case PRINT:
    case ATAN2:
    case ASSORT:
    case LBRACKET:
    case IDENTIFIER:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case GETLINE:
      case PRINT:{
        IO_Statements();
        break;
        }
      case ATAN2:{
        Math_Statements();
        break;
        }
      case ASSORT:{
        String_Statements();
        break;
        }
      case LBRACKET:
      case IDENTIFIER:{
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case IDENTIFIER:{
          jj_consume_token(IDENTIFIER);
          break;
          }
        case LBRACKET:{
          Array();
          break;
          }
        default:
          jj_la1[4] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
        Assignment();
        break;
        }
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(SEMICOLON);
      break;
      }
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Control_Statements() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case BREAK:
    case CONTINUE:
    case NEXT:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case BREAK:{
        jj_consume_token(BREAK);
        break;
        }
      case CONTINUE:{
        jj_consume_token(CONTINUE);
        break;
        }
      case NEXT:{
        jj_consume_token(NEXT);
        break;
        }
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      jj_consume_token(SEMICOLON);
      break;
      }
    case IF:{
      If_Statement();
      break;
      }
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void If_Statement() throws ParseException {
    jj_consume_token(IF);
    jj_consume_token(LPAREN);
    Expression();
    jj_consume_token(RPAREN);
    Action();
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case ELSE:{
      jj_consume_token(ELSE);
      Action();
      break;
      }
    default:
      jj_la1[9] = jj_gen;
      ;
    }
  }

  final public void IO_Statements() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case PRINT:{
      jj_consume_token(PRINT);
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LBRACKET:
      case LPAREN:
      case REFERENCE:
      case CREMENT_OP:
      case PLUS:
      case MINUS:
      case NEGATION:
      case IDENTIFIER:
      case INTEGER:
      case FLOAT:
      case NUM_EXP:
      case STRING:{
        Expression();
        break;
        }
      default:
        jj_la1[10] = jj_gen;
        ;
      }
      break;
      }
    case GETLINE:{
      jj_consume_token(GETLINE);
      break;
      }
    default:
      jj_la1[11] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void Math_Statements() throws ParseException {
    jj_consume_token(ATAN2);
  }

  final public void String_Statements() throws ParseException {
    jj_consume_token(ASSORT);
  }

  final public void Assignment() throws ParseException {
    jj_consume_token(ASSIGNMENT_OP);
    Expression();
  }

/*****************************************
        MANIPULAÇÃO DE VARIAVEIS
*****************************************/
  final public void Array() throws ParseException {
    jj_consume_token(LBRACKET);
    Expression();
    jj_consume_token(RBRACKET);
  }

/************************************************************
                      EXPRESSÕES
************************************************************/
  final public 
void Expression() throws ParseException {
    Expression00();
  }

  final public void Expression00() throws ParseException {
    E01();
    label_4:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case QMARK:{
        ;
        break;
        }
      default:
        jj_la1[12] = jj_gen;
        break label_4;
      }
      jj_consume_token(QMARK);
      E01();
      jj_consume_token(COLON);
      E01();
    }
  }

  final public void E01() throws ParseException {
    E02();
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case OR:{
        ;
        break;
        }
      default:
        jj_la1[13] = jj_gen;
        break label_5;
      }
      jj_consume_token(OR);
      E02();
    }
  }

  final public void E02() throws ParseException {
    E03();
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case AND:{
        ;
        break;
        }
      default:
        jj_la1[14] = jj_gen;
        break label_6;
      }
      jj_consume_token(AND);
      E03();
    }
  }

  final public void E03() throws ParseException {
    E04();
    label_7:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case IN:{
        ;
        break;
        }
      default:
        jj_la1[15] = jj_gen;
        break label_7;
      }
      jj_consume_token(IN);
      E04();
    }
  }

  final public void E04() throws ParseException {
    E05();
    label_8:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case RELATIONAL_OP:{
        ;
        break;
        }
      default:
        jj_la1[16] = jj_gen;
        break label_8;
      }
      jj_consume_token(RELATIONAL_OP);
      E05();
    }
  }

  final public void E05() throws ParseException {
    label_9:
    while (true) {
      E06();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case LBRACKET:
      case LPAREN:
      case REFERENCE:
      case CREMENT_OP:
      case PLUS:
      case MINUS:
      case NEGATION:
      case IDENTIFIER:
      case INTEGER:
      case FLOAT:
      case NUM_EXP:
      case STRING:{
        ;
        break;
        }
      default:
        jj_la1[17] = jj_gen;
        break label_9;
      }
    }
  }

  final public void E06() throws ParseException {
    E07();
    label_10:
    while (true) {
      if (jj_2_1(2)) {
        ;
      } else {
        break label_10;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        jj_consume_token(PLUS);
        break;
        }
      case MINUS:{
        jj_consume_token(MINUS);
        break;
        }
      default:
        jj_la1[18] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      E07();
    }
  }

  final public void E07() throws ParseException {
    E08();
    label_11:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MULTIPLICATION:
      case DIVISION:
      case MODULUS:{
        ;
        break;
        }
      default:
        jj_la1[19] = jj_gen;
        break label_11;
      }
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case MULTIPLICATION:{
        jj_consume_token(MULTIPLICATION);
        break;
        }
      case DIVISION:{
        jj_consume_token(DIVISION);
        break;
        }
      case MODULUS:{
        jj_consume_token(MODULUS);
        break;
        }
      default:
        jj_la1[20] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      E08();
    }
  }

  final public void E08() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case PLUS:
    case MINUS:
    case NEGATION:{
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case PLUS:{
        jj_consume_token(PLUS);
        break;
        }
      case MINUS:{
        jj_consume_token(MINUS);
        break;
        }
      case NEGATION:{
        jj_consume_token(NEGATION);
        break;
        }
      default:
        jj_la1[21] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
      }
    default:
      jj_la1[22] = jj_gen;
      ;
    }
    E09();
  }

  final public void E09() throws ParseException {
    E10();
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case EXPONENTIATION:{
        ;
        break;
        }
      default:
        jj_la1[23] = jj_gen;
        break label_12;
      }
      jj_consume_token(EXPONENTIATION);
      E10();
    }
  }

  final public void E10() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case CREMENT_OP:{
      jj_consume_token(CREMENT_OP);
      E11();
      break;
      }
    default:
      jj_la1[24] = jj_gen;
      if (jj_2_2(2)) {
        E11();
        jj_consume_token(CREMENT_OP);
      } else {
        switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
        case LBRACKET:
        case LPAREN:
        case REFERENCE:
        case IDENTIFIER:
        case INTEGER:
        case FLOAT:
        case NUM_EXP:
        case STRING:{
          E11();
          break;
          }
        default:
          jj_la1[25] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
  }

  final public void E11() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case REFERENCE:{
      jj_consume_token(REFERENCE);
      break;
      }
    default:
      jj_la1[26] = jj_gen;
      ;
    }
    E12();
  }

  final public void E12() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case LPAREN:{
      jj_consume_token(LPAREN);
      E13();
      jj_consume_token(RPAREN);
      break;
      }
    case LBRACKET:
    case IDENTIFIER:
    case INTEGER:
    case FLOAT:
    case NUM_EXP:
    case STRING:{
      E13();
      break;
      }
    default:
      jj_la1[27] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void E13() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
    case IDENTIFIER:{
      jj_consume_token(IDENTIFIER);
      break;
      }
    case INTEGER:{
      jj_consume_token(INTEGER);
      break;
      }
    case FLOAT:{
      jj_consume_token(FLOAT);
      break;
      }
    case NUM_EXP:{
      jj_consume_token(NUM_EXP);
      break;
      }
    case STRING:{
      jj_consume_token(STRING);
      break;
      }
    case LBRACKET:{
      Array();
      break;
      }
    default:
      jj_la1[28] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  final public void EXPR_LIST() throws ParseException {
    label_13:
    while (true) {
      jj_consume_token(COMMA);
      Expression00();
      switch ((jj_ntk==-1)?jj_ntk_f():jj_ntk) {
      case COMMA:{
        ;
        break;
        }
      default:
        jj_la1[29] = jj_gen;
        break label_13;
      }
    }
  }

  private boolean jj_2_1(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla)
 {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_3_2()
 {
    if (jj_3R_15()) return true;
    if (jj_scan_token(CREMENT_OP)) return true;
    return false;
  }

  private boolean jj_3R_23()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(92)) {
    jj_scanpos = xsp;
    if (jj_scan_token(93)) {
    jj_scanpos = xsp;
    if (jj_scan_token(94)) {
    jj_scanpos = xsp;
    if (jj_scan_token(95)) {
    jj_scanpos = xsp;
    if (jj_scan_token(96)) {
    jj_scanpos = xsp;
    if (jj_3R_26()) return true;
    }
    }
    }
    }
    }
    return false;
  }

  private boolean jj_3R_35()
 {
    if (jj_3R_36()) return true;
    return false;
  }

  private boolean jj_3R_34()
 {
    Token xsp;
    if (jj_3R_35()) return true;
    while (true) {
      xsp = jj_scanpos;
      if (jj_3R_35()) { jj_scanpos = xsp; break; }
    }
    return false;
  }

  private boolean jj_3R_27()
 {
    if (jj_scan_token(LBRACKET)) return true;
    if (jj_3R_28()) return true;
    return false;
  }

  private boolean jj_3R_17()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_20()) {
    jj_scanpos = xsp;
    if (jj_3R_21()) return true;
    }
    return false;
  }

  private boolean jj_3R_20()
 {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_3R_23()) return true;
    return false;
  }

  private boolean jj_3R_33()
 {
    if (jj_3R_34()) return true;
    return false;
  }

  private boolean jj_3R_25()
 {
    if (jj_3R_15()) return true;
    return false;
  }

  private boolean jj_3R_15()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(77)) jj_scanpos = xsp;
    if (jj_3R_17()) return true;
    return false;
  }

  private boolean jj_3R_32()
 {
    if (jj_3R_33()) return true;
    return false;
  }

  private boolean jj_3R_31()
 {
    if (jj_3R_32()) return true;
    return false;
  }

  private boolean jj_3R_30()
 {
    if (jj_3R_31()) return true;
    return false;
  }

  private boolean jj_3R_19()
 {
    if (jj_3R_22()) return true;
    return false;
  }

  private boolean jj_3R_22()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_24()) {
    jj_scanpos = xsp;
    if (jj_3_2()) {
    jj_scanpos = xsp;
    if (jj_3R_25()) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_24()
 {
    if (jj_scan_token(CREMENT_OP)) return true;
    return false;
  }

  private boolean jj_3R_18()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(80)) {
    jj_scanpos = xsp;
    if (jj_scan_token(81)) {
    jj_scanpos = xsp;
    if (jj_scan_token(82)) return true;
    }
    }
    return false;
  }

  private boolean jj_3R_16()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_3R_18()) jj_scanpos = xsp;
    if (jj_3R_19()) return true;
    return false;
  }

  private boolean jj_3R_29()
 {
    if (jj_3R_30()) return true;
    return false;
  }

  private boolean jj_3R_26()
 {
    if (jj_3R_27()) return true;
    return false;
  }

  private boolean jj_3_1()
 {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(80)) {
    jj_scanpos = xsp;
    if (jj_scan_token(81)) return true;
    }
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_14()
 {
    if (jj_3R_16()) return true;
    return false;
  }

  private boolean jj_3R_21()
 {
    if (jj_3R_23()) return true;
    return false;
  }

  private boolean jj_3R_36()
 {
    if (jj_3R_14()) return true;
    return false;
  }

  private boolean jj_3R_28()
 {
    if (jj_3R_29()) return true;
    return false;
  }

  /** Generated Token Manager. */
  public AWKTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[30];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static private int[] jj_la1_2;
  static private int[] jj_la1_3;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
      jj_la1_init_2();
      jj_la1_init_3();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x0,0x0,0x8073840,0x0,0x0,0x8070000,0x8073840,0x3800,0x3840,0x80,0x0,0x30000,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x600,0x600,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,};
   }
   private static void jj_la1_init_2() {
      jj_la1_2 = new int[] {0xf0076810,0xf0076810,0x10000010,0x4,0x10000010,0x10000010,0x10000010,0x0,0x0,0x0,0xf0076810,0x0,0x4000000,0x2000000,0x1000000,0x800000,0x400000,0xf0076810,0x30000,0x380000,0x380000,0x70000,0x70000,0x8000,0x4000,0xf0002810,0x2000,0xf0000810,0xf0000010,0x80,};
   }
   private static void jj_la1_init_3() {
      jj_la1_3 = new int[] {0x1,0x1,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x1,0x0,0x1,0x1,0x0,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[2];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public AWK(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public AWK(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new AWKTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public AWK(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new AWKTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public AWK(AWKTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(AWKTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 30; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  @SuppressWarnings("serial")
  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk_f() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[97];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 30; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
          if ((jj_la1_2[i] & (1<<j)) != 0) {
            la1tokens[64+j] = true;
          }
          if ((jj_la1_3[i] & (1<<j)) != 0) {
            la1tokens[96+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 97; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}
