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
          user.actionSum += review
          user.actionNum += 1
        }
        if(movie.genre()(noir)){
          noirSum += review
          noirNum += 1
          user.noirSum += review
          user.noirNum += 1
        }
        if(movie.genre()(light)){
          lightSum += review
          lightNum += 1
          user.lightSum += review
          user.lightNum += 1
        }
        if(movie.genre()(serious)){
          seriousSum += review
          seriousNum += 1
          user.seriousSum += review
          user.seriousNum += 1
        }
        if(movie.genre()(fantasy)){
          fantasySum += review
          fantasyNum += 1
          user.fantasySum += review
          user.fantasyNum += 1
        }
      }
    }


  }

  avg(userBase)  //average of each individual movie, individual genres, and users personal avg for each genre


}
