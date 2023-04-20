class LinkedList() {
    var head: Node = null

    def addToStart(s: String): Unit ={
        head = new Node(s, head)
    }

    def getSize(): Int ={
        var headCopy: Node = head
        var index: Int = 0

        while (headCopy != null) {
            index += 1
            headCopy = headCopy.next
        }

        return index
    }

    override def toString(): String ={
        var out: String = s"List content (size ${getSize()}) : "
        var headCopy: Node = head

        while (headCopy != null) {
            out += s"${headCopy.item} -> "
            headCopy = headCopy.next
        }

        return out + "\b\b\b"
    }

    def removeFirstElement(): Unit ={
        if(head != null){head = head.next}
    }

    def getLastElement(done: Node = head): Node ={
        if(done != null) {
            if (done.next != null) {
                return getLastElement(done.next)
            } else {
                return done
            }
        }else{
            return done
        }
    }

    def addToEnd(element: String): Unit ={
        if(head == null){
            head = new Node(element, head)
        }else {
            getLastElement(head).next = new Node(element)
        }
    }

    def isPresent(e:String, done: Node = head): Boolean ={
        try {
            if (done.item == e) {
                return true
            } else {
                return isPresent(e, done.next)
            }
        } catch{
            case _ => return false
        }
    }

    def findElement(s: String, done: Node = head): Node ={
        if(!isPresent(s)){return null}

        if(done.item == s){
            return done
        }else{
            return findElement(s, done.next)
        }
    }

    def swapElements(e1: String, e2: String): Unit ={
        if(!isPresent(e1, head) || !isPresent(e2, head)){return}

        val spotun = findElement(e1, head)
        val spodeux = findElement(e2, head)
        spotun.item = e2
        spodeux.item = e1
    }

    def removeLastElement(done: Node = head): Unit ={
        if(done == null){return}
        if(done.next == null){
            head = null
            return
        }

        if(done.next.next == null){
            done.next = null
        }else{
            removeLastElement(done.next)
        }
    }

    def removeElement(e: String, done: Node = head): Unit ={
        if(!isPresent(e)){return}

        if(done.item == e){
            head = head.next
        }else {
            if (done.next.item == e) {
                done.next = done.next.next
            } else {
                removeElement(e, done.next)
            }
        }
    }

    def insertAfter(before: String, after: String, done: Node = head): Unit ={ //insere after apres before
        if(!isPresent(before)){return}

        if(done.item == before){
            done.next = new Node(after, done.next)
        }else{
            insertAfter(before,after,done.next)
        }
    }
}

object LinkedList extends App {
    var flightList:LinkedList = new LinkedList()
    println(flightList.toString())
    flightList.addToStart("Rome")
    println(flightList.toString())
    flightList.addToStart("Paris")
    println(flightList.toString())
    flightList.addToStart("Tokyo")
    println(flightList.toString())

    println(flightList.head.toString())
    println(flightList.getLastElement().toString())
    flightList.addToEnd("Constantinople")
    println(flightList.toString())

    println(flightList.isPresent("Paris"))
    println(flightList.isPresent("Antioche"))

    flightList.swapElements("Constantinople","Paris")
    println(flightList.toString())

    flightList.removeLastElement()
    println(flightList.toString())

    flightList.addToStart("Paris")
    println(flightList.toString())
    flightList.removeElement("Tokyo")
    println(flightList.toString())
    flightList.removeElement("Paris")
    println(flightList.toString())

    flightList.insertAfter("Constantinople", "Alexandrie")
    println(flightList.toString())
    flightList.insertAfter("Rome", "Jerusalem")
    println(flightList.toString())
}
