package com.dhb.ASM;

import org.objectweb.asm.ClassWriter;
import static org.objectweb.asm.Opcodes.*;

public class ClassWriteTest {

	public static void main(String[] args) {
		ClassWriter cw = new ClassWriter(0);
		cw.visit(V1_5,ACC_PUBLIC+ACC_ABSTRACT+ACC_INTERFACE,
				"pkg/Comparable",null,"java/lang/Object",null);
		cw.visitField(ACC_PUBLIC+ACC_FINAL+ACC_STATIC,"LESS","I",null,-1).visitEnd();
		cw.visitField(ACC_PUBLIC+ACC_FINAL+ACC_STATIC,"EQUAL","I",null,0).visitEnd();
		cw.visitField(ACC_PUBLIC+ACC_FINAL+ACC_STATIC,"GREATER","I",null,1).visitEnd();

		cw.visitMethod(ACC_PUBLIC+ACC_ABSTRACT,"compareTo","(Ljava/lang/Object;)I",null,null).visitEnd();
		byte[] b = cw.toByteArray();

		MyClassLoader myClassLoder = new MyClassLoader();
		Class c = myClassLoder.defineClass("pkg.Comparable",b);
		System.out.println(c.getMethods()[0].getName());
		Tank t1 = new Tank();
	}
}
