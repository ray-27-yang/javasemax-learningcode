package com.fei.demo1;

import org.junit.Assert;
import org.junit.Test;

//测试类：junit单元测试框架，对业务中的类进行正确性测试
public class StringUtilTest {
    //为每一个方法编写测试方法：公开，无参，无返回值
    //必须加上@Test，junit框架核心步骤
    @Test
    public void testprintNameLength(){
        //测试步骤
        StringUtil.printNameLength("abcd");
        //测试用例，要写完整
        StringUtil.printNameLength("");//调方法来试空字符串，检查是否有对应机制
        StringUtil.printNameLength(null);//调方法来试null，会抛出空指针异常，检查有没有对应机制
    }
    @Test
    public void testGetMaxIndex(){
        //测试步骤
        int index = StringUtil.getMaxIndex("abcd");
        //测试用例，要写完整
        int index1 = StringUtil.getMaxIndex("");
        int index2 = StringUtil.getMaxIndex(null);

        System.out.println(index);
        System.out.println(index1);
        System.out.println(index2);

        //断言测试：断言结果是否与预期结果一致
        Assert.assertEquals("本轮测试失败，业务的最大索引有问题，请检查",3, index);
        Assert.assertEquals("本轮测试失败，业务最大索引有问题，请检查",-1, index1);
        Assert.assertEquals("本轮测试失败，业务最大索引有问题，请检查",-1, index2);
    }
}
