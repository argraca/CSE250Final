import main.{action, actionNum, actionSum, fantasy, fantasyNum, fantasySum, light, lightNum, lightSum, noir, noirNum, noirSum, serious, seriousNum, seriousSum}

class userNodeHS(user: Int){

  //var fresh: Boolean = true
  var ratings: Array[(Int, Int)] = Array()

  var preferenceFactor: Array[Float] = new Array[Float](7)
  var top: SortedSLL[Float] = new SortedSLL[Float](compare)

  def compare(a:Float, b:Float):Int = b.compare(a)

  val action = 1
  var uactionSum = 0
  var uactionNum = 0

  val noir = 2
  var unoirSum = 0
  var unoirNum = 0

  val light = 3
  var ulightSum = 0
  var ulightNum = 0

  val serious = 4
  var useriousSum = 0
  var useriousNum = 0

  val fantasy = 5
  var ufantasySum = 0
  var ufantasyNum = 0

  val history = 6
  var uhistorySum = 0
  var uhistoryNum = 0

  def user(): Int = user

  def genreAvg(genre: Int): Float={
    var rslt: Float = 0
    if(genre == action){
      rslt = uactionSum/uactionNum
    }
    if(genre == noir){
      rslt = unoirSum/unoirNum
    }
    if(genre == light){
      rslt = ulightSum/ulightNum
    }
    if(genre == serious){
      rslt = useriousSum/useriousNum
    }
    if(genre == fantasy){
      rslt = ufantasySum/ufantasyNum
    }
    if(genre == history){
      rslt = uhistorySum/uhistoryNum
    }
    rslt
  }
  def genreCheck(genre: Int): Boolean={
    var rslt = false
    if(genre == action){
      if(uactionNum == 0){
        rslt = true
      }
    }
    if(genre == noir){
      if(unoirNum == 0){
        rslt = true
      }
    }
    if(genre == light){
      if(ulightNum == 0){
        rslt = true
      }
    }
    if(genre == serious){
      if(useriousNum == 0){
        rslt = true
      }
    }
    if(genre == fantasy){
      if(ufantasyNum == 0){
        rslt = true
      }
    }
    if(genre == history){
      if(uhistoryNum == 0){
        rslt = true
      }
    }
    rslt
  }
}
