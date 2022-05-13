object main extends App{

  val movieBase: AIOLI[movieBaseNodeAG]  = movieMakerAG.processor("u.item")

  def dummyMovieEntry(index: Int): movieBaseNodeAG = new movieBaseNodeAG(index, "", 0, Set())
  val userBase: AIOLI[userNodeHS] = UserBase.userBaseMaker("u.data")

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


  def avg(userBase: AIOLI[userNodeHS]): Unit={
    val useritr = userBase.begin
    while(useritr.hasNext){
      val user:userNodeHS = useritr.next()
      for((movieIndex, review) <- user.ratings){
        val movieItr = movieBase.find(dummyMovieEntry(movieIndex))
        var movie = dummyMovieEntry(1)
        if(movieItr.hasNext) {
          movie = movieItr.next()
        }
        movie.sum += review
        movie.num += 1
        if(movie.genre()(action)){
          actionSum += review
          actionNum += 1
          user.uactionSum += review
          user.uactionNum += 1
        }
        if(movie.genre()(noir)){
          noirSum += review
          noirNum += 1
          user.unoirSum += review
          user.unoirNum += 1
        }
        if(movie.genre()(light)){
          lightSum += review
          lightNum += 1
          user.ulightSum += review
          user.ulightNum += 1
        }
        if(movie.genre()(serious)){
          seriousSum += review
          seriousNum += 1
          user.useriousSum += review
          user.useriousNum += 1
        }
        if(movie.genre()(fantasy)){
          fantasySum += review
          fantasyNum += 1
          user.ufantasySum += review
          user.ufantasyNum += 1
        }
        if(movie.genre()(history)){
          historySum += review
          historyNum += 1
          user.uhistorySum += review
          user.uhistoryNum += 1
        }
      }
      preferenceFactor(user)
      top(user)
    }
  }

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

  def preferenceFactor(input: userNodeHS): Unit ={
      for(i <- action to history){
        if(input.genreCheck(i)){
          input.preferenceFactor(i) = 0
        }else{
          val pref = input.genreAvg(i)/genreAvg(i)
          input.preferenceFactor(i) = pref
        }
      }
  }
  def top(input: userNodeHS): Unit ={
    val movieItr = movieBase.begin
    while(movieItr.hasNext){
      val movie = movieItr.next()
      var highest: Float = 0
      if(movie.genre()(action)){
        if(movie.avg() * input.preferenceFactor(action) > highest){
          highest = movie.avg() * input.preferenceFactor(action)
        }
      }
      if(movie.genre()(noir)){
        if(movie.avg() * input.preferenceFactor(noir) > highest){
          highest = movie.avg() * input.preferenceFactor(noir)
        }
      }
      if(movie.genre()(light)){
        if(movie.avg() * input.preferenceFactor(light) > highest){
          highest = movie.avg() * input.preferenceFactor(light)
        }
      }
      if(movie.genre()(serious)){
        if(movie.avg() * input.preferenceFactor(serious) > highest){
          highest = movie.avg() * input.preferenceFactor(serious)
        }
      }
      if(movie.genre()(fantasy)){
        if(movie.avg() * input.preferenceFactor(fantasy) > highest){
          highest = movie.avg() * input.preferenceFactor(fantasy)
        }
      }
      if(movie.genre()(history)){
        if(movie.avg() * input.preferenceFactor(history) > highest){
          highest = movie.avg() * input.preferenceFactor(history)
        }
      }
      input.top.insert(highest)
    }
  }
  /*def out(user: userNodeHS): Unit={
    var topList: String =
    for(i <- 0 to 9){

    }
  }*/

  avg(userBase) //average of each individual movie, individual genres, and users personal avg for each genre
  val test = userBase.begin
  val start = test.next()
  //print(start.ufantasyNum)
  //preferenceFactor(userBase)




}
