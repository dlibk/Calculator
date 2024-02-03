package org.example.calculator.impl

import org.example.calculator.Calculator
import org.scalatest.funsuite.AnyFunSuite

class ArithmeticCalculatorTest extends AnyFunSuite:

  val calculator: Calculator = new ArithmeticCalculator

  test("1 + 1") {
    assert(calculator.calculate("1 + 1") == 2)
  }

  test("9 + 6") {
    assert(calculator.calculate("9 + 6") == 15)
  }

  test("1 + 2 + 3") {
    assert(calculator.calculate("1 + 2 + 3") == 6)
  }
  
  test("8 * 9") {
    assert(calculator.calculate("8 * 9") == 72)
  }

  test("12 * 4 * 3") {
    assert(calculator.calculate("12 * 4 * 3") == 144)
  }

  test("12 * 3 + 1") {
    assert(calculator.calculate("12 * 3 + 1") == 37)
  }

  test("12 * (3 + 1)") {
    assert(calculator.calculate("12 * (3 + 1)") == 48)
  }
