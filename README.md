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
> [SortTest::testSort1](https://github.com/huntingboy/algorithm/src/test/java/com/nomad/sort/SortTest.java)  
>> Map, Collections, Comparator的使用  
>> 工资范围如果小可以考虑使用array\[salaryCount++\]来做    
