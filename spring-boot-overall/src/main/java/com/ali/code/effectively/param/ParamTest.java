package com.ali.code.effectively.param;

/**
 * @ClassName ParamTest
 * @Description 函数传参注意点
 *
 * 10:00-10:10
 * 传入参数之后，参数对应的引用地址的值是否改变
 *
 * 不要图快，还是画图分析比较靠谱，传参之后就是类似copy一个指针，然后看对该指针指向的内存区域怎么操作
 * @Author xuery
 * @Date 2019/4/18 9:41
 * @Version 1.0
 */
public class ParamTest {

    private static int intParam = 222;
    private static String strParam = "old string";
    private static StringBuilder sb = new StringBuilder("old stringBuilder-");

    public static void main(String[] args) {

        //1.1这个传入以后，会复制一个intParam的引用，intParamCopy然后指向777对应的内存地址
        intMethod(intParam);
        System.out.println(intParam);

        //1.2这个直接将类中的intParam重新引用到888对应的内存地址
        intMethod();
        System.out.println(intParam);

        //2 和1.1类似，因为String类也是不可变的
        stringMethod(strParam);
        System.out.println(strParam);

        //3.这个看方法里面的分析
        stringBuilderMethod(sb);
        System.out.println(sb.toString());

    }

    public static void intMethod(){
        intParam = 888;
    }

    public static void intMethod(int intParam){
        intParam = 777;
    }

    public static void stringMethod(String strParam){
        strParam = "new String";
    }

    public static void stringBuilderMethod(StringBuilder sb){
        //把传入的sb 复制一个引用sbCopy指向"old stringBuilder-"对应的地址，
        //然后通过这个sbCopy引用对"old stringBuilder-" append
        sb.append("first str");
        sb.append("-second str");

        //sbCopy指向另外一个引用地址，对应的字符串为"new stringBuilder-",然后对该新的字符串append
        sb = new StringBuilder("new stringBuilder-");
        sb.append("new first str");
    }

}

