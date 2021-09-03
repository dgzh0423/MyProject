package Data_Structure;
import java.util.*;
/**
 * @author 15304
 */

public class GraphMain {
    public static void main(String[] args){
        Graph graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addEdge("A", "B");
        graph.addEdge("B", "D");
        graph.addEdge("D", "C");
        graph.addEdge("A", "C");
        graph.print();
        System.out.println(graph.hasCycle());
        graph.traverseDepthFirst("A");
        System.out.println();
        graph.traverseDepthFirstIteration("A");
        System.out.println();
        graph.traverseBreadthFirst("A");
        System.out.println();

        Graph graph1 = new Graph();
        graph1.addNode("X");
        graph1.addNode("B");
        graph1.addNode("C");
        graph1.addNode("P");
        graph1.addEdge("X", "B");
        graph1.addEdge("X", "C");
        graph1.addEdge("B", "P");
        graph1.addEdge("C", "P");
        System.out.println(graph1.topologicalSort());
    }

    public static class Graph{
        private static class Node{
            private String label;

            public Node(String label) {
                this.label = label;
            }

            @Override
            public String toString() {
                return label;
            }
        }

        private Map<String, Node> nodes = new HashMap<>(); // nodes : label, Node
        private Map<Node, List<Node>> adjacentList = new HashMap<>(); // adjacentList : Node,  List<connected to this Node>

        public void addNode(String label){
            var node = new Node(label);
            nodes.putIfAbsent(label, node);
            adjacentList.putIfAbsent(node, new ArrayList<>());
        }

        public void addEdge(String from, String to){
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);
            if (fromNode == null || toNode == null){
                throw new IllegalStateException();
            }
            adjacentList.get(fromNode).add(toNode);
        }

        public void print(){
            for (var source : adjacentList.keySet()){
                var targets = adjacentList.get(source);
                if (!targets.isEmpty()){
                    System.out.println(source + " is connected to " + targets);
                }
            }
        }

        public void removeNode(String label){
            var node = nodes.get(label);
            if (node == null){
                return;
            }

            for (var n: adjacentList.keySet()){
                adjacentList.get(n).remove(node);
            }
            adjacentList.remove(node);
            nodes.remove(node);
        }

        public void removeEdge(String from, String to){
            var fromNode = nodes.get(from);
            var toNode = nodes.get(to);
            if (fromNode == null || toNode == null){
                return;
            }
            adjacentList.get(fromNode).remove(toNode);
        }

        // recursive
        public void traverseDepthFirst(String root){
            var node = nodes.get(root);
            if (node == null){
                return;
            }
            traverseDepthFirst(node, new HashSet<>());
        }
        private void traverseDepthFirst(Node root, Set<Node> visited){
            System.out.println(root);
            visited.add(root);

            for (var neighbor : adjacentList.get(root)){
                if (!visited.contains(neighbor)){
                    traverseDepthFirst(neighbor, visited);
                }
            }
        }

        // iterate
        public void traverseDepthFirstIteration(String root){
            var node = nodes.get(root);
            if (node == null){
                return;
            }

            Set<Node> visited = new HashSet<>();
            Stack<Node> stack = new Stack<>();
            stack.push(node);

            while(!stack.isEmpty()){
                var current = stack.pop();
                if (visited.contains(current)){
                    continue;
                }

                System.out.println(current);
                visited.add(current);

                for (var neighbor: adjacentList.get(current)){
                    if (!visited.contains(neighbor)){
                        stack.push(neighbor);
                    }
                }
            }
        }

        public void traverseBreadthFirst(String root){
            var node = nodes.get(root);
            if (node == null){
                return;
            }

            Set<Node> visited = new HashSet<>();
            Queue<Node> queue = new ArrayDeque<>();
            queue.add(node);

            while(!queue.isEmpty()){
                var current = queue.remove();
                if (visited.contains(current)){
                    continue;
                }
                System.out.println(current);
                visited.add(current);
                for (var neighbor : adjacentList.get(current)){
                    if (!visited.contains(neighbor)){
                        queue.add(neighbor);
                    }
                }
            }
        }

        // 拓扑排序解决有向无环图的线性排序问题
        public List<String> topologicalSort(){
            Set<Node> visited = new HashSet<>();
            Stack<Node> stack = new Stack<>();
            for (var node : nodes.values()){
                topologicalSort(node,visited,stack);
            }
            List<String> sorted = new ArrayList<>();
            while(!stack.isEmpty()){
                sorted.add(stack.pop().label);
            }
            return sorted;
        }
        private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack){
            if (visited.contains(node)){
                return;
            }
            visited.add(node);

            for (var neighbor: adjacentList.get(node)){
                topologicalSort(neighbor,visited,stack);
            }
            stack.push(node);
        }

        public boolean hasCycle(){
            Set<Node> all = new HashSet<>(nodes.values());
            Set<Node> visiting = new HashSet<>();
            Set<Node> visited = new HashSet<>();

            while(!all.isEmpty()){
                var current = all.iterator().next();
                if (hasCycle(current, all, visiting, visited)){
                    return true;
                }
            }
            return false;
        }
        private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited){
            all.remove(node);
            visiting.add(node);

            for (var neighbor: adjacentList.get(node)){
                 if (visited.contains(neighbor)){
                     continue;
                 }
                 if (visiting.contains(neighbor)){
                     return true;
                 }
                 if (hasCycle(neighbor, all, visiting, visited)){
                     return true;
                 }
            }
            visiting.remove(node);
            visited.add(node);

            return false;
        }
    }
}
