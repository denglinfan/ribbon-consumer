package com.charles.ribbonconsumer.aop_asm.CSDN;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

public class ASMAop {

    public static void main(String[] args) throws Exception{
        ClassReader cr = new ClassReader("com.charles.ribbonconsumer.aop_asm.CSDN.Operation");

        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        cr.accept(new LogclassVisitor(cw),ClassReader.SKIP_DEBUG);

        byte[] data = cw.toByteArray();
        File file = new File("Operation.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();

        /*Class<?> clazz = new MyClassLoader().defineClassForName("com.charles.ribbonconsumer.aop_asm.CSDN.Operation",cw.toByteArray());

        clazz.getMethods()[0].invoke(clazz.newInstance());*/
    }
}
