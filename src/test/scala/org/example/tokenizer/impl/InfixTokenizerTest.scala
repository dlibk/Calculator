package org.example.tokenizer.impl

import org.scalatest.funsuite.AnyFunSuite

class InfixTokenizerTest extends AnyFunSuite:
  
  val tokenizer: InfixTokenizer = InfixTokenizer()
  
  test("1 + 1 to tokens") {
    val tokens = tokenizer.split("1 + 1".toList, Nil, Nil)
    println(tokens)
  }
  
  test("1 + 2 * 3 to tokens") {
    val tokens = tokenizer.split("1 + 2 * 3".toList, Nil, Nil)
    println(tokens)
  }
  
  test("4*(5+6) to tokens") {
    val tokens = tokenizer.split("4*(5+6)+9".toList, Nil, Nil)
    println(tokens)
  }
