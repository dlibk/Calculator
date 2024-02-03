package org.example.expr

import org.example.expr.Expr.*
import org.scalatest.funsuite.AnyFunSuite

class ExprTest extends AnyFunSuite:
  
  test("1") {
    val one: Expr = Constant(1)
    assert(one.eval == 1)
  }
  
  test("1 + 1") {
    val expr: Expr = Sum(Constant(1), Constant(1))
    assert(expr.eval == 2)
  }
  
  test("4 * 3") {
    val expr: Expr = Product(Constant(4), Constant(3))
    assert(expr.eval == 12)
  }
  
  test("4 + 8 * 3") {
    val expr: Expr = Sum(Constant(4), Product(Constant(8), Constant(3)))
    assert(expr.eval == 28)
  }
  
  test("show 1 + 1") {
    val expr = Sum(Constant(1), Constant(1))
    assert(expr.toString == "1 + 1")
  }
  
  test("show 3 * 9") {
    val expr = Product(Constant(3), Constant(9))
    assert(expr.toString == "3 * 9")
  }
  
  test("show (3 + 7) * 10 * 7") {
    val expr = Product(Sum(Constant(3), Constant(7)), Product(Constant(10), Constant(7)))
    assert(expr.toString == "(3 + 7) * 10 * 7")
  }
