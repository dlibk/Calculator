package org.example.calculator

import org.example.calculator.impl.TrivialCalculator
import org.scalatest.funsuite.AnyFunSuite

class CalculatorTest extends AnyFunSuite:

  test("trivial") {
    assert(TrivialCalculator.calculate("0 + 0") == 0)
  }

  test("also trivial") {
    assert(TrivialCalculator.calculate("1 + 1") == 0)
  }
