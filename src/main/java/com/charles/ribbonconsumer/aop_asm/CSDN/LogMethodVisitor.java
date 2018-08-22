package com.charles.ribbonconsumer.aop_asm.CSDN;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class LogMethodVisitor extends MethodVisitor {

    public LogMethodVisitor(MethodVisitor mv){
        super(Opcodes.ASM5, mv);
    }

    @Override
    public void visitCode() {
        /**
         * 方法执行之前植入代码
         */
        super.visitMethodInsn(Opcodes.INVOKESTATIC, "com.charles.ribbonconsumer.aop_asm.CSDN.Log","startLog","()V", false);
        super.visitCode();
    }

    @Override
    public void visitInsn(int opcode) {
        if(opcode == Opcodes.RETURN){
            /**
             * 方法return之前插入代码
             */
            super.visitMethodInsn(Opcodes.INVOKESTATIC, "com.charles.ribbonconsumer.aop_asm.CSDN.Log","endLog","()V",false);
        }

        super.visitInsn(opcode);
    }
}
