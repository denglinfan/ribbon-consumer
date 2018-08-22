package com.charles.ribbonconsumer.aop_asm.CSDN;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class LogclassVisitor extends ClassVisitor {

    public LogclassVisitor(ClassVisitor cv){
        super(Opcodes.ASM5, cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if("oper".equals(name)){
            return new LogMethodVisitor(super.visitMethod(access,name,desc,signature,exceptions));
        }

        return super.visitMethod(access,name,desc,signature,exceptions);
    }
}
