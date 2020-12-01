package com.dhb.ASM;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassVisitor;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.MethodVisitor;

import java.io.File;
import java.io.FileOutputStream;

import static org.objectweb.asm.Opcodes.*;
public class ClassTransformerTest {

	public static void main(String[] args) throws Exception{
		ClassReader cr = new ClassReader(
			ClassPrinter.class.getClassLoader().getResourceAsStream("com/dhb/ASM/Tank.class"));
		ClassWriter cw = new ClassWriter(0);
		ClassVisitor cv = new ClassVisitor(ASM4,cw) {
			@Override
			public MethodVisitor visitMethod(int access, String name, String descriptor, String signator, String[] exceptions) {
				MethodVisitor mv = super.visitMethod(access,name,descriptor,signator,exceptions);
				return new MethodVisitor(ASM4,mv) {
					@Override
					public void visitCode() {
						visitMethodInsn(INVOKESTATIC,"TimeProxy","before","()V",false);
						super.visitCode();
					}
				};
			}
		};
		cr.accept(cv,0);
		byte[] b2 = cw.toByteArray();

		String path = (String)System.getProperties().get("user.dir");
		File f = new File(path + "/com/dhb/ASM/");
		f.mkdir();

		FileOutputStream fos = new FileOutputStream(new File(path + "/com/dhb/ASM/Tank_0.class"));
		fos.write(b2);
		fos.flush();
		fos.close();
	}
}
