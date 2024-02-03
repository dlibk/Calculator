package org.example.tokenizer

import org.example.expr.Expr
import scala.util.matching.Regex

trait Tokenizer:
  
  def tokenize(formula: String): Expr
