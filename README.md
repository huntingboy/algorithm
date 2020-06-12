# algorithm
**一些算法编程题**
## 目录
- [剑指offer](#剑指offer)
- [LeetCode](#Leetcode)
- [校招](#校招)
    - [Tencent](#Tencent)
    - [Alibaba](#Alibaba)
    - [美团](#美团)
    - [ByteDance](#ByteDance)
    
## 剑指offer
### 集合
> **问题**：工资按照出现频次降序排序  
> 输入：num(员工人数)，salaries(工资列表)  
> 输出：排序后的工资列表  
> 约束：1<=num<=10^5, 1<=salaries\[i\]<=10^9\(0<=i<num\)  
> 测试案例：  
> 输入：10,\[20000000,40000000,40000000,40000000,20000000,10000000,25000000,25000000,25000000,26000000\]  
> 输出：40000000,25000000,20000000,10000000,26000000   
> [SortTest::testSort1](https://github.com/huntingboy/algorithm/blob/master/src/test/java/com/nomad/sort/SortTest.java)  
>> Map, Collections, Comparator的使用  
>> 工资范围如果小可以考虑使用array\[salaryCount++\]来做  

### 树
> **问题**：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。  
> [ReConstructBinaryTree::reConstructBinaryTree](https://github.com/huntingboy/algorithm/blob/master/src/test/java/com/nomad/sort/TreeNode.java)  
>> 树  
>> 递归  关键在于递归函数的参数的确定  一般都是固定的，可以记住一些常见的

### 查找和排序
> **问题**：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。  
> [MinNumberInRotateArray::minNumberInRotateArray](https://github.com/huntingboy/algorithm/blob/master/src/test/java/com/nomad/sort/MinNumberInRotateArray.java)
>> 查找和排序  
>> 等价于找旋转支点（梯度）下标位置

### 递归和循环
> **问题**：斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）  
> [Fibonacci::fibonacci](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Fibonacci.java)
>> 递归和循环

> **问题**：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。  
> [Fibonacci::JumpFloorII](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Fibonacci.java)
>> 递归和循环

> **问题**：
一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。  
> [Fibonacci::jumpFloor](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Fibonacci.java)
>> 递归和循环  
>> f(n)=f(0)+f(1) + ... + f(n-1)

> **问题**：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？  
> [Fibonacci::RectCover](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Fibonacci.java)
>> 递归和循环  
>> 考虑第一个小矩形，如果横着，f(n-1);否则，f(n-2)

### 位运算
> **问题**：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。  
> [NumberOf1::numberOf1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/NumberOf1.java)
>> 位运算  
>> 对于负数要注意：最小的负数取反会溢出，所以直接返回1;其余的负数中1的个数等于32（int存储）-正数中0的个数  
>> 妙解[NumberOf1::numberOf2](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/NumberOf1.java)：把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。

### 代码的完整性
> **问题**： 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。 保证base和exponent不同时为0  
> [Power::power](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Power.java)
>> 代码的完整性  快速幂  
>> 1.全面考察指数的正负、底数是否为零等情况。  
>> 2.写出指数的二进制表达，例如13表达为二进制1101。  
>> 3.举例:10^1101 = 10^0001*10^0100*10^1000。  
>> 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。

> **问题**： 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。  
> [ReOrderArray::reOrderArray](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ReOrderArray.java)
>> 代码的完整性  
>> 空间换时间：对奇偶数分流道不同的数组，最后合并，O(2*array.length)  
>> 或者：  
>> 1.要想保证原有次序，则只能顺次移动或相邻交换。  
>> 2.i从左向右遍历，找到第一个偶数。  
>> 3.j从i+1开始向后找，直到找到第一个奇数。  
>> 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。  
>> 5.終止條件：j向後遍歷查找失敗。  

### 代码的鲁棒性
> **问题**： 输入一个链表，输出该链表中倒数第k个结点。   
> [FindKthToTail::findKthToTail](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)
>> 代码的鲁棒性    
>> 第一次遍历求出长度，第二次遍历到指定长度并输出  
>> 妙解[FindKthToTail::findKthToTail1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)：两个引用p,q,先让p走k-1步，当p.next==null时，q就是

> **问题**： 输入一个链表，反转链表后，输出新链表的表头。     
> [ReverseList::reverseList](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)
>> 代码的鲁棒性  
>> r,q,p三个引用，当p != null时，逆向中间节点q的next，然后同步向右移动，最后要处理第一个和最后一个节点的next属性   

> **问题**：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。     
> [Merge::merge](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)
>> 代码的鲁棒性  
>> 注意最先判断list1 == null和list2 == null的情况，否则tmp == null会出现空指针异常  
>> 递归版本：[Merge::merge1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)  

> **问题**：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）。     
> [HasSubtree::hasSubtree](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 代码的鲁棒性  递归  
>> 判断的是二叉树结构上的一致性  

***
> **问题**：操作给定的二叉树，将其变换为源二叉树的镜像。        
> [Mirror::mirror](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 面试思路 

***
> **问题**：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵：1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.  
> [Matrix::printMatrix](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Matrix.java)
>> 画图让抽象形象化   
>> 每次一圈，注意每一个小循环（从左到右，从上到下，从右到左，从下到上）的划分以及矩阵的形状（方阵，仅一行，仅一列，仅一个数）

### 举例让抽象具体化
> **问题**：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。  
> [MyStack](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/MyStack.java)
>> 举例让抽象具体化   
>> 数组记录元素，当做栈，同时定义一个stack属性临时记录最小的元素

> **问题**：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）  
> [MyStack::IsPopOrder](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/MyStack.java)
>> 举例让抽象具体化  
>> 如果下一个弹出的数字刚好是栈顶数字，那么直接弹出。  
>> 如果下一个弹出的数字不在栈顶，我们把压栈序列中还没有入栈的数字压入辅助栈，直到把下一个需要弹出的数字压入栈顶为止。  
>> 如果所有的数字都压入栈了仍然没有找到下一个弹出的数字，那么该序列不可能是一个弹出序列。  

> **问题**：从上往下打印出二叉树的每个节点，同层节点从左至右打印。  
> [BFS::printFromTopToBottom](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 举例让抽象具体化   
>> 队列 层次遍历

> **问题**：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。  
> [PostOrder::VerifySquenceOfBST](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 举例让抽象具体化  
>> 递归  BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义  

> **问题**：输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)　　
> [FindPath::findPath](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)  
>> 举例让抽象具体化   
>> 递归  深度优先遍历 打印路径多了target==0的判断  

### 分解让复杂问题简单
> **问题**：输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）  
> [RandomListNodeUtil::clone](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/RandomListNode.java)
>> 分解让复杂问题简单  
>> 分解为3个步骤，1.A->B->C ===> A->A'->B->B'->C->C'；2.把复制的结点的random指针指向被复制结点的random指针的下一个结点；3.拆分链表

> **问题**：输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。  
> [InOrder::convert](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)  
>> 分解让复杂问题简单  
>> 中序遍历  相同子问题  递归  
>> 处理左子树； 引用更新(对于需要全局修改的应该作为类的字段，因为没有c++的&类型)； 处理右子树； 最后返回最左节点。  

> **问题**：输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。  
> 输入：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。    
> [Permutation::permutation](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Permutation.java)
>> 分解让复杂问题简单  
>> 求出全排列(当前位置字符和后面每一个字符交换，递归)；排序

### 时间效率
> **问题**：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。  
> [MoreThanHalfNum::moreThanHalfNum_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/MoreThanHalfNum.java)
>> 时间效率  
>> HashMap的key存放array[i],value存放出现的次数  没有用桶是因为不知道最大的数是多少   
>> 妙解：注意到超过数组长度一半，那么每次同时去掉两个不同的数字，到最后只剩下一个数字或者两个相同的数字就是结果，最后对该数字回到数组做一下验证就即可。

> **问题**：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,  
> [GetLeastNumbers::getLeastNumbers_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/GetLeastNumbers.java)
>> 时间效率  
>> 使用排序工具类：对于数组，Arrays.sort(int[] a)为快排,Arrays.sort(T[], Comparator<> c)为归并排序(稳定)；对于集合，Collections.sort(list...)都是稳定的。  
>> 数组的深复制：Arrays.copyOf()(超过长度范围的默认值填充),Arrays.copyOfRange()(超过长度范围的默认值填充),System.arrayCopy()(不能超过数组长度),Object.clone()  
>> 排序 最大堆保存K个最小的数（PriorityQueue:底层为数组实现的小顶堆,可以通过传入Comparator改变比较规则）  冒泡排序的最外层循环k次

> **问题**：HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)  
> [FindGreatestSumOfSubArray::findGreatestSumOfSubArray](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindGreatestSumOfSubArray.java)  
>> 时间效率  
>> 动态规划(dp) 关键在于状态转移方程: F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变;F（i）=max（F（i-1）+array[i] ， array[i]）

> **问题**：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。  
> [NumberOf1Between1AndN::numberOf1Between1AndN_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/NumberOf1Between1AndN.java)  
>> 时间效率  
>> 枚举法 int转string进行对字符的判断  
>> 妙解[NumberOf1Between1AndN::numberOf1Between1AndN_Solution1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/NumberOf1Between1AndN.java)  
>> 分别求出个位、十位、百位。。。中出现1的次数. e.g. 316:  
>> 1. 1,11,21,...,301,311  共31+1=32个,即(316/1+8)/10*1+(316/1%10==1?0+1:0)  
>> 2. 10-19,110-119,210-219,310-316   共3*10+7=37个，即(316/10+8)/10\*10+(316/10%10==1?6+1:0)  
>> 3. 100-199  共100个，即(316/100+8)/10*100+(316/100%10==1?16+1:0)

> **问题**：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。  
> [PrintMinNumber::printMinNumber](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/PrintMinNumber.java)
>> 时间效率  
>> 关键在于字符串(int2string后拼接，然后string2int进行比较)的比较规则(拼接起来比较)：s1+s2和s2+s1比较，把小的放在前面  

### 时间空间效率的平衡
> **问题**：把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。  
> [GetUglyNumber::getUglyNumber_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/GetUglyNumber.java)  
>> 时间空间效率的平衡  
>> 丑数（2^x3^y5^z） 妙解[GetUglyNumber::getUglyNumber_Solution1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/GetUglyNumber.java) 空间换时间

> **问题**：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.  
> [FirstNotRepeatingChar::firstNotRepeatingChar](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FirstNotRepeatingChar.java)  
>> 时间空间效率的平衡  

> **问题**：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007  
> 输入描述：  
>> 题目保证输入的数组中没有相同的数字  
>> 数据范围：  
>> 对于%50的数据,size<=10^4  
>> 对于%75的数据,size<=10^5  
>> 对于%100的数据,size<=2*10^5  
> [InversePairs::inversePairs](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/InversePairs.java)  
>> 时间空间效率的平衡  
>> 归并排序+二路归并  问题转化为二路归并交换次序的次数  

> **问题**：输入两个链表，找出它们的第一个公共结点。  
> [FindFirstCommonNode::findFirstCommonNode](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)  
>> 时间空间效率的平衡    
>> 让长的链表先走长度差步，然后一起走

### 知识迁移能力
> **问题**：统计一个数字在排序数组中出现的次数。   
> [GetNumberOfK::getNumberOfK](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/GetNumberOfK.java)  
>> 知识迁移能力  
>> 注意题目排好序的数组，所有设置flag标识是否已经检查完k的所有值

> **问题**：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。  
> [TreeNode::treeDepth](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)  
>> 知识迁移能力  
>> 递归 子树高度(左子树和右子树的最大值)+1

> **问题**：输入一棵二叉树，判断该二叉树是否是平衡二叉树。  
> [TreeNode::isBalanced_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)  
>> 知识迁移能力  
>> AVL树：任一节点对应的两棵子树的最大高度差为1   递归求树的高度  带剪枝处理

> **问题**：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。  
> [FindNumsAppearOnce::findNumsAppearOnce](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindNumsAppearOnce.java)  
>> 知识迁移能力  
>> HashMap方法   
>> 位运算方法（妙解[FindNumsAppearOnce::findNumsAppearOnce1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindNumsAppearOnce.java)),先求不同的2个元素的异或值和最后一个为1的bit位的位置，并根据它对所有元素分组,不同的2个数肯定在不同的组里    

> **问题**：小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!  
> 输出描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序  
> [FindContinuousSequence::findContinuousSequence](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindContinuousSequence.java)
>> 知识迁移能力    
>> 穷举 双指针(窗口)技术

> **问题**：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。  
> 输入描述：对应每个测试案例，输出两个数，小的先输出。  
> [FindNumbersWithSum::findNumbersWithSum](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindNumbersWithSum.java)
>> 知识迁移能力    
>> 同上 穷举 双指针（窗口）技术

> **问题**：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！  
> [LeftRotateString::leftRotateString](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/LeftRotateString.java)
>> 知识迁移能力    
>> 数组 队列 注意对长度取余和str的合法性验证 和 ch2string的API

> **问题**：牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？  
> [ReverseSentence::reverseSentence](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ReverseSentence.java)  
>> 知识迁移能力    
>> StringBuffer  先分解为单词数组  再从后向前拼接

> **问题**：LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。  
> [IsContinuous::isContinuous](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/IsContinuous.java)  
>> 抽象建模能力  
>> TreeSet:TreeMap作为字段  TreeMap:存取O(logn),内部元素排序的HashMap,基于红黑树(根黑色，叶子黑色，红节点的子节点都是黑色，每个节点到叶子的路径上的黑色节点数相同)  

> **问题**：每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1),如果没有小朋友，请返回-1   
> [LastRemaining::lastRemaining_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/LastRemaining.java)
>> 抽象建模能力  
>> 约瑟夫环  最后一个报数问题  
>> 妙解[LastRemaining::lastRemaining_Solution1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/LastRemaining.java)： 通过归纳找出递归关系 f[1]=0; f[i]=(f[i-1]+m)%i (i>1)  

### 发散思维能力
> **问题**：求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。  
> [Sum::sum_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Sum.java)  
>> 发散思维能力  
>> 短路求值

> **问题**：写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。  
> [Add::add](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Add.java)  
>> 发散思维能力  
>> ^:异或求和（忽略会产生进位的位）  &:求出所有会产生进位的位   然后左移1位    2者相加即可

### 综合
> **问题**：将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0  
> 输入描述:输入一个字符串,包括数字字母符号,可以为空  
> 输出描述:如果是合法的数值表达则返回该数字，否则返回0  
> [StrToInt::strToInt](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/StrToInt.java) 
>> 综合  
>> 求各个数字位之和使用了移位运算和&元素提高效率   使用long临时存储和，后面有越界判断处理

### 数组
> **问题**：在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。  
> [Duplicate::duplicate](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Duplicate.java)  
>> 数组  

> **问题**：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。  
> [Multiply::multiply](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Multiply.java) 
>> 数组  
>> 看做n×n矩阵，先求下三角乘积，然后求上三角累乘

### 字符串
> **问题**：请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配  
> [Match::match](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/Match.java)
>> 字符串  
>> Pattern.compile(pattern).matcher(str).matchers()    递归，主要对于*,pattern索引的移动(0,1,1+)

> **问题**：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是  
> [IsNumeric::isNumeric](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/IsNumeric.java)
>> 字符串  
>> 同上 Pattern类的使用 关键在于写出整数、小数、指数的正则表达式  注意java中的转义需要写2个\\

> **问题**：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。  
> 输出描述：如果当前字符流没有存在出现一次的字符，返回#字符。  
> [FirstAppearingOnce::firstAppearingOnce](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FirstAppearingOnce.java)
>> 字符串  
>> StringBuffer和HashMap<Charater, Integer>

### 链表
> **问题**：给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。  
> [EntryNodeOfLoop::entryNodeOfLoop](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)
>> 链表  
>> 使用辅助存储空间HashMap<ListNode, Boolean>，当map存在该key时即入口   
>> 妙解[EntryNodeOfLoop::entryNodeOfLoop1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java):快慢指针法（同求链表倒数第k个节点）  
>>> 1. 快指针一次走两步，慢指针一次走一步，设链表起点到入口结点的长度是x1，快慢指针第一次相遇时距离入口结点的长度是x2，此时慢指针走了x1+x2，快指针走了2x1+2x2，也就是说x1+x2的长度正好是环的一圈大小的倍数。  
>>> 2. 此时让一个指针从起点出发，一个指针从相遇结点出发，都是一次走一步，当两个指针第一次相遇时恰好是在入口结点。

> **问题**：在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5  
> [DeleteDuplication::deleteDuplication](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)  
>> 链表  
>> 新建一个头结点来统一重复节点可能出现在开头或者中间的情况  让p指向不重复的节点，q指向要比较的节点（q和q.next比较）

### 树
> **问题**：给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。  
> [GetNext::getNext](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeLinkNode.java) 
>> 树  
>> 1. 存在右子树，则为右子树的最左子节点
>> 2. 如果右子树为空并且是parent的左子树root，则为父节点
>> 3. 如果右子树为空并且是parent的右子树root，则向上找parent一直到它是parent的左子树root

> **问题**：请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。  
> [IsSymmetrical::isSymmetrical](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 树  
>> 递归

> **问题**：请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。  
> [Print::print](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 树  
>> 使用Queue(LinkedList)存放当前行所有的节点  如果是偶数行使用Stack作为中介逆序得到结果，否则直接放到res中  

> **问题**：从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。  
> [Print::print1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 树  
>> 队列Queue(LinkedList:Deque和List的子类)  类似上题

> **问题**： 请实现两个函数，分别用来序列化和反序列化二叉树。 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。  
> [Serialize::serialize/deserialize](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 树   
>> 先序遍历的结果

> **问题**：给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。　　
> [KthNode::kthNode](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)
>> 树  
>> 非递归中序遍历接住栈Stack   递归[KthNode::kthNode1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)

> **问题**：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。　　
> [GetMedian::getMedian](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/GetMedian.java)  
>> 树  
>> LinkedList  也可以用PriorityQueue(默认小顶堆,底层是数组实现)

### 栈和队列
> **问题**：定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。  
> [MaxInWindows::maxInWindows](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/MaxInWindows.java) 
>> 栈和队列  
>> 妙解[MaxInWindows::maxInWindows1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/MaxInWindows.java)：用一个双端队列(用来记录每个窗口的最大值下标)，队列第一个位置保存当前窗口的最大值，当窗口滑动一次，判断当前最大值是否过期;新增加的值从队尾开始比较，把所有比他小的值丢掉

### 回溯法
> **问题**：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。  
> [HasPath::hasPath](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/HasPath.java)  
>> 回溯法  
>> 递归  上下左右递归遍历+出口(下标越界||位置已访问过||不满足规定条件)  一般递归函数的参数都是固定的，可以记住

> **问题**：地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？  
> [MovingCount::movingCount](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/MovingCount.java)  
>> 回溯法  
>> 类似上题  上下左右递归遍历+出口(下标越界||位置已访问过||不满足规定条件)  一般递归函数的参数都是固定的，可以记住

## Leetcode
### 树
> **问题**：求给定二叉树的最小深度。最小深度是指树的根结点到最近叶子结点的最短路径上结点的数量。  
> [MinDepth::run](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MinDepth.java)  
>> 树  

> **问题**：求给定的二叉树的后序遍历。   
> [Traversal::postorderTraversal](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/Traversal.java)
>> 树  
>> 递归  先左右子树,后根  
>> 栈（非递归）[Traversal::postorderTraversal1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/Traversal.java) 注意放到栈的次序，先右孩子后左孩子  pre指向刚访问过的节点

> **问题**：求给定的二叉树的前序遍历。   
> [Traversal::preorderTraversal](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/Traversal.java)
>> 树  
>> 递归  
>> 栈（非递归）[Traversal::preorderTraversal1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/Traversal.java)  先访问根节点（从栈pop）  注意放到栈的次序，先右孩子后左孩子  非递归实现树的遍历套路差不多，记住   

### 栈
> **问题**：计算逆波兰式（后缀表达式）的值，运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式   
> e.g. ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵ ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
> [EvalRPN::evalRPN](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/EvalRPN.java)  
>> 栈  

### 穷举
> **问题**：对于给定的n个位于同一二维平面上的点，求最多能有多少个点位于同一直线上  
> [MaxPoints::maxPoints](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MaxPoints.java)  
>> 穷举  
>> map<Double, Integer>  key:斜率  value:点个数  
>> 3种情况：垂直  相同的点  斜率

### 排序
> **问题**：在O(n log n)的时间内使用常数级空间复杂度对链表进行排序。  
> [SortList::sortList](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/SortList.java)  
>> 排序  链表  
>> 归并排序时间复杂度O(1)  对于链表，排序只需要修改引用，空间复杂度O(1)   注意sortListMerge函数的参数列表对于链表和数组的不同，本质都是范围

> **问题**：使用插入排序对链表进行排序。  
> [SortList::insertionSortList](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/SortList.java)  
>> 排序  
>> 创建一个新链表头（哨兵），对于每个要插入到该链表的节点，首先找到要插入的位置，然后在末尾插入或者在在中间插入该节点。

### 链表
> **问题**：将给定的单链表L： L 0→L 1→…→L n-1→L n, 重新排序为： L 0→L n →L 1→L n-1→L 2→L n-2→…  要求使用原地算法，并且不改变节点的值  
> [ReorderList::reorderList](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/ReorderList.java)  
>> 链表  
>> 快慢指针找到中间节点，将后面的链表反转（前插法），合并链表

### 题库
1. 两数之和   
**问题**：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍   
**示例**：
    > 给定 nums = [2, 7, 11, 15], target = 9  
      因为 nums[0] + nums[1] = 2 + 7 = 9  
      所以返回 [0, 1]  
      [Sum::twoSum](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/Sum.java)  
2. 两数相加  
**问题**：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。您可以假设除了数字 0 之外，这两个数都不会以 0 开头。  
**示例**：
    > 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)  
      输出：7 -> 0 -> 8  
      原因：342 + 465 = 807  
      [Sum::addTwoNumbers](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/Sum.java)  
      >> 链表
3. 无重复字符的最长子串  
**问题**：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。  
**示例**：
    > 输入: "abcabcbb"  
      输出: 3   
      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。  
      输入: "bbbbb"  
      输出: 1  
      解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。  
      输入: "pwwkew"  
      输出: 3  
      解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。  
      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。  
      [MyString::lengthOfLongestSubstring0](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)    
      [MyString::lengthOfLongestSubstring](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)  
      >> 字符串 双指针 Set
4. 寻找两个正序数组的中位数  
**问题**：给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。你可以假设 nums1 和 nums2 不会同时为空  
**示例**：
    > nums1 = [1, 3]  
      nums2 = [2]  
      则中位数是 2.0  
      nums1 = [1, 2]  
      nums2 = [3, 4]  
      则中位数是 (2 + 3)/2 = 2.5  
      [MyNumber::findMedianSortedArrays](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyNumber.java)  
      >> 二分查找 O(logm+n) 中位数（分奇数和偶数） 第k小的数
5. 最长回文子串  
**问题**：给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。  
**示例**
    > 输入: "babad"  
      输出: "bab"  
      注意: "aba" 也是一个有效答案。
      输入: "cbbd"  
      输出: "bb"  
      [MyString::longestPalindrome](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)  
      >> 回文串（左右剥皮后仍是回文串）  
         暴力枚举法 O(n^2)  
         动态规划法 O(n^2)：
         
         状态转移方程：P(i,j)=P(i+1,j-1)&&(Si==Sj), P(i,j)表示Si...j是否为回文串。
         边界条件：P(i,i)=true和P(i,i+1)=(Si==Si+1)
         
      >> 中心拓展法 O(n^2) O(1)：  
       
         S(i,i)->S(i-1,i+1)->... 直到无法拓展，拓展条件Si-1==Si+1
         S(i,i+1)->S(i-1,i+2)->... 直到无法拓展，拓展条件Si-1==Si+2
         取上两者长度最大值, start、end记录回文串边界下标
           
      >> Manacher法（马拉车） O(n) :
      
         对中心拓展法的优化，跳过重复检查，验证i时先验证2j-i处的臂长并跳过
         只处理奇数长度串，偶数/奇数长度串通过在每个间隙插入任意相同的一个字符即可变为奇数长度
         aaba 处理后会变成 #a#a#b#a#
         aba 会变成长度仍然为奇数的回文字符串 #a#b#a#
6. Z字形变换  
**问题**：将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
                
        L   C   I   R
        E T O E S I I G
        E   D   H   N
       
    &emsp;&emsp;之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。  
**示例**
    > 输入: s = "LEETCODEISHIRING", numRows = 3  
      输出: "LCIRETOESIIGEDHN"   
      输入: s = "LEETCODEISHIRING", numRows = 4  
      输出: "LDREOEIIECIHNTSG"  
      解释:
      
        L     D     R
        E   O E   I I
        E C   I H   N
        T     S     G
      
    > [MyString::convert](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)        
      [MyString::convert1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)        
    >> 法一：按行存储+方向控制(n==0||n==numRows-1处反向，步长=1/-1)  
       法二：找出s中字符位置和目标串中字符位置之间的关系+按行遍历直接输出：  
       第0行：k(2⋅numRows−2) k=0,1...  
       第i行：k(2⋅numRows−2)+i和(k+1)(2⋅numRows−2)−i  
       第numRows-1行：k(2⋅numRows−2)+numRows−1 (i=numRows-1的特例)
7. 整数反转  
**问题**：给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。  
**示例**：
    > 输入: 123  
      输出: 321  
      输入: -123  
      输出: -321  
      输入: 120  
      输出: 21  
      注意：假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。  
      [MyNumber::reverse](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyNumber.java)  
      >> try...catch 捕获溢出异常return 0  
         整数->String->整数  
         递归取余(pop)，右移累加(push，溢出判断：如果temp=rev⋅10+pop导致溢出，那么一定有rev≥INTMAX/10;大于，肯定会溢出；等于，只要pop>7，但是本题不存在此种情况 )
8. 字符串转换整数 (atoi)  
**问题**：请你来实现一个 atoi 函数，使其能将字符串转换成整数。首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：  
    &emsp;&emsp;如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。  
    &emsp;&emsp;假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。  
    &emsp;&emsp;该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。  
    &emsp;&emsp;注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。  
    &emsp;&emsp;在任何情况下，若函数不能进行有效的转换时，请返回 0 。  
    &emsp;&emsp;本题中的空白字符只包括空格字符 ' ' 。   
    &emsp;&emsp;假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。  
**示例**  
    > 输入: "42"  
      输出: 42  
      输入: "   -42"  
      输出: -42  
      解释: 第一个非空白字符为 '-', 它是一个负号。我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。  
      输入: "4193 with words"  
      输出: 4193  
      解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。   
      输入: "words and 987"  
      输出: 0  
      解释: 第一个非空字符是 'w', 但它不是数字或正、负号。因此无法执行有效的转换。  
      输入: "-91283472332"  
      输出: -2147483648  
      解释: 数字 "-91283472332" 超过 32 位有符号整数范围。因此返回 INT_MIN (−2^31) 。  
      [MyString::myAtoi](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)        
      >> 也可用有限状态向量机  
9. 回文数  
**问题**：判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。  
**示例**
    > 输入: 121  
      输出: true  
      输入: -121  
      输出: false  
      解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。  
      输入: 10  
      输出: false  
      解释: 从右向左读, 为 01 。因此它不是一个回文数。  
      [MyNumber::reverse](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyNumber.java)  
      >> 计算翻转后数值  
         也可以转为字符串做
10. 正则表达式匹配  
**问题**：给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '\*' 的正则表达式匹配。  
    &emsp;&emsp;'.' 匹配任意单个字符  
    &emsp;&emsp;'\*' 匹配零个或多个前面的那一个元素  
    &emsp;&emsp;所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。  
    &emsp;&emsp;s 可能为空，且只包含从 a-z 的小写字母。  
    &emsp;&emsp;p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。  
**示例**
    > s = "aa"  
      p = "a"  
      输出: false  
      解释: "a" 无法匹配 "aa" 整个字符串。  
      s = "aa"  
      p = "a*"  
      输出: true  
      解释: 因为 '\*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。  
      s = "ab"  
      p = ".\*"   
      输出: true  
      解释: ".\*" 表示可匹配零个或多个（'\*'）任意字符（'.'）。  
      s = "aab"  
      p = "c\*a\*b"  
      输出: true  
      解释: 因为 '\*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。  
      s = "mississippi"  
      p = "mis\*is\*p*."  
      输出: false  
      [MyString::isMatch](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)  
      [MyString::isMatch1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)  
      [MyString::isMatch2](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)  
      [MyString::isMatch3](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyString.java)  
      >> Pattern+Matcher  m.find():部分匹配  m.matches():完全匹配  Pattern.matches(regex, s):一次性+完全匹配  
         回溯法  按p分3种情况:"", .\*/a*（长度>=2且第二个是*）, 其他（长度=1或第二个不是*）   
         动态规划（自顶向下，自底向上）  
11. 盛最多水的容器  
**问题**：给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。  
    &emsp;&emsp;说明：你不能倾斜容器，且n的值至少为 2    
**示例**  
    > 输入：\[1,8,6,2,5,4,8,3,7]  
      输出：49  
      [MyNumber::maxArea](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyNumber.java)  
      >> 双指针 木桶原理 消状态 指针移动规则：  
         设每一状态下水槽面积为 S(i,j)(0<=i<j<n)，由于水槽的实际高度由两板中的短板决定，则可得面积公式 S(i,j)=min(h\[i],h\[j])×(j−i)。  
         在每一个状态下，无论长板或短板收窄1格，都会导致水槽 底边宽度-1：  
         若向内移动短板，水槽的短板 min(h\[i],h\[j])可能变大，因此水槽面积可能增大。  
         若向内移动长板，水槽的短板 min(h\[i],h\[j])不变或变小，下个水槽的面积一定小于当前水槽面积。
12. 整数转罗马数字  
**问题**：罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。  

        字符          数值
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000

    &emsp;&emsp;例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。    
    &emsp;&emsp;通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：  
    
        I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
        X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
        C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。

    &emsp;&emsp;给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。         
**示例**
    > 输入: 3  
      输出: "III"  
      输入: 4  
      输出: "IV"  
      输入: 9  
      输出: "IX"  
      输入: 58  
      输出: "LVIII"  
      解释: L = 50, V = 5, III = 3.  
      输入: 1994  
      输出: "MCMXCIV"  
      解释: M = 1000, CM = 900, XC = 90, IV = 4.  
      [MyNumber::intToRoman](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyNumber.java)  
      >>    
13.   
**问题**：  
**示例**
    > 
      [MyNumber::reverse](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/leetcode/MyNumber.java)  
      >>   

## 校招
### Tencent
**2020**
> **问题**：压缩字符串解压缩  
> 输入：HG[3|B[2|CA]]F  
> 输出：HGBCACABCACABCACAF(HG[3|B[2|CA]]F->HG[3|BCACA]F->HGBCACABCACABCACAF)  
> [Unzip::unzip](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/xz/tencent/twozero/Unzip.java)
>> 递归  
>> (input, begin, end)

**2019**


### Alibaba
### 美团
### ByteDance

