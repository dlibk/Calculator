package org.example.exception

enum ParseException(msg: String) extends IllegalArgumentException(msg):
  
  case UnmatchedException extends ParseException("Formula not completed")
  
  case CharNotKnownException(char: Char) 
    extends ParseException(s"I don't know this character: $char")
  
  case InvalidPositionException(msg: String) extends ParseException(msg)
