class BuildOrderResolver: Solution {
    fun findBuildOrder(projects: List<String>, dependencies: List<List<String>>) : Stack<Project> {
        val graph: BuildGraph = buildGraph(projects, dependencies)

        return orderProjects(graph.nodes)!!
    }

    fun orderProjects(projects: List<Project>): Stack<Project>? {
        val stack = Stack<Project>()

        for(i in 0 until projects.size) {
            if (projects[i].state == ProjectState.BLANK) {
                if (!doDFS(projects[i], stack)) {
                    return null
                }
            }
        }
        return stack
    }

    fun doDFS(project: Project, stack: Stack<Project>) : Boolean {
        if (project.state == ProjectState.PARTIAL) {
            return false
        }

        if (project.state == ProjectState.BLANK) {
            project.state = ProjectState.PARTIAL

            val children: List<Project> = project.children

            for(i in 0 until children.size) {
                if (!doDFS(children[i], stack)) {
                    return false
                }
            }

            project.state = ProjectState.COMPLETE

            stack.push(project)
        }
        return true
    }

    fun buildGraph(projects: List<String>, dependencies: List<List<String>>) : BuildGraph {
        val graph = BuildGraph()

        projects.forEach { project ->
            graph.getOrCreateNode(project)
        }

        dependencies.forEach { dependency ->
            val first = dependency[0]
            val second = dependency[1]
            graph.addAge(first, second)
        }

        return graph
    }
}

class BuildGraph {
    var nodes: MutableList<Project> = mutableListOf()
    var map: MutableMap<String, Project> = mutableMapOf<String, Project>()

    fun getOrCreateNode(name: String) : Project {
        if (!map.containsKey(name)) {
            val node: Project = Project(name)
            nodes.add(node)
            map.put(name, node)
        }

        return map.get(name)!!
    }

    fun addAge(startName: String, endName: String) {
        val start = getOrCreateNode(startName)
        val end = getOrCreateNode(endName)

        start.addNeighbor(end)
    }
}

class Project(open val name: String) {
    val children: MutableList<Project> = mutableListOf()
    var state: ProjectState = ProjectState.BLANK
    val map: MutableMap<String, Project> = mutableMapOf()

    var dependencies = 0

    fun incrementDependencies() {
        dependencies++
    }

    fun decrementDependencies() {
        dependencies--
    }

    fun addNeighbor(node: Project) {
        if (!map.containsKey(node.name)) {
            children.add(node)
            map.put(node.name, node)
            node.incrementDependencies()
        }
    }
}

enum class ProjectState {
    COMPLETE, PARTIAL, BLANK
}