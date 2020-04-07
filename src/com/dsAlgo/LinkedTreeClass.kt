package com.dsAlgo

import java.lang.NullPointerException

class LinkedTreeClass() : LinkedTree<Any?> {
    var root: Node? = null
    var foundNode: Node? = null
    override fun insert(data: Int) {
        if (root == null) {
            root = Node(data)
        } else {
            var parent: Node? = null
            var tempNode: Node? = root
            while (tempNode != null) {
                parent = tempNode
                if (data <= tempNode.value) {
                    tempNode = tempNode.leftNode
                } else {
                    tempNode = tempNode.rightNode
                }
            }
            if (data <= parent?.value!!) {
                parent.leftNode = Node(data)
                parent.leftNode?.parent = parent
                println("Inserting left " + parent.leftNode?.value + " with parent" + parent.value)
            } else {
                parent.rightNode = Node(data)
                parent.rightNode?.parent = parent
                println("Inserting right " + parent.rightNode?.value + " with parent" + parent.value)
            }
        }


    }


    override fun delete(any: Any?) {
        search((any as Int), root)
        var nodeFound = foundNode
        print("Data for found node = ${foundNode?.value}")
        if(nodeFound == root)
        {
            root =  null
            print("\n Deleting tree \n")
            return
        }else if (nodeFound != null) {
            if (nodeFound.rightNode == null && nodeFound.leftNode == null) {
                print("Deleting leaf node \n")
                print("Parent for the node = ${nodeFound.parent?.value}\n")
                if (nodeFound.leftNode?.value == any as Int) {
                    nodeFound.parent?.leftNode = null
                } else {
                    nodeFound.parent?.rightNode = null
                }
            } else if (nodeFound.leftNode == null && nodeFound.rightNode != null) {
                print("\n is case with no left child\n")
                val child = nodeFound.rightNode
                child?.parent = nodeFound.parent
                insertChild(nodeFound, child!!)
            } else if (nodeFound.rightNode == null && nodeFound.leftNode != null) {
                print("\nis case with no right child\n")
                val child = nodeFound.leftNode
                child?.parent = nodeFound.parent
                insertChild(nodeFound, child!!)
            } else {
                val child = nodeFound.rightNode
                if (nodeFound.leftNode != null) {
                    child?.leftNode = nodeFound.leftNode
                }
                insertChild(nodeFound, child!!)

            }
        }
    }

    override fun search(key: Int, node: Node?): Node? {
        if (node?.leftNode != null) search(key, node.leftNode)
        if (key == node?.value) {
            print("Found \n")
            foundNode = node;
            return node
        }


        if (node?.rightNode != null) search(key, node.rightNode)

        return null
    }

    override fun traverse(node: Node?) {
      try {
          println("\n ${node!!.value}")
          if (node.leftNode != null) traverse(node.leftNode)
          if (node.rightNode != null) traverse(node.rightNode)
      }catch (e:NullPointerException)
      {
          print("Root is null" )
      }


    }

    private fun insertChild(nodeFound: Node, child: Node) {
        if (nodeFound.value == nodeFound.parent?.leftNode?.value) {
            print("\nis left node in parent \n")
            nodeFound.parent?.leftNode = child
            print("Printing sibling =  ${nodeFound.parent?.rightNode?.value} ,Replacing ${nodeFound.value} with ${child.value}" +
                    " ...checking child node leftnode = ${child.leftNode?.value} ...child right node  =  ${child.rightNode?.value}... updated node:  ${nodeFound.parent?.leftNode?.value}")
        } else {
            print("\nis right child in parent\n")
            nodeFound.parent?.rightNode = child
            print("Printing sibling =  ${nodeFound.parent?.leftNode?.value} ,Replacing ${nodeFound.value} with ${child.value}" +
                    " ...checking child node leftnode = ${child.leftNode?.value} ...child right node  =  ${child.rightNode?.value}....updated node:  ${nodeFound.parent?.rightNode?.value}")
        }
    }


}

