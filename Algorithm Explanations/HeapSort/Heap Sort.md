A *heap* is a complete binary tree that satisfies the property of heap where every parent node is always greater than its child nodes.

>[!info]  Complete binary tree 
>Is a binary tree which has all levels full with the exception of last level

Heaps are of two types - 
1. Max-heap: all the parent nodes are greater than or equal to child nodes
2. Min-heap: all the parent nodes are less than or equal to child nodes

This signifies that the root node of heap will always be the *largest (or smallest)* value of the heap.

![[Min_Max_heap.png]]

### Forming heap from an array - 
- Consider an unsorted array `arr[] = {22, 47, 63, 11, 19, 26, 40, 39}`
- As we read, heap is a complete binary tree. Therefore to form a complete binary tree from an array, we must the property that
	For an element at index `i` in an array, its left child will exist at index `2*i + 1` and right child at index `2*i + 2`
- Thus the complete binary tree of above example would be -
![[Complete_binary_tree example.png]]

- To convert this binary tree to a heap we first need to understand a function `heapify`

>[!note] Max-heap
>For the purpose of illustrating this example we will make use Max-heap. The process would remain similar for Min-heap. 
>To sort in ascending order, make use of Max-heap. For descending order, make use of Min-heap

#### `heapify`
- `heapify` compares the element at index `i` and its children
- If it finds that the child index value is greater than the given index, it swaps the two values
- It will also recursively call it on the swapped index to maintain the properties of the heap on the affected sub-tree

```
function heapify(arr, size, index)
	max_index = index
	left_child = index*2 + 1
	right_child = index*2 + 2
	
	if(left_child < size AND arr[left_child] > arr[max_index])
		max_index = left_child
	if(right_child < size AND arr[right_child] > arr[max_index])
		max_index = right_child
	
	if(max_index != index)
		// swap values at max_index and index
		heapify(arr, size, max_index)
```

- Now to convert the unsorted array into a heap, we call `heapify` on all index from `0` to `size/2 - 1`  as all elements after that are leaf nodes
- Move from bottom to top maintain the the properties of a heap

```
for(i = size/2 - 1; i >= 0; i--)
	heapify(arr, size, i)
```

The resultant array would be - `arr[] = {63, 47, 40, 39, 19, 26, 22, 11}`
![[Formed_Heap.png]]

#### Sorting the heap
- The `root` node of the heap will always the largest node (Max-heap)
- Thus we can construct a sorting algorithm where, the root node is swapped with the last node of the heap and perform `heapify` on resultant heap excluding the element we just swapped
- Thus decreasing the size of heap by one
- We continue this process for all elements of the heap until we are left with a singular node in the heap and the result would be a sorted array
```
for(i = size - 1; i >= 0; i--)
	// swap root node and last node of the heap
	heapify(arr, i, 0)
```

>[!warning] Notice
>That the heap is constantly reducing in size and we are excluding the elements we just added to the end of the array with each new heap

![[Heap_sort_process.png]]

Result - `arr = {11, 19, 22, 26, 39, 40, 47, 63}`
