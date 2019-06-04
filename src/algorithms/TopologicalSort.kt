class TopoGraph(var s: String, edges: List<Pair<Int, Int>>) {
  var vertices = s.split(", ")
  var numVertices = vertices.size
  val adjacency = List(numVertices) { BooleanArray(numVertices)}
  init {
  
  }
}
