package org.example.expr

enum Expr:
  case Constant(n: Int)

  case Sum(e1: Expr, e2: Expr)

  case Product(e1: Expr, e2: Expr)

  def eval: Int = this match
    case Constant(n) => n
    case Sum(e1, e2) => e1.eval + e2.eval
    case Product(e1, e2) => e1.eval * e2.eval
  
  override def toString: String =
    def show(expr: Expr, parentheses: Boolean = false): String = expr match
      case Constant(n) => n.toString
      case Sum(e1, e2) =>
        val expr: String = show(e1) + " + " + show(e2)
        if parentheses then "(" + expr + ")" else expr
      case Product(e1, e2) => show(e1, true) + " * " + show(e2, true)
    show(this)
      

  override def equals(other: Any): Boolean = this match
    case null => false
    case Constant(n1) => other match
      case Constant(n2) => n1 == n2
      case _ => false
    case Sum(e1, e2) => other match
      case Sum(e3, e4) => e1.equals(e3) && e2.equals(e4)
      case _ => false
    case Product(e1, e2) => other match
      case Product(e3, e4) => e1.equals(e3) && e2.equals(e4)
      case _ => false
