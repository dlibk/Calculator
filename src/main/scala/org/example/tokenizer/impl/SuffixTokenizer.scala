package org.example.tokenizer.impl

import org.example.expr.Expr
import org.example.tokenizer.Tokenizer
import org.example.exception.ParseException.*
import org.example.expr.Expr.*

class SuffixTokenizer extends Tokenizer:
  override def tokenize(formula: String): Expr =
    def tokenize(tokens: List[String]): Expr = tokens match
      case Nil | "" :: Nil => throw UnmatchedException
      case x :: Nil => Constant(Integer.parseInt(x))
      case xs :+ n2 :+ operator => operator match
        case "+" => Sum(tokenize(xs), Constant(Integer.parseInt(n2)))
        case "*" => Product(tokenize(xs), Constant(Integer.parseInt(n2)))
        case x => throw CharNotKnownException(x.charAt(0))
      case _ => throw UnmatchedException
    tokenize(formula.split(Array(' ', '\n', '\t')).toList)
