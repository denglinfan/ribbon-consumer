/*
package com.charles.ribbonconsumer.aop_asm.IBM;

import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

public class AddSecurityCheckClassAdapter extends ClassAdapter {

    public AddSecurityCheckClassAdapter(ClassVisitor cv){
        */
/**
         * Responsechain 的下一个ClassVisitor,这里我们将传入ClassWriter
         * 负责改写后的代码的输出
         *//*

        super(cv);
    }

    */
/**
     * 重写visitMethod，访问到“operation”的方法时，
     * 给出自定义的MethodVisitor，实际改写方法内容
     * @param access
     * @param name
     * @param desc
     * @param signature
     * @param exceptions
     * @return
     *//*

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {

        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        MethodVisitor wrappedMv = mv;

        if(mv != null){
            //对于operation方法
            if(name.equals("operation")){
                //使用自定义MethodVisitor，实际改写方法内容
                wrappedMv = new AddSecurityCheckMethodAdapter(mv);
            }
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}
*/
