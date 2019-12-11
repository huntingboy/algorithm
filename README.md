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
> 问题：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。  
> [MoreThanHalfNum::moreThanHalfNum_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/MoreThanHalfNum.java)
>> 时间效率  
>> HashMap的key存放array[i],value存放出现的次数  没有用桶是因为不知道最大的数是多少   
>> 妙解：注意到超过数组长度一半，那么每次同时去掉两个不同的数字，到最后只剩下一个数字或者两个相同的数字就是结果，最后对该数字回到数组做一下验证就即可。

> 问题：输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,  
> [GetLeastNumbers::getLeastNumbers_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/GetLeastNumbers.java)
>> 时间效率  
>> 使用排序工具类：对于数组，Arrays.sort(int[] a)为快排,Arrays.sort(T[], Comparator<> c)为归并排序(稳定)；对于集合，Collections.sort(list...)都是稳定的。  
>> 数组的深复制：Arrays.copyOf()(超过长度范围的默认值填充),Arrays.copyOfRange()(超过长度范围的默认值填充),System.arrayCopy()(不能超过数组长度),Object.clone()  
>> 排序 最大堆保存K个最小的数（PriorityQueue:底层为数组实现的小顶堆,可以通过传入Comparator改变比较规则）  冒泡排序的最外层循环k次

> 问题：HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)  
> [FindGreatestSumOfSubArray::findGreatestSumOfSubArray](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindGreatestSumOfSubArray.java)  
>> 时间效率  
>> 动态规划(dp) 关键在于状态转移方程: F（i）：以array[i]为末尾元素的子数组的和的最大值，子数组的元素的相对位置不变;F（i）=max（F（i-1）+array[i] ， array[i]）

> 问题：求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。  
> [NumberOf1Between1AndN::numberOf1Between1AndN_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/NumberOf1Between1AndN.java)  
>> 时间效率  
>> 枚举法 int转string进行对字符的判断  
>> 妙解[NumberOf1Between1AndN::numberOf1Between1AndN_Solution1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/NumberOf1Between1AndN.java)  
>> 分别求出个位、十位、百位。。。中出现1的次数. e.g. 316:  
>> 1. 1,11,21,...,301,311  共31+1=32个,即(316/1+8)/10*1+(316/1%10==1?0+1:0)  
>> 2. 10-19,110-119,210-219,310-316   共3*10+7=37个，即(316/10+8)/10\*10+(316/10%10==1?6+1:0)  
>> 3. 100-199  共100个，即(316/100+8)/10*100+(316/100%10==1?16+1:0)

> 问题：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。  
> [PrintMinNumber::printMinNumber](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/PrintMinNumber.java)
>> 时间效率  
>> 关键在于字符串(int2string后拼接，然后string2int进行比较)的比较规则(拼接起来比较)：s1+s2和s2+s1比较，把小的放在前面  

***  
> 问题：把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。  
> [GetUglyNumber::getUglyNumber_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/GetUglyNumber.java)  
>> 时间空间效率的平衡  
>> 丑数（2^x3^y5^z） 妙解[GetUglyNumber::getUglyNumber_Solution1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/GetUglyNumber.java) 空间换时间

> 问题：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.  
> [FirstNotRepeatingChar::firstNotRepeatingChar](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FirstNotRepeatingChar.java)  
>> 时间空间效率的平衡  

> 问题：在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007  
> 输入描述：  
>> 题目保证输入的数组中没有相同的数字  
>> 数据范围：  
>> 对于%50的数据,size<=10^4  
>> 对于%75的数据,size<=10^5  
>> 对于%100的数据,size<=2*10^5  
> [InversePairs::inversePairs](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/InversePairs.java)  
>> 时间空间效率的平衡  
>> 归并排序+二路归并  问题转化为二路归并交换次序的次数  

> 问题：输入两个链表，找出它们的第一个公共结点。  
> [FindFirstCommonNode::findFirstCommonNode](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ListNode.java)  
>> 时间空间效率的平衡    
>> 让长的链表先走长度差步，然后一起走

***
> 问题：统计一个数字在排序数组中出现的次数。   
> [GetNumberOfK::getNumberOfK](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/GetNumberOfK.java)  
>> 知识迁移能力  
>> 注意题目排好序的数组，所有设置flag标识是否已经检查完k的所有值

> 问题：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。  
> [TreeNode::treeDepth](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)  
>> 知识迁移能力  
>> 递归 子树高度(左子树和右子树的最大值)+1

> 问题：输入一棵二叉树，判断该二叉树是否是平衡二叉树。  
> [TreeNode::isBalanced_Solution](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/TreeNode.java)  
>> 知识迁移能力  
>> AVL树：任一节点对应的两棵子树的最大高度差为1   递归求树的高度  带剪枝处理

> 问题：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。  
> [FindNumsAppearOnce::findNumsAppearOnce](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindNumsAppearOnce.java)  
>> 知识迁移能力  
>> HashMap方法   
>> 位运算方法（妙解[FindNumsAppearOnce::findNumsAppearOnce1](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindNumsAppearOnce.java)),先求不同的2个元素的异或值和最后一个为1的bit位的位置，并根据它对所有元素分组,不同的2个数肯定在不同的组里    

> 问题：小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!  
> 输出描述：输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序  
> [FindContinuousSequence::findContinuousSequence](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindContinuousSequence.java)
>> 知识迁移能力    
>> 穷举 双指针(窗口)技术

> 问题：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。  
> 输入描述：对应每个测试案例，输出两个数，小的先输出。  
> [FindNumbersWithSum::findNumbersWithSum](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/FindNumbersWithSum.java)
>> 知识迁移能力    
>> 同上 穷举 双指针（窗口）技术

> 问题：汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！  
> [LeftRotateString::leftRotateString](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/LeftRotateString.java)
>> 知识迁移能力    
>> 数组 队列 注意对长度取余和str的合法性验证 和 ch2string的API

> 问题：牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？  
> [ReverseSentence::reverseSentence](https://github.com/huntingboy/algorithm/blob/master/src/main/java/com/nomad/jzoffer/ReverseSentence.java)  
>> 知识迁移能力    
>> StringBuffer  先分解为单词数组  在从后向前拼接





***