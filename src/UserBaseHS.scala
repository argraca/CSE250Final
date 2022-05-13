import io.StdIn._
import io.Source
import java.io.File
import java.io.FileWriter
import java.io.PrintWriter  //makes "print" and "println" available

object UserBase extends App{
  val inputFile = if (args.length >= 1) args(0) else "u.data"
  /*val dict = Source.fromFile(inputFile).getLines()



  var movieIDList:List[Int] = List()  //
  var ratingMap: Map[Int,Double] = Map()  //

  // total number of ratings
  // total sum of ratings
  // average movie rating = sum / num


  var dictArray:Array[String] = Array()

  for(line <- dict){
    dictArray = dictArray :+ line
  }

  for(line <- dictArray){
    print(line)
    var line2 = line.split("\\s+")
    var movie = line2(1)
    //var rating = line2(2)
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
      //println("Movie ID is " + mov + " with average rating of " + averageRating)
      }

  }


// for every element (ID) in the movieList, check the list for its ratings


  // data structure[user]
  // class Movie(...){
//}

  // Do r sub m = average rating by users who rated that rating
  // We have rating and #ratings
  // have u.data, he has u.item
  // Do = U sub g = average genere ratings*/


  def userBaseMaker(input: String): AIOLI[userNodeHS]={

    val dict = Source.fromFile(input)
    val lines = dict.getLines
    val rslt: AIOLI[userNodeHS] = new AIOLI[userNodeHS](compare)

    var user: Int = 1

    while(user < 944){
      rslt.insert(new userNodeHS(user))
      user += 1
    }

    for(line<-lines) {
      val split = line.split("\\s+")
      //print(split(0)+ '\n')
      val user: Int = split(0).toInt
      val movieIndex: Int = split(1).toInt
      val rating: Int = split(2).toInt
      val tup = (movieIndex, rating)
      val target = rslt.find(new userNodeHS(user))
      target.next().ratings +:= tup
    }
    rslt
  }

  def compare(a:userNodeHS, b:userNodeHS):Int = a.user().compare(b.user())

  /*val test = userBaseMaker(inputFile)
  val itr = test.find(new userNodeHS(13))
  print(itr.next().ratings(0))
  print(test.size)*/





}

object MovieBase{
  //data structure[Movie]
}