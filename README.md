# algorithm
## 一些算法编程题
***
> 问题：工资按照出现频次降序排序  
> 输入：num(员工人数)，salaries(工资列表)  
> 输出：排序后的工资列表  
> 约束：1<=num<=10^5, 1<=salaries\[i\]<=10^9\(0<=i<num\)  
> 测试案例：  
> 输入：10,\[20000000,40000000,40000000,40000000,20000000,10000000,25000000,25000000,25000000,26000000\]  
> 输出：40000000,25000000,20000000,10000000,26000000   
> [SortTest::testSort1](https://github.com/huntingboy/algorithm/blob/master/src/test/java/com/nomad/sort/SortTest.java)  
>> Map, Collections, Comparator的使用  
>> 工资范围如果小可以考虑使用array\[salaryCount++\]来做  

***
> 问题：斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）  
> [Fibonacci::fibonacci](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Fibonacci.java)
>> 递归和循环

> 问题：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。  
> [Fibonacci::JumpFloorII](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Fibonacci.java)
>> 递归和循环

> 问题：
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。  
> [Fibonacci::jumpFloor](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Fibonacci.java)
>> 递归和循环  
>> f(n)=f(0)+f(1) + ... + f(n-1)

> 问题：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？  
> [Fibonacci::RectCover](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Fibonacci.java)
>> 递归和循环  
>> 考虑第一个小矩形，如果横着，f(n-1);否则，f(n-2)

***
> 问题：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。  
> [NumberOf1::numberOf1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/NumberOf1.java)
>> 位运算  
>> 对于负数要注意：最小的负数取反会溢出，所以直接返回1;其余的负数中1的个数等于32（int存储）-正数中0的个数  
>> 妙解[NumberOf1::numberOf2](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/NumberOf1.java)：把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。

***
> 问题： 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 保证base和exponent不同时为0  
> [Power::power](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Power.java)
>> 代码的完整性  快速幂  
>> 1.全面考察指数的正负、底数是否为零等情况。  
>> 2.写出指数的二进制表达，例如13表达为二进制1101。  
>> 3.举例:10^1101 = 10^0001*10^0100*10^1000。  
>> 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。

> 问题： 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。  
> [ReOrderArray::reOrderArray](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ReOrderArray.java)
>> 代码的完整性  
>> 空间换时间：对奇偶数分流道不同的数组，最后合并，O(2*array.length)  
>> 或者：  
>> 1.要想保证原有次序，则只能顺次移动或相邻交换。  
>> 2.i从左向右遍历，找到第一个偶数。  
>> 3.j从i+1开始向后找，直到找到第一个奇数。  
>> 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。  
>> 5.終止條件：j向後遍歷查找失敗。  

***
> 问题： 输入一个链表，输出该链表中倒数第k个结点。   
> [FindKthToTail::findKthToTail](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)
>> 代码的鲁棒性    
>> 第一次遍历求出长度，第二次遍历到指定长度并输出  
>> 妙解[FindKthToTail::findKthToTail1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)：两个引用p,q,先让p走k-1步，当p.next==null时，q就是

> 问题： 输入一个链表，反转链表后，输出新链表的表头。     
> [ReverseList::reverseList](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)
>> 代码的鲁棒性  
>> r,q,p三个引用，当p != null时，逆向中间节点q的next，然后同步向右移动，最后要处理第一个和最后一个节点的next属性   

> 问题：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。     
> [Merge::merge](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)
>> 代码的鲁棒性  
>> 注意最先判断list1 == null和list2 == null的情况，否则tmp == null会出现空指针异常  
>> 递归版本：[Merge::merge1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)  

> 问题：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）。     
> [HasSubtree::hasSubtree](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 代码的鲁棒性  递归  
>> 判断的是二叉树结构上的一致性  

***
> 问题：操作给定的二叉树，将其变换为源二叉树的镜像。        
> [Mirror::mirror](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 面试思路 

***
> 问题：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.  
> [Matrix::printMatrix](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Matrix.java)
>> 画图让抽象形象化   
>> 每次一圈，注意每一个小循环（从左到右，从上到下，从右到左，从下到上）的划分以及矩阵的形状（方阵，仅一行，仅一列，仅一个数）

***
> 问题：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。  
> [MyStack](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/MyStack.java)
>> 举例让抽象具体化   
>> 数组记录元素，当做栈，同时定义一个stack属性临时记录最小的元素

> 问题：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）  
> [MyStack::IsPopOrder](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/MyStack.java)
>> 举例让抽象具体化  
>> 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。  
>> 如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。  
>> 如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。  

> 问题：从上往下打印出二叉树的每个节点，同层节点从左至右打印。  
> [BFS::printFromTopToBottom](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 举例让抽象具体化   
>> 队列 层次遍历

> 问题：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。  
> [PostOrder::VerifySquenceOfBST](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 举例让抽象具体化  
>> 递归  BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义  

> 问题：输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)　　
> [FindPath::findPath](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)  
>> 举例让抽象具体化   
>> 递归  深度优先遍历 打印路径多了target==0的判断  

***
> 问题：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）  
> [RandomListNodeUtil::clone](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/RandomListNode.java)
>> 分解让复杂问题简单  
>> 分解为3个步骤，1.A->B->C ===> A->A'->B->B'->C->C'；2.把复制的结点的random指针指向被复制结点的random指针的下一个结点；3.拆分链表

> 问题：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。  
> [InOrder::convert](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)  
>> 分解让复杂问题简单  
>> 中序遍历  相同子问题  递归  
>> 处理左子树； 引用更新(对于需要全局修改的应该作为类的字段，因为没有c++的&类型)； 处理右子树； 最后返回最左节点。  

> 问题：输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。  
> 输入：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。    
> [Permutation::permutation](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Permutation.java)
>> 分解让复杂问题简单  
>> 求出全排列(当前位置字符和后面每一个字符交换，递归)；排序

***
> 问题：