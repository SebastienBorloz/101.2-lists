class Node(inItem: String, inNext:Node = null){
    var item: String = inItem.toLowerCase().capitalize
    var next: Node = inNext

    override def toString(): String ={
        return s"La node est a ${item}${if(next != null) {s" et va a ${next.item}"} else {""}}."
    }
}

object Node extends App{
    val MilanNode: Node = new Node("Milan")
    val ParisNode: Node = new Node("Paris", MilanNode)
    val TokyoNode: Node = new Node("Tokyo", ParisNode)
    val testNode = ParisNode
}