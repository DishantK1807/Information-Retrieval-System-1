package com.tonybeltramelli.desktop.core.scoring

import com.tonybeltramelli.desktop.util.Helper

class LanguageBasedScoring extends AScoring
{  
	override def getScore(f: (Map[String, Double], Double), query: List[String]) : Double =
	{
	  val lambda : Double = 0.1 //0.1 for title queries and 0.7 for long queries, Jelinek-Mercer smoothing method 
	  //"A Study of Smoothing Methods for Language Models Applied to Information Retrieval"
	  //Chengxiang Zhai and John Lafferty, 2001

	  val qtfs = query.flatMap(q => f._1.get(q))
	  val qcfs = query.flatMap(q => _cfs.get(q))
	  
	  ((1 - lambda) * (qtfs.sum / f._2)) + (lambda * (qcfs.sum / _cfsSum))
    }
}