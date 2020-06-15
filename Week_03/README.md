学习笔记

递归的模板:
// terminator 递归终结条件
if (level > MAX_LEVEL) { 
// process result
return; 
}
// process current logic 处理当前逻辑
process(level, param); 
// drill down 进入下一层
recur( level: level + 1, newParam); 
// restore current status 清理当前层 

1.不要进行人肉递归
2.找到最近最简单问题,将其拆解成可重复解决问题(重复子问题)
3.数学归纳法  (n=1 成立 n=2成立 n>3的时候也成立)


分治:
divide_conquer(problem, param1, param2, param3)....
    #recursion terminator 递归终结条件
    if (problem == null){
        return result;
    }
    #prepare data 准备数据
    data = prepare_data(problem);
    subproblems = splite_problem(problem, data);
    # conquer subproblems 攻克子问题
    subresult1 = divide_conquer(subprolems[0], p1, ....)
    subresult2 = divide_conquer(subprolems[1], p1, ....)
    subresult3 = divide_conquer(subprolems[2], p1, ....)
    #process and generate the final result 处理最后的问题
    result = process_result(subresult1, subresult2 , subresult3)
    
    查看myPow题目
    