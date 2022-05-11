
object movieMakerAG extends App{

  def parser(input: Array[String]): movieBaseNodeAG={  //creates individual nodes

    val index: Int = input(0).toInt
    var title: String = ""
    var finished: Boolean = false

    for(c <- input(1)){
      if(finished){}
      else if(c == '('){
        finished = true
        title = title.substring(0, title.length-1)
      }else{
        title += c
      }
    }

    val year: Int = yearGen(input(2))

    var pregenre: Set[Int] = Set()  //set of sub-genres
    var count: Int = 0

    while(count < 19){
      if(input(count + 5).toInt == 1){
        pregenre += count
      }
      count += 1
    }
    val genre: Set[Int] = compressor(pregenre)  //set of umbrella genres

    val rslt: movieBaseNodeAG = new movieBaseNodeAG(index, title, year, genre)
    rslt
  }

  def compressor(input: Set[Int]): Set[Int]={
    var rslt: Set[Int] = Set()
    if(input(0)){  //unknown
      rslt += 0
    }
    if(input(1)||input(2)||input(16)||input(18)){  //Action
      rslt += 1
    }
    if(input(6)||input(10)||input(11)||input(13)){  //Noir
      rslt += 2
    }
    if(input(3)||input(4)||input(5)||input(12)){  //Light
      rslt += 3
    }
    if(input(8)||input(14)){  //Serious
      rslt += 4
    }
    if(input(15)||input(9)){  //Fantasy
      rslt += 5
    }
    if(input(17)||input(7)){  //History
      rslt += 6
    }
    rslt
  }

  def yearGen(input: String): Int={
    val saver: Array[String] = input.split('-')
    val rslt = saver(2).toInt
    rslt
  }

  def processor(input:String): AIOLI[movieBaseNodeAG]={

    val source = io.Source.fromFile(input, "windows-1250")
    val lines = source.getLines
    val rslt: AIOLI[movieBaseNodeAG] = new AIOLI[movieBaseNodeAG](compare)

    for(line <- lines){
      val words = line.split('|')
      if(words(0).toInt == 267 || words.length <18){}
      else{
        val newNode = parser(words)
        rslt.insert(newNode)
      }
    }
    rslt
  }

  def compare(a:movieBaseNodeAG, b:movieBaseNodeAG):Int = a.index().compare(b.index())

  val inputFile = "u.item"

  val out: AIOLI[movieBaseNodeAG] = processor(inputFile)

  print(out.size)

}
