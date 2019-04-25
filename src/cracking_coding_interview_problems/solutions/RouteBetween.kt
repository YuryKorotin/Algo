class RouteBetween: Solution {
    fun search(g: Graph, start: GraphNode, end: GraphNode): Boolean {
        if (start === end) {
            return true
        }

        var queue: MutableList<GraphNode> = mutableListOf()

        g.nodes.forEach{ item ->
            item.state = NodeState.UNVISITED
        }

        start.state = NodeState.VISITED

        queue.add(start)

        var current: GraphNode? = null

        while (!queue.isEmpty()) {
            current = queue[0]

            queue.removeAt(0)

            if (current != null) {
                current!!.adjacents.forEach{ v ->
                    if (v.state == NodeState.UNVISITED) {
                        if (v == end) {
                            return true
                        } else {
                            v.state = NodeState.VISITING
                            queue.add(v)
                        }
                    }
                }
                current!!.state = NodeState.VISITED
            }
        }
        return false
    }
}

class Graph(var nodes: List<GraphNode>)

class GraphNode(var state: NodeState, var adjacents: List<GraphNode>)

enum class NodeState {
    UNVISITED, VISITED, VISITING
}