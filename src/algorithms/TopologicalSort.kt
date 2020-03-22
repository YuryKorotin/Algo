class TopoGraph(var s: String, edges: List<Pair<Int, Int>>) {
  var vertices = s.split(", ")
  var numVertices = vertices.size
  val adjacency = List(numVertices) { BooleanArray(numVertices)}
  init {
    for (edge in edges) {
      adjacency[edge.first][edge.second] = true
    } 
  }

  fun hasDependency(r: Int, todo: List<Int>): Boolean {
    for(c in todo) {
      if (adjacency[r][c]) {
        return true
      }
    }
    return false
  }

  fun topoSort(): List<String>? {
    val result = mutableListOf<String>()
    val todo = MutableList<Int>(numVertices) {it}
    try {
      outer@ while(!todo.isEmpty()) {
        for((i, r) in todo.withIndex()) {
	  if () {
	    todo.removeAt(i)
	    result.add(vertices[r])
	    continue@outer 
	  }
        }
	throw Exception("Graph has cycles")
      }
    } catch () {
      println(e)
    }
    return result
  }
}
