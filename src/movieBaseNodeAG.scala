class movieBaseNodeAG(i:Int, t:String, y:Int, g:Set[Int]){

  var sum: Int = 0
  var num: Int = 0

  def display(): Unit={
    print("Index is " + i + '\n')
    print("Title is " + t + '\n')
    print("Year is " + y + '\n')
    print("Genres are " + g + '\n')
  }

  def index():Int = i
  def genre():Set[Int] = g
  def avg(): Float = sum/num

  /*We are intending to use a wrapper for the movie and user bases to communicate.
  The movie base will hold the index, title, year, genre, and average rating after being calculated in our wrapper class.
  The user base will hold the user index, a tuple for each movie index and star rating, and then a collection of the users
  avg. rating for each genre, the preference factor for each genre, and finally the user's top 10 movie recommendations.
  The wrapper class will handle most of the calculations requiring both data structures but we have created data structures
  that allow easy access to all the data that we need.
   */
}