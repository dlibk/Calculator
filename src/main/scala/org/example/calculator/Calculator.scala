package org.example.calculator

import jdk.internal.opt.CommandLine.Tokenizer

trait Calculator:
    
    def calculate(formula: String): Int
