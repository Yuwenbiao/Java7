package Java语言的动态性.动态语言支持.方法句柄;

import java.lang.invoke.MethodType;

public class GenerateMethodTypes {
    /**
     * MethodType类中的methodType方法的使用示例
     */
    private static void generateMethodTypes() {
        //String.length()
        MethodType mt1 = MethodType.methodType(int.class);
        //String.concat(String str)
        MethodType mt2 = MethodType.methodType(String.class, String.class);
        //String.getChars(int srcBegin,int srcEnd,char[] dst,int dstBegin)
        MethodType mt3 = MethodType.methodType(void.class, int.class, int.class, char[].class, int.class);
        //String.startsWith(String prefix)
        MethodType mt4 = MethodType.methodType(boolean.class, mt2);
    }

    /**
     * 生成通用MethodType类型的示例
     */
    private static void generateGenericMethodTypes() {
        MethodType mt1 = MethodType.genericMethodType(3);
        MethodType mt2 = MethodType.genericMethodType(2, true);
    }

    /**
     * 使用方法类型在字节代码中的表示形式来创建MethodType
     */
    private void generateMethodTypesFromDescriptor() {
        ClassLoader cl = this.getClass().getClassLoader();
        String descriptor = "(Ljava/lang/String); )Ljava/lang/String;";
        MethodType mt = MethodType.fromMethodDescriptorString(descriptor, cl);
    }

    /**
     * 对MethodType中的返回值和参数类型进行修改的示例
     */
    private void changeMethodType() {
        //(int,int)String
        MethodType mt = MethodType.methodType(String.class, int.class, int.class);
        //(int,int,float)String
        mt = mt.appendParameterTypes(float.class);
        //(int,double,long,int,float)String
        mt = mt.insertParameterTypes(1, double.class, long.class);
        //(int,double,int,float)String
        mt = mt.dropParameterTypes(2, 3);
        //(int,double,String,float)String
        mt = mt.changeParameterType(2, String.class);
        //(int,double,String,float)void
        mt = mt.changeReturnType(void.class);
    }

    /**
     * 一次性修改MethodType中的返回值和所有参数的类型的示例
     */
    private void wrapAndGeneric() {
        //(int,double)Integer
        MethodType mt = MethodType.methodType(Integer.class, int.class, double.class);
        //(Integer,Double)Integer
        MethodType wrapped = mt.wrap();
        //(int,double)int
        MethodType unwrapped = mt.unwrap();
        //(Object,Object)Object
        MethodType generic = mt.generic();
        //(int,double)Object
        MethodType erased = mt.erase();
    }
}

