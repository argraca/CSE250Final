import main.{action, actionNum, actionSum, fantasy, fantasyNum, fantasySum, light, lightNum, lightSum, noir, noirNum, noirSum, serious, seriousNum, seriousSum}

class userNodeHS(user: Int){

  var fresh: Boolean = true
  var ratings: Array[(Int, Int)] = Array()

  var preferenceFactor: Map[Int, Int] = Map()

  val action = 1
  var actionSum = 0
  var actionNum = 0

  val noir = 2
  var noirSum = 0
  var noirNum = 0

  val light = 3
  var lightSum = 0
  var lightNum = 0

  val serious = 4
  var seriousSum = 0
  var seriousNum = 0

  val fantasy = 5
  var fantasySum = 0
  var fantasyNum = 0

  val history = 6
  var historySum = 0
  var historyNum = 0

  def user(): Int = user

  def genreAvg(genre: Int): Float={
    var rslt: Float = 0
    if(genre == action){
      rslt = actionSum/actionNum
    }
    if(genre == noir){
      rslt = noirSum/noirNum
    }
    if(genre == light){
      rslt = lightSum/lightNum
    }
    if(genre == serious){
      rslt = seriousSum/seriousNum
    }
    if(genre == fantasy){
      rslt = fantasySum/fantasyNum
    }
    if(genre == history){
      rslt = historySum/historyNum
    }
    rslt
  }

}
