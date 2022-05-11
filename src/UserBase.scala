import io.StdIn._
import io.Source
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter  //makes "print" and "println" available

object UserBase extends App{
  val inputFile = if (args.length >= 1) args(0) else "u.data2.txt"
  val dict = Source.fromFile(inputFile).getLines()


  var movieIDList:List[Int] = List()
  var ratingMap: Map[Int,Double] = Map()

  // total number of ratings
  // total sum of ratings
  // average movie rating = sum / num


  var dictArray:Array[String] = Array()

  for(line <- dict){
    dictArray = dictArray :+ line
  }

  for(line <- dictArray){

    var line2 = line.split("\\s+")
    var movie = line2(1)
    var rating = line2(2)
    if(!movieIDList.contains(movie)){
      movieIDList = movieIDList :+ movie.toInt
    }

   // println("Movie ID is " + movie + " with rating of " + rating)
//    for(l <- line2) {
//      println(l)
//    }
  }

//  for(s<-movieIDList){
//    println(s)
//  }

  var completedMovieID:List[Int] = List() // this so a Movie and it's rating is only listed once


  for(mov <- movieIDList){

    var sum = 0.0
    var numberOfRatings = 0
    var averageRating = 0.0

    for(line<-dictArray){
      var line2 = line.split("\\s+")
      var movie = line2(1).toInt
      var rating = line2(2).toDouble
      if(movie == mov){
        sum = sum + rating
        numberOfRatings = numberOfRatings + 1
      }
    }
    averageRating = sum / numberOfRatings
    if(!completedMovieID.contains(mov)){
      completedMovieID = completedMovieID :+ mov
      ratingMap = ratingMap + (mov -> averageRating)
      println("Movie ID is " + mov + " with average rating of " + averageRating)
      }

  }


// for every element (ID) in the movieList, check the list for its ratings


  // data structure[user]
  // class Movie(...){
//}

  // Do r sub m = average rating by users who rated that rating
  // We have rating and #ratings
  // have u.data, he has u.item
  // Do = U sub g = average genere ratings






}

object MovieBase{
  //data structure[Movie]
}