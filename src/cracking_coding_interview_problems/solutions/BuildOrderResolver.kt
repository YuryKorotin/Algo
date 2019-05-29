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
        return BuildGraph()
    }
}

class BuildGraph {
    var nodes: List<Project> = listOf()
}

class Project() {
    val children: List<Project> = listOf()
    var state: ProjectState = ProjectState.BLANK
}

enum class ProjectState {
    COMPLETE, PARTIAL, BLANK
}