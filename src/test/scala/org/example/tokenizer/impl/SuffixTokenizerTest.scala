package org.example.tokenizer.impl

import org.scalatest.funsuite.AnyFunSuite
import org.example.expr.Expr
import org.example.expr.Expr.*
import org.example.tokenizer.Tokenizer
import org.example.exception.ParseException

class SuffixTokenizerTest extends AnyFunSuite:

  val tokenizer: Tokenizer = SuffixTokenizer()

  test("1 1 +") {
    val expr: Expr = Sum(Constant(1), Constant(1))
    assert(expr.equals(tokenizer.tokenize("1 1 +")))
  }

  test("1 2 + 6 *") {
    val expr: Expr = Product(Sum(Constant(1), Constant(2)), Constant(6))
    assert(expr.equals(tokenizer.tokenize("1 2 + 6 *")))
  }

  test("100") {
    val expr: Expr = Constant(100)
    assert(expr.equals(tokenizer.tokenize("100")))
  }

  test("12 9 * 10 + 9 *") {
    val expr: Expr = Product(Sum(Product(Constant(12), Constant(9)), Constant(10)), Constant(9))
    assert(expr.equals(tokenizer.tokenize("12 9 * 10 + 9 *")))
  }

  test("Empty formula") {
    intercept[ParseException] {
      tokenizer.tokenize("")
    }
  }
