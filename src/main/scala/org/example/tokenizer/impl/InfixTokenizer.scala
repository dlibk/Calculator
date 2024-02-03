package org.example.tokenizer.impl

import org.example.exception.ParseException.CharNotKnownException
import org.example.expr.Expr
import org.example.tokenizer.Tokenizer

class InfixTokenizer extends Tokenizer:

  def split(chars: List[Char], tokenBuilder: List[Char], acc: List[String]): List[String] =
    chars match
      case Nil => (acc :+ tokenBuilder.mkString).filter(!_.isBlank)
      case c :: cs => c match
        case _ if c.isWhitespace => split(cs, tokenBuilder, acc)
        case _ if c.isDigit => split(cs, tokenBuilder :+ c, acc)
        case '+' | '*' | '(' | ')' => split(cs, Nil, acc :+ tokenBuilder.mkString :+ c.toString)
        case _ => throw CharNotKnownException(c)

  type Token = Any  // String, Symbol or List[Token], List[List[Token]], etc
  def parse(strings: List[String]): Token = ???

  override def tokenize(formula: String): Expr = null
