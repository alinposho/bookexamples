#!/bin/sh
exec scala "$0" "$@"
!#

import scala.io.Source
import scalax.io.Output

def writeToFile(p: String, s: String) {
    val pw = new java.io.PrintWriter(new File(p))
    try {
      pw.write(s)
    } finally {
      pw.close()
    }
  }

println("This script will convert playlists from Microsoft format into Unix")

val lines = Source.fromFile(args(0))

for(line <- lines) {
  
}