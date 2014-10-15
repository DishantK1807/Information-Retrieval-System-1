package com.tonybeltramelli.desktop.util

import com.github.aztek.porterstemmer.PorterStemmer

class Helper {
}

object Helper {
  val ROOT_PATH = "data/tipster/"
  val ZIP_PATH = ROOT_PATH + "/zips"
  val QRELS_PATH = ROOT_PATH + "/qrels"
  val TOPIC_PATH = ROOT_PATH + "/topics"
  val RESULT_NUMBER = 100

  val isDebugMode: Boolean = false
  
  private var _i = 0
  private var _time : Long = System.nanoTime()

  def debug(s: Any) {
    if (!isDebugMode) return
    println(s)
  }
  
  def time {
    println("time "+_i+" : " + (System.nanoTime() - _time) / 1000000000.0 + " seconds")
    _i += 1
  }
  
  def ordering(row: (String, Double)) = row._2
	
  def log2(x: Double) = Math.log10(x) / Math.log10(2.0)
}